package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class InitializeTests {
	//Testing board size
	@Test public void test01(){
		Board board = new Board();
		int expected = 49;
		int sizeOfBoard = 0;
		for(int rows = 0;rows<=6;rows++){
		if(board.get_StateOfBoard()[rows].length==7){
			sizeOfBoard = sizeOfBoard + 7;
			}
		}
		assertTrue("Expected: "+expected+" Actual: "+sizeOfBoard,expected==sizeOfBoard);
	}
	//Testing tile region
	@Test public void test02(){
		Board board = new Board();
		boolean expected = true;
		boolean actual = board.isTile(board.get_ExtraTile());
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
	//Testing token region
	@Test public void test03(){
		Board board = new Board();
		int input = 1;
		boolean expected = true;
		boolean actual = board.isTokenPosition(board.get_tokenPosition(input));
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
	
	//Testing fixed tiles
	public void generalTest(int row, int col, boolean[] expected){
		Board board = new Board();
		boolean[] actual = board.get_StateOfBoard()[row][col].curOpen();
		assertTrue("Expected: "+expected+" Actual: "+actual,expected[0]==actual[0]&&
				expected[1]==actual[1]&&expected[2]==actual[2]&&expected[3]==actual[3]);
	}
	
	@Test public void test04(){
		boolean[] expected = {true, true, true, false};
		generalTest(2,2,expected);
	}
	@Test public void test05(){
		boolean[] expected = {false, true, true, true};
		generalTest(2,4,expected);
	}
	@Test public void test06(){
		boolean[] expected = {true, true, false, false};
		generalTest(6,0,expected);
	}
	@Test public void test07(){
		boolean[] expected = {true,false, true, true};
		generalTest(4,6,expected);
	}
	
}
