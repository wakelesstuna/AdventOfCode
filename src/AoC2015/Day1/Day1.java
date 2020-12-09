package AoC2015.Day1;

import utils.FileUtil;

public class Day1 {

    public static void main(String[] args) {
        part1();
        part2();

    }

    public static void part1(){
        String input = FileUtil.readFileString("src/Day1/day1.txt");
        int floor = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '('){
                floor++;
            } else if(c == ')'){
                floor--;
            }
        }
        System.out.println(floor);
    }

    public static void part2(){
        String input = FileUtil.readFileString("src/Day1/day1.txt");
        int floor = 0;
        int j = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '('){
                floor++;
            }else if(c == ')'){
                floor--;
            }
            if (floor == -1){
                j = i + 1;
                break;
            }
        }
        System.out.println(j);
    }
}
