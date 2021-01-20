package AoC2020.Day2

import java.io.File

fun parse(file: File): List<List<String>> = file.readLines().map { it.split(" ",": ","-") }


fun valid1(min: Int, max: Int, char: Char, string: String): Boolean = string.filter { it == char }.count() in min..max

fun valid2(min: Int, max: Int, char: Char, string: String): Boolean = ((string[min -1] == char) xor (string[max -1] == char))

fun part1(file: File): Int {
    var counter = 0
    parse(file).forEach { s -> if (valid1(s[0].toInt(), s[1].toInt(), s[2].first(), s[3])) {counter++} }
    return counter
}

fun part2(file: File): Int {
    var counter = 0
    parse(file).forEach { s -> if (valid2(s[0].toInt(), s[1].toInt(), s[2].first(), s[3])) {counter++} }
    return counter
}


val validHigherFunction1:(min: Int, max: Int, char: Char, string: String) -> Boolean = {min,max,char,string -> (string.filter { it == char}.count() in min..max) }

val validHigherFunction2:(min: Int, max: Int, char: Char, string: String) -> Boolean = {min,max,char,string -> ((string[min-1] == char) xor (string[max-1] == char))}

fun partHigherFunction(file: File, valid: (Int, Int, Char, String) -> Boolean):Int{
    var counter = 0
    parse(file).forEach { s -> if (valid(s[0].toInt(), s[1].toInt(), s[2].first(), s[3])) {counter++} }
    return counter
}

fun main() {
    val file = File("src/AoC2020/Day2/day2.txt")
    println("Part 1: ${part1(file)}")
    println("Part 2: ${part2(file)}")
    println("Part 1: ${partHigherFunction(file, validHigherFunction1)}")
    println("Part 2: ${partHigherFunction(file, validHigherFunction2)}")
}