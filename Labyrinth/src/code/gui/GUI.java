package code.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JLabel _jl;
	private ArrayList<Character> _list;
	private String s;
	
	
	public GUI(LabyrinthModel lm){
		_lm = lm;
		_lm.setObserver(this);
	}
	
	@Override public void run() {
		_window = new JFrame("Labyrinth Team 125 Edition");
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window.getContentPane().setLayout(new FlowLayout());
		_window.setFocusable(true);
		_window.setSize(3, 2);
//		_window.setFocusTraversalKeysEnabled(false);
		_jl = new JLabel("a");
		
		_jp = new JPanel();
		_jp.setFocusable(true);
		_jp.setLayout(new GridLayout(LabyrinthModel.ROWS, LabyrinthModel.COLS));
		
		int c=0;
		
		for(int i=0;i<LabyrinthModel.COLS;i++){
			for(int ii=0;ii<LabyrinthModel.ROWS;ii++){
				JButton b = new JButton();
				b.setOpaque(true);
				b.setFocusable(false);
				b.setPreferredSize(new Dimension(100, 100));  // so board stays same size regardless of letters
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*4));
				_jp.add(b);
			}
		}
		_window.add(_jp);
		_window.pack();
		_window.setVisible(true);
		update();
		}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		_window.repaint();
	}

}
