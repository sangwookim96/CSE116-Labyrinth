package code;

import gui.MultiLayers;

public class Driver {
	static Tile tile;
	public Driver(Tile t){
		tile = t;
	}
	public static String[] _playerName;
	public static void main(String[]args){	
		if(args.length>=1&&args.length<=4){
			_playerName = args;		// static player name which will be stored in SaveGameHandler
		MultiLayers ml = new MultiLayers(args, tile);
		ml.setVisible(true);
		}
		else{
		System.out.println("That's not the right amount of players!");
		}
	}
	
	public static String getPlayerName(int playerNO){
		
		return _playerName[playerNO];
	}
	
	public static int getPlayerLength(){
		
		return _playerName.length;
	}
}
