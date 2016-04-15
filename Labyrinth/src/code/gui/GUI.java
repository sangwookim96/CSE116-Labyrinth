package code.gui;

import java.awt.Color;
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
import javax.swing.UIManager;
import javax.swing.border.Border;

import code.Player.Player;
import code.Tile.Tile;
import code.model.LabyrinthModel;
import code.model.Observer;

public class GUI implements Runnable,Observer {

	private JFrame _window,_window1;
	/**
	 * LabyrinthModel class
	 */
	private LabyrinthModel _lm;
	/**
	 * _jg: Main Panel
	 * _p: Extra Panel
	 */
	private JPanel _TilePanel, _jp,_p;
	private Player _player;
	private Tile _tm;
	
	/**
	 * GUI associate with Model class.
	 * @param lm
	 */
	public GUI(LabyrinthModel lm){
		_lm = lm;
		_lm.setObserver(this);
	}

	@SuppressWarnings("deprecation")
	@Override public void run() {
		
		// JFrame for Game.
		_window = new JFrame("Labyrinth");
		_window.setLayout(new GridLayout(1,2));
		_window.setSize(2000, 1000);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initializegame();
		
		_window.setVisible(true);
		_window.add(_jp);
		_window.add(_p);
		
		
		// JFrame for Instructions
		_window1 = new JFrame("Instructions");
		_window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window1.setVisible(true);
		_window1.setSize(1000,2000);
		JPanel panel1 = new JPanel();
		_window1.add(panel1);
		panel1.setLayout(new GridLayout(1,1));
		panel1.setFocusable(true);
		JLabel Instructions = new JLabel("<html>Welcome to Labyrinth the Online Board Game<br>"
				+ "Labyrinth is the perfect family game,<br>ideal for up to 4 players,<br>The "
				+ "clever and unique game play ensures an even playing field for players of all "
				+ "ages;<br>so young children, teenagers, parents and grandparents all have an "
				+ "equal chance to win.<br>As the walls are constantly moving, no two games are ever "
				+ "the same,<br> which means it always exciting. <br>Instructions:<br> </html>"
				,SwingConstants.CENTER);
		Instructions.setFont(Instructions.getFont().deriveFont(Font.ITALIC,Instructions.getFont().getSize()*3));
		panel1.add(Instructions);
	}
	
	/**
	 * check All the click-able (push-able) position on the edges of board
	 * @param x	X value of the checking tile
	 * @param y Y value of the checking tile
	 * @return true if it is click-able (push-able)
	 */
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
	
