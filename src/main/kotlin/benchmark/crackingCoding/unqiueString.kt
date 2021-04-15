@file:Suppress("PackageDirectoryMismatch")

package katas.uniqueString

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@Fork(1)
@Warmup(iterations = 5, time = 2)
@Measurement(iterations = 5, time = 2)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
class TestBenchmark {
    private var input: String = ""

    @Setup
    fun setUp() {
        input = "this"
    }

    @Benchmark
    fun isUnique1() {
        val isUnique = input.toSet().size == input.length
    }

    @Benchmark
    fun isUnique2() {
        val list = ArrayList<Int>(128)
        repeat(128) {
            list.add(it, 0)
        }
        input.forEach {
            val index = it.toInt()
            list[index] = list[index] + 1
        }
        val isUnique = list.all { it > 1 }
        println("is unique $input? : $isUnique")
    }



}


