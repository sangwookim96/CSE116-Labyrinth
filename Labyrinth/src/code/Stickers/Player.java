package code.Stickers;

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
	
	
	public Player(Tile[][] p,int x,int y){
		magicCard();
		_x = x;
		_y = y;
		_cTile = playerTile(p,_x,_y);
		
			
	}
	
	private void magicCard() {
		int shuffle = 0;
		for(int i = 0; i < 3; i++){
			shuffle = (int)(Math.random()*21);
			if(shuffle ==0){
				shuffle =25;
			}
			if(_magicCard.contains(shuffle)){
				_magicCard.remove(shuffle);
				i--;
			}
			_magicCard.add(shuffle);
		}
		
	}
	public boolean usingMagicStick(){
		if(_magicstick!=0){
			_magicstick= _magicstick-1;
			turn = true;
		}
		return false;
	}
	
	public void getToken(int a){
		_tokens.add(a);
	}
	
	public int TotalScore(){
		_score = 0;
		for(int i = 0; i < _tokens.size();i++){
			_score = _score + _tokens.get(i);
			if(_magicCard.contains(_tokens.get(i))){
				_score = _score +20;
			}
		}
		_score = _score + _magicstick * 3;
		return _score;
	}
	
	public Tile playerTile(Tile[][] p,int x,int y ){
		if(x<p.length && y<p[0].length){
			return p[x][y];
		}
		return null;
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
	
	public boolean position(Tile tTile){
		if(tTile == null || _cTile == null){
			return false;
		}
		else if((_cTile.getX()==tTile.getX()) &&(_cTile.getY() == tTile.getY()+1)){
			if(_cTile.getNorth()==true&& tTile.getSouth()==true){
				_cTile.setY(tTile.getY()+1);
				return true;
			}
			return false;
		}
		else if((_cTile.getX()==tTile.getX()) &&(_cTile.getY() == tTile.getY()-1)){
			if(_cTile.getSouth()==true&& tTile.getNorth()==true){
				_cTile.setY(tTile.getY()-1);
				return true;
			}
			return false;
		}		
		else if((_cTile.getX()==tTile.getX()+1) &&(_cTile.getY() == tTile.getY())){
			if(_cTile.getEast()==true&& tTile.getWest()==true){
				_cTile.setX(tTile.getX()+1);
				return true;
			}
			return false;
		}		
		else if((_cTile.getX()==tTile.getX()-1) &&(_cTile.getY() == tTile.getY())){
			if(_cTile.getWest()==true&& tTile.getEast()==true){
				_cTile.setX(tTile.getX()-1);
				return true;
			}
			return false;
		}
		return false;
	}
	
	
	/*
	 * Methods required:
	 * Location()
	 * Score()
	 * Tokens()
	 * PawnColor()
	 * 
	 */
	
}
	   
	