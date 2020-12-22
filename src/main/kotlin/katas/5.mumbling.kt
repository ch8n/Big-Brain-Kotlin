import kotlin.time.measureTimedValue
//https://www.codewars.com/kata/5667e8f4e3f572a8f2000039
// Mumble -> example : accum("abcd") -> "A-Bb-Ccc-Dddd"
// accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
// accum("cwAt") -> "C-Ww-Aaa-Tttt"

@kotlin.time.ExperimentalTime
fun main(){
    val input = "abcd"
    
    measure("Chetan-1") {
        println(mumble1(input))
    }
    
    measure("Chetan-2") {
        println(mumble2(input))
    }

    measure("Chetan-3") {
        println(mumble3(input))
    }

    measure("Chetan-4") {
        println(mumble4(input))
    }

    measure("Community-1") {
        println(mumbleC1(input))
    }

    measureTimedValue{
        println("TimedValue")
        println(mumble1(input))
    }.also(::println)
}

@kotlin.time.ExperimentalTime
fun measure(tag:String,block:()->Unit){
    Thread(Runnable{
        measureTimedValue { block.invoke() }.also{
            println("""
Inside Thread ${Thread.currentThread().name} 
$tag took ${it} ms
-----"""
)
        }
    }).start()
}

fun mumble1(input:String):String{
    val words = input.toCharArray()
    val mumble = StringBuilder()
    for ((index,word) in words.withIndex()) {
        mumble.append(word.toUpperCase())
        repeat(index){
            mumble.append(word.toLowerCase())
        }
        if(index != words.size -1){
            mumble.append("-")
        }
    }
    return mumble.toString()
}

fun mumble2(input:String) :String {
    var result = ""
    input.toCharArray().forEachIndexed{ index,item->
        result = "$result${item.toUpperCase()}"
        repeat(index){
            result = "$result${item.toLowerCase()}"
        }
        if(input.length-1 != index){
            result = "$result-"
        }
    }
    return result
}


fun mumble3(input:String) :String {
    val answer = input.toCharArray().foldIndexed(""){ index,acc,item->
        var result = "$acc${item.toUpperCase()}"
        repeat(index){
            result = "$result${item.toLowerCase()}"
        }
        if((input.length - 1) != index){
            result = "$result-"
        }
        result
    }
    return answer
}

fun mumble4(input:String):String{
    val words = input.split("")
    val mumble = StringBuilder()
    for ((index,word) in words.withIndex()) {
        mumble.append(word.toUpperCase())
        repeat(index){
            mumble.append(word.toLowerCase())
        }
        if(index != words.size -1){
            mumble.append("-")
        }
    }
    return mumble.toString()
}

fun mumbleC1(words:String):String{
    return words.mapIndexed { index, word -> 
        "${word.toUpperCase()}${word.toString().toLowerCase().repeat(index)}"
    }.joinToString("-")
}

fun mumbleC2(words:String):String{
    return words.mapIndexed { index, word -> 
        "${word.toUpperCase()}${word.toString().toLowerCase().repeat(index)}"
    }.joinToString("-")
}

//-------------- Community response

const val DELIMETER_CHAR = "-"

fun sheryas() {
    // https://twitter.com/imShreyasPatil
    println(mummble("cwAt"))
}

// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/delete-char-at.html#:~:text=Removes%20the%20character%20at%20the,remove%20the%20entire%20supplementary%20character.
fun mummble(word: String): String {
    val mummbleBuilder = StringBuilder()

    return with(mummbleBuilder) {
        word.forEachIndexed { index, char ->
            repeat(index + 1) { count ->
                val newChar = if (count == 0) char.toUpperCase() else char.toLowerCase()
                append(newChar)
            }.also { append(DELIMETER_CHAR) }
        }.also { deleteCharAt(mummbleBuilder.lastIndex) }

        mummbleBuilder.toString()
    }
}


//------

//https://twitter.com/therealshabi

fun shahbaz(words:String):String{
    
    val output = words.toLowerCase().mapIndexed { index,word ->
        word.toString().repeat(index+1).capitalize()
    }
    
    return output.joinToString("-")
}
