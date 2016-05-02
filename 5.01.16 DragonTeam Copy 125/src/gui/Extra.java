package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import code.Board;
import code.Tile;

public class Extra {
	
	protected JButton extra;
	protected ImageIcon[] tileImage = new ImageIcon[30];

	public Extra(Board _board, int ButtonSize, int size){
		Tile extraTile = _board.get_ExtraTile();
		  extra = new JButton();
		  String[] files ={
				  "/Images/Tile1/Tile1Rotate0Size1.png",
				  "/Images/Tile1/Tile1Rotate1Size1.png",
				  "/Images/Tile1/Tile1Rotate2Size1.png",
				  "/Images/Tile1/Tile1Rotate3Size1.png",
				  "/Images/Tile2/Tile2Rotate0Size1.png",
				  "/Images/Tile2/Tile2Rotate1Size1.png",
				  "/Images/Tile3/Tile3Rotate0Size1.png",
				  "/Images/Tile3/Tile3Rotate1Size1.png",
				  "/Images/Tile3/Tile3Rotate2Size1.png",
				  "/Images/Tile3/Tile3Rotate3Size1.png",
				  "/Images/Tile1/Tile1Rotate0.png",
				  "/Images/Tile1/Tile1Rotate1.png",
				  "/Images/Tile1/Tile1Rotate2.png",
				  "/Images/Tile1/Tile1Rotate3.png",
				  "/Images/Tile2/Tile2Rotate0.png",
				  "/Images/Tile2/Tile2Rotate1.png",
				  "/Images/Tile3/Tile3Rotate0.png",
				  "/Images/Tile3/Tile3Rotate1.png",
				  "/Images/Tile3/Tile3Rotate2.png",
				  "/Images/Tile3/Tile3Rotate3.png",
				  "/Images/Tile1/Tile1Rotate0Size3.png",
				  "/Images/Tile1/Tile1Rotate1Size3.png",
				  "/Images/Tile1/Tile1Rotate2Size3.png",
				  "/Images/Tile1/Tile1Rotate3Size3.png",
				  "/Images/Tile2/Tile2Rotate0Size3.png",
				  "/Images/Tile2/Tile2Rotate1Size3.png",
				  "/Images/Tile3/Tile3Rotate0Size3.png",
				  "/Images/Tile3/Tile3Rotate1Size3.png",
				  "/Images/Tile3/Tile3Rotate2Size3.png",
				  "/Images/Tile3/Tile3Rotate3Size3.png"};
		  for(int i=0; i<30; i++){
				  tileImage[i] = new ImageIcon(getClass().getResource(files[i]));
		  }
		  
		   int i = 0;
			  if(compareArrays(extraTile.curOpen(), new boolean[]{true, true, false, false}))
				  i=0;
			  else if(compareArrays(extraTile.curOpen(), new boolean[]{false, true, true, false}))
				  i=1;
			  else if(compareArrays(extraTile.curOpen(), new boolean[]{false, false, true, true}))
				  i=2;
			  else if(compareArrays(extraTile.curOpen(), new boolean[]{true, false, false, true}))
				  i=3;
			  else if(compareArrays(extraTile.curOpen(), new boolean[]{true, false, true, false}))
				  i=4;
			  else if(compareArrays(extraTile.curOpen(), new boolean[]{false, true, false, true}))
				  i=5;
			  else if(compareArrays(extraTile.curOpen(), new boolean[]{true, true, false, true}))
				  i=6;
			  else if(compareArrays(extraTile.curOpen(), new boolean[]{true, true, true, false}))
				  i=7;
			  else if(compareArrays(extraTile.curOpen(), new boolean[]{false, true, true, true}))
				  i=8;
			  else if(compareArrays(extraTile.curOpen(), new boolean[]{true, false, true, true}))
				  i=9;
			 
		  int image = (size-1)*10 + i;
			  extra.setIcon(tileImage[image]);
			  extra.setBounds(11*ButtonSize, 1*ButtonSize, ButtonSize, ButtonSize);
	}
	//compare values of two boolean arrays
	public boolean compareArrays(boolean[] array1, boolean[] array2){
		return (array1[0]==array2[0]&&array1[1]==array2[1]&&array1[2]==array2[2]&&array1[3]==array2[3]);
	}
	
	public JButton getButton(){
		return extra;
	}
}
