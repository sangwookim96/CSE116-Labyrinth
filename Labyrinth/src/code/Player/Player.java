package code.Player;

import java.util.ArrayList;

import code.Tile.Tile;

public class Player {
	private Character _playerchar;
	private Tile _playertile;	
	private int _magicstick =3;
	boolean turn;
	private ArrayList<Integer> _magicCard = new ArrayList<Integer>();
	private ArrayList<Integer> _tokens = new ArrayList<Integer>();
	private int _score;
	private int _x;
	private int _y;
	
	/**
	 * Tile object of "current Tile" where player is standing.
	 */
	private Tile _cTile;
	private String _name;
	
	
	/**
	 * Player Constructor associates with the Tile where the player is standing (, or will
	 * be standing).
	 * And (x,y) address on the 7*7 board.
	 * @param p	Tile where Player is standing (may be used for pointed Tile object)
	 * @param x X value of Tile location
	 * @param y Y value of Tile location
	 */
	public Player(Tile p,int x,int y){
		magicCard();
		_x = x;
		_y = y;
		_cTile = playerTile(p,_x,_y);
		_cTile.setX(x);
		_cTile.setY(y);


		
	}
	
	private void magicCard() {
		int shuffle = 0;
		for(int i = 0; i < 3; i++){
			shuffle = (int)(Math.random()*21);
			if(shuffle ==0){
				shuffle =25;
			}for(int x = 0; x < _magicCard.size(); x++){
				if(_magicCard.contains(shuffle)){
					_magicCard.remove(x);
					i--;
				}
				_magicCard.add(shuffle);
			}
		}
		
	}
	
	public ArrayList<Integer> getMagicCard(){
		return _magicCard;
	}
	public boolean usingMagicStick(){
		if(_magicstick!=0){
			_magicstick= _magicstick-1;
			turn = true;
		}
		return false;
	}
	
	/**
	 * Picking up the token.
	 * i.e.) Adding token point into "ArrayList<Integer> _token"
	 * @param a The point of a token
	 */
	public void pickUpToken(int a){
		_tokens.add(a);
	}
//	
//	public ArrayList<Integer> showToken(){
//		if(!_tokens.isEmpty()){
//			return _tokens;
//		}
//		else {
//			return _tokens;
//		}
//	}
	
	/**
	 * String that shows all the elements in _token list.
	 * @return s ("" + _token.get(i) ... so on) 
	 */
	public String myToken() {
		String s = "";
		for(int i=0;i<_tokens.size();i++){
			if(i==0){
				s=s+_tokens.get(i).toString();
			}
			else {
				s=s+", "+_tokens.get(i).toString();
			}
		}
		return s;
	}
	
	/**
	 * summation of player's token
	 * @return _score (+= _tokens.get(i) ... so on)
	 */
	public int TotalScore(){
		_score = 0;
		for(int i = 0; i < _tokens.size();i++){
			_score = _score + _tokens.get(i);
//			if(_magicCard.contains(_tokens.get(i))){
//				_score = _score +20;
//			}
		}
//		_score = _score + _magicstick * 3;
		return _score;
	}
	
	
	/**
	 * The location tile where player is standing. 
	 * @param p Tile
	 * @param x x value of Tile pointer
	 * @param y y value of Tile pointer
	 * @return the point on the board where the player is standing.
	 */
	public Tile playerTile(Tile p,int x,int y ){
		if(x<7 && y<7){
			return p;
		}
		return null;
	}
	
	/**
	 * Set _cTile (aka current Tile) to another tile.
	 * @param t the Tile _cTile become. 
	 * @return _cTile updated current Tile.
	 */
	public Tile setTile(Tile t){
		return _cTile = t;
	}

	/**
	 * Get X value of the Tile where player is standing.
	 * @return _x X value of _cTile
	 */
	public int getX(){
		return _x;
	}
	/**
	 * Get Y value of the Tile where player is standing.
	 * @return _y Y value of _cTile
	 */
	public int getY(){
		return _y;
	}
	/**
	 * Setting _cTile's X value to x
	 * @param x Update _x to x.
	 */
	public void setX(int x){
		 _x = x;
	}
	/**
	 * Setting _cTile's Y value to y
	 * @param y Update _y to y.
	 */
	public void setY(int y){
		_y = y;
	}
	/**
	 * Return Current Player Tile where Player is standing.
	 * @return _cTile a.k.a. current Player Tile
	 */
	public Tile getTile(){
		return _cTile;
	}
	
	
	/**
	 * Player (Pawn) can move to an adjacent tile one by one.
	 * (we're not going to set the final destination of player. And ending the player's turn
	 * by player's choice.)
	 * 
	 * 	getY() corresponding left and right direction.
	 * 	getX() corresponding up and down direction.
	 * 
	 * @param tTile The adjacent tile where player want to move.
	 * @return true if the player successfully moves to the adjacent tile.
	 */
	public boolean position(Tile tTile){

		if(tTile == null || _cTile == null){
			return false;
		}
		else if( (_cTile.getX()==tTile.getX()) && (_cTile.getY() == (tTile.getY()+1)) ){
			if(_cTile.getWest()==true && tTile.getEast()==true){
				_cTile = tTile;
				this.setY(tTile.getY());
				return true;
			}
		}
		else if( (_cTile.getX()==tTile.getX()) && (_cTile.getY() == (tTile.getY()-1)) ){
			if(_cTile.getEast()==true && tTile.getWest()==true){
				_cTile = tTile;
				this.setY(tTile.getY());
				return true;
			}
		}		
		else if( (_cTile.getX()==(tTile.getX()+1) ) && (_cTile.getY() == tTile.getY()) ){

			if(_cTile.getNorth()==true && tTile.getSouth()==true){
				_cTile = tTile;
				this.setX(tTile.getX());
				return true;
			}
		}		
		else if( (_cTile.getX()==(tTile.getX()-1)) && (_cTile.getY() == tTile.getY()) ){
			if(_cTile.getSouth()==true && tTile.getNorth()==true){
				_cTile = tTile;
				this.setX(tTile.getX());
				return true;
			}
		}
		return false;
	}
	
	public void PlayerColor(int color){
		if(color==0){
			// set player color to Red
		} else if(color==1){
			// set player color to Blue
		} else if(color==2){
			// set player color to Yellow
		} else if(color==3){
			// set player color to Green
		}		
	}
	
	/**
	 * Set the name of the Player.
	 * Enter name by Command Line in Driver.
	 * @param name Set _name to name.
	 */
	public void setName(String name){
		_name = name;
	}
	
	/**
	 * Return the Player
	 * @return _name Player's name
	 */
	public String getName(){
		return _name;
	}
	
	

	
}
	   
	