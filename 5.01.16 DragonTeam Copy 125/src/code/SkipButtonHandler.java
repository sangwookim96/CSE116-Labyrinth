package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.MultiLayers;
import gui.Play;

public class SkipButtonHandler implements ActionListener, MouseListener{

	Play play;
	MultiLayers ml;
	public SkipButtonHandler(Play _play, MultiLayers m){
		play = _play;
		ml = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(play.getState() == 2 || play.getState()==3){
			play.NextTurn();
			ml.initualize();
		}
		else{
			ml.updateConsole("You cannot skip Shifting Maze!");
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(play.getState() == 2){
			ml.updateConsole("You cannot skip Shifting Maze!");
		}
		
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