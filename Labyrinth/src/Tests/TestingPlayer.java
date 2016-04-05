package Tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.Player.Player;
import code.Tile.Tile;
import code.model.LabyrinthModel;

public class TestingPlayer {

	@Test public void playerTest1(){
		Player t = new Player(new Tile(),1,2);
		t.usingMagicStick();
		t.usingMagicStick();
		t.getToken(20);
		t.getToken(25);
		int result = t.TotalScore();
		int expected = 48;
		assertTrue(" the actual result is " + result, expected == result || result == expected + 20 ||result == expected + 40);
	}
	@Test public void playerTest2(){
		LabyrinthModel b = new LabyrinthModel();
		ArrayList<Player> p = new ArrayList<Player>();
		p = b.getPlayer();
		int result = p.size();
		int expected = 4;
//		for(int i = 0; i < p.size(); i++){
//		System.out.print(p.get(i).getX());
//		System.out.println(p.get(i).getX());
//		}
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	
	//Testing Player's location (standing, not where to move)
	@Test public void playerLocationTest00(){
		commonLocationTest(0,0);
	}
	@Test public void playerLocationTest01(){
		commonLocationTest(6,6);
	}
	
	public void commonLocationTest(int x, int y){
		Player player = new Player(new Tile(),x,y);
		Tile p = new Tile();
		p.setX(x);
		p.setY(y);
		Tile expect = p;
		Tile actual = player.getTile();
		
		assertTrue("Expected location: ", expect.getX() == actual.getX() && expect.getY() == actual.getY());

	}
	
	
	// Testing Player's movement to adjacent tile.
	@Test public void playerPositionTest(){
		LabyrinthModel b = new LabyrinthModel();
		ArrayList<Player> p = new ArrayList<Player>();
		p = b.getPlayer();
		Tile t = new Tile();
		t.Tiledirection('^');
		t.setX(2);
		t.setY(3);
		boolean result = p.get(0).position(t);
		boolean expected = true;
		System.out.print(p.get(0).getTile().getX());
		System.out.println(p.get(0).getTile().getY());
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	
	
	public void commonPositionTest(int xCurrent, int yCurrent, int xTo, int yTo, char cCurrent, char cTo){
		Tile currentTile = new Tile(); Tile toTile = new Tile();
		currentTile.setX(xCurrent); currentTile.setY(yCurrent);
		toTile.setX(xTo); toTile.setY(yTo);
		// requires type of tile (char)
		// run ...player.position(Tile tTile)
		
		boolean expect;
		boolean actual;
		
		assertTrue("",false);
	}
	
	
	
}
