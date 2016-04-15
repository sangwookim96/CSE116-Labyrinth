package code.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import code.Tile.Tile;
import code.model.LabyrinthModel;

public class MoveHandler implements KeyListener {

	private LabyrinthModel _board = new LabyrinthModel();



	public MoveHandler(LabyrinthModel b){
		_board = b;

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

		if(_board.getPriority()==1){
			if('w' == e.getKeyChar()){
				_board.topTile();
				Tile up = _board.getUpTile();
				boolean result = _board.getCurrentPlayer().position(up);

				_board.gameUpdate();

			}
			else if('s' == e.getKeyChar()){
				_board.bottomTile();
				Tile down = _board.getbottomTile();
				boolean result = _board.getCurrentPlayer().position(down);
				_board.gameUpdate();

			}
			else if('a' == e.getKeyChar()){
				_board.leftTile();
				Tile left = _board.getLeftTile();
				boolean result = _board.getCurrentPlayer().position(left);
				_board.gameUpdate();

			}
			else if('d' == e.getKeyChar()){
				_board.rightTile();
				Tile right = _board.getRightTile();
				boolean result = _board.getCurrentPlayer().position(right);
				_board.gameUpdate();

			}
			else if('h' == e.getKeyChar()){
					if (_board.pickUp(_board.getCurrentPlayer().getX(),_board.getCurrentPlayer().getY())){
						_board.setPriority();
					}
					_board.gameUpdate();
				}
			}
		else{
			System.out.println("You are not allow move at that time");
		}
	}

}