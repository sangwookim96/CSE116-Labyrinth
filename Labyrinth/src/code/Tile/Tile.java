package code.Tile;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

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
    private Path _path;
    private Character _char;
    private boolean _east=false;
    private boolean _north=false;
    private boolean _south=false;
    private boolean _west=false;
    static ArrayList<Integer>_points=new ArrayList<Integer>();
    
		
		public Tile() {			
			_char = ' ';
			
		}
		
		public Character getCharacter() {
			return _char;
		}
	
		public void setCharacter(char c) {
			_char=c;
		}
		
		public void rotateTiles() {
			rotateTiles rt = new rotateTiles();
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
				_north=true;
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
				_south=true;
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
		public void token(){
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
        public void settokens(){
        
        	if(_points.isEmpty()==false){
        		
				_points.remove(Math. random() * _points.size());
				
        	}
        	
        }

	}