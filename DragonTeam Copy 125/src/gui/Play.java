package gui;

public class Play{
	private int state;
	private int player;
	private int totalPlayer;
	private boolean magic;
	public Play(String[] p){
		state = 1;
		player = 1;
		totalPlayer = p.length;
		magic = false;
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
			}
		}
	}
	
	public boolean isMagicWandUsed(){
		
		return false;
	}

	public int getState(){
		return state;
	}
	public void setState(int newState){
		state = newState;
	}
	public void setPlayer(int newPlayer){
		player = newPlayer;
	}
	
	public int CurrentPlayer(){
		return player;
	}
}
