package gui;

import java.awt.Font;

import javax.swing.JLabel;

public class TurnTable {
	private JLabel whosturn;
	public TurnTable(String[] p, int ButtonSize, int FontSize, Play _play){
		whosturn = new JLabel();
		String[] stateWord = {"Shift Maze", "Move", "Magic"};
		whosturn.setText("Now it's "+ p[_play.CurrentPlayer()-1] + "'s turn at " +stateWord[_play.getState()-1]+" stage.");
		whosturn.setFont(new Font(whosturn.getName(), Font.BOLD, 2*FontSize));
		whosturn.setBounds(2*ButtonSize, 0*ButtonSize, 10*ButtonSize, ButtonSize);
	}
	
	public JLabel getLabel(){
		return whosturn;
	}

	
}
