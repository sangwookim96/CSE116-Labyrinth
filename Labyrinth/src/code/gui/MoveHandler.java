package code.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import code.Tile.Tile;
import code.model.LabyrinthModel;

public class MoveHandler implements KeyListener {
	
	private LabyrinthModel _board = new LabyrinthModel();
	private int _x;
	private int _y;

	
	public MoveHandler(LabyrinthModel b, int x, int y){
		_board = b;
		_x = x;
		_y = y;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {



		if('w' == e.getKeyChar()){
			_board.topTile();
			System.out.println("up");
			Tile up = _board.getUpTile();
			boolean result = _board.getCurrentPlayer().position(up);
//			System.out.println(up.getX());
//			System.out.println(up.getY());
//			System.out.println(up.getNorth());
//			System.out.println(up.getSouth());
//			System.out.println(up.getWest());
//			System.out.println(up.getEast());
//			System.out.println(up.getToken());
//
//
//			System.out.println(result);
		}
		else if('s' == e.getKeyChar()){
			_board.bottomTile();
			System.out.println("down");
			Tile down = _board.getbottomTile();
			boolean result = _board.getCurrentPlayer().position(down);
//			System.out.println(down.getX());
//			System.out.println(down.getY());
//			System.out.println(down.getNorth());
//			System.out.println(down.getSouth());
//			System.out.println(down.getWest());
//			System.out.println(down.getEast());
//			System.out.println(down.getToken());
//
//			
//			System.out.println(result);
		}
		else if('a' == e.getKeyChar()){
			_board.leftTile();
			System.out.println("left");
			Tile left = _board.getLeftTile();
			boolean result = _board.getCurrentPlayer().position(left);
//			System.out.println(left.getX());
//			System.out.println(left.getY());
//			System.out.println(left.getNorth());
//			System.out.println(left.getSouth());
//			System.out.println(left.getWest());
//			System.out.println(left.getEast());
//			System.out.println(left.getToken());
//
//			
//			System.out.println(result);
		}
		else if('d' == e.getKeyChar()){
			_board.rightTile();
			System.out.println("right");
			Tile right = _board.getRightTile();
			boolean result = _board.getCurrentPlayer().position(right);
//			System.out.println(right.getX());
//			System.out.println(right.getY());
//			System.out.println(right.getNorth());
//			System.out.println(right.getSouth());
//			System.out.println(right.getWest());
//			System.out.println(right.getEast());
//			System.out.println(right.getToken());
//
//			
//			System.out.println(result);
		}
		else if('h' == e.getKeyChar()){
			if(_board.getPriority()==1){
				_board.pickUp(_x,_y);
				_board.setPriority();
				_board.gameUpdate();
			}
			else{
				System.out.println("You are not allow to pick up more than one token in each turn");
			}
		}
//		System.out.println(_board.getCurrentPlayer().getTile().getX());
//		System.out.println(_board.getCurrentPlayer().getTile().getY());
		
		_board.gameUpdate();
	}

}