	/**
	 * Start of Game, creates 2 JPanels: one for 7*7 board, and one for Game Information.
	 */
	public void initializegame() {
		
		// Board Panel
		_jp = new JPanel();
		_jp.setLayout(new GridLayout(7,7));
		_jp.setFocusable(true);
				
		for(int i=0;i<_lm.ROWS;i++){
			for(int a=0;a<_lm.COLS;a++){	
				JButton b = new JButton();
				b.addKeyListener(new MoveHandler(_lm));
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*2));
				b.setPreferredSize(new Dimension(100, 100));
				if(checkTheBoard(i,a) == true){
					b.addActionListener(new ButtonListener(_lm,i,a));
				}
				_jp.add(b);
			}
		}
		
		
		// Extra Panel
		_p = new JPanel();
		_p.setLayout(new GridLayout(5,5));
		_p.setFocusable(false);
		for(int i=0;i<25;i++){
			// Background
			if(i>4 && i<20 && i!=11 && i!=12 && i!=13){
				JButton InactiveB = new JButton();
				InactiveB.setBackground(Color.DARK_GRAY);
				InactiveB.setBorderPainted(false);
				InactiveB.setFocusable(false);
				InactiveB.disable();
				_p.add(InactiveB);
			}
			
			// SEXY TITLE
			if(i==0){
				JButton b = new JButton("L");
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.RED);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*8));
				b.setPreferredSize(new Dimension(100, 100));
				_p.add(b);	
			}
			else if(i==1){
				JButton b = new JButton("A");
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.RED);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*8));
				b.setPreferredSize(new Dimension(100, 100));
				_p.add(b);
			}
			else if(i==2){
				JButton b = new JButton("B");
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.RED);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*8));
				b.setPreferredSize(new Dimension(100, 100));
				_p.add(b);
			}
			else if(i==3){
				JButton b = new JButton("Y");
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.RED);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*8));
				b.setPreferredSize(new Dimension(100, 100));
				_p.add(b);
			}
			else if(i==4){
				JButton b = new JButton("-");
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.RED);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*8));
				b.setPreferredSize(new Dimension(100, 100));
				_p.add(b);
			}
			else if(i==20){
				JButton b = new JButton("R");
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.RED);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*8));
				b.setPreferredSize(new Dimension(100, 100));
				_p.add(b);
			}
			else if(i==21){
				JButton b = new JButton("I");
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.RED);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*8));
				b.setPreferredSize(new Dimension(100, 100));
				_p.add(b);
			}
			else if(i==22){
				JButton b = new JButton("N");
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.RED);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*8));
				b.setPreferredSize(new Dimension(100, 100));
				_p.add(b);
			}
			else if(i==23){
				JButton b = new JButton("T");
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.RED);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*8));
				b.setPreferredSize(new Dimension(100, 100));
				_p.add(b);
			}
			else if(i==24){
				JButton b = new JButton("H");
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.RED);
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*8));
				b.setPreferredSize(new Dimension(100, 100));
				_p.add(b);
			}
			
			// Extra Tile Rotation Button
			else if(i==11){
				JButton b1 = new JButton();
				b1.setFont(b1.getFont().deriveFont(Font.BOLD, b1.getFont().getSize()*2));
				b1.addActionListener(new ExtraTileListener(_lm));
				b1.setPreferredSize(new Dimension(100, 100));
				_p.add(b1);
			}
			
			// End Turn Button
			else if(i==13){
				JButton b2 = new JButton("End Turn");
				b2.setFont(b2.getFont().deriveFont(Font.BOLD, b2.getFont().getSize()*2));
				b2.setBackground(Color.RED);
				b2.setForeground(Color.BLACK);
				b2.addActionListener(new ButtonListener2(_lm));
				b2.setPreferredSize(new Dimension(100, 100));
				_p.add(b2);
			}
			
			// A Player's Point Information
			else if(i==12){
				JLabel l1 = new JLabel();
				l1.setFont(l1.getFont().deriveFont(Font.BOLD, l1.getFont().getSize()*2));
				l1.setPreferredSize(new Dimension(100, 100));
				l1 .setBackground(Color.GRAY);
				_p.add(l1);
			}
		}
		update();
	}
	
	
	// Update
	@Override
	public void update() {
		// 7*7 Board update
		for(int r=0;r<_lm.ROWS;r++){
			for(int c=0;c<_lm.COLS;c++){
				JButton b = (JButton) _jp.getComponent(r*LabyrinthModel.ROWS + c);
				
				// Visual of Token
				String token = "";
				if(_lm.getTile(r, c).getToken()!=0) token = Integer.toString(_lm.getTile(r, c).getToken());
				
				// Visual of Player
				String player = "";
				for(Player p: _lm.getPlayer()){
					if(p.getX() == r && p.getY() == c){
						if(p.getName()!=null){
							player += p.getName();
						}
					}
				}
				
				//set Visual of token and player name(s)
				b.setText(token+" " + player);
				b.setIcon(this.char2Image(_lm.getTile(r,c).getCharacter()));
				b.setVerticalTextPosition(SwingConstants.CENTER);
				b.setHorizontalTextPosition(SwingConstants.CENTER);
			}
		}
		
		// Extra Panel update
			for(int i=0;i<24;i++){
				if(i<24 && i!=11 && i!=12 && i!=13){
					JButton InactiveB = new JButton();
					InactiveB.setContentAreaFilled(false);
					InactiveB.setBorderPainted(false);
					InactiveB.setFocusable(false);
					InactiveB.disable();
				}
				if(i==11){
					JButton b = (JButton) _p.getComponent(i);
					b.setIcon(this.char2Image(_lm.extraTile().getCharacter()));
					b.setVerticalTextPosition(SwingConstants.CENTER);
					b.setHorizontalTextPosition(SwingConstants.CENTER);
				}
				else if(i==13){
					JButton b = (JButton) _p.getComponent(i);
					b.setVerticalTextPosition(SwingConstants.CENTER);
					b.setHorizontalTextPosition(SwingConstants.CENTER);
				}
				else if(i==12){
					JLabel l1 = (JLabel)_p.getComponent(i);
					l1.setVerticalTextPosition(SwingConstants.CENTER);
					l1.setHorizontalTextPosition(SwingConstants.CENTER);
					if(_lm.getCurrentPlayer().TotalScore()!=0){
						l1.setText("point: " + _lm.getCurrentPlayer().TotalScore());
						l1.setVerticalTextPosition(SwingConstants.CENTER);
						l1.setHorizontalTextPosition(SwingConstants.CENTER);
					}
					else{
						l1.setText(_lm.getCurrentPlayer().getName()+" POINTS: 0 ");
						l1.setVerticalTextPosition(SwingConstants.CENTER);
						l1.setHorizontalTextPosition(SwingConstants.CENTER);
					}
					l1.setVerticalTextPosition(SwingConstants.CENTER);
					l1.setHorizontalTextPosition(SwingConstants.CENTER);
					l1.setPreferredSize(new Dimension(100, 100));
				}
			}
			_window.repaint();
		}

	/**
	 * Translate char of Tile type to ImageIcon (BufferedImage)
	 * @param c 	char Tile type
	 * @return The ImageIcon depending on Tile type
	 */
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