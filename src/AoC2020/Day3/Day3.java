package AoC2020.Day3;

import utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    private static final List<String> inputLines = FileUtil.readFileString("src/AoC2020/Day3/day3.txt");

    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        List<String> temp = new ArrayList<>();

        for (String inputLine : inputLines) {
            temp.add(inputLine.repeat(200));
        }

        int count = 0;
        int treeCount = 0;
        for (String s : temp) {
            if (s.charAt(count) == '#') {
                treeCount++;
            }
            count += 3;
        }
        System.out.println("Part 1: " + treeCount);
    }

    public static void part2() {
       List<String> temp = new ArrayList<>();

        for (String inputLine : inputLines) {
            temp.add(inputLine.repeat(200));
        }

        long i = count1Down(1, temp);
        i *= count1Down(3, temp);
        i *= count1Down(5, temp);
        i *= count1Down(7, temp);
        i *= count2Down(1, temp);
        System.out.println("Part 2: " + i);
    }

    public static long count1Down(long toTheRight, List<String> list) {
        int count = 0;
        int treeCount = 0;
        for (String s : list) {
            if (s.charAt(count) == '#') {
                treeCount++;
            }
            count += toTheRight;
        }
        return treeCount;
    }

    public static long count2Down(long toTheRight, List<String> list) {
        int count = 0;
        int treeCount = 0;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if ((i % 2 ) == 0){
                if (s.charAt(count) == '#') {
                    treeCount++;
                }
                count += toTheRight;
            }

        }
        return treeCount;
    }
}
