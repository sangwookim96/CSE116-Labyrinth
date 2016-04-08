package code.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.Tile.Tile;

public class Image {
//       private BufferedImage img;
//       
//       public Image(){
//    	   img=ImageIO.read(new File(null));
//       }
//       
//       public void paint(Graphics g){
//    	   g.drawImage(img, 0, 0, /*observer*/null);
//       }
	
	
	Tile _tile;
	JPanel _exPanel;
	JFrame _exFrame = new JFrame();
	
	
	//JButton
	
	public Image(){
		_tile = new Tile();
		_exPanel = new JPanel();
		_exPanel.setBackground(Color.black);
		ImageIcon img = new ImageIcon(/*image file address*/);
		_tile.setIcon(img);
		
		
		_exFrame.setDefaultCloseOperation(0);
		_exFrame.setSize(400, 400);
		
		
		//figure out how to add Tile class into JPanel.
		//Tile class would call image.
//		_exPanel.add(_exButton);
//		_exFrame.add(_exPanel);
//		_exFrame.validate();
		
		
		
		
	}
	
	public boolean addTileChar2Panel(Tile t){
		char charTile = t.getCharacter();
		
		
		return false;
	}
	
	
	
}
