package gui;

import java.awt.Font;

import javax.swing.JButton;

import code.YesMagicWandHandler;

public class YesMagicWand {
	JButton magicWand;
	
	public YesMagicWand(int ButtonSize, int FontSize, Play _play, MultiLayers m){
		magicWand = new JButton();
		magicWand.setText("Use Magic Wand");
		magicWand.setFont(new Font(magicWand.getName(), Font.BOLD, FontSize));
		YesMagicWandHandler yesMWH = new YesMagicWandHandler(_play, m);
		magicWand.addActionListener(yesMWH);
	}
	
	public JButton getButton(){
		return magicWand;
	}
	

}
