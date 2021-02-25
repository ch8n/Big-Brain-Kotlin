package final_450.arrays

fun main() {

    val list1 = arrayOf(5, 3)
    val list2 = arrayOf(1, 2, 3, 4, 5)
    val list3 = arrayOf(1, 2, 3)

    val union = list1 + list2 + list3
    println(union.distinct())

    val union2 = list1 union list2.toList() union list3.toList()
    println(union2)

    val intersect = list1
        .filter { list2.contains(it) }
        .filter { list3.contains(it) }
    println(intersect)

    val intersect2 = list1 intersect list2.toList() intersect list3.toList()
    println(intersect2)

    val substraction = list1
        .filter { !list2.contains(it) }
        .filter { !list3.contains(it) }
    println(substraction)

}