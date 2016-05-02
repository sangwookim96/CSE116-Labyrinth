package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class MoveTests {
	@Test public void test01(){
		Board b = new Board();
		int [] tile1 = {1,1};
		int [] tile2 = {2,1};
		int [] tile3 = {2,2};
		
		b.set_Tile(tile1, 3,0);
		b.set_Tile(tile2, 2,0);
		b.set_Tile(tile3, 5,0);
		
		int[] pawn = {1,1};
		int pawn1 = 1;
		b.set_pawnPosition(pawn1, pawn);
		int [] request = {2,2};
		boolean expected  = true;
		boolean actual = b.move(pawn1, request);
		assertTrue("Expected was"+expected+"but actual was"+actual,expected == actual);
 	
		
	}
	
	@Test public void test02(){
		Board b = new Board();
		int [] tile1 = {1,1};
		int [] tile2 = {2,1};
		int [] tile3 = {3,1};
		
		b.set_Tile(tile1, 1,2);
		b.set_Tile(tile2, 1,0);
		b.set_Tile(tile3, 5,0);
		
		int[] pawn = {1,1};
		int pawn1 = 1;
		b.set_pawnPosition(pawn1, pawn);
		int [] request = {3,1};
		boolean expected  = false;
		boolean actual = b.move(pawn1, request);
		assertTrue("Expected was "+expected+" but actual was "+actual,expected == actual);
 	
}
	@Test public void test03(){
		Board b = new Board();
		int [] tile1 = {1,1};
		int [] tile2 = {2,1};
		int [] tile3 = {3,1};
		int [] tile4 = {2,2};
		
		b.set_Tile(tile1, 1,2);
		b.set_Tile(tile2, 2,0);
		b.set_Tile(tile3, 5,0);
		b.set_Tile(tile4, 4,1);
		
		
		int[] pawn = {1,1};
		int pawn1 = 1;
		b.set_pawnPosition(pawn1, pawn);
		int [] request = {3,1};
		boolean expected  = false;
		boolean actual = b.move(pawn1, request);
		assertTrue("Expected was"+expected+"but actual was"+actual,expected == actual);
}
	@Test public void test04(){
		Board b = new Board();
		int [] tile1 = {4,3};
		int [] tile2 = {4,2};
		int [] tile3 = {3,2};
		int [] tile4 = {3,3};
		int [] tile5 = {3,4};
		
		b.set_Tile(tile1, 2,3);
		b.set_Tile(tile2, 4,1);
		b.set_Tile(tile3, 2,1);
		b.set_Tile(tile4, 3,1);
		b.set_Tile(tile5, 1,3);
		
		
		int[] pawn = {4,3};
		int pawn1 = 1;
		b.set_pawnPosition(pawn1, pawn);
		int [] request = {3,4};
		boolean expected  = true;
		boolean actual = b.move(pawn1, request);
		assertTrue("Expected was"+expected+"but actual was"+actual,expected == actual);
}
}

