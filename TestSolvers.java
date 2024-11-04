import java.util.ArrayList;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */
	// @Test
	// public void storePath() {
	// 	Maze m = new Maze(new String[] {"#___","__F_","S##_","____"});
	// 	//return solution path as arraylist of square
	// 	ArrayList<Square> arrayanswer = m.storePath();
	// 	//produce string array with * in spaces
	// 	String solution = formatMaze(m.showSolution(arrayanswer));
	// 	String result = formatMaze(new String[]{"#___","**F_","S##_","____"});
	// 	assertEquals(result,solution);
	// }
	@Test
	public void basicQCheck() {
		Maze m = new Maze(new String[] {"#___","__F_","S##_","____"});
		String[] result = new String[]{"#___","**F_","S##_","____"};
		checkMaze(new QueueWorklist(),m,result);
	}
	@Test
	public void backSCheck() {
		Maze m = new Maze(new String[] {"#___","__F_","S##_","____"});
		String[] result = new String[]{"#___","__F*","S##*","****"};
		checkMaze(new StackWorklist(),m,result);
	}
	@Test
	public void diffOrder() {
		Maze m = new Maze(new String[] {"##_#","#S_#","___#","_F__"});
		String[] result = new String[]{"##_#","#S*#","__*#","_F*_"};
		checkMaze(new StackWorklist(),m,result);
	}
	
}



