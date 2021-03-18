import java.util.*;
public class HashMapDBLinkedList {


/*	Generally, the Hashmap is to enable O(1) constant Time Complexity for the "get" operation.
	The Doubly Linked List enables O(1) constant Time Complexity for keeping track of the cache
	capacity, i.e. removing Head (Least Recently Used), adding Tail (insert new cache item)

    This code is for a Least recently used cache problem, where the least recently used Node is removed when 
    Cache reaches its capacity.
    
	Important notes:

	-The Head node will always be holding the Least-Recently-Used Node.
	-Whenever we try to get an existing node, we need to update the Node to the Tail of the Linked List
	-Whenever we put a new value, always add the node to the Tail
	-ALWAYS remember to update the Hashmap AND the Doubly Linked List. Forgetting one of them, 
	  will take you time to debug the code.


*/
	///////////// THIS PROGRAM DOES NOT HAVE LINKED LISTS FOR EVERY KEY (/bucket), ITS JUST ONE BIG LINKED LIST.
	///// Image of this:     https://www.google.com/search?q=a+hashmap+using+doubly+linked+lists&rlz=1C1CHBF_enIE815IE815&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjLxd6a_I7rAhXDYcAKHZkeC0gQ_AUoAnoECA4QBA&biw=1280&bih=577#imgrc=DIfv87sz4eS4oM
   private Node head = null;
   private Node tail = null;
   private Map<Integer, Node> map = null;
   private int capacity = 0;

   public void printList() {
       String text = "";
       Node node = head;

       while(node != null){
           text = text + "[" + node.key + "," + node.value + "],";
           node = node.next;
       }

       System.out.println(text);
   }

   /**
    * Node Class
    */
   private class Node{
       int key;
       int value;
       Node prev;
       Node next;

       public Node(int key, int value){
           this.key = key;
           this.value = value;
       }
   }

   /**
    * Constructor - Only need to initialize the Hashmap and keep track of max capacity
    * @param capacity
    */
   public HashMapDBLinkedList(int capacity) {
       map = new HashMap();
       this.capacity = capacity;
   }

   /**
    * Main Method to get value
    * @param key
    * @return
    */
   public int get(int key) {
       // 1 - Return if nothing is found
       Node node = map.getOrDefault(key, null); // if nothing is found by this method will return the 2nfd option which is in this case null
       if(node == null) return -1;

       // 2 - Else update the HashMap AND the Doubly Linked-list nodes
       removeNode(node);   //This is only being done as wants nodes that have been gotten or inserted most recently as the tail.
       //So that the least recently used nodes are at the head
       Node updatedNode = new Node(node.key, node.value);
       map.put(key, updatedNode);
       addNode(updatedNode);

       return node.value;
   }

   /**
    * Main Method to put value
    * @param key
    * @param value
    */
   public void put(int key, int value) {
       // 1 - If exist in Hashmap, update Hashmap AND move node to Tail in Doubly Linked List
       Node existingNode = map.get(key);
       if(existingNode != null){
           removeNode(existingNode);
           Node updatedNode = new Node(key, value);
           addNode(updatedNode);
           map.put(key, updatedNode); 
           return;
       }

       // 2 - If reached max capacity, remove the head node in Hashmap AND Doubly Linked List
       if(map.size() == capacity){
           map.remove(head.key);
           removeHeadNode();
       }

       // 3 - Put new value into the Hashmap AND Doubly Linked List
       Node newNode = new Node(key, value);
       map.put(key, newNode); //Note this is just the put method of a hashMap.
       addNode(newNode);
   }

   /**
    * Private method to Add node
    * Always add to the TAIL ONLY
    * @param node
    */
   private void addNode(Node node){
       // 1 - If head is null, assign both head and tail pointer to point to the new node
       if(head == null){
           head = node;
           tail = node;
           return;
       }

       // 2 - If tail is null, assign tail pointer to point to the new node and double-link head-tail
       if(head.next == null){
           head.next = node;
           node.prev = head;
           tail = node;
           return;
       }

       // 3 - Append to the Tail
       tail.next = node;
       node.prev = tail;
       tail = node;
   }

   /**
    * Private method to Remove node
    * @param node
    */
   private void removeNode(Node node){
       // 1 - Handle Head Node Removal
       if(node.prev == null){
           removeHeadNode();
           return;
       }

       // 2 - Handle Tail Node Removal
       if(node.next == null){
           tail = tail.prev;
           tail.next = null;
           return;
       }

       // 3 - Handle Middle Node Removal
       node.prev.next = node.next;
       node.next.prev = node.prev;
   }

   /**
    * Private Method to Remove Head Node
    */
   private void removeHeadNode(){
       head = head.next;
       if(head != null) head.prev = null;
   }
}
