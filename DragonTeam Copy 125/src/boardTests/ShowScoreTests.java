package boardTests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.Board;

public class ShowScoreTests {
	
	@Test public void test00(){
		Board board = new Board();
		int playerNO = 0;
		ArrayList<Integer> scoreExpected = null;
		ArrayList<Integer> scoreActual = board.showScore(playerNO);
		assertTrue("I expected the score to be "+scoreExpected+" and the score was actually "+scoreActual, scoreExpected==scoreActual);
	}
	
	@Test public void test01(){
		Board board = new Board();
		int playerNO = 1;
		int curToken = 1;
		ArrayList<Integer> scoreExpected = new ArrayList<Integer>();
		scoreExpected.add(curToken);
		board.eat(playerNO);
		ArrayList<Integer> scoreActual = board.showScore(playerNO);
		assertTrue("I expected the score to be "+scoreExpected.size()+" and the score was actually "+scoreActual.size(), scoreExpected.size()==scoreActual.size());
	}
	
	@Test public void test02(){
		Board board = new Board();
		int playerNO = 5;
		ArrayList<Integer> scoreExpected = null;
		ArrayList<Integer> scoreActual = board.showScore(playerNO);
		assertTrue("I expected the score to be "+scoreExpected+" and the score was actually "+scoreActual, scoreExpected==scoreActual);
	}
	
	@Test public void test03(){
		Board board = new Board();
		int playerNO = 3;
		int curToken = 1;
		ArrayList<Integer> scoreExpected = new ArrayList<Integer>();
		scoreExpected.add(curToken);
		scoreExpected.add(curToken);
		board.eat(playerNO);
		board.eat(playerNO);
		ArrayList<Integer> scoreActual = board.showScore(playerNO);
		assertTrue("I expected the score to be "+scoreExpected.size()+" and the score was actually "+scoreActual.size(), scoreExpected.size()==scoreActual.size());
	}

}
