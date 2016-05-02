package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.MultiLayers;
import gui.Play;

public class UseMagicHandler implements ActionListener, MouseListener {
	
	Play play;
	MultiLayers ml;
	Board board;
	String message;
	public UseMagicHandler(Play p, MultiLayers m, Board b){
		play = p;
		ml = m;
		board = b;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(play.getState()==3 && play.isMagicUsedThisTurn()==false){
			if(board.getMagicWands(play.CurrentPlayer())>0){
				board.useMagicWand(play.CurrentPlayer());
				play.setMagicState(true);
				play.setState(1);
				ml.initualize();
			}
			else{
				message = "You don't have any magic wand.";
				ml.updateConsole(message);
			}
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

		
//		play.setState(1);
//		play.NextTurn();
//		ml.initualize();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	

}
