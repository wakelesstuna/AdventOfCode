package AoC2020.Day8;

import utils.FileUtil;
import java.util.ArrayList;
import java.util.List;

public class Day8 {

    private static final List<String> input = FileUtil.readFileString("src/AoC2020/Day8/day8.txt");

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1(){
        int programCounter = 0;
        int accCounter = 0;
        List<Integer> programCounters = new ArrayList<>();
        while (true){
            programCounters.add(programCounter);
            String s = input.get(programCounter);
            String[] lines = s.split(" ");
            int i = Integer.parseInt(lines[1]);
            switch (lines[0]){
                case "nop" -> programCounter++;
                case "acc" -> { programCounter++; accCounter += i; }
                case "jmp" -> programCounter += i;
            }
            if (programCounters.contains(programCounter)){
                System.out.println("Part 1: " + accCounter);
                break;
            }
        }
    }

    private static void part2(){

        int index = 0;
        boolean run = true;
        boolean found;
        String old = "";
        Result working;
        do {
            found = false;
            while (!found && index < input.size()){
                String op = input.get(index);
                String[] opAndArgs = op.split(" ");
                if (opAndArgs[0].equals("nop")){
                    found = true;
                    old = input.get(index);
                    input.set(index,old.replace("nop", "jmp"));
                }else if (opAndArgs[0].equals("jmp")){
                    found = true;
                    old = input.get(index);
                    input.set(index, old.replace("jmp", "nop"));
                }else{
                    index++;
                }
            }
            working = checkProgram(input);
            if (!working.isWorking){
                run = false;
            }else {
                input.set(index,old);
            }
            index++;
        }while (run && index < input.size());

        System.out.println("Part 2: " + working.acc);

    }

    public static Result checkProgram(List<String> input){
        int programCounter = 0;
        int accCounter = 0;
        Result resultToReturn = new Result();

        List<Integer> programCounters = new ArrayList<>();
        while (true){
            programCounters.add(programCounter);
            String s = input.get(programCounter);
            String[] lines = s.split(" ");
            int i = Integer.parseInt(lines[1]);
            switch (lines[0]){
                case "nop" -> programCounter++;
                case "acc" -> { programCounter++; accCounter += i; }
                case "jmp" -> programCounter += i;
            }
            if (programCounters.contains(programCounter)){
                resultToReturn.isWorking = true;
                resultToReturn.acc = accCounter;
                break;
            }else if (programCounter >= input.size()){
                resultToReturn.isWorking = false;
                resultToReturn.acc = accCounter;
                break;
            }
        }
        return resultToReturn;
    }

    static class Result{
        boolean isWorking;
        int acc;
    }
}
