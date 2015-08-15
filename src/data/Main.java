package data;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

import com.sun.javafx.geom.Shape;

public class Main {
    private static int max = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int init = 280;
		int stop = 440;
		int step = 1;
        writeImageLoop(init,stop, step);

        step = 10;
		init = stop + step;
		stop = 1000;
        writeImageLoop(init, stop, step);

		System.out.println("end");
		
	}

    private static void writeImageLoop(int init, int stop, int step) {
        String previous;
        String name = "";
        String text = "";
        int num = init;
        for(int i = 0; num <= stop; i++) {


            previous = name;

            name = Integer.toString(num);
            if(previous.contentEquals(name)) {
                System.out.println(name + " fail!");
            }
            int len;
            if(name.substring(2, 3).contentEquals("0")) {
                len = 2;
            }
            else {
                len = 3;
            }
            text = name.substring(0, 1) + "." + name.substring(1, len);
            if(num == 1000) {
                text = "10";
            }

            writeImageFromText(text, ".\\drawable\\black" + name, Color.BLACK);
            writeImageFromText(text, ".\\drawable\\white" + name, Color.WHITE);
            num += step;
            num = Math.round(num * 100) / 100;
        }
    }
	
	private static void writeImageFromText(String text, String fileName, Color textColor) {
        /*
        Because font metrics is based on a graphics context, we need to create
        a small, temporary image so we can ascertain the width and height
        of the final image
      */
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Agency FB", Font.BOLD, 98); //Rockwell Condensed Agency FB Arial Narrow
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width;// = fm.stringWidth(text);
/*        if(max < width) {
            max = width;
            System.out.println(text);
            System.out.println(width);
        }*/
        width = 150;
        int height = 75;
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
        //fm = g2d.getFontMetrics();
        g2d.setColor(textColor);
        g2d.drawString(text, 0, height);


        g2d.dispose();
        try {
            ImageIO.write(getScaledImage(img, 75, 75), "png", new File(fileName + ".png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private static BufferedImage getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

}
