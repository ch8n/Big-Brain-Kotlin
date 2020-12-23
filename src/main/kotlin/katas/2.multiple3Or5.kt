//https://www.codewars.com/kata/514b92a657cdc65150000006/train/kotlin

@file:Suppress("PackageDirectoryMismatch")
package katas.multiple3Or5

// Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
fun main(){
    val limit = 200

    println("======== Chetan ==========")
    println(solution(limit))
    println(solution1(limit))
    println(solution2(limit))
    println(solution3(limit))

    println("======== Community ==========")
    // same as solution1(limit)
    println(solutionC1(limit))
    
}

fun solution(number: Int): Int {
    var acc = 0
    for (i in 0 until number) {
        if(i % 3 == 0 || i % 5 == 0){
            acc = acc + i
        }
    }
    return acc
}

fun solution1(number: Int): Int {
  return (1 until number).filter{it%3==0||it%5==0}.sum()
}

fun solution2(number: Int): Int {
  return (1 until number).sumBy{ if(it%3==0||it%5==0) it else 0 }
}

fun solution3(number: Int): Int {
  return (1 until number).fold(0){ acc,it->if(it%3==0||it%5==0) acc + it else acc }
}

fun solutionC1(number: Int): Int {
  return (3 until number step 3).union((5 until number step 5)).sum()
}


