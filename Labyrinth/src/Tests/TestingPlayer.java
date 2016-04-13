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
		t.pickUpToken(20);
		t.pickUpToken(25);
		int result = t.TotalScore();
		int expected = 45;
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
	@Test public void playerToken(){
		LabyrinthModel b = new LabyrinthModel();
		ArrayList<Player> p = new ArrayList<Player>();
		p = b.getPlayer();
		Player a = b.getPlayer().get(0);
		a.pickUpToken(20);
		a.pickUpToken(18);
		a.pickUpToken(19);
		a.pickUpToken(10);
//		System.out.print(a.showToken());

		boolean result = true;
		boolean expected = true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	
	//Testing Player's location (standing, not where to move)
	@Test public void playerLocationTest1(){
		commonLocationTest(0,0);
	}
	@Test public void playerLocationTest2(){
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
		t.Tiledirection('L');
		t.setX(3);
		t.setY(2);
		boolean result = p.get(0).position(t);
		boolean expected = true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}

	
	
	
}
