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
    public ArrayList<String> cycloTests(ArrayList<String> file) {
        ArrayList<ArrayList<String>> methods = (ArrayList<ArrayList<String>>) seaparateMethods(file).clone(); 
                                         // creates arraylist of arraylists output by separatemethods method
        ArrayList<String> scores = new ArrayList<String>();
        for (int i = 0; i < methods.size(); i++) // iterates through methods array list ignoring the first element which is the name of the method
        {
            int runningTotal = 1;
            //System.out.println(methods.get(i)); //debug
            methods.set(i, commentTest(methods.get(i))) ;
            runningTotal = runningTotal + ifTest(methods.get(i));
            runningTotal = runningTotal + caseTest(methods.get(i));
            runningTotal = runningTotal + defaultTest(methods.get(i));
            runningTotal = runningTotal + forTest(methods.get(i));
            runningTotal = runningTotal + whileTest(methods.get(i));
            runningTotal = runningTotal + doWhileTest(methods.get(i));
            runningTotal = runningTotal + breakTest(methods.get(i));
            runningTotal = runningTotal + continueTest(methods.get(i));
            runningTotal = runningTotal + catchTest(methods.get(i));
            runningTotal = runningTotal + finallyTest(methods.get(i));
            runningTotal = runningTotal + throwTest(methods.get(i));
            runningTotal = runningTotal + orTest(methods.get(i));
            runningTotal = runningTotal + andTest(methods.get(i));
            runningTotal = runningTotal + ternaryTest(methods.get(i));
            runningTotal = runningTotal + returnTest(methods.get(i));
            scores.add(methods.get(i).get(0) + " has a cyclomatic Score of : " + Integer.toString(runningTotal));
            scores.add("");
        }

        return scores;
    }

    public ArrayList<ArrayList<String>> seaparateMethods(ArrayList<String> file) {        
        ArrayList<ArrayList<String>> outArray = new ArrayList<ArrayList<String>>(); // initiates new arraylist of arraylists
        ArrayList<String> methodNames = new ArrayList<String>(); // initiates arraylist used to store names od methods
        String tempString = ""; // creates empty string for temporarily soring each file arraylist element in
        int numOfMethods = 0; // keeps running total of number of methods, used to acess array indexes
        int methodLines = 0;
        ArrayList<Integer> methodStartLinesList = new ArrayList<Integer>();
        ArrayList<Integer> methodEndLinesList = new ArrayList<Integer>();
        for (int i = 0; i < file.size(); i++) // for loop to iterate through each array element
        {
            tempString = file.get(i); // adds array element at index i to temp string
            if (tempString.contains("main") && tempString.contains("("))
            { 
                if (methodLines > 1)
                {
                    methodEndLinesList.add(i-1);
                }
                methodStartLinesList.add(i);
                methodLines =1;
                numOfMethods++;
                methodNames.add("main");
                outArray.add(new ArrayList<String>());
                outArray.get(numOfMethods - 1).add("Line: " + i + " Method: " + methodNames.get(numOfMethods - 1));
            }
            else if ((tempString.contains("public") || tempString.contains("protected") || tempString.contains("private"))
                    && tempString.contains("(")) // checks each array elemeth for the strings "public" and "(" as these determine
            {
                if (methodLines > 1)
                {
                    methodEndLinesList.add(i-1);
                }
                String[] arrOfStr = tempString.split(" ", 0);
                if (arrOfStr[2].contains("(")) {
                    methodStartLinesList.add(i);
                    methodLines =1;
                    numOfMethods++;
                    String[] arrOfStr2 = arrOfStr[2].split("\\(", 0);
                    methodNames.add(arrOfStr2[0]);
                    outArray.add(new ArrayList<String>());
                    outArray.get(numOfMethods - 1).add(methodNames.get(numOfMethods - 1));
                }
            }
            if (methodNames.size() > 0) {
               methodLines++;
               outArray.get(numOfMethods - 1).add(tempString);
            }
            if (i == file.size()-1)
            {
                methodEndLinesList.add(i);
            }
        }
        // System.out.println("array of arrays"+outArray.size()); //debug
        // System.out.println("num of start lines"+methodStartLinesList.size()); //debug
        // System.out.println("num of end lines"+methodEndLinesList.size()); //debug
        // System.out.println("num of methods"+methodNames.size()); //debug


        for (int i = 0; i < outArray.size(); i++) {
          outArray.get(i).set(0, "Lines: "+methodStartLinesList.get(i)+" - "+ methodEndLinesList.get(i) + " Method: " + methodNames.get(i) );
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
                // System.out.println(tempString); //debug
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
