package AoC2020.Day3

import utils.ExecutionTime
import java.io.File

val input = File("src/AoC2020/Day3/day3.txt").readLines()
val list = doubleList(input)

fun doubleList(list: List<String>): List<String> {
    val temp: MutableList<String> = mutableListOf()
    list.forEach { s -> temp.add(s.repeat(200)) }
    return temp
}

fun part1(): Int{
    var count = 0
    var treeCount = 0
    list.forEach { s -> if (s[count] == '#') treeCount++; count += 3 }
    return treeCount
}

fun part2(): Long{
    return  goDown(1,list,1) *
            goDown(3,list,1) *
            goDown(5,list, 1) *
            goDown(7, list, 1) *
            goDown(1, list, 2)
}

fun goDown(toTheRight: Int, list: List<String>, down: Int): Long{
    var treeCount = 0L
    var count = 0
    (0..list.size-down step down).forEach { if (list[it][count] == '#') treeCount++; count+= toTheRight }
    return treeCount
}

fun main() {
    ExecutionTime.start()
    println(part1())
    println(part2())
    ExecutionTime.stop()
}
