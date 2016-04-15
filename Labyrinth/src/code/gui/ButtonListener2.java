package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.model.LabyrinthModel;

/**
 * ActionListener for "End Round" Button.
 * @author Sangwoo
 *
 */
public class ButtonListener2 implements ActionListener {
	
	private LabyrinthModel _board = new LabyrinthModel();
	public ButtonListener2( LabyrinthModel b){
		_board = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(_board.getPriority()==1 || _board.getPriority()==2){
			_board.endRound();

			_board.gameUpdate();
		}
		else{
			System.out.println("error,you're not finish your round yet");
		}

	}

}