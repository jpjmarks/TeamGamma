/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci6110.k1627667.cyclomaticcomplexity;

import java.util.ArrayList;

/**
 *
 * @author james
 */
public class CyclomaticTest {

    // JM
    public /* ArrayList */ void cycloTests(ArrayList<String> file) {
        // System.out.println("method cycloTests begun");//debug
        ArrayList<ArrayList<String>> methods = (ArrayList<ArrayList<String>>) this.seaparateMethods(file).clone(); 
        // creates arraylist of arraylists output by separatemethods method
        for (int i = 0; i < methods.size(); i++) // iterates through methods array list
        {
            ifTest(methods.get(i));
        }

    }


    //need to add functioality to detect main method
    public ArrayList<ArrayList<String>> seaparateMethods(ArrayList<String> file) {
        ArrayList<ArrayList<String>> outArray = new ArrayList<ArrayList<String>>(); // initiates new arraylist of arraylists
        ArrayList<String> methodNames = new ArrayList<String>(); // initiates arraylist used to store names od methods
        String tempString = ""; // creates empty string for temporarily soring each file arraylist element in
        int numOfMethods = 0; // keeps running total of number of methods, used to acess array indexes
        for (int i = 0; i < file.size(); i++) // for loop to iterate through each array element
        {
            tempString = file.get(i); // adds array element at index i to temp string
            if ((tempString.contains("public") || tempString.contains("protected") || tempString.contains("private"))
                    && tempString.contains("(")) // checks each array elemeth for the strings "public" and "(" as these determine
            {

                String[] arrOfStr = tempString.split(" ", 0);
                if (arrOfStr[2].contains("(")) {
                    numOfMethods++;
                    String[] arrOfStr2 = arrOfStr[2].split("\\(", 0);
                    methodNames.add(arrOfStr2[0]);
                    outArray.add(new ArrayList<String>());
                    outArray.get(numOfMethods - 1).add("Line: " + i + " Method: " + methodNames.get(numOfMethods - 1));
                }
            }
            if (methodNames.size() > 0) {
                outArray.get(numOfMethods - 1).add(tempString);
            }
        }
        return outArray;
    }

    // JK 
    //forgot John was doing this so I made I start whoops - James
    public int ifTest(ArrayList<String> method) {
        String tempString = "";
        for (int i = 0; i < method.size(); i++) {
            tempString = method.get(i);
            if (tempString.contains("if")) {
                System.out.println(tempString);
            }
        }
        return 0;
    }

    // JM
    public int caseTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public int defaultTest(ArrayList<String> method) {

        return 0;
    }

    // JM
    public int forTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public int whileTest(ArrayList<String> method) {

        return 0;
    }

    // JM
    public int doWhileTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public int breakTest(ArrayList<String> method) {

        return 0;
    }

    // JM
    public int continueTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public int catchTest(ArrayList<String> method) {

        return 0;
    }

    // JM
    public int finallyTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public int throwTest(ArrayList<String> method) {

        return 0;
    }

    // JM
    public int orTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public int andTest(ArrayList<String> method) {

        return 0;
    }

    // JM
    public int ternaryTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public int returnTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public ArrayList<String> commentTest(ArrayList<String> method) {

        return method;
    }

}
