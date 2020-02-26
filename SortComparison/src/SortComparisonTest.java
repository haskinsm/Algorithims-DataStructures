import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Ignore;

/*
 * Array Size - 10
	Time taken in nano seconds for insertion: 3033
	Time taken in nano seconds for Selection: 2466
	Time taken in nano seconds for quick: 9400
	Time taken in nano seconds for merge iterative: 27433
	Time taken in nano seconds for merge recursive: 6366
	
	Array Size - 100
	Time taken in nano seconds for insertion: 165033
	Time taken in nano seconds for Selection: 129833
	Time taken in nano seconds for quick: 152266
	Time taken in nano seconds for merge iterative: 108733
	Time taken in nano seconds for merge recursive: 90266
	
	Array Size - 1000
	Time taken in nano seconds for insertion: 3563666
	Time taken in nano seconds for Selection: 3144466
	Time taken in nano seconds for quick: 1098499
	Time taken in nano seconds for merge iterative: 179566
	Time taken in nano seconds for merge recursive: 137700
	
	Array Size - 1000 duplicates
	Time taken in nano seconds for insertion: 280600
	Time taken in nano seconds for Selection: 364766
	Time taken in nano seconds for quick: 60966
	Time taken in nano seconds for merge iterative: 179033
	Time taken in nano seconds for merge recursive: 142066
	
	Array Size - 1000 Nearly Ordered
	Time taken in nano seconds for insertion: 246500
	Time taken in nano seconds for Selection: 292933
	Time taken in nano seconds for quick: 338533
	Time taken in nano seconds for merge iterative: 170633
	Time taken in nano seconds for merge recursive: 123433
	
	Array Size - 1000 Reverses
	Time taken in nano seconds for insertion: 311500
	Time taken in nano seconds for Selection: 276766
	Time taken in nano seconds for quick: 491433
	Time taken in nano seconds for merge iterative: 150866
	Time taken in nano seconds for merge recursive: 120733
	
	Array Size - 1000 Sorted
	Time taken in nano seconds for insertion: 234766
	Time taken in nano seconds for Selection: 253200
	Time taken in nano seconds for quick: 463500
	Time taken in nano seconds for merge iterative: 154733
	Time taken in nano seconds for merge recursive: 123033

	a. Which of the sorting algorithms does the order of input have an impact on? Why?
	
	The order of input has an impact on all the algorithms to varying degrees. This can be seen as every algorithm has a 
	different run time when double arrays of size 1000, 1000 nearly sorted, 1000 sorted, 1000 duplicates, 1000 reverse 
	are passed into it.
	
	b. Which algorithm has the biggest difference between the best and worst performance, based
	on the type of input, for the input of size 1000? Why?
	
	My quick sort algorithm has the biggest difference between the best and worst performance based on the type of input.
	For 1000 it has a run time of 1098499, which is its worse run time, and its best is for duplicates of size 1000, which has 
	a run time of 60966 nano seconds.
	
	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
	based on the input size? Please consider only input files with random order for this answer.
	
	Merge recursive has the best scalability, this can be seen for size 10, 100, 1000 its run times in nano seconds
	are 6366, 90266, 137700. 
	Quick sort has the worst scalability, this can be seen for size 10, 100, 1000 its run times in nano seconds are 
	9400, 152266, 1098499.
	
	d. Did you observe any difference between iterative and recursive implementations of merge
	sort?
	
	Yes merge recursive was more efficient for every input array. It was better than merge iterative for a considerable amount.
	
	e. Which algorithm is the fastest for each of the 7 input files?
	
	For size 10- Selection Sort
	For size 100- merge recursive
	For size 1000- merge recursive
	For size 1000 Duplicates- Quick sort
	For size 1000 Nearly Ordered- merge recursive.
	For size 1000 Reversed- merge recursive.
	For size 1000 Sorted- merge recursive.
	
	4. Use of version control
	
	Used Github.
 */

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
    	 
        
        System.out.println("\n" + "Array Size - 10" );
        long nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.insertionSort(array10); //Hoping that it receives an unsorted array each time
        }
        long nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for insertion: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.selectionSort(b10); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for Selection: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.quickSort(c10); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for quick: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortIterative(d10); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge iterative: "
                + ((nano_endTime - nano_startTime)/3) );
       
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortRecursive(e10); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge recursive: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        
        //100's
        System.out.println("\n" + "Array Size - 100" );
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.insertionSort(a100); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for insertion: "
                + ((nano_endTime - nano_startTime)/3) );
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.selectionSort(b100); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for Selection: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.quickSort(c100); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for quick: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortIterative(d100); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge iterative: "
                + ((nano_endTime - nano_startTime)/3) );
       
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortRecursive(e100); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge recursive: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        
        //For 1000's
        System.out.println("\n" + "Array Size - 1000" );
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.insertionSort(a1000); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for insertion: "
                + ((nano_endTime - nano_startTime)/3) );
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.selectionSort(b1000); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for Selection: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.quickSort(c1000); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for quick: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortIterative(d1000); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge iterative: "
                + ((nano_endTime - nano_startTime)/3) );
       
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortRecursive(e1000); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge recursive: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        //For 1000's Duplicates
        System.out.println("\n" + "Array Size - 1000 duplicates" );
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.insertionSort(a1000Duplicates); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for insertion: "
                + ((nano_endTime - nano_startTime)/3) );
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.selectionSort(b1000Duplicate); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for Selection: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.quickSort(c1000Duplicate); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for quick: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortIterative(d1000Duplicate); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge iterative: "
                + ((nano_endTime - nano_startTime)/3) );
       
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortRecursive(e1000Duplicate); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge recursive: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        //For 1000's Nearly Ordered
        System.out.println("\n" + "Array Size - 1000 Nearly Ordered");
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.insertionSort(a1000NearlyOrdered); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for insertion: "
                + ((nano_endTime - nano_startTime)/3) );
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.selectionSort(b1000Nearly); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for Selection: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.quickSort(c1000Nearly); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for quick: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortIterative(d1000Nearly); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge iterative: "
                + ((nano_endTime - nano_startTime)/3) );
       
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortRecursive(e1000Nearly); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge recursive: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        //1000'S Reveres
        System.out.println("\n" + "Array Size - 1000 Reverses" );
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.insertionSort(a1000Reverse); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for insertion: "
                + ((nano_endTime - nano_startTime)/3) );
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.selectionSort(b1000Reverse); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for Selection: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.quickSort(c1000Reverse); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for quick: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortIterative(d1000Reverse); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge iterative: "
                + ((nano_endTime - nano_startTime)/3) );
       
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortRecursive(e1000Reverse); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge recursive: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        
        //1000 Sorted
        System.out.println("\n" + "Array Size - 1000 Sorted");
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.insertionSort(a1000Sorted); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for insertion: "
                + ((nano_endTime - nano_startTime)/3) );
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.selectionSort(b1000Sorted); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for Selection: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.quickSort(c1000Sorted); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for quick: "
                + ((nano_endTime - nano_startTime)/3) );
        
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortIterative(d1000Sorted); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge iterative: "
                + ((nano_endTime - nano_startTime)/3) );
       
        
        nano_startTime = System.nanoTime();
        for(int i=0; i<3; i++) //To calc. average of 3 running times
        {
        	SortComparison.mergeSortRecursive(e1000Sorted); 
        }
        nano_endTime = System.nanoTime(); 
        System.out.println("Time taken in nano seconds for merge recursive: "
                + ((nano_endTime - nano_startTime)/3) );
          	   
    }

    
    }


