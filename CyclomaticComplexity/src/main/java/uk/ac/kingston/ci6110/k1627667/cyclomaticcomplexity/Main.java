/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci6110.k1627667.cyclomaticcomplexity;
import java.util.Scanner;	
import java.io.File;;
/**
 *
 * @author james
 */
public class Main {
    public static void main(String[] args) throws Exception 
  { 
    File file = new File("/Users/james/Ball.txt"); 
    Scanner sc = new Scanner(file);
    while (sc.hasNextLine()) 
    System.out.println(sc.nextLine());
    
    }
}

// formatting for windows file pathway
// ("C:\\Users\\pankaj\\Desktop\\test.txt");


// "/Users/james/Ball.txt"


// Java Program to illustrate reading from 
// FileReader using FileReader