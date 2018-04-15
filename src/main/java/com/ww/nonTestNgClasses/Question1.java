package com.ww.nonTestNgClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Question1 {

    public static List<String> outputList = new LinkedList<String>();
    static String[] st1;

    public static void main(String[] args) {
        doesFileExist("sample.txt");
        readFile("sample.txt");

    }

    /**
     * Check if the file exists in the specified path
     *
     * @param filePath
     */
    public static void doesFileExist(String filePath) {
        try {
            File file = new File(filePath);
            boolean found = file.exists();
            if (found) {
                System.out.println("File found");
            } else {
                System.out.println("File not found..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public static void readFile(String file) {
        List<String> finalList = new LinkedList<String>();
        String line = "";
        try {
            FileReader fReader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(fReader);

            while ((line = bReader.readLine()) != null) {
                finalList = parseString(line);
            }

            bReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String str : finalList
                ) {
            System.out.println(str.trim());
        }

    }

    /**
     * Approach followed:
     * 1. passing the each line as a main string to this method
     * 2. Used split method to split the line into array of strings based on the delimiters [-,]
     * 3. fetched strings from the array and add them to the LinkedList
     * 5. Return the list t the calling method
     *
     * Cases: tested lines with possible dictionary patterns
     * 1. string with one "-" and no ","
     * 2. string with one "-" and one ","
     * 3. string with one "-" and two ","
     * 4. duplicate strings
     *
     * @param string
     * @return
     */
    public static List<String> parseString(String string) {
        if (string.length() > 0) {
            st1 = string.split("[-,]");


            for (String string1 : st1
                    ) {
                outputList.add(string1.trim());
            }
        }

        return outputList;
    }




}


