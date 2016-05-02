package boardTests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.Board;

public class LegalMovesTests {
	@Test public void test01(){
		Board board = new Board();
		int [] tile1 = {1,3}; 
		int [] tile2 = {1,2}; 
		int [] tile3 = {2,2}; 
		int [] current = {3,2};
		board.set_Tile(current, 1, 0);
		board.set_Tile(tile1, 1, 3);
		board.set_Tile(tile2, 2, 1);
		board.set_Tile(tile3, 3, 0);
		ArrayList<int[]> list = board.legalMoves(current);
		int expected = 4;
		int actual = list.size();
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
	@Test public void test02(){
		Board board = new Board();
		int [] tile1 = {1,3}; 
		int [] tile2 = {1,2}; 
		int [] tile3 = {2,2}; 
		int [] tile4 = {4,2}; 
		int [] tile5 = {3,1}; 
		int [] tile6 = {2,1}; 
		int [] current = {3,2};
		board.set_Tile(current, 3, 0);
		board.set_Tile(tile1, 1, 3);
		board.set_Tile(tile2, 2, 1);
		board.set_Tile(tile3, 4, 3);
		board.set_Tile(tile4, 1, 0);
		board.set_Tile(tile5, 1, 0);
		board.set_Tile(tile6, 1, 1);
		ArrayList<int[]> list = board.legalMoves(current);
		int expected = 6;
		int actual = list.size();
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
}
