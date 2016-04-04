package code.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import code.Player.Player;
import code.Tile.Tile;
import code.model.LabyrinthModel;
import code.model.Observer;

public class GUI implements Runnable,Observer {

	private JFrame _jf;
	private JPanel _jp;
	private LabyrinthModel _lm;
	private Tile _tile;
	private Player _p;
	
	public GUI(LabyrinthModel lm){
		_lm = lm;
		_lm.setObserver(this);
	}
	@Override public void run() {
	
	
	
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
