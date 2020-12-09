package AoC2020.Day5;

import utils.FileUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5 {

    private static final List<String> input = FileUtil.readFileString("src/AoC2020/Day5/day5.txt");

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        //input = Collections.singletonList("FBFBBFFRLR"); // controlTest
        int highestSeatNumber = 0;
        for (String s : input) {
            int row = 0;
            int seat = 0;
            for (int i = 0; i < 7; i++) {
                if (s.charAt(i) == 'B') {
                    row += Math.pow(2, 6 - i);
                }
            }
            for (int i = 7; i < 10; i++) {
                if (s.charAt(i) == 'R') {
                    seat += Math.pow(2, 9 - i);
                }
            }
            int seatID = (row * 8) + seat;
            if (seatID > highestSeatNumber) {
                highestSeatNumber = seatID;
            }
        }
        System.out.println("Part 1: " + highestSeatNumber);
    }

    private static void part2() {
        List<Integer> seats = new ArrayList<>();

        for (String s : input) {
            int row = 0;
            int seat = 0;
            for (int i = 0; i < 7; i++) {
                if (s.charAt(i) == 'B') {
                    row += Math.pow(2, 6 - i);
                }
            }
            for (int i = 7; i < 10; i++) {
                if (s.charAt(i) == 'R') {
                    seat += Math.pow(2, 9 - i);
                }
            }
            int seatID = (row * 8) + seat;
            seats.add(seatID);
        }
        Collections.sort(seats);
        int counter = -1;
        for (int i : seats) {
            if (counter != -1 && i - counter == 2) {
                System.out.println("Part 2: " + (i - 1));
                break;
            }
            counter = i;

        }
    }
}
