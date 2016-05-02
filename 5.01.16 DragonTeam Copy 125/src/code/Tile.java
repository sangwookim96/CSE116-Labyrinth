package code;

// tile class
public class Tile{
	private int type;
	/**
	 * Array of open directions of a Tile.
	 * @author Sangwoo
	 */
	boolean[] open = {false,false,false,false}; //boolean[] open = new boolean[4]  
	 											//open[0] = false  open[1] = false...
	
	public Tile(int k) {
		if(k>=1 && k<=4){
			type = k;
		}
		else{
			type = 1;
			//Default type = 1
		}
		
		initial();
	}
	
	//type 1~4 , correspond to the 4 kinds of tiles
	//Note that type 4 (which has no open) is used in Board.isLinked() only.

	//type one refers to the tile with an open on the top and an open on the side.
	
//		||||  ||||
//		||      ||
//		||      
//		||      ||
//		||||||||||
	
	//type two refers to the tile with an open on the top and an open on the other side.
	
//		||||  ||||
//		||      ||
//	    ||      ||
//		||      ||
//		||||  ||||
	
	//type three refers to the tile with an open on the top and two opens on the side.
	
//		||||  ||||
//		||      ||
//	      
//		||      ||
//		||||||||||
	
	//type four refers to the tile with no open.
	
//	||||||||||
//	||      ||
//  ||      ||
//	||      ||
//	||||||||||
	
	public Tile clone(){
		Tile output = new Tile(type);
		output.open = open.clone();
		return output;
	}
	
	public int type(){
		return type;
	}
	public boolean[] open(){
		return open;
	}
	
	/**
	 * Initial open direction of a Tile by 4 types.
	 * @return curOpen Current opens of a Tile.
	 * @author Sangwoo
	 */
	public boolean[] initial(){
		 //initialize the Tile
		 //return the initial opens of a tile 

		switch (type){
			case 1: 
				boolean[] initialOpen2 = {true,true,false,false};
				open = initialOpen2;
				break;
			case 2: 
				boolean[] initialOpen3 = {true,false,true,false};
				open = initialOpen3;
				break;
			case 3: 
				boolean[] initialOpen4 = {true,true,false,true};
				open = initialOpen4;
				break;
			case 4: 
				boolean[] initialOpen5 = {false,false,false,false};
				open = initialOpen5;
				break;
				}
		
		return curOpen();
	}
	/**
	 * Return array of Current opens of a tile
	 * @return open.clone()
	 */
	public boolean[] curOpen(){
		//return current opens of a tile
		return open.clone();
	
	}
	/**
	 * Rotate the tile clockwise, and change the curOpne.
	 */
	public void rotate(){
		//rotate the tile clockwise and change the curOpen
		boolean[] newOpen = new boolean[4];
		newOpen[0] = open[3];
		newOpen[1] = open[0];
		newOpen[2] = open[1];
		newOpen[3] = open[2];
		
		open = newOpen;

	}
	
	
}

