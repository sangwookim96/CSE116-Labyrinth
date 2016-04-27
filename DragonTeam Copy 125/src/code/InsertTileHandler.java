package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.MultiLayers;
import gui.Play;

public class InsertTileHandler implements ActionListener {
	
	private Board _board;
	private int[] _triangle;
	private int _rotTime;
	private Play play;
	private MultiLayers ml;
	private String message;

	
	public InsertTileHandler(Board board, int[] triangle, int rotTime, Play _play, MultiLayers m){
		_board=board;
		_triangle=triangle;
		_rotTime=rotTime;
		play=_play;
		ml=m;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(play.getState() == 1){
			boolean result = _board.insert(_triangle, _rotTime);
			if(result){
				play.NextTurn();
				ml.initualize();
				//switch to move stage
			}
			else{
				message = "Whoa there bub, you can't put that tile there.";
				ml.updateConsole(message);
			}
		}

		
	}

}
