package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class Get_ExtraTileTests {
	@Test public void test01(){
		Board board = new Board();
		boolean expected = true;
		boolean actual = board.isTile(board.get_ExtraTile());
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
}
