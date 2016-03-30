package Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Stickers.Player;
import code.Tile.rotateTiles;
import code.model.LabyrinthModel;

public class Testing {

	private void commonTestCode(int expected){
		LabyrinthModel lm = new LabyrinthModel();
		int actual = lm.initializeBoard();
		assertTrue("I thought it would contain the characters "+expected+" but it actually contained "+actual+".",actual==expected);
	}
	
	@Test public void Test1(){commonTestCode(49);} //This test checks if the board is populated correctly.

	private void commonTest(int expected){
		LabyrinthModel lm = new LabyrinthModel();
		int actual = lm.initializeBoard();
		assertTrue("I thought it would contain the characters "+expected+" but it actually contained "+actual+".",actual==expected);
	}
	
	private void commonTest1(int number, int expected){
		Player p = new Player();
		int actual1 = p.players(number);
		assertTrue("I thought that when there are "+number+" players, there would be "+expected+" values in the array list but there were "+actual1+".",actual1==expected);
	}
	
	@Test public void Test5(){commonTest1(4,4);}

	private void commonTest2(int side,int expected){
		rotateTiles r = new rotateTiles();
		int actual2 = r.rotateTiles(side);
		assertTrue("I thought that the side "+side+" would turn into "+expected+"but it turned into" +actual2+".",actual2==expected);
	}

	@Test public void Test6(){commonTest2(1,0);}

		
	}


