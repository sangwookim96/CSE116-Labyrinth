package Tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import code.Tile.Tile;

public class TestingTile {

	Tile _tile = new Tile();
	int randomX = ThreadLocalRandom.current().nextInt(0,9);
	private ArrayList<Character> characterList = new ArrayList<>();
	public ArrayList<Character> list4TileDirection(){
		characterList.add('I'); characterList.add('&'); characterList.add('T'); characterList.add('$'); characterList.add('%');
		characterList.add('^'); characterList.add('L'); characterList.add('#'); characterList.add('@'); characterList.add('!');

		return characterList;
	}


	@Test public void tileDirectionTest00(){				
		commonTileDirection('I',0);
	}

	public void commonTileDirection(char c, int i){		
		char expect = c;
		char actual = _tile.getCharacter();

		assertTrue("Expected character of representing tile:"+"\""+expect+"\""
				+", but Actual: "+"\""+actual+"\"",expect==actual);
	}
	@Test public void tileTest1(){
		Tile t = new Tile();
		t.Tiledirection('L');
		boolean expected = true;
		boolean result = t.getEast()==true && t.getNorth()==true && t.getSouth()!=true && t.getWest()!=true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	@Test public void tileTest2(){
		Tile t = new Tile();
		t.Tiledirection('#');
		boolean expected = true;
		boolean result = t.getEast()!=true && t.getNorth()==true && t.getSouth()!=true && t.getWest()==true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	@Test public void tileTest3(){
		Tile t = new Tile();
		t.Tiledirection('@');
		boolean expected = true;
		boolean result = t.getEast()!=true && t.getNorth()!=true && t.getSouth()==true && t.getWest()==true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	@Test public void tileTest4(){
		Tile t = new Tile();
		t.Tiledirection('!');
		boolean expected = true;
		boolean result = t.getEast()==true && t.getNorth()!=true && t.getSouth()==true && t.getWest()!=true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	@Test public void tileTest5(){
		Tile t = new Tile();
		t.Tiledirection('T');
		boolean expected = true;
		boolean result = t.getEast()==true && t.getNorth()!=true && t.getSouth()==true && t.getWest()==true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	@Test public void tileTest6(){
		Tile t = new Tile();
		t.Tiledirection('$');
		boolean expected = true;
		boolean result = t.getEast()==true && t.getNorth()==true && t.getSouth()==true && t.getWest()!=true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	@Test public void tileTest7(){
		Tile t = new Tile();
		t.Tiledirection('%');
		boolean expected = true;
		boolean result = t.getEast()==true && t.getNorth()==true && t.getSouth()!=true && t.getWest()==true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	@Test public void tileTest8(){
		Tile t = new Tile();
		t.Tiledirection('^');
		boolean expected = true;
		boolean result = t.getEast()!=true && t.getNorth()==true && t.getSouth()==true && t.getWest()==true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	@Test public void tileTest9(){
		Tile t = new Tile();
		t.Tiledirection('I');
		boolean expected = true;
		boolean result = t.getEast()!=true && t.getNorth()==true && t.getSouth()==true && t.getWest()!=true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	@Test public void tileTest10(){
		Tile t = new Tile();
		t.Tiledirection('&');
		boolean expected = true;
		boolean result = t.getEast()==true && t.getNorth()!=true && t.getSouth()!=true && t.getWest()==true;
		assertTrue("Expected result will be " + expected + " but the actual result is " + result, expected == result);
	}
	@Test public void tileTest11(){
		Tile t = new Tile();
		ArrayList<Integer> pocket = new ArrayList<Integer> ();
		t.createToken();
		for(int i=0;i<21;i++){
			t.setTokens();
			pocket.add(t.pickUpToken());
		}
		int expected = 21;
		assertTrue("Expected result will be " + expected + " but the actual result is " + pocket.size(), expected == pocket.size());
	}



}	
