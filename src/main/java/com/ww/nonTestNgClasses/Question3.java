package com.ww.nonTestNgClasses;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Question3 {


    public static void main(String[] args) {

        System.out.println("Generating the 500 random numbers..."+"\n");
        int[] ranList = generateRandom();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value to find nth smallest..."+"\n");
        int n = scanner.nextInt();
        smallest(ranList, n);
    }

    /**
     * @return Generates first 500 random numbers
     */
    public static int[] generateRandom() {
        Random ran = new Random();
        int[] intList = new int[500];
        for (int i = 0; i < intList.length; i++) {
            intList[i] = Math.abs(ran.nextInt());
            System.out.println(intList[i]);
        }
        return intList;
    }

    /**
     * Gives the nth smallest number
     *
     * @param intList
     * @param n
     */
    public static void smallest(int[] intList, int n) {

        System.out.println("\n" + n + "th smallest number is: ");
        int[] sortList = new int[intList.length];
        Arrays.sort(intList); //sort the numbers in ascending order first
        int j = 0;

        //This loop stores the numbers in descending order in an array
        for (int i = intList.length - 1; i >= 0; i--) {
            sortList[j] = intList[i];
            j++;

        }

        System.out.println(sortList[sortList.length - n]); //gets the nth lowest number

    }
}


