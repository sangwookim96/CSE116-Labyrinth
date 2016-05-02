package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class Set_tokenPositionTests {
	@Test public void test01(){
		Board board = new Board();
		int input = 1;
		int[] expected = {3,3};
		board.set_tokenPosition(input, expected);
		int[] actual = board.get_tokenPosition(input);
		int counter = 0;
		for(int i = 0; i<2; i++){
			if(expected[i] == actual[i]){
				counter++;
			}
		}
		assertTrue("Expected: "+expected+" Actual: "+actual,counter==2);
		
	}
}
