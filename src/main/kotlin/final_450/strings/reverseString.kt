package final_450.strings

fun main(){
    val array= arrayOf("h","e","l","l","o").toMutableList()
    val mid = array.size/2
    for (index in 0 until  mid){
        println(index)
        val temp = array[index]
        val lastIndex = array.lastIndex - index
        array[index] = array[lastIndex]
        array[lastIndex] = temp
    }
    println(array)

}