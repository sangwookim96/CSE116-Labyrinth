package code.Tile;

import java.nio.file.Path;

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

	
    private Path _path;
    private Character _char;
		
		public Tile() {			
			_char = ' ';   // why "space"???
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
		


	}
