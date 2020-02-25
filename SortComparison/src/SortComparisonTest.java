import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import 

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Ignore;


//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Michael Haskins
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................
    public static final double TOLERANCE = 1e-9;
    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] a = null;
    	assertEquals("Checking if insertion sort handles empty array", null, SortComparison.insertionSort(a));
    	assertEquals("Checking if selection sort handles empty array", null, SortComparison.selectionSort(a));
    	assertEquals("Checking if quick sort handles empty array", null, SortComparison.quickSort(a));
    	assertEquals("Checking if merge sort iterative version handles empty array", null, SortComparison.mergeSortIterative(a));
    	assertEquals("Checking if merge sort recursive version handles empty array", null, SortComparison.mergeSortRecursive(a));
    }
   
    @Test
    public void testInsertionSort()
    {
    	double[] a = {2.0, 3.5, 1.9, 3.2, 4.0, 5.0};
    	double[] aSorted = {1.9, 2.0, 3.2, 3.5, 4.0, 5.0};
    	double[] aNeg = {-2.0, -3.5, -1.0, -4.0, 7.0};
    	double[] aNegSorted = {-4.0, -3.5, -2.0, -1.0, 7.0};
        double[] single = {6.0};
        double[] singleSorted = {6.0};
        
        assertArrayEquals(SortComparison.insertionSort(a), aSorted, TOLERANCE);  //I know I've mixed up the expected and actual but makes no difference
    	assertArrayEquals(SortComparison.insertionSort(aNeg), aNegSorted, TOLERANCE);
    	assertArrayEquals(SortComparison.insertionSort(single), singleSorted, TOLERANCE);
     }

    @Test
    public void testSelectionSort()
    {
    	double[] a = {2.0, 3.5, 1.9, 3.2, 4.0, 5.0};
    	double[] aSorted = {1.9, 2.0, 3.2, 3.5, 4.0, 5.0};
    	double[] aNeg = {-2.0, -3.5, -1.0, -4.0, 7.0};
    	double[] aNegSorted = {-4.0, -3.5, -2.0, -1.0, 7.0};
        double[] single = {6.0};
        double[] singleSorted = {6.0};
        
        assertArrayEquals(SortComparison.selectionSort(a), aSorted, TOLERANCE);
    	assertArrayEquals(SortComparison.selectionSort(aNeg), aNegSorted, TOLERANCE);
    	assertArrayEquals(SortComparison.selectionSort(single), singleSorted, TOLERANCE);
    }
    
    @Test
    public void testQuickSort()
    {
    	double[] a = {2.0, 3.5, 1.9, 3.2, 4.0, 1.0};
    	double[] aSorted = {1.0, 1.9, 2.0, 3.2, 3.5, 4.0};
    	double[] aNeg = {-2.0, -3.5, -1.0, -4.0, 7.0};
    	double[] aNegSorted = {-4.0, -3.5, -2.0, -1.0, 7.0};
        double[] single = {6.0};
        double[] singleSorted = {6.0};
        
        assertArrayEquals(SortComparison.quickSort(a), aSorted, TOLERANCE);
    	assertArrayEquals(SortComparison.quickSort(aNeg), aNegSorted, TOLERANCE);
    	assertArrayEquals(SortComparison.quickSort(single), singleSorted, TOLERANCE);
    }
    
    @Test
    public void testMergeSortIterative()
    {
    	double[] a = {2.0, 3.5, 1.9, 3.2, 4.0, 5.0};
    	double[] aSorted = {1.9, 2.0, 3.2, 3.5, 4.0, 5.0};
    	double[] aNeg = {-2.0, -3.5, -1.0, -4.0, 7.0};
    	double[] aNegSorted = {-4.0, -3.5, -2.0, -1.0, 7.0};
        double[] single = {6.0};
        double[] singleSorted = {6.0};
        
        assertArrayEquals(SortComparison.mergeSortIterative(a), aSorted, TOLERANCE);
    	assertArrayEquals(SortComparison.mergeSortIterative(aNeg), aNegSorted, TOLERANCE);
    	assertArrayEquals(SortComparison.mergeSortIterative(single), singleSorted, TOLERANCE);
    }
    
    @Test
    public void testMergeSortRecursive()
    {
    	double[] a = {2.0, 3.5, 1.9, 3.2, 4.0, 5.0};
    	double[] aSorted = {1.9, 2.0, 3.2, 3.5, 4.0, 5.0};
    	double[] aNeg = {-2.0, -3.5, -1.0, -4.0, 7.0};
    	double[] aNegSorted = {-4.0, -3.5, -2.0, -1.0, 7.0};
        double[] single = {6.0};
        double[] singleSorted = {6.0};
        
        assertArrayEquals(SortComparison.mergeSortRecursive(a), aSorted, TOLERANCE);
    	assertArrayEquals(SortComparison.mergeSortRecursive(aNeg), aNegSorted, TOLERANCE);
    	assertArrayEquals(SortComparison.mergeSortRecursive(single), singleSorted, TOLERANCE);
    }
    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    	double[] array10 = new double[10]; 
    	double[] a100 = new double[100]; 
    	double[] a1000 = new double[1000]; 
    	double[] a1000Duplicates = new double[1000]; 
    	double[] a1000NearlyOrdered = new double[1000]; 
    	double[] a1000Reverse = new double[1000];
    	double[] a1000Sorted = new double[1000];
    	
        double[] b10 = new double[10]; 
        double[] b100 = new double[100]; 
        double[] b1000 = new double[1000];
    	double[] b1000Duplicate = new double[1000]; 
    	double[] b1000Nearly = new double[1000];
    	double[] b1000Reverse = new double[1000]; 
    	double[] b1000Sorted = new double[1000];
    	
    	double[] c10 = new double[10];
    	double[] c100 = new double[100]; 
    	double[] c1000 = new double[1000];
    	double[] c1000Duplicate = new double[1000];
    	double[] c1000Nearly = new double[1000];
    	double[]  c1000Reverse = new double[1000]; 
    	double[] c1000Sorted = new double[1000];
    	
    	double[] d10 = new double[10]; 
    	double[] d100 = new double[100]; 
    	double[] d1000 = new double[1000];
    	double[] d1000Duplicate = new double[1000]; 
    	double[] d1000Nearly = new double[1000];
    	double[] d1000Reverse = new double[1000]; 
    	double[] d1000Sorted = new double[1000];
    	
    	double[] e10 = new double[10]; 
    	double[] e100 = new double[100]; 
    	double[] e1000 = new double[1000];
    	double[] e1000Duplicate = new double[1000]; 
    	double[] e1000Nearly = new double[1000];
    	double[] e1000Reverse = new double[1000]; 
    	double[] e1000Sorted = new double[1000];
    	
    	Scanner scan;
        File file = new File("src/numbers10.txt");
        try {
            scan = new Scanner(file);
            int i = 0;
            while(scan.hasNextDouble())
            {
                array10[i] = scan.nextDouble();
                i++;
            }
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
        
        System.arraycopy(array10, 0, b10, 0, array10.length);
        System.arraycopy(array10, 0, c10, 0, array10.length);
        System.arraycopy(array10, 0, d10, 0, array10.length);
        System.arraycopy(array10, 0, e10, 0, array10.length);
        
        
        Scanner scan2;
        File file2 = new File("src/numbers100.txt");
        try {
            scan2 = new Scanner(file2);
            int i = 0;
            while(scan2.hasNextDouble())
            {
                a100[i] = scan2.nextDouble();
                i++;
            }
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
        
        System.arraycopy(a100, 0, b100, 0, a100.length);
        System.arraycopy(a100, 0, c100, 0, a100.length);
        System.arraycopy(a100, 0, d100, 0, a100.length);
        System.arraycopy(a100, 0, e100, 0, a100.length);
        
        
        Scanner scan3;
        File file3 = new File("src/numbers1000.txt");
        try {
            scan3 = new Scanner(file3);
            int i = 0;
            while(scan3.hasNextDouble())
            {
                a1000[i] = scan3.nextDouble();
                i++;
            }
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
        
        System.arraycopy(a1000, 0, b1000, 0, a1000.length);
        System.arraycopy(a1000, 0, c1000, 0, a1000.length);
        System.arraycopy(a1000, 0, d1000, 0, a1000.length);
        System.arraycopy(a1000, 0, e1000, 0, a1000.length);
        
        
        Scanner scan4;
        File file4 = new File("src/numbers1000Duplicates.txt");
        try {
            scan4 = new Scanner(file4);
            int i = 0;
            while(scan4.hasNextDouble())
            {
                a1000Duplicates[i] = scan4.nextDouble();
                i++;
            }
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
        
        System.arraycopy(a1000Duplicates, 0, b1000Duplicate, 0, a1000Duplicates.length);
        System.arraycopy(a1000Duplicates, 0, c1000Duplicate, 0, a1000Duplicates.length);
        System.arraycopy(a1000Duplicates, 0, d1000Duplicate, 0, a1000Duplicates.length);
        System.arraycopy(a1000Duplicates, 0, e1000Duplicate, 0, a1000Duplicates.length);
        
        
        Scanner scan5;
        File file5 = new File("src/numbersNearlyOrdered1000.txt");
        try {
            scan5 = new Scanner(file5);
            int i = 0;
            while(scan5.hasNextDouble())
            {
                a1000NearlyOrdered[i] = scan5.nextDouble();
                i++;
            }
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
        
        System.arraycopy(a1000NearlyOrdered, 0, b1000Nearly, 0, a1000NearlyOrdered.length);
        System.arraycopy(a1000NearlyOrdered, 0, c1000Nearly, 0, a1000NearlyOrdered.length);
        System.arraycopy(a1000NearlyOrdered, 0, d1000Nearly, 0, a1000NearlyOrdered.length);
        System.arraycopy(a1000NearlyOrdered, 0, e1000Nearly, 0, a1000NearlyOrdered.length);
        
        

        Scanner scan6;
        File file6 = new File("src/numbersReverse1000.txt");
        try {
            scan6 = new Scanner(file6);
            int i = 0;
            while(scan6.hasNextDouble())
            {
                a1000Reverse[i] = scan6.nextDouble();
                i++;
            }
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
        
        System.arraycopy(a1000Reverse, 0, b1000Reverse, 0, a1000Reverse.length);
        System.arraycopy(a1000Reverse, 0, c1000Reverse, 0, a1000Reverse.length);
        System.arraycopy(a1000Reverse, 0, d1000Reverse, 0, a1000Reverse.length);
        System.arraycopy(a1000Reverse, 0, e1000Reverse, 0, a1000Reverse.length);
        
        
        Scanner scan7;
        File file7 = new File("src/numbersSorted1000.txt");
        try {
            scan7 = new Scanner(file7);
            int i = 0;
            while(scan7.hasNextDouble())
            {
                a1000Sorted[i] = scan7.nextDouble();
                i++;
            }
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
        
        System.arraycopy(a1000Sorted, 0, b1000Sorted, 0, a1000Sorted.length);
        System.arraycopy(a1000Sorted, 0, c1000Sorted, 0, a1000Sorted.length);
        System.arraycopy(a1000Sorted, 0, d1000Sorted, 0, a1000Sorted.length);
        System.arraycopy(a1000Sorted, 0, e1000Sorted, 0, a1000Sorted.length);
    	
      System.nanoTime()
        
        
        System.out.println("Array Size - 10");
        Stopwatch stopwatch1 = Stopwatch.();
        SortComparison.insertionSort(array10);
    	   double time = stopwatch1.elapsedTime();
    	   System.out.println("Elapsed Time Insert " + time);
    	   
    	   Stopwatch stopwatch2 = new Stopwatch();
           SortComparison.quickSort(b10);
       	   double time2 = stopwatch2.elapsedTime();
       	   System.out.println("Elapsed Time Quick " + time2);  
       	   
       	   Stopwatch stopwatch3 = new Stopwatch();
       	   SortComparison.mergeSortIterative(c10);
    	   double time3 = stopwatch3.elapsedTime();
    	   System.out.println("Elapsed Time Merge iterative " + time3);
    	   
    	   Stopwatch stopwatch4 = new Stopwatch();
           SortComparison.mergeSortRecursive(d10);
       	   double time4 = stopwatch4.elapsedTime();
       	   System.out.println("Elapsed Time Shell " + time4);
       	   
	       Stopwatch stopwatch5 = new Stopwatch();
	       SortComparison.selectionSort(e10);
    	   double time5 = stopwatch5.elapsedTime();
    	   System.out.println("Elapsed Time Selection " + time5);
    	   
    	   System.out.println("Array Size - 100");
           Stopwatch stopwatch7 = new Stopwatch();
           SortComparison.insertionSort(a100);
       	   double time7 = stopwatch7.elapsedTime();
       	   System.out.println("Elapsed Time Insert " + time7);
       	   
	       Stopwatch stopwatch8 = new Stopwatch();
	       SortComparison.quickSort(b100);
    	   double time8 = stopwatch8.elapsedTime();
    	   System.out.println("Elapsed Time Quick " + time8);
    	   
    	   Stopwatch stopwatch9 = new Stopwatch();
       	   SortComparison.mergeSortIterative(c100);
    	   double time9 = stopwatch9.elapsedTime();
    	   System.out.println("Elapsed Time Merge " + time9);

    	   Stopwatch stopwatch10 = new Stopwatch();
           SortComparison.mergeSortRecursive(d100);
       	   double time10 = stopwatch10.elapsedTime();
       	   System.out.println("Elapsed Time Shell " + time10);
       	   
	       Stopwatch stopwatch11 = new Stopwatch();
		   SortComparison.selectionSort(e100);
	 	   double time11 = stopwatch11.elapsedTime();
	 	   System.out.println("Elapsed Time Selection " + time11);
	 	   
	 	   Stopwatch stopwatch12 = new Stopwatch();
	       SortComparison.bubbleSort(f100);
	       double time12 = stopwatch12.elapsedTime();
	       System.out.println("Elapsed Time Bubble " + time12);
	       
	       System.out.println("Array Size - 1000");
           Stopwatch stopwatch13 = new Stopwatch();
           SortComparison.insertionSort(a1000);
       	   double time13 = stopwatch13.elapsedTime();
       	   System.out.println("Elapsed Time Insert " + time13);
       	   
       	   Stopwatch stopwatch14 = new Stopwatch();
	       SortComparison.quickSort(b1000);
	 	   double time14 = stopwatch14.elapsedTime();
	 	   System.out.println("Elapsed Time Quick " + time14);
	 	   
	 	   Stopwatch stopwatch15 = new Stopwatch();
      	   SortComparison.mergeSortIterative(c1000);
      	   double time15 = stopwatch15.elapsedTime();
      	   System.out.println("Elapsed Time Merge " + time15);
      	   
      	   Stopwatch stopwatch16 = new Stopwatch();
      	   SortComparison.mergeSortRecursive(d1000);
     	   double time16 = stopwatch16.elapsedTime();
     	   System.out.println("Elapsed Time Shell " + time16);
     	   
     	   Stopwatch stopwatch17 = new Stopwatch();
		   SortComparison.selectionSort(e1000);
	 	   double time17 = stopwatch17.elapsedTime();
	 	   System.out.println("Elapsed Time Selection " + time17);
	 	   
	       System.out.println("Array Size - 1000 - Duplicates");
           Stopwatch stopwatch19 = new Stopwatch();
           SortComparison.insertionSort(a1000Duplicates);
       	   double time19 = stopwatch19.elapsedTime();
       	   System.out.println("Elapsed Time Insert " + time19);
       	
	       Stopwatch stopwatch20 = new Stopwatch();
	       SortComparison.quickSort(b1000Duplicate);
    	   double time20 = stopwatch20.elapsedTime();
    	   System.out.println("Elapsed Time Quick " + time20);
       	   
    	   Stopwatch stopwatch21 = new Stopwatch();
	       SortComparison.mergeSortIterative(c1000Duplicate);
    	   double time21 = stopwatch21.elapsedTime();
    	   System.out.println("Elapsed Time Merge " + time21);
    	   
    	   Stopwatch stopwatch22 = new Stopwatch();
	       SortComparison.mergeSortRecursive(d1000Duplicate);
    	   double time22 = stopwatch22.elapsedTime();
    	   System.out.println("Elapsed Time Shell " + time22);
    	   
    	   Stopwatch stopwatch23 = new Stopwatch();
	       SortComparison.selectionSort(e1000Duplicate);
    	   double time23 = stopwatch23.elapsedTime();
    	   System.out.println("Elapsed Time Selection " + time23);
    	   
    	   System.out.println("Array Size - 1000 - Nearly Ordered");
    	   Stopwatch stopwatch25 = new Stopwatch();
	       SortComparison.insertionSort(a1000Nearly);
    	   double time25 = stopwatch25.elapsedTime();
    	   System.out.println("Elapsed Time Insert " + time25);
    	   
    	   Stopwatch stopwatch26 = new Stopwatch();
	       SortComparison.quickSort(b1000Nearly);
    	   double time26 = stopwatch26.elapsedTime();
    	   System.out.println("Elapsed Time Quick " + time26);
    	   
    	   Stopwatch stopwatch27 = new Stopwatch();
	       SortComparison.mergeSortIterative(c1000Nearly);
    	   double time27 = stopwatch27.elapsedTime();
    	   System.out.println("Elapsed Time Merge " + time27);
    	   
    	   Stopwatch stopwatch28 = new Stopwatch();
	       SortComparison.mergeSortRecursive(d1000Nearly);
    	   double time28 = stopwatch28.elapsedTime();
    	   System.out.println("Elapsed Time Shell " + time28);
    	   
    	   Stopwatch stopwatch29 = new Stopwatch();
	       SortComparison.selectionSort(e1000Nearly);
    	   double time29 = stopwatch29.elapsedTime();
    	   System.out.println("Elapsed Time Selection " + time29);
    	
    	   System.out.println("Array Size - 1000 - Reversed");
    	   Stopwatch stopwatch31 = new Stopwatch();
	       SortComparison.insertionSort(a1000Reverse);
    	   double time31 = stopwatch31.elapsedTime();
    	   System.out.println("Elapsed Time Insert " + time31);
    	   
    	   Stopwatch stopwatch32 = new Stopwatch();
	       SortComparison.quickSort(b1000Reverse);
    	   double time32 = stopwatch32.elapsedTime();
    	   System.out.println("Elapsed Time Quick " + time32);
    	   
    	   Stopwatch stopwatch33 = new Stopwatch();
	       SortComparison.insertionSort(c1000Reverse);
    	   double time33 = stopwatch33.elapsedTime();
    	   System.out.println("Elapsed Time Merge " + time33);
    	   
    	   Stopwatch stopwatch34 = new Stopwatch();
	       SortComparison.insertionSort(d1000Reverse);
    	   double time34 = stopwatch34.elapsedTime();
    	   System.out.println("Elapsed Time Shell " + time34);
    	   
    	   Stopwatch stopwatch35 = new Stopwatch();
	       SortComparison.insertionSort(e1000Reverse);
    	   double time35 = stopwatch35.elapsedTime();
    	   System.out.println("Elapsed Time Selection " + time35);
    	 
    	   System.out.println("Array Size - 1000 - Sorted");
    	   Stopwatch stopwatch37 = new Stopwatch();
	       SortComparison.insertionSort(a1000Sorted);
    	   double time37 = stopwatch37.elapsedTime();
    	   System.out.println("Elapsed Time Insert " + time37);
    	   
    	   Stopwatch stopwatch38 = new Stopwatch();
	       SortComparison.quickSort(b1000Sorted);
    	   double time38 = stopwatch38.elapsedTime();
    	   System.out.println("Elapsed Time Quick " + time38);
    	   
    	   Stopwatch stopwatch39 = new Stopwatch();
	       SortComparison.mergeSortIterative(c1000Sorted);
    	   double time39 = stopwatch39.elapsedTime();
    	   System.out.println("Elapsed Time Merge " + time39);
    	   
    	   Stopwatch stopwatch40 = new Stopwatch();
	       SortComparison.mergeSortRecursive(d1000Sorted);
    	   double time40 = stopwatch40.elapsedTime();
    	   System.out.println("Elapsed Time Shell " + time40);
    	   
    	   Stopwatch stopwatch41 = new Stopwatch();
	       SortComparison.selectionSort(e1000Sorted);
    	   double time41 = stopwatch41.elapsedTime();
    	   System.out.println("Elapsed Time Selection " + time41); 	
    	   */    	   
    }

    
    }


