package data;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;;

import com.sun.javafx.geom.Shape;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "";
		double num = 3;
		double delta = 0.01;
		for(int i = 0; num <= 4.2; i++) {
			
			text = Double.toString(num);
			System.out.println(text);
			writeImageFromText(text, text);
			num += delta;
			num = Math.ceil(num * 100) / 100;
		}
		
	}
	
	private static void writeImageFromText(String text, String fileName) {
        /*
        Because font metrics is based on a graphics context, we need to create
        a small, temporary image so we can ascertain the width and height
        of the final image
      */
     BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
     Graphics2D g2d = img.createGraphics();
     Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 50);
     g2d.setFont(font);
     FontMetrics fm = g2d.getFontMetrics();
     int width = fm.stringWidth(text);
     int height = fm.getHeight();
     g2d.dispose();

     img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
     g2d = img.createGraphics();
     g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
     g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
     g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
     g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
     g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
     g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
     g2d.setFont(font);
     fm = g2d.getFontMetrics();
     g2d.setColor(Color.WHITE);
     g2d.setBackground(Color.BLACK);
     g2d.drawString(text, 0, fm.getAscent());
     
     g2d.dispose();
     try {
         ImageIO.write(img, "png", new File(fileName + ".png"));
     } catch (IOException ex) {
         ex.printStackTrace();
     }
	}

}
