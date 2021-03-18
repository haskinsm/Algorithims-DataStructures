import java.util.Scanner;
import java.util.*;
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
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {
	public String filename; 
	public int sA; //Speeds in metres per minute 
	public int sB;
	public int sC;
	public int minSpeed;
	public int maxSpeed;
	public double distTo [][];
	public int lastStreetUsedFromAtoB [][]; //Called edgeTo in the Princeton book //Thought it represented the number of streets used, but it represents the last edge/street 
	// used in the shortest path from a to b. i.e. lastStreetUsedFromAtoB[1][2] initially = a, but say 1>3>2 is shorter then the lastStreetUsedFromAtoB[1][2]=3 (I think).
	// Since I've used double arrays it is pretty much useless info I think, can't see where I could use it, must only be useful when using a node sort of data point/object.
	public int numStreets;//Number of edges
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
    */
    CompetitionDijkstra (String filename, int speedA, int speedB, int speedC){
        this.filename = filename;
    	sA = speedA;
    	sB = speedB;
    	sC = speedC;
    	minSpeed = Math.min(sA, Math.min( sB, sC));
    	maxSpeed = Math.max(sA, Math.max(sB, sC));
    	try
    	{
    		File input = new File(filename);
        	Scanner scanner = new Scanner(input);
        	int i = 0;
        	while(scanner.hasNextLine())
        	{
        		String [] split = scanner.nextLine().trim().split(" ");//Need to trim so whitespace is ingnored
        		//Need split to dice up the line so can take in the necessary ints
        		//split(" ") will split the string into string of array with separator as space 
        		// First int is the number of intersections, second is the number of streets
        		// From then on its 'intersectionA interscetionB distanceAB' (all ints)
        		//Should split '6 7 8' into split[1] '6', split[2] '7'.....
        		if(i==0) //Will only enter on first pass, create double arrays of appropriate size here for distTo and lastStreetUsedFromAtoB and give them initial values
        		{
        			distTo = new double[Integer.parseInt(split[0])][Integer.parseInt(split[0])]; //Need to parse from the split strings
            		lastStreetUsedFromAtoB = new int[Integer.parseInt(split[0])][Integer.parseInt(split[0])]; 
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
        		else if(i==1)
        		{
        			numStreets = Integer.parseInt(split[0]);//Number of edges
        		}
        		else //Don't use split[i] as the max length of split ranges from 1 to 3. i.e. resets after every loop
        		{
        			//i.e. distTo[intersetionA][intersectionB]=.5555.......km      *distance is given as a double
        			distTo[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = Double.parseDouble(split[2]);
        			lastStreetUsedFromAtoB[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = Integer.parseInt(split[0]);
        		}
        		i++;
        	}
        	//The loop below will calc. the network of shortest paths 
        	for(int c = 0; c < distTo.length; c++)
        	{
        		dijkstrashortestPath(c);
        		//The relaxation process in Dijkstra's algorithm
        		//refers to updating the cost of all vertices connected to a vertex v,
        		//if those costs would be improved by including the path via v.
        		//i.e. find all the shortest paths to a vertex and then repeat this 
        		//step until all the shortest paths from every possible node to all the others has been found
        	}
        	scanner.close();
    	}catch(Exception x){ //Need this because kept getting null pointer errors on webcat without it.
    		distTo = new double[0][0];
    		lastStreetUsedFromAtoB = new int[0][0];
    		return;
    	}
    }
    
    public void dijkstrashortestPath(int k){
    	boolean [] shPathTreeSet = new boolean[distTo.length]; //True if intersection i is included in shortest path tree or shortest distance from k to i is finalized
    	shPathTreeSet[k] = true; //As same intersection so k is included, and distance from k to k should be kept as 0.
    	while(true) //Will return when the shortest path to all intersections from intersection k has been found
    	{
    		int x = -1;
    		//The For loop sets x to a new intersection and once the shortest path to a new intersection has not been found it breaks the loop
    		for(int i = 0; i < distTo.length; i ++) 
    		{
    			if(shPathTreeSet[i] == false && distTo[k][i] != Integer.MAX_VALUE) //If distAB is equal to max value it is not possible to go directly from A to B
    			{
    				x = i;
    				break; 
    			}
    		}
    		if(x == -1) //All shPaths have been found to K from all the other intersections
    		{
    			return; 
    		}   
    		shPathTreeSet[x] = true;  	
    		for(int i = 0; i < distTo.length; i++) //Loops through and relaxes distance when advantageous to include intersection x when trying to get from k to i
    		{
				if(distTo[k][x] + distTo[x][i] < distTo[k][i])
				{
    				distTo[k][i] = distTo[k][x] + distTo[x][i];
    				lastStreetUsedFromAtoB[k][i] = x; //Pretty much useless info I think, since using double arrays, might comment out/ delete, but included it cause the book had edgeTo.
    				shPathTreeSet[i] = false;
				}
    		}
    		//shPathTreeSet[x] = true;  	has to be above loop 
    	}
    }

    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
      */
    public int timeRequiredforCompetition(){

        //TO DO
        double maxShPath = 0.0; //In Km  
        // Loop below finds the intersection with the max shortest path
    	for(int i = 0; i < distTo.length; i++)
    	{
    		for(int j = 0; j < distTo[i].length; j++)
    		{
    			if(distTo[i][j] == Integer.MAX_VALUE) // distTo[i][j] contains all the shortest paths in the network, if one shortest path has the value..
     			{                                     // ... Integer.Max_Value then the network is incomplete/ unsuitable. i.e. it is impossible to get from I to J, making..
     				return - 1;                       // ... it unsuitable for the competition and so the time required should return -1.
     			}
    			else if(distTo[i][j] > maxShPath)
    			{
    				maxShPath = distTo[i][j];
    			}
    		}
    	}
        double maxShPathInM = maxShPath*1000;
        //Speeds in metres per minute 
        int timeReq = (int) Math.ceil((maxShPathInM)/minSpeed); //Need to use Math.Ceil to always round up when converting double to int. i.e. 3.2->4
        if( maxShPath == 0 || minSpeed < 50 || maxSpeed > 100 )//Error checking, Can only have speeds 50<=sA, sB, sC <=100 and a maxShPath of 0 should return -1
    	{
    		return - 1;
    	}
        return timeReq; //returns time in mins
    }

}
