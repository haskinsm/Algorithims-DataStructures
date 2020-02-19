
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
	    	for( int i = 0; i < a.length ; i++)
	    	{
	    	    smallest = a[i];
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
    	recursiveQuick(a, 0, a.length);
    	return a;
    }//end quicksort
    
    private static void recursiveQuick(double a[], int lo, int hi) {
    	if(hi <= lo) {  //As array does not need to be sorted
    	return;
    	}
    	int pivotPos = partition(a, lo, hi); 
    	recursiveQuick(a, lo, pivotPos-1);
    	recursiveQuick(a, pivotPos+1, hi);
    	}
    
    private static int partition(double a[], int lo, int hi) { // Selects a partition element that is greater than or less than elements to right and left respectively
    	int i = lo;
    	int j = hi+1;
    	double pivot = a[lo];
    	while(true) {
	    	while( a[i++] < pivot) {   //Could have errors here, check later
	    		if(i == hi) break;
    	    }
	    	while( pivot < a[j--] ) {
	    		if(j == lo) break;
    	    }
	    	if(i >= j) break;
	    	double temp = a[i];
	    	a[i] = a[j];
	    	a[j] = temp;
    	}
    	a[lo] = a[j];
    	a[j] = pivot;
    	return j;
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
            // For current size of subarrays to 
            // be merged curr_size varies from  
            // 1 to n/2 
            int curr_size;  
                          
            // For picking starting index of  
            // left subarray to be merged 
            int left_start; 
                              
              
            // Merge subarrays in bottom up  
            // manner. First merge subarrays  
            // of size 1 to create sorted  
            // subarrays of size 2, then merge 
            // subarrays of size 2 to create  
            // sorted subarrays of size 4, and 
            // so on. 
            for (curr_size = 1; curr_size <= n-1;  
                          curr_size = 2*curr_size) 
            { 
                  
                // Pick starting point of different 
                // subarrays of current size 
                for (left_start = 0; left_start < n-1; 
                            left_start += 2*curr_size) 
                { 
                    // Find ending point of left  
                    // subarray. mid+1 is starting  
                    // point of right 
                    int mid = Math.min(left_start + curr_size - 1, n-1); 
              
                    int right_end = Math.min(left_start  
                                 + 2*curr_size - 1, n-1); 
              
                    // Merge Subarrays a[left_start...mid] 
                    // & a[mid+1...right_end] 
                    merge(a, left_start, mid, right_end); 
                } 
            }
            return a;
        } 
          
        /* Function to merge the two haves a[l..m] and 
        a[m+1..r] of array a[] */
        static void merge(double a[], int l, int m, int r) 
        { 
            int i, j, k; 
            int n1 = m - l + 1; 
            int n2 = r - m; 
          
            /* create temp arrays */
            double L[] = new double[n1]; 
            double R[] = new double[n2]; 
          
            /* Copy data to temp arrays L[] 
            and R[] */
            for (i = 0; i < n1; i++) 
                L[i] = a[l + i]; 
            for (j = 0; j < n2; j++) 
                R[j] = a[m + 1+ j]; 
          
            /* Merge the temp arrays back into 
            a[l..r]*/
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
          
            /* Copy the remaining elements of  
            L[], if there are any */
            while (i < n1) 
            { 
                a[k] = L[i]; 
                i++; 
                k++; 
            } 
          
            /* Copy the remaining elements of 
            R[], if there are any */
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
            mergeSortIterative(left); // recursive call for left and right
            mergeSortIterative(right); 
  
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
    }

 }//end class

