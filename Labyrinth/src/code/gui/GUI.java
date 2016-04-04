package code.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.Player.Player;
import code.Tile.Tile;
import code.model.LabyrinthModel;
import code.model.Observer;

public class GUI implements Runnable,Observer {

	private JFrame _window;
	private JPanel _jp;
	private LabyrinthModel _lm;
	private Tile _tile;
	private Player _p;
	
	public GUI(LabyrinthModel lm){
		_lm = lm;
		_lm.setObserver(this);
	}
	
	@Override public void run() {
		_window = new JFrame("Labyrinth Team 125 Edition");
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window.getContentPane().setLayout(new FlowLayout());
		_window.setFocusable(true);
//		_window.setFocusTraversalKeysEnabled(false);
		
		_jp = new JPanel();
		_jp.setFocusable(true);
		_jp.setLayout(new GridLayout(LabyrinthModel.ROWS, LabyrinthModel.COLS));
		
		
		_window.pack();
		_window.setVisible(true);
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
