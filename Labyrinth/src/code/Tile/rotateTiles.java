package code.Tile;

/**
 * This class is written to 
 * create a rotation effect 
 * on the tiles that are to 
 * be populated when the 
 * board is initialized.
 * the instance variables 
 * _north;
 * _south;
 * _east;
 * _west;
 * represent the section of a 
 * tile and our method sets the 
 * positions equal to the 
 * position to its right.
 * 
 * @param rotation rotates the 
 * tile to the right
 * 
 */
public class rotateTiles {
	

	private int _north;
	private int _south;
	private int _east;
	private int _west;
	
	public int rotateTiles(int side){
	
		_north = 1; 
		_east=0;
		_south=1;
		_west=0;
		
		_north=_east;
		_east=_south;
		_south=_west;
		_west=_north;
		
		return 0;
	}
	
}
