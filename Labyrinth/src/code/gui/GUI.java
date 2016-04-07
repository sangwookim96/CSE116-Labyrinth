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
	private LabyrinthModel _lm;
//	private Tile _tile;
//	private Player _p;
//	private JLabel _jl;
//	private ArrayList<Character> _list;
//	private String s;
//	
//	
	public GUI(LabyrinthModel lm){
		_lm = lm;
		_lm.setObserver(this);
	}
//	
	@Override public void run() {
		
		_lm = new LabyrinthModel();
		
		_window = new JFrame("Labyrinth");
		_window.setVisible(true);
		_window.setLayout(new GridLayout(1,2));
		_window.setSize(1500, 1000);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp = new JPanel();
		_window.add(jp);
		jp.setLayout(new GridLayout(7,7));
		jp.setFocusable(true);
		
		for(int i=0;i<_lm.ROWS;i++){
			for(int a=0;a<_lm.COLS;a++){
				JButton b = new JButton();
				b.setPreferredSize(new Dimension(100, 100));
				jp.add(b);
			}
		}
		
		JPanel p = new JPanel();
		_window.add(p);
		p.setLayout(new GridLayout(1,1));
		p.setFocusable(true);
		JButton b1 = new JButton("Extra Tile");
		p.add(b1);
		b1.setPreferredSize(new Dimension(100, 100));
		
		
		
		
		
		
		
	}
//		_window = new JFrame("Labyrinth Team 125 Edition");
//		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		_window.getContentPane().setLayout(new FlowLayout());
//		_window.setFocusable(true);
////		_window.setSize(3,2);
//		_window.setFocusTraversalKeysEnabled(false);
//		_jl = new JLabel("a");
//		
//		_jp = new JPanel();
//		_jp.setFocusable(true);
//		_jp.setLayout(new GridLayout(LabyrinthModel.ROWS, LabyrinthModel.COLS));
//		
//		JPanel panel = new JPanel();
//		panel.setLayout(new GridLayout(7,2));
//		_jp.setFocusable(true);
//		
//		int c=0;
//		
//		for(int i=0;i<LabyrinthModel.COLS;i++){
//			for(int ii=0;ii<LabyrinthModel.ROWS;ii++){
//				JButton b = new JButton();
//				b.setOpaque(true);
//				b.setFocusable(false);
//				b.setPreferredSize(new Dimension(100, 100));  // so board stays same size regardless of letters
//				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*4));
//				_jp.add(b);
//			}
//		}
//		_window.add(panel);
//		_window.add(_jp);
//		_window.pack();
//		_window.setVisible(true);
//		update();
//		}
//	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		_window.repaint();
	}

}
