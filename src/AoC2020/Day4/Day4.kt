package AoC2020.Day4

import java.io.File

val input = File("src/AoC2020/Day4/day4.txt").readLines()
val stringsContains = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

fun main() {
    part1()
    part2()
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

fun part2() {
    var numberOfValidPassports = 0
    var validPassport: Boolean
    val strings = mutableMapOf<String, String>()

    input.forEach { passport ->
        if (passport.isEmpty()) {
            validPassport = true
            strings.forEach { (k, v) ->
                when (k) {
                    "byr" -> {
                        if (strings["byr"]!!.toInt() !in 1920..2002) {
                            validPassport = false
                        }
                    } // byr (Birth Year) - four digits; at least 1920 and at most 2002
                    "iyr" -> {
                        if (strings["iyr"]!!.toInt() !in 2010..2020) {
                            validPassport = false
                        }
                    } // iyr (Issue Year) - four digits; at least 2010 and at most 2020
                    "eyr" -> {
                        if (strings["eyr"]!!.toInt() !in 2020..2030) {
                            validPassport = false
                        }
                    } // eyr (Expiration Year) - four digits; at least 2020 and at most 2030
                    "hcl" -> {
                        if (!strings["hcl"]!!.matches("#[a-f0-9]{6}".toRegex())) {
                            validPassport = false
                        }
                    } // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f
                    "ecl" -> {
                        val color = strings["ecl"]
                        if (color != "amb" && color != "blu" && color != "brn" && color != "gry" && color != "grn" && color != "hzl" && color != "oth") {
                            validPassport = false
                        }
                    } // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth
                    "pid" -> {
                        if (!strings["pid"]!!.matches("[0-9]{9}".toRegex())) {
                            validPassport = false
                        }
                    } // pid (Passport ID) - a nine-digit number, including leading zeroes
                    "hgt" -> {
                        val hgt = strings["hgt"]
                        if (hgt!!.endsWith("cm")) {
                            val hgtCm = hgt.replace("cm", "").toInt()
                            if (hgtCm < 150 || hgtCm > 193) {
                                validPassport = false
                            }
                        } else if (hgt.endsWith("in")) {
                            val hgtIn = hgt.replace("in", "").toInt()
                            if (hgtIn < 59 || hgtIn > 76) {
                                validPassport = false
                            }
                        }else{
                            validPassport = false
                        }
                    }
                    else -> {
                        validPassport = false
                    }
                }
            }
            if (validPassport) {
                numberOfValidPassports++
            }
            strings.clear()
        } else {
            val lines = passport.split(" ")
            lines.forEach { val value = it.split(":"); strings[value[0]] = value[1] }
        }


    }
    println(numberOfValidPassports)
}