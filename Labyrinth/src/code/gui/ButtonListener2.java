package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.model.LabyrinthModel;

public class ButtonListener2 implements ActionListener {
	
	private LabyrinthModel _board = new LabyrinthModel();
	public ButtonListener2( LabyrinthModel b){
		_board = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(_board.getPriority()==1){
			_board.endRound();
		}
		else{
			System.out.println("error,you're not finish your round yet");
		}

	}

}