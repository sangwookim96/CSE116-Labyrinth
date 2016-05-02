package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import code.Board;

public class PawnLayer {
	
	JLabel pawn;

	public PawnLayer(int playerNO,Board _board, int size, int ButtonSize){
			
			int[] pos = _board.get_pawnPosition(playerNO);
			
			Color[] colors= {Color.blue, Color.orange, Color.red, Color.green};
			pawn = new JLabel();
			//pawn.setText("P"+playerNO);
			//pawn.setFont(new Font(pawn.getName(), Font.BOLD, FontSize));
			//pawn.setForeground(colors[playerNO-1]);
			ImageIcon pawnIcon[] = new ImageIcon[4];
			for(int i=0; i<4; i++){
				pawnIcon[i] = new ImageIcon(getClass().getResource("/Images/Pawns/Player"+(i+1)+"_75x75.png"));
			}
			
			
			Image img = pawnIcon[playerNO-1].getImage();
			Image newImg = img.getScaledInstance(pawnIcon[playerNO-1].getIconHeight()/ (int)Math.pow(2.2, 3-size), pawnIcon[playerNO-1].getIconWidth()/ (int)Math.pow(2.2, 3-size) , java.awt.Image.SCALE_SMOOTH);
			pawn.setIcon(new ImageIcon(newImg));
			
			int position = (int)Math.round(ButtonSize*0.1);
			switch(playerNO){
			case 1:
				pawn.setBounds((pos[1]+2)*ButtonSize+position, (pos[0]+2)*ButtonSize+position, ButtonSize/2, ButtonSize/2);
				break;
			case 2:
				pawn.setBounds((pos[1]+2)*ButtonSize+5*position, (pos[0]+2)*ButtonSize+position, ButtonSize/2, ButtonSize/2);
				break;
			case 3:
				pawn.setBounds((pos[1]+2)*ButtonSize+position, (pos[0]+2)*ButtonSize+5*position, ButtonSize/2, ButtonSize/2);
				break;
			case 4:
				pawn.setBounds((pos[1]+2)*ButtonSize+5*position, (pos[0]+2)*ButtonSize+5*position, ButtonSize/2, ButtonSize/2);
				break;
			}
			

	}
	
	public JLabel getLabel(){
		return pawn;
	}
}
