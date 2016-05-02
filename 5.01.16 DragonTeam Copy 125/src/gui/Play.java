package gui;

public class Play{
	private int state;
	private int player;
	private int totalPlayer;
	private boolean magicState;
	public Play(String[] p){
		state = 1;
		player = 1;
		totalPlayer = p.length;
		magicState = false;
	}
	
	public void NextTurn(){
		if(totalPlayer == 4){
			switch(state){
			case 1:
				state = 2;
				break;
			case 2:

				switch(player){
				case 1:
					player = 2;
					state = 1;
					break;
				case 2:
					player = 3;
					state = 1;
					break;
				case 3:
					player = 4;
					state = 1;
					break;
				case 4:
					player = 1;
					state = 1;
					break;
				}
				break;
			case 3:
				switch(player){
				case 1:
					player = 2;
					state = 1;
					break;
				case 2:
					player = 3;
					state = 1;
					break;
				case 3:
					player = 4;
					state = 1;
					break;
				case 4:
					player = 1;
					state = 1;
					break;
				}
				break;
			}
		}

		else if(totalPlayer == 3){
			switch(state){
			case 1:
				state = 2;
				break;
			case 2:

				switch(player){
				case 1:
					player = 2;
					state = 1;
					break;
				case 2:
					player = 3;
					state = 1;
					break;
				case 3:
					player = 1;
					state = 1;
					break;
				}
				break;
			case 3:
				switch(player){
				case 1:
					player = 2;
					state = 1;
					break;
				case 2:
					player = 3;
					state = 1;
					break;
				case 3:
					player = 1;
					state = 1;
					break;
				}
				break;
			}
		}
		
		else if(totalPlayer == 2){
			switch(state){
			case 1:
				state = 2;
				break;
			case 2:

				switch(player){
				case 1:
					player = 2;
					state = 1;
					break;
				case 2:
					player = 1;
					state = 1;
					break;
				}
				break;
			case 3:
				switch(player){
				case 1:
					player = 2;
					state = 1;
					break;
				case 2:
					player = 1;
					state = 1;
					break;
				}
				break;
			}
		}
	}

	public int getState(){
		return state;
	}
	
	public int CurrentPlayer(){
		return player;
	}
	
	public void setState(int i){
		state = i;
	}	
	
	/**
	 * This method will control the duplication avoiding function later.
	 * @return true if player used a magic its turn, false otherwise.
	 */
	public boolean isMagicUsedThisTurn(){
		
		return magicState;
	}
	public void setMagicState(boolean b){
		magicState = b;
	}
}
