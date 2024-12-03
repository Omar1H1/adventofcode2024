package org.example.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculifDisc {

    public static void count(String filePath) {
        int safeCount = 0;
        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                List<BigInteger> levels = new ArrayList<>();

                String data = myReader.nextLine();
                String[] info = data.split(" ");

                for (String s : info) {
                    levels.add(new BigInteger(s));
                }

                if (isSafe(levels)) {
                    safeCount++;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }

        System.out.println("Total safe reports: " + safeCount);
    }

    private static boolean isSafe(List<BigInteger> levels) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            BigInteger current = levels.get(i);
            BigInteger next = levels.get(i + 1);
            BigInteger difference = next.subtract(current).abs();

            if (difference.compareTo(BigInteger.ONE) < 0 || difference.compareTo(BigInteger.valueOf(3)) > 0) {
                return false;
            }

            if (current.compareTo(next) < 0) {
                isDecreasing = false;
            } else if (current.compareTo(next) > 0) {
                isIncreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }
}