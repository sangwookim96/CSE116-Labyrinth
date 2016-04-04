package Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Player.Player;
import code.Tile.Tile;

public class TestingPlayer {

	@Test public void playerTest1(){
		Player t = new Player(new Tile[7][7],0,0);
		t.usingMagicStick();
		t.usingMagicStick();
		t.getToken(20);
		t.getToken(25);
		int result = t.TotalScore();
		int expected = 48;
		assertTrue(" the actual result is " + result, expected == result || result == expected + 20 ||result == expected + 40);
	}
//	@Test public void playerTest2(){
//		Player p = new Player(new Tile[7][7],0,0);
//		Tile t = new Tile();
//		t.setX(0);
//		t.setY(1);
//		boolean result = p.position(t);
//		boolean expected = true;
//		System.out.println("the x is " + t.getX() + " the y is " + t.getY());
//		System.out.println("the x is " + p.getX() + " the y is " + p.getY());
//		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
//	}
	
	//Testing Player's location (standing, not where to move)
	@Test public void playerLocationTest00(){
		commonLocationTest(0,0);
	}
	@Test public void playerLocationTest01(){
		commonLocationTest(6,6);
	}
	
	public void commonLocationTest(int x, int y){
		Player player = new Player(new Tile[7][7],x,y);
		Tile[][] p = new Tile[7][7];
		Tile expect = p[x][y];
		Tile actual = player.playerTile(p, x, y);
		
		assertTrue("Expected location: "+"\""+expect+"\""+", Actual location: "+"\""+actual+"\"",
				expect==actual);
	}
	
	
	// Testing Player's movement to adjacent tile.
	@Test public void playerPositionTest(){
		
	}
	public void commonPositionTest(int xCurrent, int yCurrent, int xTo, int yTo){
		Tile tile = new Tile();
		
		boolean expect;
		boolean actual;
		
		assertTrue("",false);
	}
	
	
	
}
