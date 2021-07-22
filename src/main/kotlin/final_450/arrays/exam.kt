package final_450.arrays

fun main() {

    val input = "23"
    val numbers = arrayOf<String>("123", "234", "567")
    val names = arrayOf<String>("chetan", "pokemon", "sokemon")

    val result = numbers
        .zip(names)
        .sortedBy { it.second }
        .firstOrNull {
            it.first.contains(input)
        } ?: "No Contact"

    println(result)

    val input0 = "00-44  48 5555 8361".apply { println(length % 2 == 0) }
    val input2 = "0 - 22 1985--324".trim().apply { println(length) } // even
    val result2 = input2.split("")
        .filter { it.toIntOrNull() != null }
        .chunked(3)
        .let {
            if (it.last().size == 1) {
                val newFormat = it.takeLast(2)
                    .joinToString("")
                    .split("")
                    .filter { it.toIntOrNull() != null }
                    .chunked(2)
                return@let it.dropLast(2) + newFormat
            }
            it
        }
        .joinToString(separator = "-") {
            it.joinToString(separator = "")
        }
    //022-198-53-24
    println(result2)


    val yearOfVacation: Int = 2014
    val startMonth: String = "April"
    val endMonth: String = "May"
    val dayOfWeek: String = "Wednesday"
    // answer = 7

    val holidays = getDays(startMonth, endMonth, yearOfVacation, dayOfWeek)
    println(holidays / 7)

    val target = 3
    val nodes1 = listOf(1, 3)
    val nodes2 = listOf(2, 2)
    val links = nodes1.zip(nodes2)
    val sorted = links.map {
        val (first,second) = it
        listOf(first,second).sorted()
    }
    println(sorted)

}

fun getDays(startMonth: String, endMonth: String, year: Int, startDay: String): Int {

    val weekIndex = listOf(
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    )

    val monthIndex = listOf(
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December",
    )

    val dayInMonth = mapOf(
        "January" to 31,
        "February" to if (isLeapYear(year)) 29 else 28,
        "March" to 31,
        "April" to 30,
        "May" to 31,
        "June" to 30,
        "July" to 31,
        "August" to 31,
        "September" to 30,
        "October" to 31,
        "November" to 30,
        "December" to 31,
    )

    val indexOfStartMonth = monthIndex.indexOf(startMonth)
    val indexOfEndMonth = monthIndex.indexOf(endMonth)
    val result = (indexOfStartMonth..indexOfEndMonth).map {
        val month = monthIndex.get(it)
        dayInMonth.get(month) ?: 0
    }.sum()

    val startedOn = weekIndex.indexOf(startDay)

    return result - startedOn
}


fun isLeapYear(year: Int): Boolean {
    return when {
        year % 4 != 0 -> false
        year % 400 == 0 -> true
        else -> year % 100 != 0
    }
}