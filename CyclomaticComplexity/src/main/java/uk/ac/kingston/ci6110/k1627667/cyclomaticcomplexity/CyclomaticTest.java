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

    public /*ArrayList*/ void CycloTests(ArrayList<String> file)
    {
        for (int i = 0; i < file.size(); i++) 
        {
          System.out.println("Line " + i + ": " + file.get(i));
        }
    }

    public int ifTest(ArrayList<String> method)
    {

        return 0;
    }

    public int caseTest(ArrayList<String> method)
    {

        return 0;
    }

    public int defaultTest(ArrayList<String> method)
    {

        return 0;
    }
    public int forTest(ArrayList<String> method)
    {

        return 0;
    }

    public int whileTest(ArrayList<String> method)
    {

        return 0;
    }

    public int doWhileTest(ArrayList<String> method)
    {

        return 0;
    }

    public int breakTest(ArrayList<String> method)
    {

        return 0;
    }

    public int continueTest(ArrayList<String> method)
    {

        return 0;
    }

    public int catchTest(ArrayList<String> method)
    {

        return 0;
    }

    public int finallyTest(ArrayList<String> method)
    {

        return 0;
    }

    public int throwTest(ArrayList<String> method)
    {

        return 0;
    }

    public int orTest(ArrayList<String> method)
    {

        return 0;
    }

    public int andTest(ArrayList<String> method)
    {

        return 0;
    }

    public int ternaryTest(ArrayList<String> method)
    {

        return 0;
    }

    public int returnTest(ArrayList<String> method)
    {

        return 0;
    }

    
}

