package boardTests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.Board;

public class ContainsArrayTests {
	@Test public void test01(){
		Board board = new Board();
		ArrayList<int[]>expected = new ArrayList<int[]>();
		int[]expected2 = {1,3};
		expected.add(expected2);
		int[]expected3 = {1,3};
		boolean actual = board.containsArray(expected, expected3);
		assertTrue("Expected: "+expected2+" Actual: "+expected3,actual);
	}
}
