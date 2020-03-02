package uk.ac.kingston.ci6110.k1627667.cyclomaticcomplexity;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;;
/**
 *
 * @author james
 */
public class Main 
{
  private static Scanner sc;
  private static Scanner sc2;

  public static void main(final String[] args) throws Exception 
  {
    //http://www.lizard.ws cyclo tester
     File file = new File("/Users/kellacy/Documents/testcode2.txt"); //John Test
  //File file = new File("/Users/james/Documents/University/Y3/Dependable Systems/Team Gamma/TeamGamma/CyclomaticComplexity/src/main/java/uk/ac/kingston/ci6110/k1627667/cyclomaticcomplexity/testcode.txt"); // James Test File Location
  //File file = new File("/Users/james/Documents/University/Y3/Dependable Systems/Team Gamma/TeamGamma/CyclomaticComplexity/src/main/java/uk/ac/kingston/ci6110/k1627667/cyclomaticcomplexity/testcode2.txt"); // James Test File Location 2
    CyclomaticTest newTest = new CyclomaticTest();
    sc = new Scanner(file);
    sc2 = new Scanner(file);
    String outp = "";
    ArrayList<String> inArray = new ArrayList<String>();
    ArrayList<String> outArray = new ArrayList<String>();

    while (sc.hasNextLine()) 
    {
      outp = outp + sc.nextLine().trim();
      inArray.add(sc2.nextLine().trim());
    }
    outArray = newTest.cycloTests(inArray);
    
   for(int i=0;i<outArray.size();i++)  
    {  
     System.out.println(outArray.get(i));     
    }  
    
    // Get code to readable Point
    // Remove Class
    /*
    final int classBracket = (outp.indexOf("{") + 1);
    final int endPointClass = outp.length();
    System.out.println(classBracket);
    final String outp2 = outp.substring(classBracket, endPointClass);
    System.out.println("");
    System.out.println(outp2);

    // Remove Main Function - Used if there is one in file (Such as this file)
    // int functionBracket = (outp2.indexOf("{") + 1);
    // int endPointFunction = outp2.length();
    // String outp3 = outp2.substring(functionBracket, endPointFunction);
    // System.out.println("");
    // System.out.println(outp3);

    // Remove End
    final int lastLength = (outp2.length() - 1); // Would be 2 if needing to Remove Main Function ^^
    final String outp3 = outp2.substring(0, lastLength);
    System.out.println("");
    System.out.println(outp3);

    // @James
    // Current thoughts are we need to make one consistent test file
    // one in this directory is good but I think we need to expand it and make it
    // more complicated
    // after that we can create some more files to test against to understand which
    // specific use-cases we need to account for.
    // From here we could seperate into an array by ';' or '{' and '}'
    // Need to discuss with James what is required for formula as we can just ignore
    // some code
    */
  }

}

// formatting for windows file pathway
// ("C:\\Users\\pankaj\\Desktop\\test.txt");

// formatting for MacOS
// "/Users/james/Ball.txt"

// Java Program to illustrate reading from
// FileReader using FileReader