package final_450.arrays.palledrome

fun main(){

    val input = "rooor"
    println(palldrome(input))

}

fun palldrome(input:String): Boolean {
    if (input.isEmpty() || input.length == 1){
        return true
    }

    if (input.first() == input.last()){
        return palldrome(input.drop(1).dropLast(1))
    }

    return false
}