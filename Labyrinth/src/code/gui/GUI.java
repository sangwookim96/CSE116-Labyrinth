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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import code.Player.Player;
import code.Tile.Tile;
import code.model.LabyrinthModel;
import code.model.Observer;

public class GUI implements Runnable,Observer {

	private JFrame _window;
	private LabyrinthModel _lm;
	private JPanel _TilePanel, _jp,_p;
//	JButton _b;
	private Tile _tm;
	public GUI(LabyrinthModel lm){
		_lm = lm;
		_lm.setObserver(this);
	}

	@SuppressWarnings("deprecation")
	@Override public void run() {
				
		_window = new JFrame("Labyrinth");
		_window.setLayout(new GridLayout(1,2));
		_window.setSize(2000, 1000);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initializegame();
		
		_window.setVisible(true);
		_window.add(_jp);
		_window.add(_p);
	}
	
	
	
	public boolean checkTheBoard(int x, int y){
		if(y==0 && (x==1 || x==3 || x==5) ){
			return true;
		}
		if(y==6 && (x==1 || x==3 || x==5) ){
			return true;
		}
		if(x==0 && (y==1 || y==3 || y==5) ){
			return true;
		}
		if(x==6 && (y==1 || y==3 || y==5) ){
			return true;
		}
		return false;
	}
	
	public void initializegame() {
		
		_jp = new JPanel();
		_jp.setLayout(new GridLayout(7,7));
		_jp.setFocusable(true);
		
//		String s = "";
		
		for(int i=0;i<_lm.ROWS;i++){
			for(int a=0;a<_lm.COLS;a++){	
				JButton b = new JButton();
//				b.setFocusable(true);
				b.addKeyListener(new MoveHandler(_lm,i,a));
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*2));
				b.setPreferredSize(new Dimension(100, 100));
				if(checkTheBoard(i,a) == true){
					b.addActionListener(new ButtonListener(_lm,i,a));
				}
				_jp.add(b);
			}
		}
		
		_p = new JPanel();
		_p.setLayout(new GridLayout(5,5));
		_p.setFocusable(false);
		for(int i=0;i<24;i++){
			if(i<24 && i!=4 && i!=7	&& i!=17){
				JButton InactiveB = new JButton();
				InactiveB.setContentAreaFilled(false);
				InactiveB.setBorderPainted(false);
				InactiveB.setFocusable(false);
				InactiveB.disable();
				_p.add(InactiveB);
			}
			if(i==4){
				JButton b1 = new JButton();
				b1.setFont(b1.getFont().deriveFont(Font.BOLD, b1.getFont().getSize()*2));
				b1.addActionListener(new ExtraTileListener(_lm));
				b1.setPreferredSize(new Dimension(100, 100));
				_p.add(b1);
			}
			else if(i==7){
				JLabel l = new JLabel("TOKEN: ");
				l.setFont(l.getFont().deriveFont(Font.BOLD, l.getFont().getSize()*2));
				l.setPreferredSize(new Dimension(100, 100));
				_p.add(l);
			}

			else if(i==17){
				JLabel l1 = new JLabel("POINTS: 0");
				l1.setFont(l1.getFont().deriveFont(Font.BOLD, l1.getFont().getSize()*2));
				l1.setPreferredSize(new Dimension(100, 100));
				_p.add(l1);
			}
		}
		update();
	}
	
	
	
	@Override
	public void update() {
		for(int r=0;r<_lm.ROWS;r++){
			for(int c=0;c<_lm.COLS;c++){
				JButton b = (JButton) _jp.getComponent(r*LabyrinthModel.ROWS + c);
				b.setText(_lm.getTile(r,c).getToken()+"");
				b.setIcon(this.char2Image(_lm.getTile(r,c).getCharacter()));
				b.setVerticalTextPosition(SwingConstants.CENTER);
				b.setHorizontalTextPosition(SwingConstants.CENTER);
			}
		}
			for(int i=0;i<24;i++){
				if(i<24 && i!=4 && i!=7	&& i!=17){
					JButton InactiveB = new JButton();
					InactiveB.setContentAreaFilled(false);
					InactiveB.setBorderPainted(false);
					InactiveB.setFocusable(false);
					InactiveB.disable();
				}
				if(i==4){
					JButton b = (JButton) _p.getComponent(i);
					b.setIcon(this.char2Image(_lm.extraTile().getCharacter()));
					b.setText(_lm.extraTile().getToken()+"");
//					b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*2));
					b.setVerticalTextPosition(SwingConstants.CENTER);
					b.setHorizontalTextPosition(SwingConstants.CENTER);
				}
				else if(i==7){
					JLabel l = (JLabel)_p.getComponent(i);
					l.setPreferredSize(new Dimension(100, 100));
				}
				else if(i==17){
					JLabel l1 = (JLabel)_p.getComponent(i);
					l1.setPreferredSize(new Dimension(100, 100));
				}
			}
			_window.repaint();
		}

	public ImageIcon char2Image(char c){
		//L Tile
		ImageIcon exclamation =new ImageIcon("Labyrinth BufferImages\\L Tile\\Type !.png");
		ImageIcon at = new ImageIcon("Labyrinth BufferImages\\L Tile\\Type @.png");
		ImageIcon hashtag = new ImageIcon("Labyrinth BufferImages\\L Tile\\Type #.png");
		ImageIcon L = new ImageIcon("Labyrinth BufferImages\\L Tile\\Type L.png");
		
		//I Tile
		ImageIcon and = new ImageIcon("Labyrinth BufferImages\\I Tile\\Type &.png");
		ImageIcon I = new ImageIcon("Labyrinth BufferImages\\I Tile\\Type I.png");
		
		//T Tile
		ImageIcon percentage = new ImageIcon("Labyrinth BufferImages\\T Tile\\Type %.png");
		ImageIcon power = new ImageIcon("Labyrinth BufferImages\\T Tile\\Type ^.png");
		ImageIcon dollar = new ImageIcon("Labyrinth BufferImages\\T Tile\\Type $.png");
		ImageIcon T = new ImageIcon("Labyrinth BufferImages\\T Tile\\Type T.png");		
		
		if(c=='!'){
			return exclamation;
		}else if(c=='@'){
			return at;			
		}else if(c=='#'){
			return hashtag;
		}else if(c=='L'){
			return L;
		}else if(c=='&'){
			return and;
		}else if(c=='I'){
			return I;
		}else if(c=='%'){
			return percentage;
		}else if(c=='^'){
			return power;
		}else if(c=='$'){
			return dollar;
		}else if(c=='T'){
			return T;
		}		
		return null;
	}
	
}
