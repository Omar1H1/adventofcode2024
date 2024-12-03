package org.example;

import org.example.day1.CalculDistance;
import org.example.day2.CalculifDisc;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculDistance.calculDistance("src/main/resources/input1.txt");
        CalculifDisc.count("src/main/resources/input2.txt");

    }
}