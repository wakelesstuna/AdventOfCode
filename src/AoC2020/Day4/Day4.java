package AoC2020.Day4;

import utils.FileUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 {

    private static final List<String> input = FileUtil.readFileString("src/AoC2020/Day4/day4.txt");


    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        Map<String, String> keyStrings = new HashMap<>();
        String[] keyMustContain = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        boolean validPassport;
        int numberOfvalidPassport = 0;


        for (String passport : input){
            if (passport.isEmpty()){
                validPassport = true;
                for (String must: keyMustContain){
                    if (!keyStrings.containsKey(must)){
                        validPassport = false;
                        break;
                    }
                }
                if (validPassport){
                    numberOfvalidPassport++;
                }
                keyStrings.clear();
            }else {
                String[] lines = passport.split(" ");
                for (String line :lines){
                    String[] key = line.split(":");
                    keyStrings.put(key[0],key[1]);
                }
            }
        }
        System.out.println("Part 1: " + numberOfvalidPassport);
    }

    private static void part2(){
        Map<String, String> keyStrings = new HashMap<>();
        boolean validPassport;
        int numberOfvalidPassport = 0;

        for (String passport : input){

            if (passport.isEmpty()){
                validPassport = true;
                // byr (Birth Year) - four digits; at least 1920 and at most 2002
                if (keyStrings.containsKey("byr")){
                    int year = Integer.parseInt(keyStrings.get("byr"));
                    if (year < 1920 || year > 2002){
                        validPassport = false;
                    }
                }else{
                    validPassport = false;
                }
                // iyr (Issue Year) - four digits; at least 2010 and at most 2020
                if (keyStrings.containsKey("iyr")){
                    int year = Integer.parseInt(keyStrings.get("iyr"));
                    if (year < 2010 || year > 2020){
                        validPassport = false;
                    }
                }else{
                    validPassport = false;
                }
                // eyr (Expiration Year) - four digits; at least 2020 and at most 2030
                if (keyStrings.containsKey("eyr")){
                    int year = Integer.parseInt(keyStrings.get("eyr"));
                    if (year < 2020 || year > 2030){
                        validPassport = false;
                    }
                }else{
                    validPassport = false;
                }
                // hgt (Height) - a number followed by either cm or in:
                //      If cm, the number must be at least 150 and at most 193
                //      If in, the number must be at least 59 and at most 76
                if (keyStrings.containsKey("hgt")){
                    String hgt = keyStrings.get("hgt");
                    if (hgt.endsWith("cm")){
                        int hgtCm = Integer.parseInt(hgt.replace("cm", ""));
                        if (hgtCm < 150 || hgtCm > 193){
                            validPassport = false;
                        }
                    }else if (hgt.endsWith("in")){
                        int hgtIn = Integer.parseInt(hgt.replace("in", ""));
                        if (hgtIn < 59 || hgtIn > 76){
                            validPassport = false;
                        }
                    }else{
                        validPassport = false;
                    }
                }else{
                    validPassport = false;
                }
                // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f
                if (keyStrings.containsKey("hcl")){
                    if (!keyStrings.get("hcl").matches("#[a-f0-9]{6}")){
                        validPassport = false;
                    }
                }else {
                    validPassport = false;
                }
                // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth
                if (keyStrings.containsKey("ecl")){
                    String color = keyStrings.get("ecl");
                    if (!color.equals("amb") && !color.equals("blu") && !color.equals("brn")
                            && !color.equals("gry") && !color.equals("grn") && !color.equals("hzl")
                            && !color.equals("oth")){
                        validPassport = false;
                    }
                }else{
                    validPassport = false;
                }
                // pid (Passport ID) - a nine-digit number, including leading zeroes
                if (keyStrings.containsKey("pid")){
                    if (!keyStrings.get("pid").matches("[0-9]{9}")){
                        validPassport = false;
                    }
                }else{
                    validPassport = false;
                }
                // cid (Country ID) - ignored, missing or not
                if (validPassport){
                    numberOfvalidPassport++;
                }
                keyStrings.clear();
            }else {
                String[] lines = passport.split(" ");
                for (String line :lines){
                    String[] key = line.split(":");
                    keyStrings.put(key[0],key[1]);
                }
            }
        }
        System.out.println("Part 2: " + numberOfvalidPassport);
    }
}
