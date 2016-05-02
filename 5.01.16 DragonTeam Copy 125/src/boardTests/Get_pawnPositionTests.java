package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class Get_pawnPositionTests {
	
	@Test public void test01(){
		Board board = new Board();
		int input = 1;
		int[] expected = {2,2};
		int[] actual = board.get_pawnPosition(input);
		int counter = 0;
		for(int i = 0; i<2; i++){
			if(expected[i] == actual[i]){
				counter++;
			}
		}
		assertTrue("Expected: "+expected+" Actual: "+actual,counter==2);
		
	}
}
