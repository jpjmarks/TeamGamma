/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci6110.k1627667.cyclomaticcomplexity;
import java.util.Scanner;

import javax.naming.MalformedLinkException;

import java.io.File;;
/**
 *
 * @author james
 */
public class Main {
    public static void main(String[] args) throws Exception 
  { 
    File file = new File("/Users/kellacy/Documents/testClass.java"); //John Test File Location
    Scanner sc = new Scanner(file);
    String outp = "";
    while (sc.hasNextLine())
    {
      outp = outp + sc.nextLine().trim();
    }
    System.out.println(outp);
    
    //Get code to readable Point
    //Remove Class
    int classBracket = (outp.indexOf("{") + 1);
    int endPointClass = outp.length();
    System.out.println(classBracket);
    String outp2 = outp.substring(classBracket, endPointClass);
    System.out.println("");
    System.out.println(outp2);

    //Remove Main Function - Used if there is one in file (Such as this file)
    // int functionBracket = (outp2.indexOf("{") + 1);
    // int endPointFunction = outp2.length();
    // String outp3 = outp2.substring(functionBracket, endPointFunction);
    // System.out.println("");
    // System.out.println(outp3);

    //Remove End
    int lastLength = (outp2.length() - 1); //Would be 2 if needing to Remove Main Function ^^
    String outp3 = outp2.substring(0, lastLength);
    System.out.println("");
    System.out.println(outp3);    

    //@James
    //Current thoughts are we need to make one consistent test file
    //one in this directory is good but I think we need to expand it and make it more complicated
    //after that we can create some more files to test against to understand which
    //specific use-cases we need to account for.
    //From here we could seperate into an array by ';' or '{' and '}'
    //Need to discuss with James what is required for formula as we can just ignore some code
  }

}

// formatting for windows file pathway
// ("C:\\Users\\pankaj\\Desktop\\test.txt");

// formatting for MacOS
// "/Users/james/Ball.txt"


// Java Program to illustrate reading from 
// FileReader using FileReader