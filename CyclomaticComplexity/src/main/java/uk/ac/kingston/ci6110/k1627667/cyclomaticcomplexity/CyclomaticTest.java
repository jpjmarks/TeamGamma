package uk.ac.kingston.ci6110.k1627667.cyclomaticcomplexity;
import java.util.ArrayList;
/** 
 * @author James Marks & John Kelly
 */

public class CyclomaticTest {
    int commentScore = 0;
    // JM
    public ArrayList<ArrayList<String>> cycloTests(ArrayList<String> file) 
    {
        int totalComplexity = 0;
        ArrayList<ArrayList<String>> methods = (ArrayList<ArrayList<String>>) seaparateMethods(file); // creates arraylist of arraylists output by separatemethods method
        ArrayList<ArrayList<String>> scores = new ArrayList<ArrayList<String>>();
        scores.add(new ArrayList<String>()); // adds a new array list to the output 2d array
        scores.get(0).add("Total Scores"); 
        scores.get(0).add("Overall Complexity: "); 
        scores.get(0).add("Number of Mehods: "+ methods.size());
        scores.get(0).add("Number of Lines: "); 
        scores.get(0).add("Number of Comments: ");
        scores.get(0).add("");
        for (int j = 0; j < methods.size(); j++) // iterates through methods array list ignoring the first element which is the name of the method
        {
            int i = j+1;
            scores.add(new ArrayList<String>()); // adds a new array list to the output 2d array
            scores.get(i).add(methods.get(j).get(0)); // adds total score to an array to dispaly as the result.
            int runningTotal = 1; // running total opf the complexity, starting at 1 as all methods if runnable
                                  // will have a complexity of 0 even with no code
            // System.out.println(methods.get(i)); //debug
            int thisTest = 0;
            methods.set(j, commentTest(methods.get(j))); // comment and string tests to remove any mentions of trigger words
            methods.set(j, variableTest(methods.get(j))); // variable names tests to remove any mentions of trigger words

            // each of the following lines runs each individual test on each arraly list
            // returning the score for each test
            // possibly display the scores for individual tests later

            thisTest = ifTestTwo(methods.get(j));
            scores.get(i).add("If, Else If, and Else statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = caseTest(methods.get(j));
            scores.get(i).add("Case statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = defaultTest(methods.get(j));
            scores.get(i).add("Default statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = forTest(methods.get(j));
            scores.get(i).add("For Loops increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = whileTest(methods.get(j));
            scores.get(i).add("While Loops increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = doWhileTest(methods.get(j));
            scores.get(i).add("Do While Loops increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = breakTest(methods.get(j));
            scores.get(i).add("Break statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = continueTest(methods.get(j));
            scores.get(i).add("Continue statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = catchTest(methods.get(j));
            scores.get(i).add("Catch statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = finallyTest(methods.get(j));
            scores.get(i).add("Finally statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = throwTest(methods.get(j));
            scores.get(i).add("Throw statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = andOrTest(methods.get(j));
            scores.get(i).add("&& and || Boolean conditions increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = ternaryTest(methods.get(j));
            scores.get(i).add("Ternary statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            thisTest = returnTest(methods.get(j));
            scores.get(i).add("Return statements increased this methods score by: " + thisTest); // adds total score to an array to dispaly as the result.
            runningTotal = runningTotal + thisTest;

            totalComplexity = totalComplexity + runningTotal;
            scores.get(i).set(0, methods.get(j).get(0) + " has a cyclomatic Score of : " + Integer.toString(runningTotal)); // adds total score to an array to dispaly as the result.
            scores.get(i).add("");
        }

        scores.get(0).set(0,"Total Scores"); 
        scores.get(0).set(1,"Overall Complexity: " + totalComplexity); 
        scores.get(0).set(3, "Number of Lines: " + file.size());
        scores.get(0).set(4, "Number of Comments: " + commentScore);
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
                    methodEndLinesList.add(i+1); // adds end line of previous method to array
                }
                methodStartLinesList.add(i-1); // adds start line of current method
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
                    methodEndLinesList.add(i-1); // adds end line of previous method to array
                }
                String[] arrOfStr = tempString.split(" ", 0); // removes spaces and splits words
                if (arrOfStr[2].contains("(")) { // checks if the 3rd element contains ( as most methods will have this or the will not run
                    methodStartLinesList.add(i-1); // makes note of the line this method starts on
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

        for (int i = 0; i < outArray.size(); i++) {
            outArray.get(i).set(0, "Lines: " + methodStartLinesList.get(i) + " - " + methodEndLinesList.get(i)
                    + " Method: " + methodNames.get(i));
        }
        return outArray;
    }

    // JK
    // added code to testcode2 in method getGameState to help test this
    public ArrayList<String> commentTest(ArrayList<String> method) {
        //Censor comments
        //count comments (commentCount)
        return method;
    }

    //JK - Complete
    public ArrayList<String> variableTest(ArrayList<String> method) {
        //if, else, case, break, default, for, while, continue, do, catch, throw, return, finally

        for(int i = 0; i < method.size(); i++)
        {
            String deletionName = "";
            String currentLine = method.get(i);

            if(currentLine.contains("int") || currentLine.contains("String") || currentLine.contains("byte") || currentLine.contains("short") || currentLine.contains("long") || currentLine.contains("float") || currentLine.contains("double") || currentLine.contains("char") || currentLine.contains("boolean"))
            {
                //System.out.println("I got here"); //debug
                String[] cutString = currentLine.split(" ");
                int arrLength = cutString.length;

                for(int x = 0; x < arrLength; x++) //Find variable declaration and save the name of the variable
                {
                    if(cutString[x].contains("int") || cutString[x].contains("String") || cutString[x].contains("byte") || cutString[x].contains("short") || cutString[x].contains("long") || cutString[x].contains("float") || cutString[x].contains("double") || cutString[x].contains("char") || cutString[x].contains("boolean"))
                    {
                        if(cutString[x].contains("System.out.println")){
                        }else{
                            //System.out.println(cutString[x]);
                            deletionName = cutString[x+1];
                            x = arrLength;
                            //System.out.println("I'm deleting: " + deletionName + " at line " + (i+3)); //debug
    
                            for(int y = 0; y < method.size(); y++) //Change variable names to, "null"
                            {
                                String deleteLine = method.get(y);
            
                                if(deleteLine.contains(deletionName))
                                {
                                    deleteLine = deleteLine.replace(deletionName, "banana");
                                    method.set(y, deleteLine);
                                    //System.out.println("Deleted"); //debug
                                }
            
                                
                            }
                        }

                    }
                }

            }
        }

        return method;
    }

    public int ifTestTwo(ArrayList<String> method)
    {
        int score = 0;
        String thisLine = "";
        String nextLine = "";
        for (int i = 0; i < method.size(); i++) 
        {
            thisLine = method.get(i);
            if (i < method.size() - 1) 
            {
                nextLine = method.get(i + 1);
            }
            if (thisLine.contains("if") &&((thisLine.contains("{") || nextLine.contains("{"))))
            {
              System.out.println(method.get(i)); //debug

            String[] arrOfStr = thisLine.split(" ", 0); // removes spaces and splits words
                if (arrOfStr[0].contains("if")) 
                {
                  //  System.out.println(method.get(i)); //debug
                    score++;
                }
            }
            if (thisLine.contains("else if") &&((thisLine.contains("{") || nextLine.contains("{"))))
            {
             //  System.out.println(method.get(i)); //debug
                String[] arrOfStr = thisLine.split(" ", 0); // removes spaces and splits words
                if (arrOfStr.length<1)
                { 
                    if (arrOfStr[0].contains("else")||arrOfStr[1].contains("else")) 
                    {
                      //  System.out.println(method.get(i)); //debug
                        score++;
                    }
                }
                else 
                {
                    if (arrOfStr[0].contains("else")) 
                    {
                       // System.out.println(method.get(i)); //debug
                        score++;
                    }
                }
            }
        }
        return score;
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

    // JK *IN PROGRESS*
    public int whileTest(ArrayList<String> method) { // Picks up 2 on getGameState on testcode 2, assume this is part of the main method that James is working on (To make it avoid)
        int finalWhileScore = 0;

        for (int i = 0; i < method.size(); i++) {
            String thisLine = method.get(i);
            String nextLine = "";

            if(i != method.size() - 1)
            {
                nextLine = method.get(i+1);
            }

            if (thisLine.contains("while") && (thisLine.contains("{") || nextLine.contains("{"))) {
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

    // JK *IN PROGRESS*
    public int breakTest(ArrayList<String> method) {
        int finalBreakScore = 0;

        for (int i = 0; i < method.size(); i++) {
            String tempString = method.get(i);

            if (tempString.contains("break") && tempString.contains(";")) {
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
                    } 
                    else 
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
    public int caseTest(ArrayList<String> method) {

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
}
