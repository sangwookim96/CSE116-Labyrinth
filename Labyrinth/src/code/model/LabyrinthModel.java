package code.model;

import java.util.ArrayList;

import code.model.Observer;
import java.util.Random;
import code.Player.Player;
import code.Tile.Tile;
import code.gui.GUI;
public class LabyrinthModel {

	
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
		Tile _temp2=null;
		
	/** a representation of the board (non-graphical)
	 * 
	 */
		private Tile[][] _board; 
	/** a representation of the board (non-graphical)
	 * 
	 */
		private String ss;       // 
		private ArrayList<Player> _player = new ArrayList<Player>();
		private Observer _observer;
	
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
			for(int r=0;r<7;r++){
				for(int c=0;c<7;c++){
					if(r==0&&c==0){
						_board[r][c]=new Tile();
						_board[r][c].Tiledirection('!');
					}
					else if(r==6&&c==6){
						_board[r][c]=new Tile();
						_board[r][c].Tiledirection('#');
					}
					else if(r==6&&c==0){
						_board[r][c]=new Tile();
						_board[r][c].Tiledirection('L');
					}
					else if(r==0&&c==6){
						_board[r][c]=new Tile();
						_board[r][c].Tiledirection('@');
					}
					else if((r==0&&c==2)||(r==2&&c==4)||(r==0&&c==4)){
						_board[r][c]=new Tile();
						_board[r][c].Tiledirection('T');
						if(checkPlayer(r,c)){
							_player.add(new Player(_board[r][c],r,c));
						}
					}
					else if((r==2&&c==0)||(r==2&&c==2)||(r==4&&c==0)){
						_board[r][c]=new Tile();
						_board[r][c].Tiledirection('$');
						if(checkPlayer(r,c)){
							_player.add(new Player(_board[r][c],r,c));
						}
					}
					else if((r==6&&c==2)||(r==4&&c==2)||(r==6&&c==4)){
						_board[r][c]=new Tile();
						_board[r][c].Tiledirection('%');
						if(checkPlayer(r,c)){
							_player.add(new Player(_board[r][c],r,c));
						}
					}
					else if((r==2&&c==6)||(r==4&&c==6)||(r==4&&c==4)){
						_board[r][c]=new Tile();
						_board[r][c].Tiledirection('^');
						if(checkPlayer(r,c)){
							_player.add(new Player(_board[r][c],r,c));
						}
					}
					else{
						_board[r][c]=new Tile();
						char check=randomCharacter();
//						if(check=='0'){
//							System.out.println("fuck");
//							break;
//						}							
							_board[r][c].Tiledirection(check);
							if((0 < r && r < 6 )&&(0 < c && c < 6 )&&(!checkPlayer(r,c))){
								_board[r][c].setTokens();
						}
					}

				} 
			}
			randomCharacter();
			
//			ss= "";
//			for(int r=0;r<7;r++){
//				for(int c=0;c<7;c++){
//					char c1 = _board[r][c].getCharacter();
//					ss=ss+c1;
//				}
//			}
//			
//			int Stringlength = ss.length();
//			System.out.println(ss);
//			
//			return Stringlength;
		}
		
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
		
		public ArrayList<Player> getPlayer(){
			return _player;
		}
		
		public Tile getTile(int x,int y){
			return _board[x][y];
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
				    _temp1.setCharacter(c);
				    ss=s+c;
			    }
//				System.out.println(ss);
				
				
				return '0';			
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