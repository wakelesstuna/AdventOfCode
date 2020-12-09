package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {

    public static List<Integer> readFileInt(String location){
        List<Integer> inputNumbers = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(location));
            while (sc.hasNextInt()){
                inputNumbers.add(sc.nextInt());
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputNumbers;

    }

    public static List<String> readFileString(String location) {
        List<String> inputLines = new ArrayList<>();
        try {
           Scanner sc = new Scanner(new File(location));
           while (sc.hasNextLine()){
               inputLines.add(sc.nextLine());
           }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputLines;
    }

}
