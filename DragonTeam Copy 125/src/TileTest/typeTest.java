package TileTest;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Tile;

public class typeTest {

	
	public void generaltest(int input, int expected) {
		Tile t = new Tile(input);
		int actual = t.type();
		assertTrue("Expected was " +expected+ "but actual was " + actual, expected == actual); 
	}
	
	
	@Test
	public void test01() {generaltest(1,1);}

	@Test
	public void test02() {generaltest(6,1);}

	@Test
	public void test03() {generaltest(-5,1);}
	
}
