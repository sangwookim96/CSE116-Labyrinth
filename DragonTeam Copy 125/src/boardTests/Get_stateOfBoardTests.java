package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class Get_stateOfBoardTests {
	@Test public void test01(){
		Board board = new Board();
		int expected = 49;
		int actual = 0;
		for(int i=0;i<=6;i++){
			for(int j=0;j<=6;j++){
				if(board.isTile(board.get_StateOfBoard()[i][j])){
					actual++;
				}
			}
		}
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
}
