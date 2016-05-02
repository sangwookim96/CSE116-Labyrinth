package gui;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import code.Board;

public class GameBoard {
	
	ImageIcon _tile1rotate0size1 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate0Size1.png"));
	ImageIcon _tile1rotate1size1 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate1Size1.png"));
	ImageIcon _tile1rotate2size1 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate2Size1.png"));
	ImageIcon _tile1rotate3size1 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate3Size1.png"));
	ImageIcon _tile2rotate0size1 = new ImageIcon(getClass().getResource("/Images/Tile2/Tile2Rotate0Size1.png"));
	ImageIcon _tile2rotate1size1 = new ImageIcon(getClass().getResource("/Images/Tile2/Tile2Rotate1Size1.png"));
	ImageIcon _tile3rotate0size1 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate0Size1.png"));
	ImageIcon _tile3rotate1size1 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate1Size1.png"));
	ImageIcon _tile3rotate2size1 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate2Size1.png"));
	ImageIcon _tile3rotate3size1 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate3Size1.png"));
	
	ImageIcon _tile1rotate0size2 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate0.png"));
	ImageIcon _tile1rotate1size2 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate1.png"));
	ImageIcon _tile1rotate2size2 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate2.png"));
	ImageIcon _tile1rotate3size2 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate3.png"));
	ImageIcon _tile2rotate0size2 = new ImageIcon(getClass().getResource("/Images/Tile2/Tile2Rotate0.png"));
	ImageIcon _tile2rotate1size2 = new ImageIcon(getClass().getResource("/Images/Tile2/Tile2Rotate1.png"));
	ImageIcon _tile3rotate0size2 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate0.png"));
	ImageIcon _tile3rotate1size2 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate1.png"));
	ImageIcon _tile3rotate2size2 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate2.png"));
	ImageIcon _tile3rotate3size2 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate3.png"));
	
	ImageIcon _tile1rotate0size3 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate0Size3.png"));
	ImageIcon _tile1rotate1size3 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate1Size3.png"));
	ImageIcon _tile1rotate2size3 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate2Size3.png"));
	ImageIcon _tile1rotate3size3 = new ImageIcon(getClass().getResource("/Images/Tile1/Tile1Rotate3Size3.png"));
	ImageIcon _tile2rotate0size3 = new ImageIcon(getClass().getResource("/Images/Tile2/Tile2Rotate0Size3.png"));
	ImageIcon _tile2rotate1size3 = new ImageIcon(getClass().getResource("/Images/Tile2/Tile2Rotate1Size3.png"));
	ImageIcon _tile3rotate0size3 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate0Size3.png"));
	ImageIcon _tile3rotate1size3 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate1Size3.png"));
	ImageIcon _tile3rotate2size3 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate2Size3.png"));
	ImageIcon _tile3rotate3size3 = new ImageIcon(getClass().getResource("/Images/Tile3/Tile3Rotate3Size3.png"));


	JButton boardTile;
	boolean[] curTile;
	
	//MultiLayers _ml;
	int bs;

	public GameBoard(Board _board, int size, int ButtonSize, int i, int j){
		boardTile = new JButton(Integer.toString(_board.get_StateOfBoard()[i][j].type()));
		boardTile.setBounds((j+2)*ButtonSize, (i+2)*ButtonSize, ButtonSize, ButtonSize);
		curTile = _board.get_StateOfBoard()[i][j].curOpen();
		bs = ButtonSize;
		updateImageSize(size);

	}
	
	public JButton getButton(){
		return boardTile;
	}
	
