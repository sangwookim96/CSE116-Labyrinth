package boardTests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import code.Board;

public class EatTests {
	
	@Test public void test00(){
		Board board = new Board();
		int playerNO = 1;
		ArrayList<Integer> scoreExpected = new ArrayList<Integer>();
		scoreExpected.add(1);
		board.eat(playerNO);
		int expected = scoreExpected.size();
		ArrayList<Integer> scoreActual = board.showScore(playerNO);
		int actual = scoreActual.size();
		assertTrue("I expected the value to be "+expected+" but it was actually "+actual, expected==actual);
	}
	
	@Test public void test01(){
		Board board = new Board();
		int playerNO = 2;
		ArrayList<Integer> scoreExpected = new ArrayList<Integer>();
		scoreExpected.add(3);
		scoreExpected.add(7);
		board.eat(playerNO);
		board.eat(playerNO);
		int expected = scoreExpected.size();
		ArrayList<Integer> scoreActual = board.showScore(playerNO);
		int actual = scoreActual.size();
		assertTrue("I expected the value to be "+expected+" but it was actually "+actual, expected==actual);
	}
	
	@Test public void test02(){
		Board board = new Board();
		int playerNO = 3;
		ArrayList<Integer> scoreExpected = new ArrayList<Integer>();
		scoreExpected.add(24);
		scoreExpected.add(432);
		scoreExpected.add(23423);
		board.eat(playerNO);
		board.eat(playerNO);
		board.eat(playerNO);
		int expected = scoreExpected.size();
		ArrayList<Integer> scoreActual = board.showScore(playerNO);
		int actual = scoreActual.size();
		assertTrue("I expected the value to be "+expected+" but it was actually "+actual, expected==actual);
	}
	
	@Test public void test03(){
		Board board = new Board();
		int playerNO = 4;
		ArrayList<Integer> scoreExpected = new ArrayList<Integer>();
		scoreExpected.add(24);
		scoreExpected.add(432);
		scoreExpected.add(23423);
		scoreExpected.add(234);
		board.eat(playerNO);
		board.eat(playerNO);
		board.eat(playerNO);
		int expected = scoreExpected.size();
		ArrayList<Integer> scoreActual = board.showScore(playerNO);
		int actual = scoreActual.size();
		assertTrue("I expected the value to be "+expected+" but it was actually "+actual, expected!=actual);
	}

}
