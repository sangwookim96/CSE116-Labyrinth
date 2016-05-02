package boardTests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.Board;

public class CheckNeighborTests {
	@Test public void test01(){
		Board board = new Board();
		int [] neighbor1 = {2,1}; //left of current tile
		int [] neighbor2 = {1,2}; //above current tile
		int [] neighbor3 = {3,2}; //below current tile
		int [] neighbor4 = {2,3}; //right of current tile
		int [] current = {2,2};
		board.set_Tile(current, 5, 0);
		board.set_Tile(neighbor1, 5, 0);
		board.set_Tile(neighbor2, 5, 0);
		board.set_Tile(neighbor3, 5, 0);
		board.set_Tile(neighbor4, 5, 0);
		ArrayList<int[]> list = board.checkNeighbor(current);
		int expected = 4;
		int actual = list.size();
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
	@Test public void test02(){
		Board board = new Board();
		int [] neighbor1 = {2,1}; //left of current tile
		int [] neighbor2 = {1,2}; //above current tile
		int [] neighbor3 = {3,2}; //below current tile
		int [] neighbor4 = {2,3}; //right of current tile
		int [] current = {2,2};
		board.set_Tile(current, 5, 0);
		board.set_Tile(neighbor1, 3, 0);
		board.set_Tile(neighbor2, 5, 0);
		board.set_Tile(neighbor3, 5, 0);
		board.set_Tile(neighbor4, 5, 0);
		ArrayList<int[]> list = board.checkNeighbor(current);
		int expected = 3;
		int actual = list.size();
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
	@Test public void test03(){
		Board board = new Board();
		int [] neighbor1 = {2,1}; //left of current tile
		int [] neighbor2 = {1,2}; //above current tile
		int [] neighbor3 = {3,2}; //below current tile
		int [] neighbor4 = {2,3}; //right of current tile
		int [] current = {2,2};
		board.set_Tile(current, 1, 0);
		board.set_Tile(neighbor1, 3, 0);
		board.set_Tile(neighbor2, 2, 0);
		board.set_Tile(neighbor3, 5, 0);
		board.set_Tile(neighbor4, 5, 0);
		ArrayList<int[]> list = board.checkNeighbor(current);
		int expected = 0;
		int actual = list.size();
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
}
