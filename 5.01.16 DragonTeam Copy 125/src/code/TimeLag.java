package code;

import java.util.ArrayList;

import gui.MultiLayers;

public class TimeLag implements Runnable{
	Board board;
	MultiLayers ml;
	int playerNO;
	ArrayList<int[]> set;

	public TimeLag(Board _board, int _playerNO, MultiLayers m, ArrayList<int[]> _set){
		board = _board;
		ml = m;
		set = _set;
		playerNO = _playerNO;

	}

	@Override
	public void run() {
		//call move so player can eat token
		board.move(playerNO, set.get(set.size()-1));
		
		//Make pawn move to each of tiles on the path.
		for(int i=0; i<set.size(); i++){

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			board.set_pawnPosition(playerNO, set.get(i));
			ml.initualizePawn();
			ml.repaint();
		}
		ml.initualizeToken();
		ml.initualizeScoreBoard();
		ml.initualizeTurnTable();
		ml.repaint();
	}

}
