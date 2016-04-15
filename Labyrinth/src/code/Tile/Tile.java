package code.Tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import code.Player.Player;
import code.gui.GUI;
import code.model.LabyrinthModel;

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
	/**
	 * For Testing purpose, we store the type of Tile as character
	 */
	private Character _char;
	
	/**
	 * East path's open statue
	 */
	private boolean _east=false;
	/**
	 * North path's open statue
	 */
	private boolean _north=false;
	/**
	 * South path's open statue
	 */
	private boolean _south=false;
	/**
	 * West path's open statue
	 */
	private boolean _west=false;
	
	/**
	 * Tile's X value on 7*7 board
	 */
	private int _x;
	/**
	 * Tile's Y value on 7*7 board
	 */
	private int _y;
	
	/**
	 * ArrayList of Tokens (TOKENS BRO, TOKENS) that must be on when starting game.
	 */
	static ArrayList<Integer>_points=new ArrayList<Integer>();
	/**
	 * Value of token that Tile is holding.
	 */
	private int _token;
	/**
	 * Tile Image (a.k.a. BufferedImage)
	 */
	public BufferedImage _img;
	
	private code.gui.GUI _gui;
	

	/**
	 * For the testing purpose each tile has its individual character.
	 */
	public Tile() {			
		_char = ' ';
		
	}

	/**
	 * Get char for testing purpose
	 * @return _char Tile's testing char.
	 */
	public Character getCharacter() {
		return _char;
	}

	/**
	 * Set testing char (_char) to c
	 * @param c 
	 */
	public void setCharacter(char c) {
		_char=c;
	}

	/**
	 * According to TileTypeChart (in the BufferedImage file in this project file),
	 * Every cases of rotation of 3 tile types has representing char.
	 * (* 'T' represents upside down T) 
	 * @param type Input of representation of Tile type as char.
	 * @return boolean values of Tile's 4 direction.
	 */
	public boolean Tiledirection(char type){
		if(type=='L'){
			_north=true;
			_east=true;
			return true;
		}
		if(type=='!'){
			_north=true;
			_west=true;
			return true;
		}
		if(type=='@'){
			_south=true;
			_west=true;
			return true;
		}
		if(type=='#'){
			_south=true;
			_east=true;
			return true;
		}

		if(type=='%'){
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
		if(type=='T'){
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
	 * check if the tile has a token
	 * @return true if token value is not equal zero
	 */
	public boolean hasToken(){
		return _token!=0;
	}
	
	/**
	 * Set the value of token that the Tile is holding to i.
	 * Usually, set _token to 0 after Player done pick-up action.
	 * @param i input of future token value. (usually 0)
	 */
	public void setValueOfToken(int i){
		_token = i;
	}
	
	/**
	 * return the current value of token that on the  tile
	 * @return the value of the token
	 */
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
	
	
	/**
	 * Return boolean value of North path of the Tile
	 * @return _north
	 */
	public boolean getNorth(){
		return _north;
	}
	/**
	 * Return boolean value of south path of the Tile
	 * @return _south
	 */
	public boolean getSouth(){
		return _south;
	}
	/**
	 * Return boolean value of west path of the Tile
	 * @return _west
	 */
	public boolean getWest(){
		return _west;
	}
	/**
	 * Return boolean value of east path of the Tile
	 * @return _east
	 */
	public boolean getEast(){
		return _east;
	}
	
	/**
	 * Set Tile's X value to x
	 * Usually use this for switching X values of an ExtraTile, & a Tile on the push-able
	 * position of the board. 
	 * @param x Set Tile's X value to x
	 */
	public void setX(int x){
		_x = x;
	}
	/**
	 * Set Tile's Y value to y
	 * Usually use this for switching Y values of an ExtraTile, & a Tile on the push-able
	 * position of the board. 
	 * @param y Set Tile's Y value to y
	 */
	public void setY(int y){
		_y = y;
	}
	
	/**
	 * Check if there is any players standing on the Tile
	 * @param player ArrayList<Player> that storing all the players in the game.
	 * @return true if one of element of "ArrayList<Player> player" has same X & Y value as the Tile's X & Y.
	 */
	public boolean hasPlayer(ArrayList<Player> player){
		for(int i = 0; i < player.size(); i++ ){
			if(player.get(i).getTile().getX()==_x && player.get(i).getTile().getY() == _y){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Edit all X&Y values of the Player objects in CURRENT TILE to Tile t
	 * Usually use during shifting column or row activity
	 * @param player	ArrayList<Player> player. Checks if any Player objects are standing on (x,y).
	 * @param t	Tile object which is destination of Player(s).
	 */
	public void changingPlayerPosition(ArrayList<Player> player, Tile t){
		for(int i = 0; i < player.size(); i++ ){
			if(player.get(i).getTile().getX()==_x && player.get(i).getTile().getY() == _y){
				player.get(i).setTile(t);
				player.get(i).setX(t.getX());
				player.get(i).setY(t.getY());

			}
		}
	}

	// We don't need this. new ImageIcon("BufferedImage Name") is the BufferedImage object of "... Name".
	public BufferedImage setIcon(String string) {
		Graphics g = null;
		BufferedImage img;
		String filename;
//		try {
//			if(string.equals("!")){
//				filename="C:/Users/ziyi/git/team-125/Labyrinth/Labyrinth BufferImages/L Tile/Type !.png";
//				img=ImageIO.read(new File(filename));
//				_img=img;
//				return _img;	
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return _img;	
		// TODO Auto-generated method stub
		
	}

	private void paint(Graphics g,BufferedImage img) {
		g.drawImage(img, getX(), getY(), null);
		// TODO Auto-generated method stub
		
	}
	
	
	// Image class
	
	

	


}