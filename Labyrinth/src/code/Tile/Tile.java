package code.Tile;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

import code.Player.Player;

/** This class is the tile class which basically states the methods 
that are used to populate the board based on the tile path shape
and is defined in the Labyrinth Model class. We use the instance 
variable _char in order to use character representations when we 
populate the board in initialize board in the model class. c is a 
local variable used in this class to represent character. 
get character is a method that pulls a character and we use set 
character to set that shaped path onto the tile.

@param get character which obtains a character at a given position
@param set character places that character onto a tile. 
@author Himayet Chowdhury, Aditya Kishan Ankaraboyana
*/

public  class Tile {

	int token;
	private Character _char;
	private boolean _east=false;
	private boolean _north=false;
	private boolean _south=false;
	private boolean _west=false;
	private int _x;
	private int _y;
	static ArrayList<Integer>_points=new ArrayList<Integer>();
	private int _token;


	public Tile() {			
		_char = ' ';

	}

	public Character getCharacter() {
		return _char;
	}

	public void setCharacter(char c) {
		_char=c;
	}

	public boolean Tiledirection(char type){
		if(type=='L'){
			_north=true;
			_east=true;
			return true;
		}
		if(type=='#'){
			_north=true;
			_west=true;
			return true;
		}
		if(type=='@'){
			_south=true;
			_west=true;
			return true;
		}
		if(type=='!'){
			_south=true;
			_east=true;
			return true;
		}

		if(type=='T'){
			_south=true;
			_east=true;
			_west=true;
			return true;
		}
		if(type=='$'){
			_north=true;
			_east=true;
			_south=true;
			return true;
		}
		if(type=='%'){
			_west=true;
			_east=true;
			_north=true;
			return true;
		}
		if(type=='^'){
			_west=true;
			_north=true;
			_south=true;
			return true;
		}
		if(type=='I'){
			_north=true;
			_south=true;
			return true;
		}
		if (type=='&'){
			_east=true;
			_west=true;
			return true;
		}

		return false;

	}

	/**
	 * This method adds 21 values to the ArrayList named _points. 
	 * The value range from 1 to 20 and 25.
	 */
	public void createToken(){
		for(int i=1;i<21;i++){
			_points.add(i);
		}
		_points.add(25);

	}

	/**
	 * This method sets the tokens on the board. The basic principle is to remove 
	 * one out of 21 tokens from the ArrayList _points and put it on the board.
	 * We repeat this until the whole ArrayList is empty.
	 */
	public void setTokens(){

		if(!_points.isEmpty()){
			_token = _points.remove((int)(Math. random() * _points.size()));
		}

	}
	/**
	 * return the current value of token that on the  tile
	 * @return the value of the token
	 */
	public int pickUpToken(){
		return _token;
	}
	
	/**
	 * check if the tile has a token
	 * @return true if token value is not equal zero
	 */
	public boolean hasToken(){
		return _token!=0;
	}
	

	public void setValueOfToken(int i){
		_token = i;
	}
	
	public int getToken(){
		return _token;
	}
	
	/**
	 * get the  x position of that tile
	 * @return the value of current x position
	 */
	public int getX(){
		return _x;
	}
	/**
	 * get the  y position of that tile
	 * @return the value of current y position
	 */
	public int getY(){
		return _y;
	}
	
	
	
	public boolean getNorth(){
		return _north;
	}
	public boolean getSouth(){
		return _south;
	}
	public boolean getWest(){
		return _west;
	}
	public boolean getEast(){
		return _east;
	}
	

	public void setX(int x){
		_x = x;
	}

	public void setY(int y){
		_y = y;
	}
	//check if there is player standing on the tile
	public boolean hasPlayer(ArrayList<Player> player){
		for(int i = 0; i < player.size(); i++ ){
			if(player.get(i).getTile().getX()==_x && player.get(i).getTile().getY() == _y){
				return true;
			}
		}
		return false;
	}
	
	//change all the players that in current tile to tile t
	public void changingPlayerPosition(ArrayList<Player> player, Tile t){
		for(int i = 0; i < player.size(); i++ ){
			if(player.get(i).getTile().getX()==_x && player.get(i).getTile().getY() == _y){
				player.get(i).setTile(t);
			}
		}
	}

	


}