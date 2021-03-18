class ListEquals {
	
	static class LNode {
		
	public int data;
	public LNode next;
	
	public LNode(int d, LNode nxt) 
	{
		data = d;
		next = nxt;
	}

	public boolean compareTo(LNode head2) {
		// TODO Auto-generated method stub
		if( data == head2.data )
		{
			return true;       //Be careful with checking if nodes are null, typically have to do node.next == null or something to avoid null pointer exceptions
		}		
		return false;
	}
}
	public static boolean listEquals(LNode head1, LNode head2) {
		if( head1 == null || head2 == null)
		{
			return false;
		}
		if( head1.compareTo(head2) && head1 != null)
		{
			if( head1.next == null && head2.next == null)
			{
				return true;
			}
			return listEquals( head1.next, head2.next);
		}
		return false;
	}
	// TODO
		/*
		 * Questions
		 * (b) What is the worst-case asymptotic running time of your implementation using the
			Θ-notation? In your answer consider that both lists contain N nodes. Adequately
			explain your answer. (Answer in comments in the file)
			
			The worst case running time of compareTo method is Θ(1). As there is only assignments and an if statement in this method.
			
			The worst case running time of listEquals method is Θ(N), as there is only assignments which have a run time cost of 1 and in the worst case 
			this method is recursively executed N times. Therefore the worst-case asymptotic running time is Θ(N).
			
			Overall for implementation worst-case asymptotic running time is Θ(N).
			
			(c) Is your implementation O(N2)? Is it O(log N)? Adequately explain your answer.
			(Answer in comments in the file)
			
			Worst-case asymptotic running time of my implementation using the
			O-notation is O(N^2). It cannot be O(log N), as the O-notation is used for the worst case running times upper bound and log N is less than my Θ-notation
			for the asymptotic worst case running time of Θ(N), so it fails the axiom Θ(time) <= O(time). Since N^2 is greater than N it is possible for to have O(N^2), i.e. Θ(N) < O(N^2), 
			so passes the axiom Θ(time) <= O(time)
		 */
		public boolean binarySearch( int[] a, int x)  //Practice recursive binarySearch attempt not part of etest****
	      {
	     		return binarySearch( a, x, 0);
	      }
	      private boolean binarySearch(int[] a, int x, int currentMiddle)
	      {
	      		if( currentMiddle == 0) {
	      			currentMiddle = a.length;
	      			}
	      		if( currentMiddle < 0 || currentMiddle >= a.length ) { 
	      			return false;
      				}
	      		if( x > a[currentMiddle] ) {
	      			currentMiddle ++;
	      			binarySearch( a, x, currentMiddle );
	      			}
	           if( x < a[currentMiddle] ) {
	      			currentMiddle --;
	      			binarySearch( a, x, currentMiddle );
	           		}
		        return true;
	      }	
	
	public static void main (String[] args) 
	{
		LNode list1 = new LNode(0, new LNode(1, new LNode(2, null)));
		LNode list2 = new LNode(0, new LNode(1, new LNode(2, null)));
		LNode list3 = new LNode(0, new LNode(88, new LNode(2, null)));
		LNode list4 = new LNode(0, new LNode(1, null));
		System.out.println("should be true: " + listEquals(list1, list2));
		System.out.println("should be false: " + listEquals(list1, list3));
		System.out.println("should be false: " + listEquals(list1, list4));
		System.out.println("should be false: " + listEquals(list1, null));
	}
}