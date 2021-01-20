package AoC2020.Day3

import utils.ExecutionTime
import java.io.File

val input = File("src/AoC2020/Day3/day3.txt").readLines()

fun bigList(list: List<String>): List<String> = list.map { it.repeat(100) }

fun part1(): Int = goDownTheSlope(3, bigList(input), 1).toInt()

fun part2(): Long = goDownTheSlope(1, bigList(input), 1) *
        goDownTheSlope(3, bigList(input), 1) *
        goDownTheSlope(5, bigList(input), 1) *
        goDownTheSlope(7, bigList(input), 1) *
        goDownTheSlope(1, bigList(input), 2)

fun goDownTheSlope(toTheRight: Int, list: List<String>, down: Int): Long {
    var treeCount = 0L
    var count = 0
    (0..list.size  - down step down).forEach { if (list[it][count] == '#') treeCount++; count += toTheRight }
    return treeCount
}

fun main() {
    ExecutionTime.start()
    println(part1())
    println(part2())
    ExecutionTime.stop()
}
