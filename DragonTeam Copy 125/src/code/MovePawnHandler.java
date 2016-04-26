package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Timer;

import code.Board;
import gui.MultiLayers;
import gui.Play;

public class MovePawnHandler implements ActionListener {
	
	private Board _board;
	private int _playerNO;
	private int[] _request;
	private Play play;
	private MultiLayers ml;
	private String message;
	
	public MovePawnHandler(Board board, int[] request, Play _play, MultiLayers m){
		_board=board;
		_playerNO=_play.CurrentPlayer();
		_request=request;
		play = _play;
		ml=m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(play.getState() == 2){
			Board _board2 = _board.clone();
			boolean result = _board2.move(_playerNO, _request);
			if(result==false){
				message = "Whoops! You can't move there!";
				ml.updateConsole(message);
			}
			else if(result==true){
				int[] pos = _board.get_pawnPosition(_playerNO);
				ArrayList<int[]> allPath = _board.legalMoves(pos);
				allPath.add(pos);
				ArrayList<int[]> set = _board.findPath(_playerNO, _request, allPath);
				set.remove(set.size()-1);
				
				TimeLag tl = new TimeLag(_board, _playerNO, ml, set);
				Thread thread = new Thread(tl);
				thread.start();

				play.NextTurn();

			}
		}
		
	}

}
