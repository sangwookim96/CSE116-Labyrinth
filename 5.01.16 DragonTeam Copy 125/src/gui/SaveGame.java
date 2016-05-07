package gui;

import java.awt.Font;

import javax.swing.JButton;

import code.Board;
import code.Driver;
import code.SaveGameHandler;
import code.SkipButtonHandler;
import code.Tile;

public class SaveGame {
JButton save;

	
	public SaveGame(int ButtonSize, int FontSize, Play _play, MultiLayers m, Driver d, 
			Board b, Tile t){
		save = new JButton();
		save.setText("Save Game");
		save.setFont(new Font(save.getName(), Font.BOLD, FontSize));
		save.setBounds(11*ButtonSize, 8*ButtonSize, 2*ButtonSize, ButtonSize);
	
		SaveGameHandler sgh = new SaveGameHandler(d, _play, m, b, t);
		save.addActionListener(sgh);
	}
	
	public JButton getButton(){
		return save;
	}

}
