import java.util.Scanner;
import java.io.File;
/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */

public class CompetitionFloydWarshall {
	public String filename; 
	public int sA; //Speeds in metres per minute 
	public int sB;
	public int sC;
	public int minSpeed;
	public double distTo [][];
	public int streetsTo [][]; //commonly known as edgeTo -> edges=Streets
	public int numStreets;
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */
    CompetitionFloydWarshall (String filename, int speedA, int speedB, int speedC){ //Can just reuse code from start of Dijkstras 
    	this.filename = filename;
    	sA = speedA;
    	sB = speedB;
    	sC = speedC;
    	minSpeed = Math.min(sA, Math.min( sB, sC));
    	try
    	{
    		File file = new File(filename);
        	Scanner scanner = new Scanner(file);
        	int i = 0;
        	
        	while(scanner.hasNextLine())
        	{
        		String [] split = scanner.nextLine().trim().split("\\s+");//Need to trim so whitespace is ingnored
        		//Need split to dice up the line so can take in the necessary ints
        		//split("\\s+") will split the string into string of array with separator as space or multiple spaces.
        		// First int is the number of intersections, second is the number of streets
        		// From then on its 'intersectionA interscetionB distanceAB' (all ints)
        		//Should split '6 7 8' into line[1] '6', line[2] '7'.....
        		if(i==0) //Will only enter on first pass, create double arrays of appropriate size here for distTo and streetsTo and give them initial values
        		{
        			distTo = new double[Integer.parseInt(split[0])][Integer.parseInt(split[0])]; //Need to parse from the split strings
            		streetsTo = new int[Integer.parseInt(split[0])][Integer.parseInt(split[0])]; 
            		//Use number of intersections as length of both dimensions as 
            		//will (in the for loops below) give non possible and (temporarily) possible paths a very large value which will allow them to be ignored.
            		for(int j = 0; j < distTo.length; j++)
            		{
            			for(int z = 0; z < distTo[j].length; z++)
            			{
            				distTo[j][z] = Integer.MAX_VALUE; //Will later assign the appropriate distances to possible paths.
            				if(z == j) //When z==j at the same intersection so distance = 0
            				{
            					distTo[j][z] = 0;
            				}
            			}	
            		}
        		}
        		if(i==1)
        		{
        			numStreets = Integer.parseInt(split[0]);
        		}
        		else //Don't use split[i] as the max length of split ranges from 1 to 3. i.e. resets after every loop
        		{
        			//i.e. distTo[intersetionA][intersectionB]=.5555.......km      *distance is given as a double
        			distTo[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = Double.parseDouble(split[2]);
        			streetsTo[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = Integer.parseInt(split[0]);
        		}
        		i++;
        	}
        	scanner.close();
    	}catch(Exception x){}
    	//Floyd-Warshall algorithim for shortest path
    	for(int i = 0; i <distTo.length; i++)
    	{  
    		// Let all intersections be source one by one
    		for(int j = 0; j < distTo.length; j++)
    		{
    			// Let all intersections be destination for the above intersection source 
    			for(int k = 0; k < distTo.length; k++)
    			{
    				// If intersection i is on the shortest path from j to k, then update the value of dist[j][k] 
    				if(distTo[j][i] + distTo[i][k] < distTo[j][k])
    				{
    					distTo[j][k] = distTo[j][i] + distTo[i][k];
    					streetsTo[j][k] = i;  //*****Might add code later to prefer paths that are equal but use less streets, like I did in Dijk.
    				}
    			}
    		}
    	}
    }


    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){ //Can copy and paste from same method for Dijkstras.

        //TO DO
    	 double maxShPath = 0.0; //In Km  
         // Loop below finds the intersection with the max shortest path
     	for(int i = 0; i < distTo.length; i++)
     	{
     		for(int j = 0; j < distTo[i].length; j++)
     		{
     			if(distTo[i][j] == Integer.MAX_VALUE) //Not a possible path if this is the case, maybe should do distTo[i][j] < Integer.MaxValue && distTo[i][j] > maxShPath
     			{                                     //Try Later **********
     				return - 1;
     			}
     			else if(distTo[i][j] > maxShPath)
     			{
     				maxShPath = distTo[i][j];
     			}
     		}
     	}
         if( maxShPath == 0 || minSpeed <= 0 )//Error Chceking for neg. speeds
     	{
     		return - 1;
     	}
         double maxShPathInM = maxShPath*1000;
         //Speeds in metres per minute 
         int timeReq = (int) Math.ceil((maxShPathInM)/minSpeed); //Need to use Math.Ceil to always round up when converting double to int. i.e. 3.2->4
         return timeReq; //returns time in mins
    }

}

