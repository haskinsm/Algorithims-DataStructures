import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  TODO  Michael Haskins
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
  //TODO write more tests here.
	@Test
	public void testHeight()
	{
		 BST<Integer, Integer> bst = new BST<Integer, Integer>();
		 assertEquals("Checking if height method works for an empty BST", -1, bst.height() );
		
		 bst.put(7, 7);   //(key, value)
		 assertEquals("Checking if height method returns 0 for a BST only one node", 0, bst.height() );
		 
	     bst.put(8, 8);    //Same as BST in testPrettyPrint() 
	     bst.put(3, 3);     
	     bst.put(1, 1);      
	     bst.put(2, 2);      
	     bst.put(6, 6);      
	     bst.put(4, 4);       
	     bst.put(5, 5);  
	     
	     assertEquals("Checking if height method works for a BST with nodes in it", 4, bst.height() );
	}
	
	@Test
	public void testMedian()
	{
		 BST<Integer, Integer> bst = new BST<Integer, Integer>();
		 assertEquals("Checking if median method works for an empty BST", null, bst.median() );
		
		 bst.put(7, 7);   //(key, value)
		 assertEquals("Checking if median method returns root for a BST only one node", bst.get(7), bst.get( bst.median() ) );
		 
	     bst.put(8, 8);    //Same as BST in testPrettyPrint() 
	     bst.put(3, 3);     
	     bst.put(1, 1);      
	     bst.put(2, 2);      
	     bst.put(6, 6);      
	     bst.put(4, 4);       
	     bst.put(5, 5);  
	     assertEquals("Checking if median method returns median key for a BST with a number of nodes", 
	    		 bst.get(4), bst.get( bst.median() ) ); //List: 1,2,3,4,|5,6,7,8    median key is 4
	}

	@Test
	public void testPrintKeysInOrder()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking if printKeysInOrder method works for an empty BST", "()", bst.printKeysInOrder() );
		 
		bst.put(7, 7);   //(key, value)
		assertEquals("Checking if printKeysInOrder method returns correctly for a BST with only one node", "(()7())", 
				bst.printKeysInOrder() );
		
		bst.put(8, 8);   // Tree:    7
	    bst.put(3, 3);   //        3   8
	    bst.put(1, 1);   //       1
	    
	    assertEquals("Checking if printKeysInOrder method returns correct string for a BST with a number of nodes", 
	    		"(((()1())3())7(()8()))", bst.printKeysInOrder() );
		 
	}
	

    @Test
    public void testGet()
    {	 
   	 BST<String, Integer> bst = new BST<String, Integer>();
   	 bst.put("C", 2); // key value
   	 bst.put("D", 3);
   	 assertNull(bst.get("B"));
   	 
   	 assertEquals("Checking if binary search tree returns value of key 'C' which is 2", (Integer) 2, bst.get("C"));
    }
    
    @Test
    public void testPut() // Put method is sort of already tested in printKeysInOrder
    {
	   	BST<Integer, Integer> bst = new BST<Integer, Integer>();
	   	bst.put(2, null);
	   	assertEquals(bst.printKeysInOrder(), "()" );  
	   	
	   	bst.put(7, 7);       
        assertEquals(bst.printKeysInOrder(), "(()7())"); 
        
        bst.put(8, 8);       
        bst.put(3, 3);
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(6, 6);
        bst.put(4, 4);
        bst.put(5, 5);
        assertEquals("(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
    }
    
    @Test
	 public void testContains()
	 {
		 BST<Integer, Integer> bst = new BST<Integer, Integer>();
		 assertEquals("Checking what happens when run method on empty BST", false, bst.contains( bst.median() ) ); //Median will always return a key if tree is not empty
		 
	     bst.put(7, 7);   //        _7_
	     bst.put(8, 8);   //      /     \
	     bst.put(3, 3);   //    _3_      8
	     bst.put(1, 1);   //  /     \
	     bst.put(2, 2);   // 1       6
	     bst.put(6, 6);   //  \     /
	     bst.put(4, 4);   //   2   4
	     bst.put(5, 5);   //        \
	                      //         5
	     assertEquals("Checking whether the BST contains Node with key 4", true, bst.contains( 4 ) ); 
	 }
	
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      // Tests below were given with problem
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
     }
     
}
