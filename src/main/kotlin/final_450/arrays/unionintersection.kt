package final_450.arrays

fun main() {

    unionByPlus()
    unionByUnion()

    val list1 = arrayOf(5, 3)
    val list2 = arrayOf(1, 2, 3, 4, 5)
    val list3 = arrayOf(1, 2, 3)

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

fun unionByPlus(){
    val list1 = listOf(5, 3)
    val list2 = listOf(1, 2, 3, 4, 5)
    val list3 = listOf(1, 2, 3)
    val resultList = (list1 + list2 + list3).distinct()
    println(resultList)
}

fun unionByUnion(){
    val list1 = listOf(5, 3)
    val list2 = listOf(1, 2, 3, 4, 5)
    val list3 = listOf(1, 2, 3)
    val resultSet = list1 union  list2 union  list3
    println(resultSet)
}

