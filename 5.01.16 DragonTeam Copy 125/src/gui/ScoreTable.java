package gui;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import code.Board;

public class ScoreTable {
	protected JLabel name = new JLabel();
	protected ArrayList<Integer> score = new ArrayList<Integer>();
	public ScoreTable(String p,Board _board, int playerNO, int ButtonSize, int FontSize){
		

		    	name = new JLabel();
		    	score = _board.showScore(playerNO);
		    	String message = "";
		    	if(score.isEmpty()){
		    		message = "0";
		    	}
		    	else{
		    		for(Integer i:score){
		    		message += ", "+i;
		    		}
		    		message = message.substring(2);
		    	}
		    	
		    	// text of tokens, and magic wand.
		    	name.setText("<html>"+p+"     "+message+"<br>"+", magicWand: "+ 
		    			_board.getMagicWands(playerNO)+"</html>");
		    	name.setFont(new Font(name.getName(), Font.BOLD, FontSize));
		    	name.setBounds(11*ButtonSize, (playerNO+2)*ButtonSize, 3*ButtonSize, ButtonSize);
		    	
		    
	}
	
	public JLabel getLabel(){
		return name;
	}
}
