package data;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import java.awt.*;

public class MainFontList {

	  public static void main(String[] a) {
		  
		  
		  
	      SwingUtilities.invokeLater (new Runnable ()
	        {
	            public void run ()
	            {
	            	
	            	
	                JFrame frame = new JFrame("panel demo");
	                frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
	                frame.setSize(2000, 1100);
	                
	                JScrollPane scrPane = new FontList();
	                scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	                
	                frame.setContentPane(scrPane);
	                
	                frame.setVisible(true);
	            }
	        });
	    }

}
