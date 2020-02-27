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
public class CyclomaticTest
{
    private int counter = 0;
    public int i =0;
    public void setCounter(int c)
    {
        this.counter = c;
    }
    public int getCounter()
    {
        return this.counter;
    }
//JM
    public /*ArrayList*/ void CycloTests(ArrayList<String> file)
    {
        for (int i = 0; i < file.size(); i++) 
        {
          System.out.println("Line " + i + ": " + file.get(i));
        }
    }
//JK
    public int ifTest(ArrayList<String> method)
    {

        return 0;
    }
//JM
    public int caseTest(ArrayList<String> method)
    {

        return 0;
    }
//JK
    public int defaultTest(ArrayList<String> method)
    {

        return 0;
    }
//JM
    public int forTest(ArrayList<String> method)
    {

        return 0;
    }
//JK
    public int whileTest(ArrayList<String> method)
    {

        return 0;
    }
//JM
    public int doWhileTest(ArrayList<String> method)
    {

        return 0;
    }
//JK
    public int breakTest(ArrayList<String> method)
    {

        return 0;
    }
//JM
    public int continueTest(ArrayList<String> method)
    {

        return 0;
    }
//JK
    public int catchTest(ArrayList<String> method)
    {

        return 0;
    }
//JM
    public int finallyTest(ArrayList<String> method)
    {

        return 0;
    }
//JK
    public int throwTest(ArrayList<String> method)
    {

        return 0;
    }
//JM
    public int orTest(ArrayList<String> method)
    {

        return 0;
    }
//JK
    public int andTest(ArrayList<String> method)
    {

        return 0;
    }
//JM
    public int ternaryTest(ArrayList<String> method)
    {

        return 0;
    }
//JK
    public int returnTest(ArrayList<String> method)
    {

        return 0;
    }

    
}

