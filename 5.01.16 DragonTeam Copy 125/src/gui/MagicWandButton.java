package gui;

import java.awt.Font;

import javax.swing.JButton;

import code.Board;
import code.SkipButtonHandler;
import code.UseMagicHandler;

public class MagicWandButton {
	JButton magicWand;
	Board board;
	
	public MagicWandButton(int ButtonSize, int FontSize, Play _play, MultiLayers m, Board b){
		magicWand = new JButton();
		magicWand.setText("Use Magic Wand");
		magicWand.setFont(new Font(magicWand.getName(), Font.BOLD, FontSize));
		magicWand.setBounds(11*ButtonSize, 7*ButtonSize, 3*ButtonSize, ButtonSize);
		UseMagicHandler mwh = new UseMagicHandler(_play, m, b);
		magicWand.addActionListener(mwh);
	}
	
	public JButton getButton(){
		return magicWand;
	}

}
