package AoC2020.Day2;

import utils.FileUtil;

import java.util.List;

public class Day2 {

    private static final List<String> input = FileUtil.readFileString("src/AoC2020/Day2/day2.txt");

    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        int firstNumber;
        int secondNumber;
        int passWordCounter = 0;
        int counter = 0;

        for (String s : input) {
            int indexOf = s.indexOf(':'); // get index of : as start position
            char letter = s.charAt(indexOf - 1); // getting the letter that the password should include
            int indexOf1 = s.indexOf('-'); // to split the two numbers
            firstNumber = Integer.parseInt(s.substring(0, indexOf1)); // getting firstNumber
            secondNumber = Integer.parseInt(s.substring(indexOf1 + 1, indexOf - 2).trim()); // getting SecondNumber
            String password = s.substring(indexOf + 1).trim(); // to get the password to compare against

            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == letter) {
                    counter++;
                }
            }
            if (counter >= firstNumber && counter <= secondNumber) {
                passWordCounter++;
            }
            counter = 0;
        }

        System.out.println("Part 1: " + passWordCounter);

    }

    public static void part2() {
        int firstNumber;
        int secondNumber;
        int counter = 0;

        for (String s : input) {
            int indexOf = s.indexOf(':'); // get index of : as start position
            char letter = s.charAt(indexOf - 1); // getting the letter that the password should include
            int indexOf1 = s.indexOf('-'); // to split the two numbers
            firstNumber = Integer.parseInt(s.substring(0, indexOf1)); // getting firstNumber
            secondNumber = Integer.parseInt(s.substring(indexOf1 + 1, indexOf - 2).trim()); // getting SecondNumber
            String password = s.substring(indexOf + 1).trim(); // to get the password to compare against

            // ^ = xor operator, one of the two must be true not both
            if (password.charAt(firstNumber - 1) == letter ^ password.charAt(secondNumber - 1) == letter) {
                counter++;
            }
        }
        System.out.println("Part 2: " + counter);
    }
}