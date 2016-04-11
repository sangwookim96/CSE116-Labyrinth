package code.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import code.model.Observer;

import java.util.Random;

import javax.imageio.ImageIO;

import code.Player.Player;
import code.Tile.Tile;
import code.gui.GUI;
public class LabyrinthModel extends Tile{


	/* This is our main model class that is basically a hub for methods and connections between all other classes
	 * in the model.
	 */

	/**
	 * Defining the Rows and Columns to be used in other method to populate the board.
	 * 
	 */
	public static final int COLS = 7;   

	/** These are static variables because their values do not change throughout the program.
	 * 
	 */
	public static final int ROWS = COLS; 
	ArrayList<Character> movetiles = new ArrayList<Character>();
	int _size=34;

	/**This is the temporary variable that after initialization is the tile that is used for the first move.
	 * 
	 */
	Tile _temp1 = new Tile();  		// temp variable for FreeTile
	Tile _temp2= new Tile();

	/** a representation of the board (non-graphical)
	 * 
	 */
	private Tile[][] _board; 
	/** a representation of the board (non-graphical)
	 * 
	 */
	private String s;       // 
	private ArrayList<Player> _player = new ArrayList<Player>();
	private ArrayList<String> _list;
	private Observer _observer;
	private int _cPlayer = 1;
	private int _playerNumber;
	private Player _currentPlayer;
	private int _priority = 0;
	private Tile _top = new Tile();
	private Tile _bottom = new Tile();
	private Tile _left = new Tile();
	private Tile _right = new Tile();

	/**
	 * The following constructor does the job of initializing the Tile array to a 7 by 7 board.
	 * The set of for loops add 34 I, L and T tiles to an array list from which characters are randomly drawn.
	 * From having a look at the spare tiles, it was discovered that there are 10 I tiles and 12 L and T tiles.
	 * @author Aditya Kishan Ankaraboyana
	 */
	public LabyrinthModel() {
		_observer = null;
		Tile t = new Tile();
		t.createToken();		
		_board=new Tile[7][7];
		setupTile();
		initializeBoard();
		_temp1.setX(9);
		_temp1.setY(9);
		_currentPlayer = _player.get(0);

	}

	public void setupTile(){
		for(int i=0;i<5;i++){     
			movetiles.add('I');
		}
		for(int i=0;i<5;i++){     
			movetiles.add('&');
		}
		for(int j=0;j<3;j++){
			movetiles.add('T');
		}
		for(int j=0;j<3;j++){
			movetiles.add('$');
		}
		for(int j=0;j<3;j++){
			movetiles.add('%');
		}
		for(int j=0;j<3;j++){
			movetiles.add('^');
		}
		for(int k=0;k<3;k++){
			movetiles.add('L');
		}	
		for(int k=0;k<3;k++){
			movetiles.add('#');
		}	
		for(int k=0;k<3;k++){
			movetiles.add('@');
		}	
		for(int k=0;k<3;k++){
			movetiles.add('!');
		}

	}



