package AoC2020.Day6;

import utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Day6 {

    private static final List<String> input = FileUtil.readFileString("src/AoC2020/Day6/day6.txt");

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1(){
        int totalYes = 0;
        List<Character> chars = new ArrayList<>();

        for (String s : input){
            if (s.isEmpty()){
                // when we come to an blank line we add the chars size to
                // the total count och totalYes
                totalYes += chars.size();
                chars.clear();
            }else {
                // looping through the line, if chars doesn't contains the
                // char we looking at add it to the list
                for (char c : s.toCharArray()){
                    if (!chars.contains(c)){
                        chars.add(c);
                    }
                }
            }
        }
        System.out.println("Part 1: " + totalYes);
    }

    private static void part2(){
        int totalYes = 0;
        List<Character> chars = new ArrayList<>();
        boolean firstLine = true;
        boolean contains;

        for (String s : input){
            if (s.isEmpty()){
                // when we come to an blank line we add the chars size to
                // the total count och totalYes
                totalYes += chars.size();
                // reset chars to count the next group
                chars.clear();
                firstLine = true;
            }else {
                if (firstLine){
                    // adds all char of the lineBefore to chars
                    for (char c : s.toCharArray()){
                        chars.add(c);
                    }
                    firstLine = false;
                }else {
                    // loops the String backwards
                    for (int i = chars.size() - 1; i >= 0; i--) {
                        // gets the present char
                        char c = chars.get(i);
                        contains = false;
                        // loops the String to se if present char is in the String
                        for (char c2 : s.toCharArray()) {
                            // if we find the char we won't remove it
                            if (c2 == c) {
                                contains = true;
                                break;
                            }
                        }
                        // if the char isn't in the String we remove it
                        if (!contains) {
                            chars.remove(i);
                        }
                    }
                }
            }
        }
        System.out.println("Part 2: " + totalYes);
    }
}