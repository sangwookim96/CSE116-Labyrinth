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

}
