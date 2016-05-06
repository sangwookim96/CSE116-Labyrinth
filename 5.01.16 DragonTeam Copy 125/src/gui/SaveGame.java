package gui;

import java.awt.Font;

import javax.swing.JButton;

import code.SkipButtonHandler;

public class SaveGame {
JButton save;
	
	public SaveGame(int ButtonSize, int FontSize, Play _play, MultiLayers m){
		save = new JButton();
		save.setText("Save Game");
		save.setFont(new Font(save.getName(), Font.BOLD, FontSize));
		save.setBounds(11*ButtonSize, 9*ButtonSize, 2*ButtonSize, ButtonSize);
	
		//	SaveGamehandler sgh = new SaveGameHandler(_play, m);
	//	save.addActionListener(sgh);
	}
	
	public JButton getButton(){
		return save;
	}

}