	/**
	 * This method has a simple function of initializing the board as the name suggests.
	 * The first for conditions manually set the corners as L Tiles
	 * The fifth conditional statement assigns T's to the other 12 static tiles.
	 * The final condition initializes all other mobile tiles by using Random function.
	 * For purpose of testing this method return an integer that counts all the characters from the tiles.
	 * To check this we used an output of integer which holds the size 
	 * @author Aditya Kishan Ankaraboyana
	 */
	public void initializeBoard() {
		Image img;
		Graphics g=null;
		for(int r=0;r<7;r++){
			for(int c=0;c<7;c++){
				if(r==0&&c==0){
					_board[r][c]=new Tile();
					_board[r][c].setX(r);
					_board[r][c].setY(c);
					_board[r][c].Tiledirection('#');
					_board[r][c].setCharacter('#');
					
					
					
				}
				else if(r==6&&c==6){
					_board[r][c]=new Tile();
					_board[r][c].setX(r);
					_board[r][c].setY(c);
					_board[r][c].Tiledirection('!');
					_board[r][c].setCharacter('!');
				}
				else if(r==6&&c==0){
					_board[r][c]=new Tile();
					_board[r][c].setX(r);
					_board[r][c].setY(c);
					_board[r][c].Tiledirection('L');
					_board[r][c].setCharacter('L');;
				}
				else if(r==0&&c==6){
					_board[r][c]=new Tile();
					_board[r][c].setX(r);
					_board[r][c].setY(c);
					_board[r][c].Tiledirection('@');
					_board[r][c].setCharacter('@');
				}
				else if((r==0&&c==2)||(r==2&&c==4)||(r==0&&c==4)){
					_board[r][c]=new Tile();
					_board[r][c].setX(r);
					_board[r][c].setY(c);
					_board[r][c].Tiledirection('%');
					_board[r][c].setCharacter('%');
					if(checkPlayer(r,c)){
						_player.add(new Player(_board[r][c],r,c));
					}
				}
				else if((r==2&&c==0)||(r==2&&c==2)||(r==4&&c==0)){
					_board[r][c]=new Tile();
					_board[r][c].setX(r);
					_board[r][c].setY(c);
					_board[r][c].Tiledirection('$');
					_board[r][c].setCharacter('$');
					if(checkPlayer(r,c)){
						_player.add(new Player(_board[r][c],r,c));
					}
				}
				else if((r==6&&c==2)||(r==4&&c==2)||(r==6&&c==4)){
					_board[r][c]=new Tile();
					_board[r][c].setX(r);
					_board[r][c].setY(c);
					_board[r][c].Tiledirection('T');
					_board[r][c].setCharacter('T');
					if(checkPlayer(r,c)){
						_player.add(new Player(_board[r][c],r,c));
					}
				}
				else if((r==2&&c==6)||(r==4&&c==6)||(r==4&&c==4)){
					_board[r][c]=new Tile();
					_board[r][c].setX(r);
					_board[r][c].setY(c);
					_board[r][c].Tiledirection('^');
					_board[r][c].setCharacter('^');
					if(checkPlayer(r,c)){
						_player.add(new Player(_board[r][c],r,c));
					}
				}
				else{
					_board[r][c]=new Tile();
					_board[r][c].setX(r);
					_board[r][c].setY(c);
					char check=randomCharacter();						
					_board[r][c].Tiledirection(check);
					_board[r][c].setCharacter(check);
					if((0 < r && r < 6 )&&(0 < c && c < 6 )&&(!checkPlayer(r,c))){
						_board[r][c].setTokens();
						
					}
				}
//				System.out.println(_board[r][c].getCharacter());
			} 			
		}
		randomCharacter();
	}
	public String Characters() {
		s = "";
		String ss= "";
		String characters = "";
		Array[] Array = new Array[49];
		_list = new ArrayList<String>();
		for(int r=0;r<7;r++){
			for(int c=0;c<7;c++){
				char c1 = _board[r][c].getCharacter();
				s+=c1;
				_list.add(s);
				characters+=s;
				s=ss;
			}
		}//System.out.println(characters);
		
		return characters;
	} 

	//check the initial player position
	public boolean checkPlayer(int x,int y){
		if(x==2 && y==2){
			return true;
		}
		if(x==2 && y==4){
			return true;
		}
		if(x==4 && y==2){
			return true;
		}
		if(x==4 && y==4){
			return true;
		}
		return false;
	}
	
	public Tile getTile(int x, int y){
		return _board[x][y];
	}

	//collect all the tile,only use for test
	public ArrayList<Character> allTheTile(){
		ArrayList<Character> a = new ArrayList<Character>();
		for (int x = 0; x < 7; x++){
			for(int y = 0; y < 7; y++){
				a.add(getTile(x,y).getCharacter());
				//System.out.print(a);
			}
		}
		return a;
	}
	
	public ArrayList<Player> getPlayer(){
		return _player;
	}



