/*
package AoC2015.Day2;

import utils.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day2 {



    public static void main(String[] args) {
        //part1(); //1586300
        part2();
    }

    public static void part1(){
        List<String> input = FileUtil.readFileStringList("src/AoC2015/Day2/day2.txt");
        String[] temp;
        int totalSurface = 0;
        for (String s : input){
            temp = s.split("x");
            int l = Integer.parseInt(temp[0]);
            int w = Integer.parseInt(temp[1]);
            int h = Integer.parseInt(temp[2]);
            int surface = 2*(l*w) + 2*(w*h) + 2*(h*l);
            int minValue = Math.min(l*w, Math.min(w*h,h*l));

            totalSurface += minValue + (surface);
        }
        System.out.println(totalSurface);
    }

    public static void part2(){
        List<String> input = FileUtil.readFileStringList("src/AoC2015/Day2/day2.txt");
        //List<String> input = Collections.singletonList("2x3x4");

        String[] temp;
        int totalRibbon = 0;

        for (String s : input){
            temp = s.split("x");
            int l = Integer.parseInt(temp[0]);
            int w = Integer.parseInt(temp[1]);
            int h = Integer.parseInt(temp[2]);
            int ribbonForBow = l * w * h;
            System.out.println(ribbonForBow);
            ArrayList<Integer>twoLowestNumbers = new ArrayList<>(Arrays.asList(l,w,h));
            Collections.sort(twoLowestNumbers);
            twoLowestNumbers.remove(twoLowestNumbers.size()-1);
            for (int i : twoLowestNumbers){
                totalRibbon += i + i;
            }
            totalRibbon += ribbonForBow;
        }
        System.out.println(totalRibbon);

    }


}*/
