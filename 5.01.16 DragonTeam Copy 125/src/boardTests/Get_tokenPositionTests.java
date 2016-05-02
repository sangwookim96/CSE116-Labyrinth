package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class Get_tokenPositionTests {
	@Test public void test01(){
		Board board = new Board();
		int input = 1;
		int[] expected = {1,1};
		board.set_tokenPosition(input,expected);//already checked the set_tokenPosition works 
												//I'm setting position instead of just getting the actual
												//position of the token because the tokens are scrambled
												//initially and all we need to do is check if the get
												//method actually works
		int[] actual = board.get_tokenPosition(input);
		int counter = 0;
		for(int i = 0; i<2; i++){
			if(expected[i] == actual[i]){
				counter++;
			}
		}
		assertTrue("Expected: "+expected+" Actual: "+actual,counter==2);
	}
	@Test public void test02(){
		Board board = new Board();
		int input = 2;
		int[] expected = {2,3};
		board.set_tokenPosition(input, expected);
		int [] actual = board.get_tokenPosition(input);
		int counter = 0;
		for(int i = 0; i<2; i++){
			if(expected[i] == actual[i]){
				counter++;
			}
		}
		assertTrue("Expected: "+expected+" Actual: "+actual,counter==2);
	}
}
