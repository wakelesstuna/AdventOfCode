package AoC2020.Day9;

import utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Day9 {

    private static final List<String> input = FileUtil.readFileString("src/AoC2020/Day9/day9.txt");
    //private static final List<String> input = FileUtil.readFileString("src/AoC2020/Day9/test.txt");
    private static final int test = 25; // 5 for testCode, 25 for realCode

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        List<Integer> prev25 = new ArrayList<>();
        for (int i = 0; i < test; i++) {
            prev25.add(Integer.parseInt(input.get(i)));
        }
        for (int i = test; i < input.size(); i++) {
            int num = Integer.parseInt(input.get(i));
            boolean found = false;
            for (int j = 0; j < prev25.size(); j++) {
                for (int k = j + 1; k < prev25.size(); k++) {
                    int num1 = prev25.get(j);
                    int num2 = prev25.get(k);
                    if (num1 + num2 == num) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                prev25.remove(0);
                prev25.add(num);
            } else {
                System.out.println("Part 1: " + num);
                break;
            }
        }
    }

    private static void part2() {
        List<Integer> prev25 = new ArrayList<>();
        int badNum = 0;
        int badNumIndex = 0;
        for (int i = 0; i < test; i++) {
            prev25.add(Integer.parseInt(input.get(i)));
        }
        for (int i = test; i < input.size(); i++) {
            int num = Integer.parseInt(input.get(i));
            boolean found = false;
            for (int j = 0; j < prev25.size(); j++) {
                for (int k = j + 1; k < prev25.size(); k++) {
                    int num1 = prev25.get(j);
                    int num2 = prev25.get(k);
                    if (num1 + num2 == num) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                prev25.remove(0);
                prev25.add(num);
            } else {
                badNum = num;
                badNumIndex = i;
                break;
            }
        }

        for (int i = 0; i < badNumIndex - 2; i++) {
            for (int j = i+1; j < badNumIndex - 2; j++) {
                int sum = 0;
                int smallest = Integer.MAX_VALUE;
                int largest = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int num = Integer.parseInt(input.get(k));
                    sum += num;
                    if (sum < smallest) {
                        smallest = num;
                    } else if (num > largest) {
                        largest = num;
                    }
                }
                if (sum == badNum) {
                    System.out.println("Part 2: " + (smallest + largest));
                    break;
                }
            }
        }
    }
}
