package AoC2020.Day10;

import utils.FileUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day10 {

    private static final List<String> input = FileUtil.readFileString("src/AoC2020/Day10/day10.txt");
    private static final List<Integer> inputInt = input.stream().mapToInt(Integer::parseInt).boxed().sorted(Integer::compareTo).collect(Collectors.toList());
    private static Map<String, Long> paths;


    public static void main(String[] args) {
        part1();

    }

    private static void part1(){
        inputInt.sort(Integer::compareTo);
        inputInt.add(0,0);
        inputInt.add(inputInt.get(inputInt.size() -1) + 3);


        int diff1 = 1;
        int diff3 = 1;
        for (int i = 1; i < inputInt.size(); i++) {
            int diff = inputInt.get(i) - inputInt.get(i-1);
            switch (diff){
                case 1 -> diff1++;
                case 3 -> diff3++;
            }
        }
        System.out.println("Part 1: " + (diff1 * diff3));
        paths = new HashMap<>();
        System.out.println("Part 2: " + part2(inputInt));

    }

    private static long part2(List<Integer> inputInt){
        if (inputInt.size() == 1){
            return 1;
        }
        long arrangements = 0;
        int index = 1;
        int current = inputInt.get(0);
        while (inputInt.size() > index && inputInt.get(index) - current < 4){
            List<Integer> subList = inputInt.subList(index, inputInt.size());
            String subListStr = Arrays.toString(subList.toArray(new Integer[0]));
            if(paths.containsKey(subListStr))
            {
                arrangements += paths.get(subListStr);
            }
            else
            {
                long subArrangements = part2(subList);
                paths.put(subListStr, subArrangements);
                arrangements += subArrangements;
            }
            index++;
        }
        return arrangements;
    }

}
