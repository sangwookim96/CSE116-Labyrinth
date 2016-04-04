package Path;

import code.Tile.Tile;
import code.model.LabyrinthModel;

public class Path extends LabyrinthModel {

	private char c;
	private Tile[][] _board;
	
	/**
	 * push method defines column or row shifting when pushing a freeTile. 
	 * @param position the point location where freeTile be inserted to board.
	 */

	public void push(int position){           //This method checks for legal moves  
		// We need a method that translates Array point to int. 
		Tile temp1=null;
		Tile temp2;
		
		switch(position){
		case 1:{
			temp2=_board[1][6];
			for (int c=6;c>0;c--){
				_board[1][c]=_board[1][c-1];
			}
			_board[1][0]=temp1;
		}
		case 2:{
			temp2=_board[3][6];
			for (int c=6;c>0;c--){
				_board[3][c]=_board[3][c-1];
			}
			_board[3][0]=temp1;
		}
		case 3:{
			temp2=_board[5][6];
			for (int c=6;c>0;c--){
				_board[5][c]=_board[5][c-1];
			}
			_board[5][0]=temp1;
		}
		case 4:{
			temp2=_board[6][1];
			for (int r=6;r>0;r--){
				_board[r][1]=_board[r-1][1];
			}
			_board[0][1]=temp1;
		}
		case 5:{
			temp2=_board[6][3];
			for (int r=6;r>0;r--){
				_board[r][3]=_board[r-1][3];
			}
			_board[0][3]=temp1;
		}
		case 6:{
			temp2=_board[6][5];
			for (int r=6;r>0;r--){
				_board[r][5]=_board[r-1][5];
			}
			_board[0][5]=temp1;
		}
		case 7:{
			temp2=_board[1][0];
			for (int c=0;c<6;c++){
				_board[1][c]=_board[1][c+1];
			}
			_board[1][6]=temp1;
			temp1 = temp2;
		}
		case 8:{
			temp2=_board[3][0];
			for (int c=0;c<6;c++){
				_board[3][c]=_board[3][c+1];
			}
			_board[3][6]=temp1;
			temp1 = temp2;
		}
		case 9:{
			temp2=_board[5][0];
			for (int c=0;c<6;c++){
				_board[5][c]=_board[5][c+1];
			}
			_board[5][6]=temp1;
			temp1 = temp2;
		}
		case 10:{
			temp2 =_board[0][5];
			for (int r=0;r<6;r++){
				_board[r][5]=_board[r+1][5];
			}
			_board[6][5]=temp1;
			temp1 = temp2;
		}
		case 11:{
			temp2=_board[0][3];
			for (int r=0;r<6;r++){
				_board[r][3]=_board[r+1][3];
			}
			_board[6][3]=temp1;
			temp1 = temp2;
		}
		case 12:{
			temp2=_board[0][1];
			for (int r=0;r<6;r++){
				_board[r][3]=_board[r+1][1];
			}
			_board[6][1]=temp1;
			temp1 = temp2;
			}

		}
	
	}
	
	
	/**
	 * Translating point of board to the integer (pushable) position which we named.
	 * @param x x value of point
	 * @param y y value of pint
	 * @return Position that we named by integer numbers.
	 */
	public int Point2Position(int x, int y){
		Tile location = _board[x][y];
		if(location==_board[1][6]){
			return 1;
		} else
		if(location==_board[3][6]){
			return 2;		
		}else
		if(location==_board[5][6]){
			return 3;
		}else
		if(location==_board[6][1]){
			return 4;
		}else
		if(location==_board[6][3]){
			return 5;
		}else
		if(location==_board[6][5]){
			return 6;
		}else
		if(location==_board[1][0]){
			return 7;
		}else
		if(location==_board[3][0]){
			return 8;
		}else
		if(location==_board[5][0]){
			return 9;
		}else
		if(location==_board[0][5]){
			return 10;
		}else
		if(location==_board[0][3]){
			return 11;
		}else
		if(location==_board[0][5]){
			return 12;
		}
		
		return 0;
	}



}
