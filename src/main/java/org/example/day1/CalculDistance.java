package org.example.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CalculDistance {

    public static BigInteger calculDistance(String filePath) {
        List<BigInteger> firstArray = new ArrayList<>();
        List<BigInteger> secondArray = new ArrayList<>();
        HashMap<BigInteger, Integer> countMap = new HashMap<>();

        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] info = data.split(" ");

                if (info.length < 4) {
                    continue;
                }

                BigInteger firstValue = new BigInteger(info[0]);
                BigInteger secondValue = new BigInteger(info[3]);

                firstArray.add(firstValue);
                secondArray.add(secondValue);

                // Increment counts for the second value
                countMap.put(secondValue, countMap.getOrDefault(secondValue, 0) + 1);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

        // Sort both arrays
        firstArray.sort(BigInteger::compareTo);
        secondArray.sort(BigInteger::compareTo);

        BigInteger totalDistance = BigInteger.ZERO;
        BigInteger totalSimilarityScore = BigInteger.ZERO;

        // Calculate total distance and similarity score
        for (int i = 0; i < Math.min(firstArray.size(), secondArray.size()); i++) {
            // Calculate total distance
            totalDistance = totalDistance.add(secondArray.get(i).subtract(firstArray.get(i)).abs());

            // Calculate similarity score
            int countInSecondArray = countMap.getOrDefault(firstArray.get(i), 0);
            totalSimilarityScore = totalSimilarityScore.add(firstArray.get(i).multiply(BigInteger.valueOf(countInSecondArray)));
        }

        System.out.println("Total Distance: " + totalDistance);
        System.out.println("Total Similarity Score: " + totalSimilarityScore);
        return totalDistance;
    }
}
