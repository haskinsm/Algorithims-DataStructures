import static org.junit.Assert.assertEquals;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


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
    	double[] array10 = new double[10]; double[] a100 = new double[100]; double[] a1000 = new double[1000];
    	double[] a1000Duplicates = new double[1000]; double[] a1000NearlyOrdered = new double[1000];
    	double[]  a1000Reverse = new double[1000]; double[] a1000Sorted = new double[1000];
    	
    	File file1 = new File("src/assignment input data files.zip/numbers10.txt");
        In fileReader = new In(file1);
        array10 = fileReader.readAllDoubles();
        fileReader.close();
        
        
        System.out.println("Array Size - 10");
        Stopwatch stopwatch = new Stopwatch();
        SortComparison.insertionSort(array10);
    	double time = stopwatch.elapsedTime();
    	System.out.println("Elapsed Time Insert " + time);
    	   
    	  
    	   
    }

    
    }


