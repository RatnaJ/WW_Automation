package com.ww.nonTestNgClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Question1 {

    public static List<String> outputList = new LinkedList<String>();

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
     * 2. finding the index value of the delimiters (- ,)
     * 3. based on the index values of delimiters, getting the stream of chars between the delimiters as substrings
     * 4. Every time the substring is fetched from the main string, adding it to the LinkedList
     * 5. finally printing the output list values
     *
     * Cases: tested lines with possible dictionary patterns
     * 1. string with one "-" and no ","
     * 2. string with one "-" and one ","
     * 3. string with one "-" and two ","
     *
     * @param string
     * @return
     */
    public static List<String> parseString(String string) {
        String string1 = "";
        int cIndex = 0;
        int nIndex = 0;
        boolean hyphenCheck = false;

        if (string.length() > 0)
            while (nIndex >= 0) {
                if (hyphenCheck == false) { //This condition is to check for the first "-"
                    nIndex = string.indexOf("-");
                    hyphenCheck = true;
                }

                string1 = string.substring(cIndex, nIndex);
                outputList.add(string1);
                cIndex = nIndex + 1;
                nIndex = string.indexOf(",", cIndex);
                //commaCount++;

                if (nIndex < 0) { //If there are no more commas found in the main string, get the remaining string of chars after the last ","
                    string1 = string.substring(cIndex);
                    outputList.add(string1);

                }

            }
        return outputList;
    }

}


