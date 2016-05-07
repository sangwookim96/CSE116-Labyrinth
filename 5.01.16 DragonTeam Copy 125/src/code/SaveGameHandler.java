package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Writer;

import gui.MultiLayers;
import gui.Play;

public class SaveGameHandler implements ActionListener {
//	Writer saveOutput = null;
//	File file = new File("Save File.txt");
//	saveOutput = new BufferWriter(new FileWriter(file));
	
	String _saveFileFormat = "";
	int _amountOfPlayers = Driver.getPlayerLength();
	String _playerRecord = "";
	String _tileRecord = "";
	Play play;
	MultiLayers ml;
	Driver driver;
	Board board;
	Tile tile;
	public SaveGameHandler(Driver d, Play _play, MultiLayers m, Board b, Tile t){
		driver = d;		// Names of players **** HOW CAN I CALL "args" from Driver???
		play = _play;	// Turn of Player and its state (using magic wand)
		ml = m;
		board = b;
		tile = t;
		
		
	}

	/*
	 * list of all the player records 
	 * [name, pawn color, wands remaining, secret recipe ingredients, 
	 * tokens collected]
	 */
	/*
	 * type (T = has a t-intersection, I = has a straight path, 
	 * L = has a 90 degree/corner path), 
	 * its rotation (0, 1, 2 or 3), 
	 * 
	 * the token on it (0 if none, otherwise a number from 1-20 or 25),
	 *  
	 * and a list of the player pawns on the tile. 
	 */
	/*
	 * The one illegal push for the loose tile 
	 * (which is not represented explicitly, 
	 * but can be inferred from the other information stored). 
	 * The triangle "push points" will be numbered 1 through 12, 
	 * starting in the upper left corner of the board and proceeding clockwise. 
	 * If the game is saved before the first player has made a move,
	 *  a 0 is written.
	 */
	/*
	 * line #1:
	 * [River,BLUE,3,[3,12,14],[1,3,4,11]],
	 * [Kaylee,RED,2,[2,10,16],[2,6,7,8,9]],
	 * [Jayne,GREEN,0,[5,9,18],[5,10,12]]
	 * line #2:
	 * [T0,0,[]],[L3,0,[]],[L2,0,[]],[I3,0,[BLUE,GREEN]],[T1,0,[]],[I0,0,[]],[T3,0,[]],[L2,0,[]],[L1,0,[]],[T2,19,[RED]]...and so on...
	 * line #3:
	 * 9
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(isStartOfPlayer()){
			_saveFileFormat = _saveFileFormat + _playerRecord + "\n" + _tileRecord;
		}

	}
	
	// The ONLY condition for saving game (start of player's turn)
	public boolean isStartOfPlayer(){
		if(play.getState()==1 && play.isMagicUsedThisTurn()==false){
			return true;
		}		
		return false;
	}
	
	/** 
	 * add player informations in array of _PlayerRecord
	 * informations need: player name, color of pawn, magic wand remaining, secrete recipe.
	 * @param NOfPlayers total amount of players (1~4)
	 */
	
	public void generatePlayerRecord(int NOfPlayers){ // amount of players
		if(NOfPlayers-1>=0&&NOfPlayers-1<=3){
			for(int i=0; i<NOfPlayers; i++){
				if(i>=1){
					_playerRecord = _playerRecord+", ";
				}
				_playerRecord = _playerRecord + "["+Driver.getPlayerName(i)+", "+colorOfPawn(i+1)
				+", "+magicRemain(i+1)+", "+secreteRecipeIngredient(i+1)+", "
				+tokensCollected(i+1)+"]";
			}
		}
	}	
	
	/**
	 * Scan all 7*7 board, and all tiles in the board.
	 * information need: Type of tile+Rotation, token on it, list of pawns on it(color).
	 */
	public void generateTileRecord(){
	
		for(int c=0; c<=6; c++){// y
			for(int r=0; r<=6; r++){// x
				int[] tileLocation = {r,c};
				if(c==0&&r==0){
					_tileRecord = _tileRecord + "[";
				}else{
					_tileRecord = _tileRecord+ ", [";
				}
				whatTileType(c, r);
				whatTokenOnTile(tileLocation);
				whatPlayersOnTile(tileLocation);
				_tileRecord = _tileRecord+"]";
			}
		}		
	}
	
	/**
	 * Write tile type save file format (i.e. <type of tile><rotation#>
	 * @param c x value of tile position on board
	 * @param r y value of tile position on board
	 * @return String of save tile format (i.e. T0, L3, etc.)
	 */
	public String whatTileType(int c, int r){
		
		int[] tileLocation = {r,c};
		_tileRecord = _tileRecord + "[";
		switch(board.get_StateOfBoard()[r][c].type()){
		case 1:
			return _tileRecord = _tileRecord + "L"+howManyTileRotation(tileLocation);
		case 2:
			return _tileRecord = _tileRecord + "I"+howManyTileRotation(tileLocation);
		case 3:
			return _tileRecord = _tileRecord + "T"+howManyTileRotation(tileLocation);
		}
			
		return null;
	}
	public String howManyTileRotation(int[] position){
		int row = position[0];
		int col = position[1];
		for(int i=0; i<=3; i++){
			if(board.get_StateOfBoard()[row][col].curOpen().equals(tile.initial())){
				return _tileRecord = _tileRecord + i;
			}
				
		}
		
		return _tileRecord = _tileRecord +0;
	}
	
	/**
	 * Write save file format of token on the tile.
	 * If empty, 0.
	 * @param position array position of tile
	 * @return String save file format of token on the tile position.
	 */
	public String whatTokenOnTile(int[] position){
		int row = position[0];
		int col = position[1];
		for(int tokenNO=1; tokenNO<=21; tokenNO++){
			if(position==board.get_tokenPosition(tokenNO)){
				if(tokenNO==21){
					return _tileRecord = _tileRecord+ ", 25";
				}
				return _tileRecord = _tileRecord+ ", " + tokenNO;
			}
		}
		return _tileRecord = _tileRecord + ", 0";
	}
	/**
	 * Write list of players in bracket
	 * @param position tile location where to check
	 * @return String save file format of player on the tile position.
	 */
	public String whatPlayersOnTile(int[] position){
		_tileRecord = _tileRecord+", [";
		for(int i=1; i<=_amountOfPlayers;i++){
			if(i>=2){
				_tileRecord = _tileRecord+", ";
			}
			if(position.equals(board.get_pawnPosition(i))){
				return _tileRecord = _tileRecord+ colorOfPawn(i);
			}
		}
		
		return _tileRecord = _tileRecord+"]";
	}
	
	// Player informations methods
	
	public String tokensCollected(int playerNO){
		String result = ""+board.showScore(playerNO);
		
		return result;
	}
	
	public String secreteRecipeIngredient(int playerNO){
		String result = ""+board.getFormula(playerNO);
		
		return result;
	}
	
	public String magicRemain(int playerNO){
		String result = ""+board.getMagicWands(playerNO);
		
		return result;
	}
	
	public String colorOfPawn(int playerNO){
		switch(playerNO){
		case 1:
			return "RED"; 
		case 2:
			return "BLUE";
		case 3: 
			return "GREEN";
		case 4:
			return "PURPLE";
		}
		
		return null;
	}
	
	public String PlayerNO2Name(int playerNO){
		String playerName = Driver.getPlayerName(playerNO);
		
		return playerName;
	}
	

}
