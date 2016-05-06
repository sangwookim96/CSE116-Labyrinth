package code;

import gui.MultiLayers;

public class Driver {
	public static String[] _playerName;
	public static void main(String[]args){	
		if(args.length>=1&&args.length<=4){
			_playerName = args;		// static player name which will be stored in SaveGameHandler
		MultiLayers ml = new MultiLayers(args);
		ml.setVisible(true);
		}
		else{
		System.out.println("That's not the right amount of players!");
		}
	}
	
	public static String getPlayerName(int playerNO){
		
		return _playerName[playerNO];
	}
}
