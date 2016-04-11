package code.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import code.Tile.Tile;
import code.model.LabyrinthModel;

public class MoveHandler implements KeyListener {
	
	private LabyrinthModel _board = new LabyrinthModel();
	private int _x;
	private int _y;
	private int _player;

	
	public MoveHandler(LabyrinthModel b, int number, int x, int y){
		_board = b;
		_x = x;
		_y = y;
		_player = number;
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
		_board.topTile();
		_board.bottomTile();
		_board.leftTile();
		_board.rightTile();

		if('w' == e.getKeyChar()){
			Tile up = _board.getUpTile();
			_board.getPlayer().get(_player).position(up);
		}
		else if('s' == e.getKeyChar()){
			Tile down = _board.getbottomTile();
			_board.getPlayer().get(_player).position(down);
		}
		else if('a' == e.getKeyChar()){
			Tile left = _board.getLeftTile();
			_board.getPlayer().get(_player).position(left);
		}
		else if('d' == e.getKeyChar()){
			Tile right = _board.getRightTile();
			_board.getPlayer().get(_player).position(right);
		}
		else{
			System.out.println("error, you press the wrong buttons");
		}
	}

}
