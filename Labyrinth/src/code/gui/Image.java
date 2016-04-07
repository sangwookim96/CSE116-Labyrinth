package code.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Image {
       private BufferedImage img;
       
       public Image(){
    	   img=ImageIO.read(new File(null));
       }
       
       public void paint(Graphics g){
    	   g.drawImage(img, 0, 0, /*observer*/null);
       }
}
