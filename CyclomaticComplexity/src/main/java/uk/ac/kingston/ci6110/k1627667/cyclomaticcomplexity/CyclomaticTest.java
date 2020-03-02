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
            int runningTotal = 1; //running total opf the complexity, starting at 1 as all methods if runnable will have a complexity of 0 even with no code
            //System.out.println(methods.get(i)); //debug
            methods.set(i, commentTest(methods.get(i))) ; //comment and string tests to remove any  mentions of trigger words
           //each of the following lines runs each individual test on each arraly list returning the score for each test
           //possibly display the scores for individual tests later
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
            scores.add(methods.get(i).get(0) + " has a cyclomatic Score of : " + Integer.toString(runningTotal)); // adds total score to an array to dispaly as he result.
            scores.add("");
        }

        return scores; //returns the array of scores
    }

    public ArrayList<ArrayList<String>> seaparateMethods(ArrayList<String> file)  //initiates separate methods methof with an input of arraylist of type string, returning an array list of array lists
    {        
        ArrayList<ArrayList<String>> outArray = new ArrayList<ArrayList<String>>(); // initiates new 2d arraylist
        ArrayList<String> methodNames = new ArrayList<String>(); // initiates arraylist used to store names od methods
        String tempString = ""; // creates empty string for temporarily soring each file arraylist element in
        ArrayList<Integer> methodStartLinesList = new ArrayList<Integer>();
        ArrayList<Integer> methodEndLinesList = new ArrayList<Integer>();
        for (int i = 0; i < file.size(); i++) // for loop to iterate through each array element
        {
            tempString = file.get(i); // adds array element at index i to temp string
            if (tempString.contains("main") && tempString.contains("(")) //checks if method is main method
            { 
                if (methodNames.size()> 0) //checks if this is the first method in the file
                {
                    methodEndLinesList.add(i-1); //adds end line of previous method to array
                }
                methodStartLinesList.add(i); //adds start line of current method
                 //increases the number of methods by 1
                methodNames.add("main"); //adds "main" to the array of method names
                outArray.add(new ArrayList<String>()); //adds a new array list to the output 2d array
                outArray.get(methodNames.size()  - 1).add("Line: " + i + " Method: " + methodNames.get(methodNames.size()  - 1)); //sets the name of the method as the first element of each arraylist in turn
            }

            //!FIX NEEDED! NEED TO CHECK FOR PRESNCE OF '{' ON CURRENT OR NEXT LINE 

            else if ((tempString.contains("public") || tempString.contains("protected") || tempString.contains("private")) //checks if the current line contains any modifiers that indicate methods
                    && tempString.contains("(")) // checks each array elemeth for the strings "public" and "(" as these determine
            {
                if (methodNames.size()> 0) //checks if this is the first method in the file
                {
                    methodEndLinesList.add(i-1); // adds end line of previous method to array
                }
                String[] arrOfStr = tempString.split(" ", 0); // removes spaces and splits words
                if (arrOfStr[2].contains("(")) { //checks if the 3rd element contains ( as most methods will have this or the will not run
                    methodStartLinesList.add(i); // makes note of the line this method starts on
                    // 
                    String[] arrOfStr2 = arrOfStr[2].split("\\(", 0);
                    methodNames.add(arrOfStr2[0]);
                    outArray.add(new ArrayList<String>());
                    outArray.get(methodNames.size()  - 1).add(methodNames.get(methodNames.size() - 1));
                }
            }
            if (methodNames.size() > 0) {
               outArray.get(methodNames.size() - 1).add(tempString);
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
        // for (int i = 0; i< methodStartLinesList.size();i++)
        // {
        //     System.out.println("start lines "+methodStartLinesList.get(i)); //debug

        // }
        // for (int i = 0; i< methodEndLinesList.size();i++)
        // {
        //     System.out.println("End lines "+methodEndLinesList.get(i)); //debug
        // }
 
        for (int i = 0; i < outArray.size(); i++) {
          outArray.get(i).set(0, "Lines: "+methodStartLinesList.get(i)+" - "+ methodEndLinesList.get(i) + " Method: " + methodNames.get(i) );
        }
        return outArray;
    }

    // JK 
    //forgot John was doing this so I made I start whoops - James
     public int ifTest(ArrayList<String> method) {
    //     int finalIfScore = 0;
    //     String tempString = "";
    //     ArrayList<String> valueLines = new ArrayList<>();

    //     for (int i = 0; i < method.size(); i++) {
    //         tempString = method.get(i);
    //         tempString = tempString.replaceAll(" ","");
    //         //System.out.println(tempString); //debug

    //         if (tempString.contains("elseif")){
    //             valueLines.add("elseif");
    //         }else if (tempString.contains("if")){
    //             valueLines.add("if");
    //         }else if (tempString.contains("else")){
    //             valueLines.add("else");
    //         }
    //     }

    //     //System.out.println(valueLines); //debug
    //     int ifMaxLimit = 0;
    //     while(ifMaxLimit != valueLines.size())
    //     {
    //         String currentLine = valueLines.get(ifMaxLimit);
    //         if(currentLine == "if"){
    //             int escapeOtherIfCheck = 0;
    //             int checkAheadIf = 1;
    //             int ifCount = 1;
    //             int elifCount = 0;
    //             int elseCount = 0;
    //             //System.out.println(currentLine); //debug

    //             //Count else if's and else's contained within the if, need max guard!!
    //             while(escapeOtherIfCheck != 1){
    //                 if(valueLines.get(ifMaxLimit + checkAheadIf) == "elseif"){
    //                     //System.out.println("elif"); //debug
    //                     elifCount++;
    //                     checkAheadIf++;
    //                 }else if(valueLines.get(ifMaxLimit + checkAheadIf)== "else"){
    //                     //System.out.println("else"); //debug
    //                     elseCount++;
    //                     escapeOtherIfCheck++;
    //                 }else if(valueLines.get(ifMaxLimit + checkAheadIf)== "if"){
    //                     //System.out.println("found another"); //debug
    //                     escapeOtherIfCheck++;
    //                 }
    //             }

    //             if(elseCount == 1){
    //                 finalIfScore = finalIfScore + (ifCount + elifCount);
    //             }else if(elseCount == 0){
    //                 if(elifCount == 0 || elifCount == 1)
    //                 {
    //                     finalIfScore++;
    //                 }
    //                 else
    //                 {
    //                     finalIfScore = finalIfScore + (elifCount - ifCount);
    //                 }
    //             }
    //             //System.out.println(finalIfScore); //debug
    //         }
    //         ifMaxLimit++;
    //     }
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
    public int whileTest(ArrayList<String> method) { //Picks up 2 on getGameState on testcode 2, assume this is part of the main method that James is working on (To make it avoid)
        int finalWhileScore = 0;

        for (int i = 0; i < method.size(); i++) {
            String tempString = method.get(i);

            if (tempString.contains("while")){
                finalWhileScore++;
            }
        }
        //System.out.println("While Score = " + finalWhileScore); //debug
        return finalWhileScore;
    }

    // JM
    public int doWhileTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public int breakTest(ArrayList<String> method) {
        int finalBreakScore = 0;

        for (int i = 0; i < method.size(); i++) {
            String tempString = method.get(i);

            if (tempString.contains("break")){
                finalBreakScore++;
            }
        }
        //System.out.println("Break Score = " + finalBreakScore); //debug
        return finalBreakScore;
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
    //added cose to testcode2 in method getGameState to help test this
    public ArrayList<String> commentTest(ArrayList<String> method) {

        return method;
    }

}
