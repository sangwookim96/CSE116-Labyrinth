package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class getMagicWandsTests {
	
	@Test public void test01(){
		Board board = new Board();
		int expected = 3;
		int actual = board.getMagicWands(1);
		assertTrue("Expected value was "+expected+" but actual value was "+actual, expected==actual);
	}
	
	@Test public void test02(){
		Board board = new Board();
		board.useMagicWand(1);
		int expected = 2;
		int actual = board.getMagicWands(1);
		assertTrue("Expected value was "+expected+" but actual value was "+actual, expected==actual);
	}

}
