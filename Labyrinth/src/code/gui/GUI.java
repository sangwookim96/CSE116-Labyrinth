package code.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	private JPanel _TilePanel;
	private Tile _tm;
	public GUI(LabyrinthModel lm){
		_lm = lm;
		_lm.setObserver(this);
	}
//	
	@SuppressWarnings("deprecation")
	@Override public void run() {
		
_lm = new LabyrinthModel();
		
		_window = new JFrame("Labyrinth");
		_window.setVisible(true);
		_window.setLayout(new GridLayout(1,2));
		_window.setSize(2000, 1000);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp = new JPanel();
		_window.add(jp);
		jp.setLayout(new GridLayout(7,7));
		jp.setFocusable(true);
		
		String s = "";
		
		for(int i=0;i<_lm.ROWS;i++){
			for(int a=0;a<_lm.COLS;a++){
				ImageIcon c=new ImageIcon("C:\\Users\\AdityaKishan\\git\\team-125\\Labyrinth\\Labyrinth BufferImages\\L Tile\\Type !.png");
				JButton b = new JButton(/*s+_lm.getTile(i,a).getCharacter()*//*c*/);
				//b.(_tm.setIcon(s+_lm.getTile(i,a).getCharacter()));
				b.setIcon(c);
				b.setPreferredSize(new Dimension(100, 100));
				jp.add(b);
			}
		}
		
		
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,5));
		p.setFocusable(false);
		for(int i=0;i<24;i++){
			if(i<24 && i!=4 && i!=7	&& i!=17){
				JButton InactiveB = new JButton();
				InactiveB.setContentAreaFilled(false);
				InactiveB.setBorderPainted(false);
				InactiveB.setFocusable(false);
				InactiveB.disable();
				p.add(InactiveB);
			}
			if(i==4){
				JButton b1 = new JButton("EXTRA TILE");
				b1.setPreferredSize(new Dimension(100, 100));
				p.add(b1);
			}
			else if(i==7){
				JLabel l = new JLabel("TOKEN: ");
				l.setPreferredSize(new Dimension(100, 100));
				p.add(l);
			}
			else if(i==17){
				int points = 0;
				JLabel l1 = new JLabel("POINTS: "+ points);
				l1.setPreferredSize(new Dimension(100, 100));
				p.add(l1);
			}
		}
		_window.add(p);
	}
	
	public ImageIcon char2Image(char c){
		//L Tile
		ImageIcon exclamation =new ImageIcon("C:\\Users\\AdityaKishan\\git\\team-125\\Labyrinth\\Labyrinth BufferImages\\L Tile\\Type !.png");
		ImageIcon at = new ImageIcon("");
		ImageIcon hashtag = new ImageIcon("");
		ImageIcon L = new ImageIcon("");
		
		//I Tile
		ImageIcon and = new ImageIcon("");
		ImageIcon I = new ImageIcon("");
		
		//T Tile
		ImageIcon percentage = new ImageIcon("");
		ImageIcon power = new ImageIcon("");
		ImageIcon dollar = new ImageIcon("");
		ImageIcon T = new ImageIcon("");
		
		
		
		
		
		return null;
	}
	
//	
	@Override
	public void update() {
		
//		JButton _TilePanel.getComponent()
		// TODO Auto-generated method stub
		
		_window.repaint();
	}

}
