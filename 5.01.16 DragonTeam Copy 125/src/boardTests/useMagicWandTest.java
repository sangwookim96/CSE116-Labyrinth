package boardTests;

//note

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;

public class useMagicWandTest {
	@Test public void test01(){
		Board b = new Board();
		int expected = 2;
		int actual = b.useMagicWand(1);
		assertTrue("Expected was "+expected+" but actual was "+actual,expected==actual);
	}
	
		@Test public void test02(){
		Board b = new Board();
		int expected = -1;
		int actual = b.useMagicWand(5);
		assertTrue("Expected was "+expected+" but actual was "+actual,expected==actual);	
	}
		
		@Test public void test03(){
			Board b = new Board();
			b.useMagicWand(1);
			int expected = 1;
			int actual = b.useMagicWand(1);
			assertTrue("Expected was "+expected+" but actual was "+actual,expected==actual);
		}
		
		@Test public void test04(){
			Board b = new Board();
			b.useMagicWand(2);
			b.useMagicWand(2);
			int expected = 0;
			int actual = b.useMagicWand(2);
			assertTrue("Expected was "+expected+" but actual was "+actual,expected==actual);
		}
		
		@Test public void test05(){
			Board b = new Board();
			b.useMagicWand(3);
			b.useMagicWand(3);
			b.useMagicWand(3);
			int expected = -1;
			int actual = b.useMagicWand(3);
			assertTrue("Expected was "+expected+" but actual was "+actual,expected==actual);
		}
		
		@Test public void test06(){
			Board b = new Board();
			b.useMagicWand(4);
			b.useMagicWand(4);
			b.useMagicWand(4);
			b.useMagicWand(4);
			int expected = -1;
			int actual = b.useMagicWand(4);
			assertTrue("Expected was "+expected+" but actual was "+actual,expected==actual);
		}
		
		@Test public void test07(){
			Board b = new Board();
			b.useMagicWand(0);
			int expected = -1;
			int actual = b.useMagicWand(0);
			assertTrue("Expected was "+expected+" but actual was "+actual,expected==actual);
		}
}

