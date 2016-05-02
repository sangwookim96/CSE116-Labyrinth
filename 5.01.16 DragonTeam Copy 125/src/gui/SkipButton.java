package gui;

import java.awt.Font;

import javax.swing.JButton;

import code.SkipButtonHandler;

public class SkipButton {
	JButton skip;
	
	public SkipButton(int ButtonSize, int FontSize, Play _play, MultiLayers m){
		skip = new JButton();
		skip.setText("Skip move!!");
		skip.setFont(new Font(skip.getName(), Font.BOLD, FontSize));
		skip.setBounds(11*ButtonSize, 9*ButtonSize, 2*ButtonSize, ButtonSize);
		SkipButtonHandler sbh = new SkipButtonHandler(_play, m);
		skip.addActionListener(sbh);
	}
	
	public JButton getButton(){
		return skip;
	}
		
}