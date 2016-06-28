import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import ij.*;
import ij.process.*;
import ij.gui.*;
import ij.plugin.filter.*;
import ij.process.*;
import java.lang.Math.*;

import javax.imageio.*;
import java.applet.Applet;

public class bolt1 {
	
	private static BufferedImage img;
	private static BufferedImage biFiltered;
	private static int w,h;
	
    String title = null; 
    int sobel_x[][] = {{-1,0,1},
                       {-2,0,2},
                       {-1,0,1}};
    int sobel_y[][] = {{-1,-2,-1},
                       {0,0,0},
                       {1,2,1}};
    int pixel_x;
    int pixel_y;

    public int setup(String arg, ImagePlus im) { 
        title = im.getTitle(); 
        return DOES_8G; 
    }
	
	public static void loadimg(String imageSource){
		
		img = null;
		try {
		    img = ImageIO.read(new File( imageSource));
		} catch (IOException e) { 
			System.out.println("Image could not be read");}
	}
	
	public static void saveimg(String filename){
            w = img.getWidth(null);
            h = img.getHeight(null);
            if (img.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2 =
                    new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics big = bi2.getGraphics();
                big.drawImage(img, 0, 0, null);
                biFiltered = img = bi2;
                RenderedImage rimage = (RenderedImage)bi2;
                try {
                File outputfile = new File(filename);
                ImageIO.write(rimage, "png", outputfile);
                }catch(IOException e){
                	System.out.println("Could not save new file");
                }
        }
	}
	
	
	 
	public static void main (String[] args){
		loadimg("1.png");
		saveimg("2.png");
		System.out.println("Finish");}


}
