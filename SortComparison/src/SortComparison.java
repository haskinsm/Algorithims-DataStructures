
// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Michael Haskins
 *   Lecture notes 
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
	private static double array[];
	
    static double [] insertionSort (double a[]){ //returns list if empty or full
    	if( a == null || a.length == 1)
    	{
    		return a;
    	}
    	double temp;
    	for (int i = 1; i < a.length; i++) {
	    	for(int j = i ; j > 0 ; j--){
		    	if(a[j] < a[j-1]){
		    	temp = a[j];
		    	a[j] = a[j-1];
		    	a[j-1] = temp;
		    	}
    	    }
    	}
    	return a;
        //todo: implement the sort
    }//end insertionsort
    // Given a list 8, 4, 3, 5
    // Sorts in the steps 4, 8|, 3, 5 ... 3, 4, 8|, 5 ... 3, 4, 5, 8|.
	// a is partially sorted after each increment of i.
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){ //returns null if empty list

         //todo: implement the sort
    	if( a == null || a.length == 1)
    	{
    		return a;
    	}
    	double smallest, temp;
    	smallest = 0;
    	for( int j = 0; j < a.length - 1; j++)   //Length is n-1 as no point in looping again for an nth time, as should be all sorted
    	{
    		smallest = a[j];
	    	for( int i = j + 1; i < a.length ; i++)
	    	{
	    		if( smallest > a[i])
	    		{
	    			temp = a[i];
	    			a[i] = smallest;
	    			smallest = temp;
	    		}
	    	}
	    	a[j] = smallest;
    	}
    	return a; 
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){ //Makes use of recursiveQuick and partition methods
    	//todo: implement the sort
    	if( a == null || a.length == 1)
    	{
    		return a;
    	}
    	array = a;
    	recursiveQuick( 0, (a.length - 1));
    	return a;
    }//end quicksort
    
    private static void recursiveQuick( int lo, int hi) {
    	if(hi <= lo) {  //As array does not need to be sorted
    		return;
    	}
    	int pivotPos = partition( lo, hi); 
    	if(lo < (pivotPos - 1)) //If lo == pivotPos then no need to sort what is left of pivotPos 
    	{
    		recursiveQuick( lo, pivotPos-1);
    	}
    	if(hi > pivotPos) ////If hi == pivotPos then no need to sort what is right of pivotPos 
    	{
    	recursiveQuick( pivotPos+1, hi);
    	}
    }
    
    private static int partition( int lo, int hi) { // Selects a partition element that is greater than or less than elements to right and left respectively
        { 
            double pivot = array[hi];  
            int i = (lo-1); // index of smaller element, needs to be -1 to start.
            for (int j=lo; j<hi; j++) 
            { 
                if (array[j] < pivot) 
                { 
                    i++;      
                    // swap elements 
                    double temp = array[i]; 
                    array[i] = array[j]; 
                    array[j] = temp; 
                } 
            } 
      
            // swaps array[i+1] and array[high] (or pivot) 
            double temp = array[i+1];  //Needs to be i+1
            array[i+1] = array[hi]; 
            array[hi] = temp; 
            return i+1; 
        } 
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	//todo: implement the sort
    	if( a == null)
    	{
    		return a;
    	}
    	int n = a.length;
    	mergeSortIterativeCode( a, n);
    	return a;
    }
    
    static double[] mergeSortIterativeCode(double a[], int n) {
            int subarraySize; // current size of subarrays, will range from 1 to n/2 
            int left_start; 
           
            // Merging subarrays in bottom up manner. Merging subarrays of size 1, then size 2, then size 4.....
            for (subarraySize = 1; subarraySize <= n-1;  
                          subarraySize = 2*subarraySize) 
            { 
                for (left_start = 0; left_start < n-1; 
                            left_start += 2*subarraySize) //picking starting point of subarrays  
                { 
                    // Find ending point of left  
                    // subarray. mid+1 is starting  
                    // point of right 
                    int mid = Math.min(left_start + subarraySize - 1, n-1); 
                    int right_end = Math.min(left_start  
                                 + 2*subarraySize - 1, n-1);               
                    // Merge Subarrays                    
                    merge(a, left_start, mid, right_end); 
                } 
            }
            return a;
        } 
          
       //Merges two subarrays
        static void merge(double a[], int l, int m, int r) 
        { 
            int i, j, k; 
            int n1 = m - l + 1; 
            int n2 = r - m; 
            //Temp arrays for left and right
            double L[] = new double[n1]; 
            double R[] = new double[n2]; 
          
            //Copying the temp arrays for their respective ranges
            for (i = 0; i < n1; i++) 
                L[i] = a[l + i]; 
            for (j = 0; j < n2; j++) 
                R[j] = a[m + 1+ j]; 
            //merge back in the sorted temp arrays into a
            i = 0; 
            j = 0; 
            k = l; 
            while (i < n1 && j < n2) 
            { 
                if (L[i] <= R[j]) 
                { 
                    a[k] = L[i]; 
                    i++; 
                } 
                else
                { 
                    a[k] = R[j]; 
                    j++; 
                } 
                k++; 
            } 
          
           //Copies remaining elements if any
            while (i < n1) 
            { 
                a[k] = L[i]; 
                i++; 
                k++; 
            } 
            while (j < n2) 
            { 
                a[k] = R[j]; 
                j++; 
                k++; 
            } 
        }  
    //end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    		//todo: implement the sort
    	if(a == null) 
        { 
            return null; 
        } 
  
        if(a.length > 1) 
        { 
            int middle = a.length / 2; 
  
            // Splitting left part 
            double[] left = new double[middle]; 
            for(int i = 0; i < middle; i++) 
            { 
                left[i] = a[i]; 
            } 
              
            // Splitting right part 
            double[] right = new double[a.length - middle]; 
            for(int i = middle; i < a.length; i++) 
            { 
                right[i - middle] = a[i]; 
            } 
            mergeSortRecursive(left); // recursive call for left and right
            mergeSortRecursive(right); 
  
            int i = 0; 
            int j = 0; 
            int k = 0; 
  
            // Merge left and right arrays 
            while(i < left.length && j < right.length) 
            { 
                if(left[i] < right[j]) 
                { 
                    a[k] = left[i]; 
                    i++; 
                } 
                else
                { 
                    a[k] = right[j]; 
                    j++; 
                } 
                k++; 
            } 
            // Collect remaining elements 
            while(i < left.length) 
            { 
                a[k] = left[i]; 
                i++; 
                k++; 
            } 
            while(j < right.length) 
            { 
                a[k] = right[j]; 
                j++; 
                k++; 
            } 
        } 
        return a;
   }//end mergeSortRecursive
    	
    


   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    	SortComparisonTest.main(args);
    }

 }//end class

