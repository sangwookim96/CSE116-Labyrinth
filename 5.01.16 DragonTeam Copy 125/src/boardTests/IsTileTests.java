package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;
import code.Tile;

public class IsTileTests {
	@Test public void test01(){
		Board board = new Board();
		Tile tile = new Tile(2);
		boolean expected = true;
		boolean actual = board.isTile(tile);
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
}
