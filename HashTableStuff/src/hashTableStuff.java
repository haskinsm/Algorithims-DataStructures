import java.util.*; 
public class hashTableStuff {
	    public static void main(String[] arg) 
	    { 
	  
	        // creating a hash table 
	        Hashtable<String, Integer> marks =  
	                  new Hashtable<String, Integer>(); 
	  
	        // enter name/marks pair 
	        marks.put("tweener", new Integer(345)); 
	        marks.put("krantz", 245 );  //Don't need to have 'new Integer(...)'
	        marks.put("burrows", new Integer(790)); 
	        marks.put("tancredi", new Integer(365)); 
	        marks.put("bellick", new Integer(435)); 
	        marks.put("bellick", new Integer(235));   // Only stores this entry now for bellick
	  
	        // get the value mapped with key krantz 
	  
	        System.out.println(marks.get("krantz")); 
	        
	        // size of hash table 
	        System.out.println("Size is: " + marks.size()); 
	        
	        // String equivalent of map 
	        System.out.println("string equivalent" +  
	                     " of map: " + marks.toString()); 
	        
	        // creating set view for keys 
	        Set sKey = marks.keySet(); 
	        Set sValues = marks.entrySet(); //Need to have .entrySet here cant just do marks.values()
	        
	        // checking collection view of values 
	        System.out.println("collection values: " + marks.values()); 
	        // checking key set 
	        System.out.println("key set: " + sKey);
	        
	        // remove value for "burrows" from Hashtable h 
	        marks.remove("burrows"); 
	        
	        Hashtable<String, Integer> h1 = new Hashtable<String, Integer>();
	        
	        // copy all element of h into h1 
	        h1.putAll(marks); 
	  
	        // checking h1 
	        System.out.println("Values in h1: " + h1);
	        
	        // create enumeration which will be used to display elements
	        Enumeration e = marks.elements(); 
	        Enumeration e2 = marks.elements(); 
	        
	        System.out.println("display values:"); 
	        String valuesString = "";
	        while (e.hasMoreElements()) { 
	            System.out.println(e.nextElement());
	            //or could do
	            valuesString += e2.nextElement() + " ";
	        }
	        System.out.println( "Values: " + valuesString );
	        
	        // check whether a value exists or not 
	        if (marks.containsValue(345)) 
	            System.out.println("value found in table"); 
	        
	        // check whether a value exists or not 
	        if (marks.containsKey("bellick")) 
	            System.out.println("Key found in table"); 
	        
	        // Checking for the Value '345' 
	        System.out.println("Is the value '345' present? " +  
	                            marks.contains((int) 345)); // need to cast as normally only takes in strings
	        
	        // create a clone or shallow copy of hash table h 
	        Hashtable<String, Integer> marks1 = 
                    new Hashtable<String, Integer>();
	        marks1 = (Hashtable<String, Integer>)marks.clone(); 
	  
	        // checking clone h1 
	        System.out.println("values in clone: " + marks1); 
	        
	        // provide value for new key which is absent 
	        // using computeIfAbsent method 
	        marks.computeIfAbsent("haskins", k -> 600); // Won't do anything if table already contains a value for haskins
	        
	        // print new mapping 
	        System.out.println("new hashTable: "
	                           + marks); 
	        
	        //Printing out keys and values together
	        System.out.println( "\nPrinting out keys and value pairs: ");
	        for (Map.Entry m:marks.entrySet()) { 
	            System.out.println(m.getKey()+" "+m.getValue()); 
	        } 
	    }  
}
