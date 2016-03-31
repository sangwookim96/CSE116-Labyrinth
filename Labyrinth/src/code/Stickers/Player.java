package code.Stickers;

import java.util.ArrayList;

public class Player {

	/**
	 * ArrayList was created to store the name of the players that are in the game.
	 * 
	 * @param list = new ArrayList of strings.
	 * 
	 * @author Himayet C
	 * 
	 */
	
	ArrayList<String> list = new ArrayList<String>();
	
	
	
	/**
	 * Over here we created an instance variable _number which represents the maximum amount of players 
	 * that can join the game which is 4 or 0-3.
	 */
	private int _number;
	
	
	/**
	 *   
	 * We created a String and labeled it s. this string represents a player title. 
	 * 
	 * when we do the for loop and add the player i value. it adds it to the array list as player 0. 
	 * 
	 * then it redefines the string as player so that we can add them as players 0-3. 
	 * 
	 * 
	 * @author Himayet C and Aditya K
	 */
	public int players(int number){
		_number = number;
		String s = "Player ";
		for(int i=0;i<_number;i++){
			int player;
			player=i;
			char c = (char)player;
			s=s+player;
			list.add(s);
			s = "Player ";
			
		}
		return list.size();
		
		
		
	}
	
	
}
