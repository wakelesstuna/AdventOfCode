package AoC2020.Day2

import java.io.File

fun parse(file: File): List<List<String>> = file.readLines().map { it.split(" ",": ","-") }

fun valid1(min: Int, max: Int, char: Char, string: String): Boolean{
    var counter = 0
    string.forEach { s -> if (s == char) {counter++} }
    return counter in min..max
}

fun part1(file: File): Int {
    var counter = 0
    parse(file).forEach { s -> if (valid1(s[0].toInt(), s[1].toInt(), s[2].first(), s[3])) {counter++} }
    return counter
}

fun valid2(min: Int, max: Int, char: Char, string: String): Boolean = ((string[min -1] == char) xor (string[max -1] == char))

fun part2(file: File): Int {
    var counter = 0
    parse(file).forEach { s -> if (valid2(s[0].toInt(), s[1].toInt(), s[2].first(), s[3])) {counter++} }
    return counter
}

fun main() {
    val file = File("src/AoC2020/Day2/day2.txt")
    println(part1(file))
    println(part2(file))
}