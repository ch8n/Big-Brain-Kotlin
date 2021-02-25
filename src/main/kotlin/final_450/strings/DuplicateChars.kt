package final_450.strings

fun main(){
    val input = "geeksforgeeks"
    input.groupingBy { it }
        .eachCount()
        .filter { it.value>1 }
        .map { print(it.key) }
}
