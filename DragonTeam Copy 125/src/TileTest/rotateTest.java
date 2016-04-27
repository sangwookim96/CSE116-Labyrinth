package TileTest;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Tile;

public class rotateTest {

	public void generaltest3(int input, int rotateTime , boolean [] expected ) {
		Tile t = new Tile(input);
		for(int i=0; i<rotateTime; i++){
			t.rotate();
		}
		
		boolean [] actual = t.curOpen();
		assertTrue("Expected was " +expected+ "but actual was " + actual, (expected[0] == actual[0]) && (expected[1] == actual[1]) && (expected[2] == actual[2]) && (expected[3] == actual[3]));

}
	
	@Test
	public void test01() {
		boolean[] ex = {false,true,false,false};
		generaltest3(1,1, ex);
		}
	
	@Test
	public void test06() {
		boolean[] ex = {false,false,true,false};
		generaltest3(1,2, ex);
		}
	
	@Test
	public void test02() {
		boolean[] ex = {false,true,true,false};
		generaltest3(2,1, ex);
		}


	@Test
	public void test03() {
		boolean[] ex = {false,true,false,true};
		generaltest3(3,1, ex);
		}
	
	@Test
	public void test04() {
		boolean[] ex = {true,true,true,false};
		generaltest3(4,1, ex);
		}
	
	@Test
	public void test05() {
		boolean[] ex = {true,true,true,true};
		generaltest3(5,1, ex);
		}
}
