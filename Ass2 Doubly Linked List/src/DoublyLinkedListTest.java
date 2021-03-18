import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  Michael Haskins
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    @Test
    public void testIsEmpty()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertTrue( testDLL.isEmpty() ); //test if isEmpty() returns true when there is an empty DLL.
    	testDLL.insertBefore( 0, 1);
    	assertTrue( !testDLL.isEmpty() ); //test if isEmpty() returns false when there is a non-empty DLL.
    }
    
    @Test
    public void testGet() //Tests if get method returns the correct data
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
        assertEquals( "Checking if get returns the data at position 1- expected element returned 2", 2, (int) testDLL.get( 1 ));
        assertEquals( "Checking if get returns the data at position 2- expected element returned 3", 3, (int) testDLL.get( 2 ));
        assertEquals( "Checking if get returns the data at position 1- expected element returned 1", 1, (int) testDLL.get( 0 ));
    }
    
    @Test
    public void deleteAt()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
        //Checks if delete method works
        assertEquals( "Checking if deleteAt correctly deletes the data at position 1- expected return true", true, testDLL.deleteAt( 1 ));
        assertEquals( "Checking if other nodes were unaffected by the deleteAt method- expected return 2 elements", "1,3", testDLL.toString() );
        assertEquals( "Checking if deleteAt correctly deletes the data at position 1- expected return true", true, testDLL.deleteAt( 1 ));
        assertEquals( "Checking if other nodes were unaffected by the deleteAt method- expected return 1 elements", "1", testDLL.toString() );
 
        //Checks if delete method does not delete any of the data when pos entered is not contained within the DLL
        assertEquals( "Checking if deleteAt correctly does not delete the data at position 1, only one node left in DLL- expected return false", false, testDLL.deleteAt( 1 ));
        assertEquals( "Checking if node was unaffected by the deleteAt method- expected return 1 elements", "1", testDLL.toString() );
        assertEquals( "Checking if deleteAt correctly does not delete the data at position -3, only one node left in DLL- expected return false", false, testDLL.deleteAt( -3 ));
        assertEquals( "Checking if node was unaffected by the deleteAt method- expected return 1 elements", "1", testDLL.toString() );
        
        assertEquals( "Checking if deleteAt correctly deletes the data at position 0- expected return true", true, testDLL.deleteAt( 0 ));
        assertEquals( "Checking if node was deleted by the deleteAt method- expected return no elements", "", testDLL.toString() );

        //Checks if deleteAt method fails when DLL is empty and does not change the empty DLL.
        assertEquals( "Checking if deleteAt correctly deletes the data at position 0- expected return false", false, testDLL.deleteAt( 0 ));
        assertEquals( "Checking if DLL unchanged by the deleteAt method- expected return no elements", "", testDLL.toString() );
    }
    
    @Test
    public void testReverse()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.reverse();
    	assertEquals( "Checking if reverse method doesnt fail when there is an empty list", "", testDLL.toString());
    	
    	testDLL.insertBefore(0,1);
    	testDLL.reverse();
    	assertEquals( "Checking if reverse method works to reverse the DLL list from '1' to '1'", "1", testDLL.toString());
    	
    	testDLL.insertBefore(1,2);
    	testDLL.reverse();
    	assertEquals( "Checking if reverse method works to reverse the DLL list from '1,2' to '2,1'", "2,1", testDLL.toString());
     
    	testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);
        
        testDLL.reverse();
        assertEquals( "Checking if reverse method works to reverse the DLL list from '2,1,3,4,5' to '5,4,3,1,2'", "5,4,3,1,2", testDLL.toString());
    }

    @Test
    public void testMakeUnique()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
    	testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
        testDLL.makeUnique();
        assertEquals( "Checking if make unique method doesnt remove unique values from the DLL list which had the elements 1,2,3", "1,2,3", testDLL.toString() ); 
      
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,3);
        testDLL.insertBefore(5,3);
        
        testDLL.makeUnique(); //removes first instance of the non-unique variable
        assertEquals( "Checking if make unique method works to remove non-unique values from the DLL list which had the elements 1,2,3,4,3,3", "1,2,3,4", testDLL.toString() );     
    }
    
    @Test 
    public void testPush()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(1);
    	testDLL.push(2);
    	testDLL.push(3);
    	assertEquals( "Checking if push method successfully adds data to head of the list", "3,2,1", testDLL.toString());	
    }
    
    @Test
    public void testPop()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertEquals( "Checking if pop method successfully returns null when list is empty", null, testDLL.pop());
    	
    	testDLL.push(1);
    	testDLL.push(2);
    	assertEquals( "Checking if pop method successfully returns item at head of list, current list is 2,1",  "2", testDLL.pop().toString()); // toString here changes the return item to String to avoid errors	
    }
    
    @Test
    public void testEnqueue() //adds to tail of DLL
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(2);
    	assertEquals( "Checking if enqueue method successfully adds 2 to DLL",  "2", testDLL.toString());
    	
    	testDLL.enqueue(3);
    	assertEquals( "Checking if enqueue method successfully adds 3 to end of DLL",  "2,3", testDLL.toString());
    }
    
    @Test
    public void testDequeue() //takes from head of DLL
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(2);
    	testDLL.enqueue(4);
    
    	assertEquals( "Checking if dequeue method successfully returns 2 to DLL",  "2", testDLL.dequeue().toString());
    	assertEquals( "Checking if dequeue method successfully deleted the element that was removed. So data left should be 4", "4", testDLL.toString());
    }
}

