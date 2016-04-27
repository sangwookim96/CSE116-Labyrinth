package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import code.Board;
import code.InsertTileHandler;

public class Triangle {
	private JButton[] tri = new JButton[12];
	private ImageIcon[] triImg = new ImageIcon[4];
	
	public Triangle(Board _board, int ButtonSize, int size, Play _play, MultiLayers m){

		int[] pos1 = {0,1};
		int[] pos2 = {0,3};
		int[] pos3 = {0,5};
		int[] pos4 = {1,6};
		int[] pos5 = {3,6};
		int[] pos6 = {5,6};
		int[] pos7 = {6,1};
		int[] pos8 = {6,3};
		int[] pos9 = {6,5};
		int[] pos10 = {1,0};
		int[] pos11 = {3,0};
		int[] pos12 = {5,0};

		int[][] posArray = {pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9, pos10, pos11, pos12};
		

		triImg[0] = new ImageIcon(getClass().getResource("/Images/Triangle insertions/TriangeDown.png"));
		triImg[1] = new ImageIcon(getClass().getResource("/Images/Triangle insertions/TriangeLeft.png"));
		triImg[2] = new ImageIcon(getClass().getResource("/Images/Triangle insertions/TriangeUp.png"));
		triImg[3] = new ImageIcon(getClass().getResource("/Images/Triangle insertions/TriangeRight.png"));

	int s = 0;
	switch(size){
	case 1:
		s = 60;
		break;
	case 2:
		s = 100;
		break;
	case 3:
		s = 170;
		break;
	}
	Image[] img = new Image[4];
	Image[] newImg = new Image[4];
	for(int i=0; i<4; i++){
		img[i] = triImg[i].getImage();
		newImg[i] = img[i].getScaledInstance(triImg[i].getIconHeight()*s/170, triImg[i].getIconWidth()*s/170 , java.awt.Image.SCALE_SMOOTH);

	}

		//putting upper triangles
		for(int i=0; i<3; i++){

			tri[i] = new JButton();
			tri[i].setIcon(new ImageIcon(newImg[0]));
			tri[i].setBounds((posArray[i][1]+2)*ButtonSize, (posArray[i][0]+1)*ButtonSize, ButtonSize, ButtonSize);
			InsertTileHandler ith1 = new InsertTileHandler(_board, posArray[i].clone(), 0, _play, m);
			tri[i].addActionListener(ith1);
		}
		//putting right triangles
		for(int i=3; i<6; i++){
			tri[i] = new JButton();
			tri[i].setIcon(new ImageIcon(newImg[1]));
			tri[i].setBounds((posArray[i][1]+3)*ButtonSize, (posArray[i][0]+2)*ButtonSize, ButtonSize, ButtonSize);
			InsertTileHandler ith1 = new InsertTileHandler(_board, posArray[i].clone(), 0, _play, m);
			tri[i].addActionListener(ith1);
		}
		//putting down triangles
		for(int i=6; i<9; i++){
			tri[i] = new JButton();
			tri[i].setIcon(new ImageIcon(newImg[2]));
			tri[i].setBounds((posArray[i][1]+2)*ButtonSize, (posArray[i][0]+3)*ButtonSize, ButtonSize, ButtonSize);
			InsertTileHandler ith1 = new InsertTileHandler(_board, posArray[i].clone(), 0, _play, m);
			tri[i].addActionListener(ith1);
			
			
		}
		//putting left triangles
		for(int i=9; i<12; i++){
			tri[i] = new JButton();
			tri[i].setIcon(new ImageIcon(newImg[3]));
			tri[i].setBounds((posArray[i][1]+1)*ButtonSize, (posArray[i][0]+2)*ButtonSize, ButtonSize, ButtonSize);
			InsertTileHandler ith1 = new InsertTileHandler(_board, posArray[i].clone(), 0, _play, m);
			tri[i].addActionListener(ith1);
		}
	}
	
	public JButton[] getTri(){
		return tri;
	}

}
