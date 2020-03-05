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
    //Needed for IF testing, much easier with visibility
    ArrayList<Integer> usedElseIfs = new ArrayList<>();
    ArrayList<Integer> usedElses = new ArrayList<>();
    ArrayList<String> finalIfList = new ArrayList<>();

    // JM
    public ArrayList<ArrayList<String>> cycloTests(ArrayList<String> file) 
    {
        ArrayList<ArrayList<String>> methods = (ArrayList<ArrayList<String>>) seaparateMethods(file).clone();
        // creates arraylist of arraylists output by separatemethods method
       ArrayList<ArrayList<String>> scores = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < methods.size(); i++) // iterates through methods array list ignoring the first element which is the name of the method
        {
            scores.add(new ArrayList<String>()); // adds a new array list to the output 2d array
            scores.get(i).add(methods.get(i).get(0)); // adds total score to an array to dispaly as the result.
            int runningTotal = 1; // running total opf the complexity, starting at 1 as all methods if runnable
                                  // will have a complexity of 0 even with no code
            // System.out.println(methods.get(i)); //debug
            int thisTest = 0;
            methods.set(i, commentTest(methods.get(i))); // comment and string tests to remove any mentions of trigger
                                                         // words
            // each of the following lines runs each individual test on each arraly list
            // returning the score for each test
            // possibly display the scores for individual tests later
            // thisTest = ifTest(methods.get(i));
            // scores.get(i).add("If, Else If, and Else statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            // runningTotal = runningTotal + thisTest;
            thisTest = caseTest(methods.get(i));
            scores.get(i).add("Case statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;
            thisTest = defaultTest(methods.get(i));
            scores.get(i).add("Default statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;
            thisTest = forTest(methods.get(i));
            scores.get(i).add("For Loops increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;
            thisTest = whileTest(methods.get(i));
            scores.get(i).add("While Loops increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;
            thisTest = doWhileTest(methods.get(i));
            scores.get(i).add("Do While Loops increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;
            thisTest = breakTest(methods.get(i));
            scores.get(i).add("Break statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;
            thisTest = continueTest(methods.get(i));
            scores.get(i).add("Continue statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;
            thisTest = catchTest(methods.get(i));
            scores.get(i).add("Catch statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;
            thisTest = finallyTest(methods.get(i));
            scores.get(i).add("Finally statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + finallyTest(methods.get(i));
            thisTest = throwTest(methods.get(i));
            scores.get(i).add("Throw statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + throwTest(methods.get(i));
            thisTest = andOrTest(methods.get(i));
            scores.get(i).add("&& and || Boolean conditions increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + andOrTest(methods.get(i));
            thisTest = ternaryTest(methods.get(i));
            scores.get(i).add("Ternary statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + ternaryTest(methods.get(i));
            thisTest = returnTest(methods.get(i));
            scores.get(i).add("Return statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + returnTest(methods.get(i));
            scores.get(i).set(0, methods.get(i).get(0) + " has a cyclomatic Score of : " + Integer.toString(runningTotal)); // adds total score to an array to dispaly as the result.
            scores.get(i).add("");
        }

        return scores; // returns the array of scores
    }

    //JM *COMPLETE*
    public ArrayList<ArrayList<String>> seaparateMethods(ArrayList<String> file) // initiates separate methods methof with an input of arraylist of type string, returning an array list of array lists
    {
        ArrayList<ArrayList<String>> outArray = new ArrayList<ArrayList<String>>(); // initiates new 2d arraylist
        ArrayList<String> methodNames = new ArrayList<String>(); // initiates arraylist used to store names od methods
        String tempString = ""; // creates empty string for temporarily soring each file arraylist element in
        ArrayList<Integer> methodStartLinesList = new ArrayList<Integer>();
        ArrayList<Integer> methodEndLinesList = new ArrayList<Integer>();
        for (int i = 0; i < file.size(); i++) // for loop to iterate through each array element
        {
            tempString = file.get(i); // adds array element at index i to temp string
            if (tempString.contains("main") && tempString.contains("(")) // checks if method is main method
            {
                if (methodNames.size() > 0) // checks if this is the first method in the file
                {
                    methodEndLinesList.add(i - 1); // adds end line of previous method to array
                }
                methodStartLinesList.add(i); // adds start line of current method
                // increases the number of methods by 1
                methodNames.add("main"); // adds "main" to the array of method names
                outArray.add(new ArrayList<String>()); // adds a new array list to the output 2d array
                outArray.get(methodNames.size() - 1)
                        .add("Line: " + i + " Method: " + methodNames.get(methodNames.size() - 1)); // sets the name of the method as the first element ofeach arraylist in turn
            }

            // !FIX NEEDED! NEED TO CHECK FOR PRESNCE OF '{' ON CURRENT OR NEXT LINE

            else if ((tempString.contains("public") || tempString.contains("protected")
                    || tempString.contains("private")) // checks if the current line contains any modifiers that indicate methods
                    && tempString.contains("(")) // checks each array elemeth for the strings "public" and "(" as these determine
            {
                if (methodNames.size() > 0) // checks if this is the first method in the file
                {
                    methodEndLinesList.add(i - 1); // adds end line of previous method to array
                }
                String[] arrOfStr = tempString.split(" ", 0); // removes spaces and splits words
                if (arrOfStr[2].contains("(")) { // checks if the 3rd element contains ( as most methods will have this or the will not run
                    methodStartLinesList.add(i); // makes note of the line this method starts on
                    //
                    String[] arrOfStr2 = arrOfStr[2].split("\\(", 0);
                    methodNames.add(arrOfStr2[0]);
                    outArray.add(new ArrayList<String>());
                    outArray.get(methodNames.size() - 1).add(methodNames.get(methodNames.size() - 1));
                }
            }
            if (methodNames.size() > 0) {
                outArray.get(methodNames.size() - 1).add(tempString);
            }
            if (i == file.size() - 1) {
                methodEndLinesList.add(i);
            }
        }
        // System.out.println("array of arrays"+outArray.size()); //debug
        // System.out.println("num of start lines"+methodStartLinesList.size()); //debug
        // System.out.println("num of end lines"+methodEndLinesList.size()); //debug
        // System.out.println("num of methods"+methodNames.size()); //debug
        // for (int i = 0; i< methodStartLinesList.size();i++)
        // {
        // System.out.println("start lines "+methodStartLinesList.get(i)); //debug

        // }
        // for (int i = 0; i< methodEndLinesList.size();i++)
        // {
        // System.out.println("End lines "+methodEndLinesList.get(i)); //debug
        // }

        for (int i = 0; i < outArray.size(); i++) {
            outArray.get(i).set(0, "Lines: " + methodStartLinesList.get(i) + " - " + methodEndLinesList.get(i)
                    + " Method: " + methodNames.get(i));
        }
        return outArray;
    }

    // JK
    // added code to testcode2 in method getGameState to help test this
    public ArrayList<String> commentTest(ArrayList<String> method) {

        return method;
    }

    // JK
    public int ifTest(ArrayList<String> method) {
        int finalIfScore = 0;
        ArrayList<Integer> allIfLocations = new ArrayList<>();

        for (int i = 0; i < method.size(); i++) {
            String tempString = method.get(i);

            if (tempString.contains("if")) {
                if (tempString.contains("else if")){

                }else{
                    allIfLocations.add(i+3); //Due to the number of ArrayList gone through starting at 0, it appears 3 behind, hence +3.
                }
            }

            
        }

        //System.out.println(allIfLocations); //debug

        for(int i = (allIfLocations.size() - 1); i >= 0; i--)
        {
            //System.out.println("Checking out IF at location, " + allIfLocations.get(i)); //debug
            ifTestRecursion(allIfLocations.get(i), method);
        }
        
        //System.out.println(finalIfList); //debug

        //Score Counting
        for(int i = 0; i < finalIfList.size(); i++)
        {
            String currentLine = finalIfList.get(i);
            int x = i + 1;

            if(currentLine == "if")
            {
                boolean nextIfFound = false;
                int elifCount = 0;
                int elseCount = 0;
                
                while(nextIfFound == false)
                {
                    String temp = "";
                    temp = finalIfList.get(x);

                    if(temp == "else if")
                    {
                        elifCount++;
                    }else if(temp == "else")
                    {
                        elseCount++;
                    }else if(temp == "if")
                    {
                        nextIfFound = true;
                    }
                    else{
                    }
                    x++;

                    if(x >= finalIfList.size())
                    {
                        nextIfFound = true;
                    }
                }

                if(elseCount == 1)
                {
                    finalIfScore = finalIfScore + (1 + elifCount);
                }else if(elifCount == 1){
                    finalIfScore++;
                }else if(elifCount > 1){
                    finalIfScore = finalIfScore + elifCount;
                }else if(elifCount == 0){
                    finalIfScore++;
                }
                //System.out.println(finalIfScore); //debug
            }

        }

        //System.out.println(finalIfScore); //debug
        return finalIfScore;
    }

    public void ifTestRecursion(int startPos, ArrayList<String> method){
        int lineIterator = startPos - 3;
        finalIfList.add("if");
        boolean firstRun = true;
        boolean hitEnd = false;
        boolean lastBracketClosed = false;

        while(hitEnd == false)
        {
            String currentLine = method.get(lineIterator);
            //System.out.println(currentLine); //debug

            int openLocation = currentLine.lastIndexOf("{");
            int closedLocation = currentLine.lastIndexOf("}");

            if(openLocation == closedLocation){
                lineIterator++;
            }

            if(openLocation > closedLocation){
                lastBracketClosed = false;
                lineIterator++;
            }

            if(closedLocation > openLocation && lastBracketClosed == true){
                String removeBracketLine = currentLine;
                String newLine = removeBracketLine.replace( '}' , '?');
                method.set(lineIterator, newLine);
                hitEnd = true;
                //System.out.println("DOUBLE CLOSED FOUND"); //debug
            }else if(closedLocation > openLocation){
                lastBracketClosed = true;
                lineIterator++;
            }

            //System.out.println(currentLine); //debug
            //System.out.println(openLocation + ", " + closedLocation); //debug
            
            // if(firstRun == false){
            //     if(currentLine.contains("if")){
            //         if(currentLine.contains("else if")){
            //         }else{
            //             hitEnd=true;
            //             System.out.println("ANOTHER IF FOUND");
            //         }
            //     }
            // }else{
            //     firstRun = false;
            // }

            if(currentLine.contains("else if"))
            {
                boolean isElseIfUsed = false;

                for(int i = 0; i < usedElseIfs.size(); i++)
                {
                    if(lineIterator == usedElseIfs.get(i))
                    {
                        isElseIfUsed = true;
                    }
                    
                }

                if(isElseIfUsed == false)
                {
                    usedElseIfs.add(lineIterator);
                    finalIfList.add("else if");
                    //System.out.println("Adding ELSE IF"); //debug
                }
            }

            if(currentLine.contains("else"))
            {
                if(currentLine.contains("else if")){
                }else{
                    boolean isElseUsed = false;

                    for(int i = 0; i < usedElses.size(); i++)
                    {
                        if(lineIterator == usedElses.get(i))
                        {
                            isElseUsed = true;
                        }
                        
                    }
    
                    if(isElseUsed == false)
                    {
                        usedElses.add(lineIterator);
                        finalIfList.add("else");
                        hitEnd = true;
                        //System.out.println("Adding ELSE"); // debug
                    }
                }

            }

            if(lineIterator == (method.size() - 1 ))
            {
                hitEnd=true;
            }
        }
    }

    // JM
    public int caseTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public int defaultTest(ArrayList<String> method) {

        return 0;
    }

    // JM *COMPLETE*
    public int forTest(ArrayList<String> method) {
        int score = 0;
        String thisLine = "";
        String nextLine = "";
        for (int i = 0; i < method.size(); i++) {
            thisLine = method.get(i);
            if (i < method.size() - 1) {
                nextLine = method.get(i + 1);
            }
            if (thisLine.contains("for") && (thisLine.contains("{") || nextLine.contains("{")))
            {
                String[] arrOfStr = thisLine.split(" ", 0); // removes spaces and splits words
                if (arrOfStr[0].equals("for")) {
                    score++;
                }
            }
        }
        return score;
    }

    // JK
    public int whileTest(ArrayList<String> method) { // Picks up 2 on getGameState on testcode 2, assume this is part of the main method that James is working on (To make it avoid)
        int finalWhileScore = 0;

        for (int i = 0; i < method.size(); i++) {
            String tempString = method.get(i);

            if (tempString.contains("while")) {
                finalWhileScore++;
            }
        }
        // System.out.println("While Score = " + finalWhileScore); //debug
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

            if (tempString.contains("break")) {
                finalBreakScore++;
            }
        }
        // System.out.println("Break Score = " + finalBreakScore); //debug
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

    // JM *COMPLETE*
    public int andOrTest(ArrayList<String> method) 
    { // start andOr method
        int score = 0; // sets score to 0
        String thisLine = ""; // sets thisline string to null
        for (int i = 0; i < method.size(); i++) 
        { // iterates through each arrayolist element(line of code)
            thisLine = method.get(i); // sets current arraylist elemat to the thisLine string
            {
                if (thisLine.contains("&&")) 
                {
                    String[] arrOfStr1 = thisLine.split("&&"); // removes && and splits words
                    if (arrOfStr1.length == 1) 
                    {
                        score++;
                    } else 
                    {
                        for (int j = 0; j < arrOfStr1.length - 1; j++) 
                        { // iterates for each space between elements
                            score++; // adds 1 to the score for each split
                            // System.out.println(arrOfStr1[j]);// debug
                        }
                    }
                }
                if (thisLine.contains("||")) 
                {
                    String[] arrOfStr2 = thisLine.split("\\|\\|"); // removes || and splits words

                    if (arrOfStr2.length == 1) 
                    {
                        score++;
                    } 
                    else 
                    {
                        for (int k = 0; k < arrOfStr2.length - 1; k++) 
                        { // iterates for each space between elements
                            score++; // adds 1 to the scroe for each split
                            // System.out.println(arrOfStr2[k]);// debug
                        }
                    }
                }

            }

        }
        return score;
    }

    // JM
    public int ternaryTest(ArrayList<String> method) {

        return 0;
    }

    // JK
    public int returnTest(ArrayList<String> method) {

        return 0;
    }

}
