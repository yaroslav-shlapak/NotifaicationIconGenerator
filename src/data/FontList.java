package data;

/*
 * Copyright (c) 2000 David Flanagan.  All rights reserved.
 * This code is from the book Java Examples in a Nutshell, 2nd Edition.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
 * For a commercial use license, or to purchase the book (recommended),
 * visit http://www.davidflanagan.com/javaexamples2.
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GraphicsEnvironment;

/**
 * An applet that displays the standard fonts and styles available in Java 1.1
 */
public class FontList extends JScrollPane {
	// The available font families
	String[] families = { "Serif", // "TimesRoman" in Java 1.0
			"SansSerif", // "Helvetica" in Java 1.0
			"Monospaced" }; // "Courier" in Java 1.0

	// The available font styles and names for each one
	int[] styles = { Font.PLAIN, Font.ITALIC, Font.BOLD,
			Font.ITALIC + Font.BOLD };

	String[] stylenames = { "Plain", "Italic", "Bold", "Bold Italic" };

	// Draw the applet.
	public void paint(Graphics g) {
		/*
		 * for (int f = 0; f < families.length; f++) { // for each family for
		 * (int s = 0; s < styles.length; s++) { // for each style Font font =
		 * new Font(families[f], styles[s], 18); // create font g.setFont(font);
		 * // set font String name = families[f] + " " + stylenames[s]; //
		 * create name g.drawString(name, 20, (f * 4 + s + 1) * 20); // display
		 * name } }
		 */

		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();

		for (int i = 0; i < fonts.length; i++) {
			//this.setPreferredSize(new Dimension(10, 1));
			Font font = new Font(fonts[i], Font.PLAIN, 15); // create font
			g.setFont(font); // set font
			String name = fonts[i]; // create name
			int len = name.length() > 20 ? 20 : name.length();
			g.drawString("9.0.123456789 " + name.substring(0, len), 17 + i % 6 * 300,  17 + i / 6 * 17); // display name
			System.out.println(fonts[i]);
					//	Needed for the scroll bars to appear

			//this.revalidate();			//	Needed to recalc the scroll bars
			//this.repaint();			//	Needed to show the correct content
		}
	}

}
