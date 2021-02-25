package final_450.strings

fun main() {
    val input = "ABCD"
    val result = "CDAB"
    for (index in 0..input.lastIndex) {
        val rotation = input.takeLast(index) + input.dropLast(index)
        println(rotation)
        if (rotation == result) {
            println(true)
        }
    }
    println(false)

    println("------ method 2 ---------")

    val merge = "$input$input"
    println(merge)
    println("CDAB" in merge)
    println(merge.split("CDAB")[0])


}