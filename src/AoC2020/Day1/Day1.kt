package AoC2020.Day1

import java.io.File
import utils.ExecutionTime

val input = File("src/AoC2020/Day1/day1.txt").readLines().map { it.toInt() }

fun part1(): Unit = run outForeach@{ input.forEach { k -> input.drop(0).forEach { e -> if (k+e == 2020)  {return@outForeach println(k*e); } } } }

fun part2(): Unit = run outForeach@{ input.forEach { i -> input.drop(0).forEach { k -> input.drop(0).forEach { e -> if (i+k+e == 2020)  {return@outForeach println(i*k*e); } } } } }

fun main() {
    ExecutionTime.start()
    //part1()
    part2()
    ExecutionTime.stop()


}