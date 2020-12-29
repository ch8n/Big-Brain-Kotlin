package katas

fun main() {

    val hash = """
        #100daysofcode #learning #freecodecamp #coding #programming #students #koltin #datastructure #developerlife #programminglanguage #programmers #coder #codingdays #development #dev #developers #geeklife #codenewbie #365daysofcode #backtobasics 
        #kotlin #androiddeveloper #android #google #appdevelopment #androiddevelopment #androiddev #java #javaprogramming #programming #100daysofcode #learning #freecodecamp #coding #students #howto
        #androiddeveloper #android #google #androiddev #java #programming #100daysofcode #learning #freecodecamp #coding #students #howto #codenewbie #android11 #11weekofandroid #365daysofcode         
    """.trimIndent()

    val result =hash.split(" ").filter { it.isNotBlank() }.distinct().joinToString(" ")
    println(result)

}