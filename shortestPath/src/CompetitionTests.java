import static org.junit.Assert.*;

import org.junit.Test;

public class CompetitionTests {

	@Test
	public void testDijkstraConstructor() {
		
	}
	
	@Test
    public void testFWConstructor() {
        //TODO
    }

    //TODO - more tests
	@Test
    public void testDijkstraFilenameError()
    {
    	CompetitionDijkstra map;
    	String filename = "tsha.txt";
    	int sA = 50;
    	int sB = 80;
    	int sC = 60;
    	map = new CompetitionDijkstra(filename, sA, sB, sC);
    }
    
    @Test
    public void testFloydWarshallFilenameError()
    {
    	CompetitionFloydWarshall map;
    	String filename = "tsha.txt";
    	int sA = 50;
    	int sB = 80;
    	int sC = 60;
    	map = new CompetitionFloydWarshall(filename, sA, sB, sC);
    }
    
    @Test
    public void testDijkstraNegativeSpeed()
    {
    	CompetitionDijkstra map;
    	String filename = "tinyEWD.txt";
    	int sA = 0;
    	int sB = 80;
    	int sC = 60;
    	map = new CompetitionDijkstra(filename, sA, sB, sC);
    	assertEquals(-1, map.timeRequiredforCompetition());
    	sA = -1;
    	sB = 0;
    	sC = -2;
    	map = new CompetitionDijkstra(filename, sA, sB, sC);
    	assertEquals(-1, map.timeRequiredforCompetition());
    }
    
    @Test
    public void testFloyWarshallNegativeSpeed()
    {
    	CompetitionFloydWarshall map;
    	String filename = "tinyEWD.txt";
    	int sA = 0;
    	int sB = 80;
    	int sC = 60;
    	map = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	assertEquals(-1, map.timeRequiredforCompetition());
    	sA = -1;
    	sB = 0;
    	sC = -2;
    	map = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	assertEquals(-1, map.timeRequiredforCompetition());
    }
    
    @Test
    public void testInputA()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String filename = "input-A.txt";
    	int sA = 60;
    	int sB = 80;
    	int sC = 50;
    	mapD = new CompetitionDijkstra(filename, sA, sB, sC);
    	mapFW = new CompetitionFloydWarshall(filename, sA, sB, sC);
    }
    
    @Test
    public void testInputB()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String filename = "input-B.txt";
    	int sA = 60;
    	int sB = 80;
    	int sC = 50;
    	mapD = new CompetitionDijkstra(filename, sA, sB, sC);
    	mapFW = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	assertEquals(10000, mapD.timeRequiredforCompetition());
    	assertEquals(10000, mapFW.timeRequiredforCompetition());
    }
    
    
}
