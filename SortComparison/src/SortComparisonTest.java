import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;
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
        
        assertArrayEquals(SortComparison.insertionSort(a), aSorted, TOLERANCE);
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
    	/*
        //TODO: implement this method
    	double [] array10 = new double[10]; double [] a100 = new double[100]; double [] a1000 = new double[1000];
    	double [] a1000Duplicate = new double[1000]; double [] a1000Nearly = new double[1000];
    	double []  a1000Reverse = new double[1000]; double [] a1000Sorted = new double[1000];
    	
    	File file1 = new File("src/numbers10.txt");
        In fileReader = new In(file1);
        array10 = fileReader.readAllDoubles();
        fileReader.close();
        
        File file2 = new File("src/numbers100.txt");
        In fileReader2 = new In(file2);
        a100 = fileReader2.readAllDoubles();
        fileReader2.close();
        
        File file3 = new File("src/numbers1000.txt");
        In fileReader3 = new In(file3);
        a1000 = fileReader3.readAllDoubles();
        fileReader3.close();
        
        File file4 = new File("src/numbers1000Duplicates.txt");
        In fileReader4 = new In(file4);
        a1000Duplicate = fileReader4.readAllDoubles();
        fileReader4.close();
        
        File file5 = new File("src/numbersNearlyOrdered1000.txt");
        In fileReader5 = new In(file5);
        a1000Nearly = fileReader5.readAllDoubles();
        fileReader5.close();
        
        File file6 = new File("src/numbersReverse1000.txt");
        In fileReader6 = new In(file6);
        a1000Reverse = fileReader6.readAllDoubles();
        fileReader6.close();
        
        File file7 = new File("src/numbersSorted1000.txt");
        In fileReader7 = new In(file7);
        a1000Sorted = fileReader7.readAllDoubles();
        fileReader7.close();
        
        
        StdOut.println("Array Size - 10");
        Stopwatch stopwatch = new Stopwatch();
        SortComparison.insertionSort(array10);
    	   double time = stopwatch.elapsedTime();
    	   StdOut.println("Elapsed Time Insert " + time);
    	   
    	   Stopwatch stopwatch2 = new Stopwatch();
           SortComparison.quickSort(array10);
       	   double time2 = stopwatch2.elapsedTime();
       	   StdOut.println("Elapsed Time Quick " + time2);  
       	   
       	   Stopwatch stopwatch3 = new Stopwatch();
       	   SortComparison.mergeSortIterative(array10);
    	   double time3 = stopwatch3.elapsedTime();
    	   StdOut.println("Elapsed Time Merge " + time3);
    	  
	       Stopwatch stopwatch5 = new Stopwatch();
	       SortComparison.selectionSort(arary10);
    	   double time5 = stopwatch5.elapsedTime();
    	   StdOut.println("Elapsed Time Selection " + time5);
    	   
    	   StdOut.println("Array Size - 100");
           Stopwatch stopwatch7 = new Stopwatch();
           SortComparison.insertionSort(a100);
       	   double time7 = stopwatch7.elapsedTime();
       	   StdOut.println("Elapsed Time Insert " + time7);
       	   
	       Stopwatch stopwatch8 = new Stopwatch();
	       SortComparison.quickSort(b100);
    	   double time8 = stopwatch8.elapsedTime();
    	   StdOut.println("Elapsed Time Quick " + time8);
    	   
    	   Stopwatch stopwatch9 = new Stopwatch();
       	   SortComparison.mergeSort(c100);
    	   double time9 = stopwatch9.elapsedTime();
    	   StdOut.println("Elapsed Time Merge " + time9);
    	  
	       Stopwatch stopwatch11 = new Stopwatch();
		   SortComparison.selectionSort(e100);
	 	   double time11 = stopwatch11.elapsedTime();
	 	   StdOut.println("Elapsed Time Selection " + time11);
	 	 
	       StdOut.println("Array Size - 1000");
           Stopwatch stopwatch13 = new Stopwatch();
           SortComparison.insertionSort(a1000);
       	   double time13 = stopwatch13.elapsedTime();
       	   StdOut.println("Elapsed Time Insert " + time13);
       	   
       	   Stopwatch stopwatch14 = new Stopwatch();
	       SortComparison.quickSort(b1000);
	 	   double time14 = stopwatch14.elapsedTime();
	 	   StdOut.println("Elapsed Time Quick " + time14);
	 	   
	 	   Stopwatch stopwatch15 = new Stopwatch();
      	   SortComparison.mergeSort(c1000);
      	   double time15 = stopwatch15.elapsedTime();
      	   StdOut.println("Elapsed Time Merge " + time15);
     	   
     	   Stopwatch stopwatch17 = new Stopwatch();
		   SortComparison.selectionSort(e1000);
	 	   double time17 = stopwatch17.elapsedTime();
	 	   StdOut.println("Elapsed Time Selection " + time17);
	 	  
	       StdOut.println("Array Size - 1000 - Duplicates");
           Stopwatch stopwatch19 = new Stopwatch();
           SortComparison.insertionSort(a1000Duplicate);
       	   double time19 = stopwatch19.elapsedTime();
       	   StdOut.println("Elapsed Time Insert " + time19);
       	
	       Stopwatch stopwatch20 = new Stopwatch();
	       SortComparison.quickSort(b1000Duplicate);
    	   double time20 = stopwatch20.elapsedTime();
    	   StdOut.println("Elapsed Time Quick " + time20);
       	   
    	   Stopwatch stopwatch21 = new Stopwatch();
	       SortComparison.mergeSort(c1000Duplicate);
    	   double time21 = stopwatch21.elapsedTime();
    	   StdOut.println("Elapsed Time Merge " + time21);
    	   
    	   Stopwatch stopwatch23 = new Stopwatch();
	       SortComparison.selectionSort(e1000Duplicate);
    	   double time23 = stopwatch23.elapsedTime();
    	   StdOut.println("Elapsed Time Selection " + time23);
    	  
    	   StdOut.println("Array Size - 1000 - Nearly Ordered");
    	   Stopwatch stopwatch25 = new Stopwatch();
	       SortComparison.insertionSort(a1000Nearly);
    	   double time25 = stopwatch25.elapsedTime();
    	   StdOut.println("Elapsed Time Insert " + time25);
    	   
    	   Stopwatch stopwatch26 = new Stopwatch();
	       SortComparison.quickSort(b1000Nearly);
    	   double time26 = stopwatch26.elapsedTime();
    	   StdOut.println("Elapsed Time Quick " + time26);
    	   
    	   Stopwatch stopwatch27 = new Stopwatch();
	       SortComparison.mergeSort(c1000Nearly);
    	   double time27 = stopwatch27.elapsedTime();
    	   StdOut.println("Elapsed Time Merge " + time27);
    	  
    	   Stopwatch stopwatch29 = new Stopwatch();
	       SortComparison.selectionSort(e1000Nearly);
    	   double time29 = stopwatch29.elapsedTime();
    	   StdOut.println("Elapsed Time Selection " + time29);
    	  
    	   
    	   StdOut.println("Array Size - 1000 - Reversed");
    	   Stopwatch stopwatch31 = new Stopwatch();
	       SortComparison.insertionSort(a1000Reverse);
    	   double time31 = stopwatch31.elapsedTime();
    	   StdOut.println("Elapsed Time Insert " + time31);
    	   
    	   Stopwatch stopwatch32 = new Stopwatch();
	       SortComparison.quickSort(b1000Reverse);
    	   double time32 = stopwatch32.elapsedTime();
    	   StdOut.println("Elapsed Time Quick " + time32);
    	   
    	   Stopwatch stopwatch33 = new Stopwatch();
	       SortComparison.insertionSort(c1000Reverse);
    	   double time33 = stopwatch33.elapsedTime();
    	   StdOut.println("Elapsed Time Merge " + time33);
    	   
    	   Stopwatch stopwatch34 = new Stopwatch();
	       SortComparison.insertionSort(d1000Reverse);
    	   double time34 = stopwatch34.elapsedTime();
    	   StdOut.println("Elapsed Time Shell " + time34);
    	   
    	   Stopwatch stopwatch35 = new Stopwatch();
	       SortComparison.insertionSort(e1000Reverse);
    	   double time35 = stopwatch35.elapsedTime();
    	   StdOut.println("Elapsed Time Selection " + time35);
    	   
    	   Stopwatch stopwatch36 = new Stopwatch();
	       SortComparison.insertionSort(f1000Reverse);
    	   double time36 = stopwatch36.elapsedTime();
    	   StdOut.println("Elapsed Time Bubble " + time36);
    	   
    	   StdOut.println("Array Size - 1000 - Sorted");
    	   Stopwatch stopwatch37 = new Stopwatch();
	       SortComparison.insertionSort(a1000Sorted);
    	   double time37 = stopwatch37.elapsedTime();
    	   StdOut.println("Elapsed Time Insert " + time37);
    	   
    	   Stopwatch stopwatch38 = new Stopwatch();
	       SortComparison.quickSort(b1000Sorted);
    	   double time38 = stopwatch38.elapsedTime();
    	   StdOut.println("Elapsed Time Quick " + time38);
    	   
    	   Stopwatch stopwatch39 = new Stopwatch();
	       SortComparison.mergeSort(c1000Sorted);
    	   double time39 = stopwatch39.elapsedTime();
    	   StdOut.println("Elapsed Time Merge " + time39);
    	  
    	   Stopwatch stopwatch41 = new Stopwatch();
	       SortComparison.selectionSort(e1000Sorted);
    	   double time41 = stopwatch41.elapsedTime();
    	   StdOut.println("Elapsed Time Selection " + time41);
    	   */
    }

    
    }


