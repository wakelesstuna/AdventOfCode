package AoC2020.Day4


import java.io.File

val input = File("src/AoC2020/Day4/day4.txt").readLines()
val stringsContains = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

fun main() {
    part1()

}

fun part1() {
    var numberOfValidPassports = 0
    var isValid: Boolean
    val strings = mutableMapOf<String, String>()

    input.forEach { line ->
        if (line.isEmpty()) {
            isValid = true
            stringsContains.forEach {
                if (!strings.containsKey(it)) {
                    isValid = false
                }
            }
            if (isValid) {
                numberOfValidPassports++
            }
            strings.clear()
        } else {
            val lines = line.split(" ")
            lines.forEach { val value = it.split(":"); strings[value[0]] = value[1] }
        }
    }
    println(numberOfValidPassports)


}