package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class PushPlayerTests {
	@Test public void test01(){
		Board board = new Board();
		int player1 = 1;
		int [] randpos = {1,3};
		board.set_pawnPosition(player1,randpos);   //set position in order to ensure player would
												   //be pushed since when initialized, player 1
												   //is set to {2,2} so its not pushed
		int [] expected = {2,3};
		int [] position = {0,3};
		board.pushPlayer(position, player1);
		int [] actual = board.get_pawnPosition(player1);
		int counter = 0;
		for(int i = 0; i<2; i++){
			if(expected[i] == actual[i]){
				counter++;
			}
		}
		assertTrue("Expected: "+expected+" Actual: "+actual,counter==2);
	}
}
