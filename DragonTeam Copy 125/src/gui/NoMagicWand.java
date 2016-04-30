package gui;

import java.awt.Font;

import javax.swing.JButton;

import code.NoMagicWandHandler;

public class NoMagicWand {
	JButton magicWand;
	
	public NoMagicWand(int ButtonSize, int FontSize, Play _play, MultiLayers m){
		magicWand = new JButton();
		magicWand.setText("Use Magic Wand");
		magicWand.setFont(new Font(magicWand.getName(), Font.BOLD, FontSize));
		NoMagicWandHandler noMWH = new NoMagicWandHandler(_play, m);
		magicWand.addActionListener(noMWH);
	}
	
	public JButton getButton(){
		return magicWand;
	}

}