	public char randomCharacter() {			
		String s = "";
		Random x=new Random();
		if(movetiles.size()!=1){
			int i=x.nextInt(_size);

			char c=movetiles.get(i);

			movetiles.remove(i);
			_size=_size-1;

			return c;
		}
		else{
			char c=movetiles.get(0);
			_temp1.Tiledirection(c);
			_temp1.setCharacter(c);
//			s=s+c;
		}
//						System.out.println(ss);


		return '0';			
	}
	
	
	//swap the player and token data between two tile
	//for example,there are token number 25 and two players standing in the tile c.If tile c
	//has been push out off the board,by calling the change method will set the token number 25 and two player
	//from the tile c to tile t
	public void change(Tile c, Tile t){
		if(c.hasToken()){
			t.setValueOfToken(c.getToken());
			c.setValueOfToken(0);
		}
		if(c.hasPlayer(_player)){
			c.changingPlayerPosition(_player, t);
		}
	}
	
	//This method checks for legal moves  
	// We need a method that translates Array point to int. 	
	public void push (int position ){	
		switch(position){
		case 1:{
			_temp2=_board[1][6];
			change(_temp2,_temp1);
			for (int c=6;c>0;c--){
				_board[1][c]=_board[1][c-1];
			}
			_board[1][0]=_temp1;
			_board[1][0].setX(1);
			_board[1][0].setY(0);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		case 2:{
			_temp2=_board[3][6];
			change(_temp2,_temp1);
			for (int c=6;c>0;c--){
				_board[3][c]=_board[3][c-1];
			}
			_board[3][0]=_temp1;
			_board[3][0].setX(3);
			_board[3][0].setY(0);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		case 3:{
			_temp2=_board[5][6];
			change(_temp2,_temp1);
			for (int c=6;c>0;c--){
				_board[5][c]=_board[5][c-1];
			}
			_board[5][0]=_temp1;
			_board[5][0].setX(5);
			_board[5][0].setY(0);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		case 4:{
			_temp2=_board[6][1];
			change(_temp2,_temp1);
			for (int r=6;r>0;r--){
				_board[r][1]=_board[r-1][1];
			}
			_board[0][1]=_temp1;
			_board[0][1].setX(1);
			_board[0][1].setY(0);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		case 5:{
			_temp2=_board[6][3];
			change(_temp2,_temp1);
			for (int r=6;r>0;r--){
				_board[r][3]=_board[r-1][3];
			}
			_board[0][3]=_temp1;
			_board[0][3].setX(0);
			_board[0][3].setY(3);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		case 6:{
			_temp2=_board[6][5];
			change(_temp2,_temp1);
			for (int r=6;r>0;r--){
				_board[r][5]=_board[r-1][5];
			}
			_board[0][5]=_temp1;
			_board[0][5].setX(0);
			_board[0][5].setY(5);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		case 7:{
			_temp2=_board[1][0];
			change(_temp2,_temp1);
			for (int c=0;c<6;c++){
				_board[1][c]=_board[1][c+1];
			}
			_board[1][6]=_temp1;
			_board[1][6].setX(1);
			_board[1][6].setY(6);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		case 8:{
			_temp2=_board[3][0];
			change(_temp2,_temp1);
			for (int c=0;c<6;c++){
				_board[3][c]=_board[3][c+1];
			}
			_board[3][6]=_temp1;
			_board[3][6].setX(3);
			_board[3][6].setY(6);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			
			break;
		}
		case 9:{
			_temp2=_board[5][0];
			change(_temp2,_temp1);
			for (int c=0;c<6;c++){
				_board[5][c]=_board[5][c+1];
			}
			_board[5][6]=_temp1;
			_board[5][6].setX(5);
			_board[5][6].setY(6);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		case 10:{
			_temp2 =_board[0][5];
			change(_temp2,_temp1);
			for (int r=0;r<6;r++){
				_board[r][5]=_board[r+1][5];
			}
			_board[6][5]=_temp1;
			_board[6][5].setX(6);
			_board[6][5].setY(5);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		case 11:{
			_temp2=_board[0][3];
			change(_temp2,_temp1);
			for (int r=0;r<6;r++){
				_board[r][3]=_board[r+1][3];
			}
			_board[6][3]=_temp1;
			_board[6][3].setX(6);
			_board[6][3].setY(3);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		case 12:{
			_temp2=_board[0][1];
			change(_temp2,_temp1);
			for (int r=0;r<6;r++){
				_board[r][1]=_board[r+1][1];
			}
			_board[6][1]=_temp1;
			_board[6][1].setX(6);
			_board[6][1].setY(1);
			_temp1 = _temp2;
			_temp1.setX(9);
			_temp1.setY(9);
			break;
		}
		}


	}
	/**
	 * Translating point of board to the integer (pushable) position which we named.
	 * @param x x value of point
	 * @param y y value of pint
	 * @return Position that we named by integer numbers.
	 */
	public int Point2Position(int x, int y){
		Tile location = _board[x][y];
		if(location==_board[1][6]){
			return 1;
		}
		else
			if(location==_board[3][6]){
				return 2;		
			}
		else
			if(location==_board[5][6]){
				return 3;
			}
		else
			if(location==_board[6][1]){
				return 4;
			}
		else
			if(location==_board[6][3]){
				return 5;
			}
		else
			if(location==_board[6][5]){
				return 6;
			}
		else
			if(location==_board[1][0]){
				return 7;
			}
		else
			if(location==_board[3][0]){
				return 8;
			}
		else
			if(location==_board[5][0]){
				return 9;
			}
		else
			if(location==_board[0][5]){
				return 10;
			}
		else
			if(location==_board[0][3]){
				return 11;
			}
		else
			if(location==_board[0][1]){
				return 12;
			}
		return 0;
	} 
	
	public Tile extraTile(){
		return _temp1;
	}
	public void endRound(){
		resetPriority();
		if(_cPlayer == _playerNumber ){
			_cPlayer = 0;
		}
		_cPlayer++;
		_currentPlayer = _player.get(_cPlayer);
	}
	
	public Player getCurrentPlayer(){
		return _currentPlayer;
	}
	
	public void topTile(){
		if(_currentPlayer.getX() > 0){
			_top = getTile((_currentPlayer.getX()-1),_currentPlayer.getY());
		}
		else{
			_top = null;
		}
	}
	public Tile getUpTile(){
		return _top;
	}
	
	public void bottomTile(){
		if(_currentPlayer.getX() < 6){
			_bottom = getTile((_currentPlayer.getX()+1),_currentPlayer.getY());

		}
		else{
			_bottom = null;
		}
	}
	
	public Tile getbottomTile(){
		return _bottom;
	}
	
	
	public void leftTile(){
		if(_currentPlayer.getY() > 0){
			_left = getTile(_currentPlayer.getX(),(_currentPlayer.getY()-1));

		}
		else{
			_left = null;
		}
	}
	
	public Tile getLeftTile(){
		return _left;
	}
	
	
	public void rightTile(){
		if(_currentPlayer.getY() < 6){
			_right = getTile(_currentPlayer.getX(), (_currentPlayer.getY()+1));

		}
		else{
			_right = null;
		}
	}
	
	public Tile getRightTile(){
		return _right;
	}
	
	
	public void setPlayerNumber(int i){
		_playerNumber = i; 
	}
	
	public int getPlayerNumber(){
		return _playerNumber; 
	}
	
	public void magicstick(){
		if(_currentPlayer.usingMagicStick()==true){
			_priority =0;
		}
		else{
			System.out.println("You don't have magic stick!");
		}
	}

	public void setPriority(){
		_priority++;
	}
	public int getPriority(){
		return _priority;
	}
	public void resetPriority(){
		_priority = 0;
	}

	public void setObserver(Observer ob) {
		// TODO Auto-generated method stub
		_observer = ob;
	}

	public void gameUpdate() {
		if (_observer != null) {
			_observer.update();
		}
	}






}