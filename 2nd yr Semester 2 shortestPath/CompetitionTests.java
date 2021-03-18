import static org.junit.Assert.*;

import org.junit.Test;

public class CompetitionTests {

	@Test
	public void testDijkstraConstructor() {
		CompetitionDijkstra graph;
    	String filename = "tinyEWD.txt"; 
    	int sA = 50;
    	int sB = 40; 
    	int sC = 45;
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
	}

	@Test
    public void testFloydWarshallConstructor() {
        //TODO
	    CompetitionFloydWarshall graph;
		String filename = "tinyEWD.txt";
		int sA = 50;
		int sB = 40;
		int sC = 45;
		graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
	}

    //TODO - more tests
	/*  ****Have tests further down with speeds and times that are correct
	@Test
	public void testTimeRequiredForCompDij() {
		CompetitionDijkstra graph;
    	String filename = "tinyEWD.txt"; //I think 4->0 is the worst meeting point, sh. distance is 1.86
    	int sA = 50;
    	int sB = 40; // 1860/40=46.5=47(Will round up always)   ***Could well be wrong with this 
    	int sC = 45;
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
    	assertEquals(47, graph.timeRequiredforCompetition());
	}
	
	@Test
	public void testTimeRequiredForCompFW() {
		CompetitionFloydWarshall graph;
		String filename = "tinyEWD.txt";
		int sA = 50;
		int sB = 40;
		int sC = 45;
		graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
		assertEquals(47, graph.timeRequiredforCompetition());
	}
	*/
	@Test
    public void testDijkstraFalseSpeeds()
    {
    	CompetitionDijkstra graph;
    	String filename = "tinyEWD.txt";
    	int sA = 6;//Will result in return of -1 for .timeReq method
    	int sB = -4;
    	int sC = 9;
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
    	assertEquals(-1, graph.timeRequiredforCompetition());
        sA = 0; //Will result in return of -1 for .timeReq method
    	sB = 40;
    	sC = 45;
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
    	assertEquals(-1, graph.timeRequiredforCompetition());
    	sA = 100; //Will result in return of -1 for .timeReq method
     	sB = 120;
     	sC = 60;
     	graph = new CompetitionDijkstra(filename, sA, sB, sC);
     	assertEquals(-1, graph.timeRequiredforCompetition());
    }
    
    @Test
    public void testFloyWarshallFalseSpeeds()
    {
    	CompetitionFloydWarshall graph;
    	String filename = "tinyEWD.txt";
    	int sA = 6;//Will result in return of -1 for .timeReq method
    	int sB = -4;
    	int sC = 9;
    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	assertEquals(-1, graph.timeRequiredforCompetition());
    	sA = 0; //Will result in return of -1 for .timeReq method
     	sB = 40;
     	sC = 45;
    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	assertEquals(-1, graph.timeRequiredforCompetition());
    	sA = 100; //Will result in return of -1 for .timeReq method
     	sB = 120;
     	sC = 60;
     	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
     	assertEquals(-1, graph.timeRequiredforCompetition());
    }
    
	@Test
    public void testDijkstraFilenameError()
    {
    	CompetitionDijkstra graph;
    	String filename = "zzzcccc.txt";
    	int sA = 50;
    	int sB = 40;
    	int sC = 45;
    	graph = new CompetitionDijkstra(filename, sA, sB, sC);
    }
    
    @Test
    public void testFloydWarshallFilenameError()
    {
    	CompetitionFloydWarshall graph;
    	String filename = "zzzcccc.txt";
    	int sA = 50;
    	int sB = 40;
    	int sC = 45;
    	graph = new CompetitionFloydWarshall(filename, sA, sB, sC);
    }
   
   /* @Test
    public void test1000EWD()
    {
    	CompetitionDijkstra graphDijk;
    	CompetitionFloydWarshall graphFW;
    	String filename = "1000EWD.txt";
    	int sA = 60;
    	int sB = 52;
    	int sC = 98;
    	graphDijk = new CompetitionDijkstra(filename, sA, sB, sC);
    	graphFW = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	//No idea what the right time would be so cant test that
    }
    */
    
    //Speeds and time taken from webcat suggestions
    @Test
    public void testInputDDijk()
    {
    	CompetitionDijkstra graphDijk;
    	String filename = "input-D.txt";
    	int sA = 50;
    	int sB = 80;
    	int sC = 60;
    	graphDijk = new CompetitionDijkstra(filename, sA, sB, sC);
    	assertEquals(38, graphDijk.timeRequiredforCompetition());
    }
    
    @Test
    public void testInputDFW()
    {
    	CompetitionFloydWarshall graphFW;
    	String filename = "input-D.txt";
    	int sA = 50;
    	int sB = 80;
    	int sC = 60;
    	graphFW = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	assertEquals(38, graphFW.timeRequiredforCompetition());
    }
      
    @Test
    public void testInputIDijk()
    {
    	CompetitionDijkstra graphDijk;
    	String filename = "input-I.txt";
    	int sA = 72;
    	int sB = 70;
    	int sC = 65;
    	graphDijk = new CompetitionDijkstra(filename, sA, sB, sC);
    	assertEquals(185, graphDijk.timeRequiredforCompetition());
    }
    
    @Test
    public void testInputIFW()
    {
    	CompetitionFloydWarshall graphFW;
    	String filename = "input-I.txt";
    	int sA = 72;
    	int sB = 70;
    	int sC = 65;
    	graphFW = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	assertEquals(185, graphFW.timeRequiredforCompetition());
    }
      
      
}
