package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.model.LabyrinthModel;

/**
 * Actionlistener for JButtons on the push-able position of 7*7 board
 * @author Sangwoo, Taki
 *
 */
public class ButtonListener implements ActionListener {
	
	private LabyrinthModel _board = new LabyrinthModel();
	private int _x;
	private int _y;
	
	public ButtonListener(LabyrinthModel b, int x, int y){
		_board = b;
		_x = x;
		_y = y;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(_board.getPriority()==0){
			_board.push(_board.Point2Position(_x, _y));
			_board.setPriority();
			_board.gameUpdate();
		}
		else{
			System.out.println("error,you alreadly shift the tile");
		}
	}

}
