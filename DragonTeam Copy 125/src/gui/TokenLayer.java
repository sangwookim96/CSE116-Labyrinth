package gui;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import code.Board;

public class TokenLayer {

	ImageIcon tokenArray[] = new ImageIcon[21];

	int tokenNO;
	int size;
	JLabel token;
	public TokenLayer(int _tokenNO, Board _board, int ButtonSize, int _size){
		token = new JLabel();
		tokenNO = _tokenNO;
		size = _size;
		int[] pos =_board.get_tokenPosition(tokenNO);
		int position = (int)Math.round(ButtonSize*0.3);
		token.setBounds((pos[1]+2)*ButtonSize+position-6, (pos[0]+2)*ButtonSize+position-3, ButtonSize/2, ButtonSize/2);
		
		//initualizing token Image Icons
		for(int i=0; i<20; i++){
		tokenArray[i] = new ImageIcon(getClass().getResource("/Images/Tokens/Token"+ (i+1) +".png"));
		}
		tokenArray[20] = new ImageIcon(getClass().getResource("/Images/Tokens/Token25.png"));
		
		Image img = tokenArray[tokenNO-1].getImage();
		Image newImg = img.getScaledInstance(tokenArray[tokenNO-1].getIconHeight()*size, tokenArray[tokenNO-1].getIconWidth()*size , java.awt.Image.SCALE_SMOOTH);
		token.setIcon(new ImageIcon(newImg));
		
	}

	
	public JLabel getLabel(){
		return token;
	}
	
}
