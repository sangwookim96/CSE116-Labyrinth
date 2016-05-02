package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

//note
public class Set_pawnPositionTests {
	
	@Test public void test01(){
		Board board = new Board();
		int playerNO = 1;
		int[] position = {2,3};
		board.set_pawnPosition(playerNO, position);
		int[] expected = {2,3};
		int[] actual = board.get_pawnPosition(playerNO);
		int counter = 0;
		for(int i = 0; i<2; i++){
			if(expected[i] == actual[i]){
				counter++;
			}
		}
		assertTrue("Expected position: "+expected+" actual"
				+ " position: "+actual,counter==2);
	}
}
