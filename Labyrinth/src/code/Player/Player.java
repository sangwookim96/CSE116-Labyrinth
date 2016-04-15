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
	private Tile _cTile;
	private String _name;
	
	
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
	 * @param a the point of a token
	 */
	public void pickUpToken(int a){
		_tokens.add(a);
	}
	public ArrayList<Integer> showToken(){
		if(!_tokens.isEmpty()){
			return _tokens;
		}
		else {
			return _tokens;
		}
	}
	
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
	
	
	public Tile setTile(Tile t){
		return _cTile = t;
	}

	
	public int getX(){
		return _x;
	}
	public int getY(){
		return _y;
	}
	public void setX(int x){
		 _x = x;
	}
	public void setY(int y){
		_y = y;
	}
	public Tile getTile(){
		return _cTile;
	}
	
	
	/**
	 * Player (Pawn) can move to an adjacent tile one by one.
	 * (we're not going to set the final destination of player. And ending the player's turn
	 * by player's choice.)
	 * 
	 * @param tTile the adjacent tile where player want to move.
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
	public void setName(String name){
		_name = name;
	}
	
	public String getName(){
		return _name;
	}
	
	

	
}
	   
	