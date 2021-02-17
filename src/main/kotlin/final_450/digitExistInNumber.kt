package final_450

fun main() {
    println("number exist?")
    println(digitExistInNumber(123467, 1))
}

// 123 , 1
fun digitExistInNumber(input: Int, digit: Int): Boolean {

    var number = input
    while (number != 0) {
        if (number % 10 == digit) {
            return true
        } else {
            number /= 10
        }
    }
    return false

}