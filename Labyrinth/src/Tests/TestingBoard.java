package Tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.Player.Player;
import code.Tile.Tile;
import code.model.LabyrinthModel;

public class TestingBoard {


	@Test public void boardTest1(){
		ArrayList<Character> a = new ArrayList<Character>();
		LabyrinthModel b = new LabyrinthModel();
		a = b.allTheTile();
		for(int i = 0; i < a.size(); i++){
			System.out.print(a.get(i));
		}
		boolean expected = true;
		assertTrue(".......",expected=true);
	}

	@Test public void boardTest2 (){
		LabyrinthModel b = new LabyrinthModel();
		boolean result = b.getTile(0, 0).getToken() == 0 && b.getTile(2, 2).getToken()== 0 && b.getTile(1, 2).getToken() > 0;
		boolean expected = true;
		assertTrue("",expected==result);
	}
	@Test public void boardTest3 (){
		LabyrinthModel b = new LabyrinthModel();
		ArrayList<Player> p = new ArrayList<Player>();
		Tile t = new Tile();		
		int result = b.getTile(3,5).getToken();

		b.push(b.Point2Position(3,6));
		b.push(b.Point2Position(3,6));

		int expected = b.getTile(3,0).getToken();

		assertTrue("",expected==result);
	}
	@Test public void boardTest4 (){
		LabyrinthModel b = new LabyrinthModel();
		ArrayList<Player> p = new ArrayList<Player>();
		Tile t = new Tile();
		p = b.getPlayer();
		t = b.getTile(3,2);


		boolean result = p.get(0).position(t);
		
		b.push(b.Point2Position(3,6));
		b.push(b.Point2Position(3,6));
		b.push(b.Point2Position(3,6));
		b.push(b.Point2Position(3,6));
		b.push(b.Point2Position(3,6));

		boolean expected = b.getTile(3,0).hasPlayer(p);

		assertTrue("",expected==result);
	}
}

	

