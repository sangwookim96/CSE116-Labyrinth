package code.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	
	
	JButton _exButton;
	JPanel _exPanel;
	JFrame _exFrame = new JFrame();
	
	
	
	
	public Image(){
		_exButton = new JButton();
		_exPanel = new JPanel();
		_exPanel.setBackground(Color.black);
		ImageIcon img = new ImageIcon(/*image file address*/);
		_exButton.setIcon(img);
		
		
		_exFrame.setDefaultCloseOperation(0);
		_exFrame.setSize(400, 400);
		
		_exPanel.add(_exButton);
		_exFrame.add(_exPanel);
		_exFrame.validate();
		
	}
	
}
