package AoC2020.Day1;

import utils.FileUtil;
import utils.ExecutionTime;
import java.util.List;

public class Day1 {

    private static final  List<Integer> input = FileUtil.readFileInt("src/AoC2020/Day1/day1.txt");

    public static void main(String[] args) {
        ExecutionTime.start();
        part1();
        part2();
        ExecutionTime.stop();
    }

    public static void part1(){
        for (Integer a : input) {
            for (Integer b : input) {
                if (a + b == 2020) {
                    System.out.println("Part 1: " + a * b);
                    return;
                }
            }
        }
    }

    public static void part2(){
        for (Integer a : input) {
            for (Integer b : input) {
                for (Integer c : input) {
                    if (a + b + c == 2020) {
                        System.out.println("Part 2: " + a * b * c);
                        return;
                    }
                }
            }
        }
    }
}
