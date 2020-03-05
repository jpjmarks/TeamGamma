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
    //File file = new File("/Users/kellacy/Documents/testcode.txt"); //John Test
   //File file = new File("/Users/james/Documents/University/Y3/Dependable Systems/Team Gamma/TeamGamma/CyclomaticComplexity/src/main/java/uk/ac/kingston/ci6110/k1627667/cyclomaticcomplexity/testcode.txt"); // James Test File Location
   // File file = new File("/Users/kellacy/Documents/testcode2.txt"); //John Test
   //File file = new File("/Users/james/Documents/University/Y3/Dependable Systems/Team Gamma/TeamGamma/CyclomaticComplexity/src/main/java/uk/ac/kingston/ci6110/k1627667/cyclomaticcomplexity/testcode.txt"); // James Test File Location
  File file = new File("/Users/james/Documents/University/Y3/Dependable Systems/Team Gamma/TeamGamma/CyclomaticComplexity/src/main/java/uk/ac/kingston/ci6110/k1627667/cyclomaticcomplexity/testcode2.txt"); // James Test File Location 2
    CyclomaticTest newTest = new CyclomaticTest();
    sc = new Scanner(file);
    sc2 = new Scanner(file);
    String outp = "";
    ArrayList<String> inArray = new ArrayList<String>();
    ArrayList<ArrayList<String>> outArray = new ArrayList<ArrayList<String>>();

    while (sc.hasNextLine()) 
    {
      outp = outp + sc.nextLine().trim();
      inArray.add(sc2.nextLine().trim());
    }
    outArray = newTest.cycloTests(inArray);
    
   for(int i=0;i<outArray.size();i++)  
    {  
      for (int j =0;j<outArray.get(i).size();j++)
      {
     System.out.println(outArray.get(i).get(j));     
      }
    }  
  }

}

// formatting for windows file pathway
// ("C:\\Users\\pankaj\\Desktop\\test.txt");

// formatting for MacOS
// "/Users/james/Ball.txt"

// Java Program to illustrate reading from
// FileReader using FileReader