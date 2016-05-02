package boardTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board;
import code.Tile;

public class InsertTests {
	@Test public void test01(){
		Board board = new Board();
		int[] position = {0,1};
		int rotation = 3;
		boolean expected = true;
		Tile extra = board.get_ExtraTile();
		//int i = 1;
		//i=2;
		Tile t1=new Tile(1);
		Tile t2=new Tile(1);
		Tile t3=new Tile(1);
		Tile t4=new Tile(1);
		Tile t5=new Tile(1);
		Tile t6=new Tile(1);
		Tile t7=new Tile(1);
		t1 = board.get_StateOfBoard()[0][1];
		t2 = board.get_StateOfBoard()[1][1];
		t3 = board.get_StateOfBoard()[2][1];
		t4 = board.get_StateOfBoard()[3][1];
		t5 = board.get_StateOfBoard()[4][1];
		t6 = board.get_StateOfBoard()[5][1];
		t7 = board.get_StateOfBoard()[6][1];
		board.insert(position, rotation);
		boolean actual = true;
		if(!t7.equals(board.get_ExtraTile())){
			actual = false;
		}
		if(t6.type()!=board.get_StateOfBoard()[6][1].type()){
			actual = false;
		}
		if(!t5.equals(board.get_StateOfBoard()[5][1])){
			actual = false;
		}
		if(!t4.equals(board.get_StateOfBoard()[4][1])){
			actual = false;
		}
		if(!t3.equals(board.get_StateOfBoard()[3][1])){
			actual = false;
		}
		if(!t2.equals(board.get_StateOfBoard()[2][1])){
			actual = false;
		}
		if(!t1.equals(board.get_StateOfBoard()[1][1])){
			actual = false;
		}
		if(!extra.equals(board.get_StateOfBoard()[0][1])){
			actual = false;
		}
		assertTrue("Expected: "+expected+" Actual: "+actual,expected==actual);
	}
	/*public static void main(String[] args){
		Board board = new Board();
		for(int i=0;i<=6;i++){
			for(int j =0;j<=6;j++){
				System.out.print(board.get_StateOfBoard()[i][j].type()+ " ");
			}
			System.out.println("");
		}
		System.out.println(board.get_ExtraTile().type());
		int[] arr = {0,1};
		boolean b = board.insert(arr,3);
		System.out.println(b);
		System.out.println("");
		for(int i=0;i<=6;i++){
			for(int j =0;j<=6;j++){
				System.out.print(board.get_StateOfBoard()[i][j].type()+ " ");
			}
			System.out.println("");
		}
		System.out.println(board.get_ExtraTile().type());
	}*/
}