	public void updateImageSize(int size){
		if(size == 1){
			int state = 0;
			switch(state){
			case 0:
				boolean[] tile1rotate0size1 = new boolean[]{true, true, false, false};
				int counter0=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate0size1[k]){
						counter0++;
						if(counter0==4){
							boardTile.setIcon(_tile1rotate0size1);
							break;
						}
					}
				}
			
			case 1:
				boolean[] tile1rotate1size1 = new boolean[]{false, true, true, false};
				int counter1=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate1size1[k]){
						counter1++;
						if(counter1==4){
							boardTile.setIcon(_tile1rotate1size1);
							break;
						}
					}
				}
			
			case 2:
				boolean[] tile1rotate2size1 = new boolean[]{false, false, true, true};
				int counter2=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate2size1[k]){
						counter2++;
						if(counter2==4){
							boardTile.setIcon(_tile1rotate2size1);
							break;
					}
				}
			}

			
			case 3:
				boolean[] tile1rotate3size1 = new boolean[]{true, false, false, true};
				int counter3=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate3size1[k]){
						counter3++;
						if(counter3==4){
							boardTile.setIcon(_tile1rotate3size1);
							break;
						}
					}
				}
				
			case 4:
				boolean[] tile2rotate0size1 = new boolean[]{true, false, true, false};
				int counter4=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile2rotate0size1[k]){
						counter4++;
						if(counter4==4){
							boardTile.setIcon(_tile2rotate0size1);
							break;
						}
					}
				}
				
			case 5:
				boolean[] tile2rotate1size1 = new boolean[]{false, true, false, true};
				int counter5=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile2rotate1size1[k]){
						counter5++;
						if(counter5==4){
							boardTile.setIcon(_tile2rotate1size1);
							break;
						}
					}
				}
						
			case 6:
				boolean[] tile3rotate0size1 = new boolean[]{true, true, false, true};
				int counter6=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate0size1[k]){
						counter6++;
						if(counter6==4){
							boardTile.setIcon(_tile3rotate0size1);
							break;
						}
					}
				}
				
			case 7:
				boolean[] tile3rotate1size1 = new boolean[]{true, true, true, false};
				int counter7=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate1size1[k]){
						counter7++;
						if(counter7==4){
							boardTile.setIcon(_tile3rotate1size1);
							break;
						}
					}
				}
				
			case 8:
				boolean[] tile3rotate2size1 = new boolean[]{false, true, true, true};
				int counter8=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate2size1[k]){
						counter8++;
						if(counter8==4){
							boardTile.setIcon(_tile3rotate2size1);
							break;
						}
					}
				}
				
			case 9:
				boolean[] tile3rotate3size1 = new boolean[]{true, false, true, true};
				int counter9=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate3size1[k]){
						counter9++;
						if(counter9==4){
							boardTile.setIcon(_tile3rotate3size1);
							break;
						}
					}
				}
			}
		}
		
		else if(size == 2){
			int state = 0;
			switch(state){
			case 0:
				boolean[] tile1rotate0size2 = new boolean[]{true, true, false, false};
				int counter0=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate0size2[k]){
						counter0++;
						if(counter0==4){
							boardTile.setIcon(_tile1rotate0size2);
							break;
						}
					}
				}
			
			case 1:
				boolean[] tile1rotate1size2 = new boolean[]{false, true, true, false};
				int counter1=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate1size2[k]){
						counter1++;
						if(counter1==4){
							boardTile.setIcon(_tile1rotate1size2);
							break;
						}
					}
				}
			
			case 2:
				boolean[] tile1rotate2size2 = new boolean[]{false, false, true, true};
				int counter2=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate2size2[k]){
						counter2++;
						if(counter2==4){
							boardTile.setIcon(_tile1rotate2size2);
							break;
					}
				}
			}

			
			case 3:
				boolean[] tile1rotate3size2 = new boolean[]{true, false, false, true};
				int counter3=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate3size2[k]){
						counter3++;
						if(counter3==4){
							boardTile.setIcon(_tile1rotate3size2);
							break;
						}
					}
				}
				
			case 4:
				boolean[] tile2rotate0size2 = new boolean[]{true, false, true, false};
				int counter4=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile2rotate0size2[k]){
						counter4++;
						if(counter4==4){
							boardTile.setIcon(_tile2rotate0size2);
							break;
						}
					}
				}
				
			case 5:
				boolean[] tile2rotate1size2 = new boolean[]{false, true, false, true};
				int counter5=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile2rotate1size2[k]){
						counter5++;
						if(counter5==4){
							boardTile.setIcon(_tile2rotate1size2);
							break;
						}
					}
				}
						
			case 6:
				boolean[] tile3rotate0size2 = new boolean[]{true, true, false, true};
				int counter6=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate0size2[k]){
						counter6++;
						if(counter6==4){
							boardTile.setIcon(_tile3rotate0size2);
							break;
						}
					}
				}
				
			case 7:
				boolean[] tile3rotate1size2 = new boolean[]{true, true, true, false};
				int counter7=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate1size2[k]){
						counter7++;
						if(counter7==4){
							boardTile.setIcon(_tile3rotate1size2);
							break;
						}
					}
				}
				
			case 8:
				boolean[] tile3rotate2size2 = new boolean[]{false, true, true, true};
				int counter8=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate2size2[k]){
						counter8++;
						if(counter8==4){
							boardTile.setIcon(_tile3rotate2size2);
							break;
						}
					}
				}
				
			case 9:
				boolean[] tile3rotate3size2 = new boolean[]{true, false, true, true};
				int counter9=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate3size2[k]){
						counter9++;
						if(counter9==4){
							boardTile.setIcon(_tile3rotate3size2);
							break;
						}
					}
				}
			}	
		}
		
		else if(size == 3){
			int state = 0;
			switch(state){
			case 0:
				boolean[] tile1rotate0size3 = new boolean[]{true, true, false, false};
				int counter0=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate0size3[k]){
						counter0++;
						if(counter0==4){
							boardTile.setIcon(_tile1rotate0size3);
							break;
						}
					}
				}
			
			case 1:
				boolean[] tile1rotate1size3 = new boolean[]{false, true, true, false};
				int counter1=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate1size3[k]){
						counter1++;
						if(counter1==4){
							boardTile.setIcon(_tile1rotate1size3);
							break;
						}
					}
				}
			
			case 2:
				boolean[] tile1rotate2size3 = new boolean[]{false, false, true, true};
				int counter2=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate2size3[k]){
						counter2++;
						if(counter2==4){
							boardTile.setIcon(_tile1rotate2size3);
							break;
					}
				}
			}

			
			case 3:
				boolean[] tile1rotate3size3 = new boolean[]{true, false, false, true};
				int counter3=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile1rotate3size3[k]){
						counter3++;
						if(counter3==4){
							boardTile.setIcon(_tile1rotate3size3);
							break;
						}
					}
				}
				
			case 4:
				boolean[] tile2rotate0size3 = new boolean[]{true, false, true, false};
				int counter4=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile2rotate0size3[k]){
						counter4++;
						if(counter4==4){
							boardTile.setIcon(_tile2rotate0size3);
							break;
						}
					}
				}
				
			case 5:
				boolean[] tile2rotate1size3 = new boolean[]{false, true, false, true};
				int counter5=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile2rotate1size3[k]){
						counter5++;
						if(counter5==4){
							boardTile.setIcon(_tile2rotate1size3);
							break;
						}
					}
				}
						
			case 6:
				boolean[] tile3rotate0size3 = new boolean[]{true, true, false, true};
				int counter6=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate0size3[k]){
						counter6++;
						if(counter6==4){
							boardTile.setIcon(_tile3rotate0size3);
							break;
						}
					}
				}
				
			case 7:
				boolean[] tile3rotate1size3 = new boolean[]{true, true, true, false};
				int counter7=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate1size3[k]){
						counter7++;
						if(counter7==4){
							boardTile.setIcon(_tile3rotate1size3);
							break;
						}
					}
				}
				
			case 8:
				boolean[] tile3rotate2size3 = new boolean[]{false, true, true, true};
				int counter8=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate2size3[k]){
						counter8++;
						if(counter8==4){
							boardTile.setIcon(_tile3rotate2size3);
							break;
						}
					}
				}
				
			case 9:
				boolean[] tile3rotate3size3 = new boolean[]{true, false, true, true};
				int counter9=0;
				for(int k=0; k<4; k++){
					if(curTile[k]==tile3rotate3size3[k]){
						counter9++;
						if(counter9==4){
							boardTile.setIcon(_tile3rotate3size3);
							break;
						}
					}
				}
			}
		}	
	}
}
