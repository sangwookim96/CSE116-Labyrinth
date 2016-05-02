package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class PushTokenTests {
	@Test public void test01(){
		Board board = new Board();
		int token1 = 1;
		int [] randpos = {1,3};
		board.set_tokenPosition(token1,randpos);   //set position in order to ensure token would
												   //be pushed since when initialized, token 1
												   //is random so there's a chance it might not be 
												   //pushed so to test it i would place it on a 
												   //position where it can be pushed
		int [] expected = {2,3};
		int [] position = {0,3};
		board.pushToken(position, token1);
		int [] actual = board.get_tokenPosition(token1);
		int counter = 0;
		for(int i = 0; i<2; i++){
			if(expected[i] == actual[i]){
				counter++;
			}
		}
		assertTrue("Expected: "+expected+" Actual: "+actual,counter==2);
	}
}
