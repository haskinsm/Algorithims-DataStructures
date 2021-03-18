
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Michael Haskins
 *  @version 05/10/19 11:13:22 
 *  Time: 3( labs) + 3 + 2 + 1 + 1 + 3
 *  Program gets 98.5% on webcat, 17/10/19.
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: TODO   Theta(1)
     *
     * Justification:
     *  TODO        As this method only accesses one node object, the worst case runtime is Theta(1).
     */
    public boolean isEmpty()
    {
      // TODO
    	if( head == null ) // if head is null tail should be null
    	{
    		return true;
		}
    	return false;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: TODO	Theta(N)
     *
     * Justification:
     *  TODO		The worst-case run time for this occurs when the data is to be inserted at (DataSize - 1).
     *  This would make the function enter the while loop resulting in a runtime cost of
     *  Theta(N). The assignments have no run time cost by the order of growth.
     */
    public void insertBefore( int pos, T data ) 
    {
      //TODO
    	DLLNode newNode = new DLLNode( data, null, null );
    	if( isEmpty())
    	{
    		head = newNode;
    		tail = newNode;
    	}
    	else if( pos <= 0 || pos == 0) // Add to head of non-empty list
    	{
    		DLLNode temp = head;
            head = newNode;
        	head.next = temp; //Should work for every scenario 
        	temp.prev = head;
        	//head.prev should be null already from head = null in constructor of DLL.   		
    	}
    	else //Add somewhere in the middle of the list or to tail of list
    	{
    		DLLNode temp = head;
    		int count = 1;
    		if( head != tail)
    		{
				while( temp.next != null) 
				{
					temp = temp.next;
		    		if( pos == count)
		    		{
		    			temp.prev.next = newNode;
		    			newNode.prev = temp.prev;
		    			newNode.next = temp;
		    			temp.prev = newNode;
		    			return;
		    		}
		    		count++;
				}
    		}
    		temp = tail;
    		tail = newNode;
    		tail.prev = temp;
    		temp.next = tail;
    	}
    	return;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: TODO  Theta(N)
     *
     * Justification:
     *  TODO		Worst case runtime scenario occurs when the pos = number of nodes in DLL.
     *  This results in a runtime by the order of growth of Theta(N).
     *
     */
    public T get(int pos) 
    {
      //TODO
    	if( !isEmpty())
    	{
    		/*if( pos <= 0 )
    		{
    			return head.data; //not necessary
    		} */
    		DLLNode temp = head;
    		int count = 0; 
    		boolean dataFound = false;
    		while( !dataFound)
    		{
    			if( count == pos)
    			{
    				return temp.data;
    			}
    			if( temp == tail) //if gets into this if statement the given position is outside the list
    			{
    				return null;
    			}
    			temp = temp.next;
    			count++; // Count goes after if to catch if pos = 0.
    		}
    	}
      return null;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: TODO  Theta(N)
     *
     * Justification:
     *  TODO		Worst case runtime scenario occurs when pos = number of nodes in DLL. 
     *  This results in the program entering a while loop and by the order of growth the run time is Theta(N).
     */
    public boolean deleteAt(int pos) 
    {
      //TODO
    	if( pos >= 0 && !isEmpty() )
    	{
    		int count = 0;
    		DLLNode temp = head;
    		if( count == pos)  //Will catch if at the head.
    		{
    			temp = temp.next;
    			if( head != tail)  //Need these to avoid null pointer exception, if temp == null and then do temp.prev will be errors
    			{
	    			temp.prev = null;
	    			head = temp;
    			}
    			else
    			{
    				head = null;
    			}
    			return true;
    		}
    		while( temp != null ) //only enters if list size is greater than one and pos !=0.
    		{ 
    			DLLNode temp2 = temp;
    			temp = temp.next;
    			if( count == pos )
    			{
    				if( temp == null) //reached end of list if enters here.
        			{
    					temp2 = temp2.prev;
    					tail = temp2;
    					tail.next = null;
    					tail.prev = temp2.prev;
    					
    					return true;
        			}
    				// Only reaches here if pos to delete is in the middle of the list
    				temp2 = temp2.prev;
    				temp.prev = temp2; 
    				temp2.next = temp; // This should work for the tail, as will just be setting next/prev or both to null.
    				return true;
    			}
    			
    			count ++; //Count needs to go after the if to catch is pos is 0.
    		}
    	}
      return false;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: TODO  	Theta(N)
     *
     * Justification:
     *  TODO		The worst case running time occurs when number of nodes in DLL is greater than 2. 
     *  It then enters the while loop and by the order of growth this results in a running time of Theta(N).
     */
    public void reverse()
    {
      //TODO
    	if( !isEmpty() && head != tail ) //Only enters if more than one node in list
    	{
	    	DLLNode currentNode = head;
	    	head = tail;
    		tail = currentNode; 
	    	DLLNode temp = head;
	    	while( temp != null) //Reversing DLL, so next node becomes prev and prev becomes next.
	    	{
	    		currentNode = temp.next;
	    		temp.next = temp.prev;
	    		temp.prev = currentNode;
	    		temp = temp.next;	
	    	}
    	}
    	return;
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements unique.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: TODO  Theta(N^2)
     *
     * Justification: Worst Case run time scenario occurs when number of nodes is greater than 1.
     * The order of growth then for two nested loops is Theta(n^2).
     *  TODO
     */
     public void makeUnique() //removes first instance of any non-unique variables.
    {
      //TODO
    	 if( !isEmpty() && head != tail)
    	 {
	    	 int pos = 0;
	    	 int i = 0;
	    	 while( get( pos ) != null ) 
	    	 {
	    		 //T data = get(pos);
	    		 i = pos + 1;
	    		 while( get(i) != null )    
	    		 {
	    			 if( get(pos).equals(get(i)) && get(i) != null )  
	    			 {
	    				 deleteAt(i); 
	    			 }
	    			 else
	    			 {
	    			 	i++;  //Need to have this incrementation in an else statement, as if a non-unique item is deleted this effects the indexing.
	    			 	//So when item is deleted if the index is then incremented this could have skipped over non-unique element.
	    			 }
	    		 }
	    		 pos++;
	    	 }
    	 }
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: TODO   Theta(1)
     *
     * Justification:
     *  TODO    Running time of this method is Theta(1), as only accessing elements in method 
     *  and when the insert before method is implemented the run time of this should be Theta(1) as only inserting at head of DLL.
     */
    public void push(T item)  //Add item at pos 0.
    {
      //TODO
    	int atHeadOfList = 0;
    	insertBefore( atHeadOfList, item);
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: TODO   Theta(1)
     *
     * Justification:
     *  TODO		Worst case running time is the same as best case running time. Only accessing elements in this method and when
     *  the deleteAt method is called the run time for this is Theta(1) so by the order of Growth the run time is Theta(N).
     */
    public T pop() 
    {
      //TODO
    	if( !isEmpty() )
    	{
    		int atHeadOfList = 0;
    		T item = get( atHeadOfList );
    		if( deleteAt( atHeadOfList ) )
			{
			    return item;
			}
    	}
      return null;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: TODO	Theta(1)
     *
     * Justification:
     *  TODO    Worst Case run time for this is Theta(1), because when inserting a node at the head the insertBefore method has a run time of Theta(1)
     *  and the rest of the code in this method is just assignments and the creating of objects whose run time can be ignored by the order of growth.
     */
    public void enqueue(T item) 
    {
      //TODO   let tail be end of the queue
    		if( head == null)
    		{
    			insertBefore(0, item);
    			return;
    		}
    		DLLNode temp = new DLLNode( item, tail, null);
    		tail.next = temp;
	    	tail = temp;
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: TODO Theta(1)
     *
     * Justification:
     *  TODO		Worst case run time is Theta(1) by the order of growth. When the deleteAt method is called it only has to 
     *  delete an item at the head of the list so does not need to go into the loop in that function. The rest of the code here is only assignments
     *   whose runtime can be ignored by the order of growth.
     */
    public T dequeue() //Dequeuing from the head and queuing from the tail.
    {
      //TODO
    	if( !isEmpty() )
    	{
    		int topOfQPos = 0;
    		T item = get( topOfQPos );
    		if( deleteAt( topOfQPos ) )
    		{
    			return item;
    		}
    		
    	}
      return null;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }

    /*
     * Practice for ETest:  Recursive binary Search method
     * 
     * public boolean binarySearch( int[] a, int x)
     * {
     * 		return binarySearch( a, x, 0);
     * }
     * private boolean binarySearch(int[] a, int x, int currentMiddle)
     * {
     * 		if( currentMiddle == 0)
     * 			currentMiddle = a.length;
     * 		if( currentMiddle < 0 || currentMiddle >= a.length ) 
     * 			return false;
     * 		if( x == a[currentMiddle] ) 
     * 			return true;
     * 		if( x > a[currentMiddle] ) 
     * 			currentMiddle ++;
     * 			binarySearch( a, x, currentMiddle );
     *      if( x < a[currentMiddle] ) 
     * 			currentMiddle --;
     * 			binarySearch( a, x, currentMiddle );
     * 		
     * 		
     * 		
     * }
      */

}


