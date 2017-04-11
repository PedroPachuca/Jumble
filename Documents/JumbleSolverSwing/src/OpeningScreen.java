import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class OpeningScreen extends JPanel {

	Image img;
	public OpeningScreen() {
		this.setPreferredSize(new Dimension(800,600));
		this.setBackground(Color.orange);
		openImage();
	}
	private void openImage() {
		URL url = this.getClass().getResource("images/jumble1.jpg");
		img = new ImageIcon(url).getImage();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double scl = 1.0;// assume 100% size of the image to display
		int w = img.getWidth(this),h = img.getHeight(this),
			desiredW = 8* this.getWidth()/10, desiredH = 8* this.getHeight()/10;
		
		if(w > desiredW) {
			scl = desiredW;
			scl/=w;
		}
		// we know the pic will be narrow enough 
		// now check to see if too high, still, after scaling
		if(h*scl > desiredH) {
			scl = desiredH/(h*scl);
		}
		// the image should be same aspect ratio as before, and small
		// enough to be on the screen
		
		g.drawImage(img, this.getWidth()/10, this.getHeight()/10,
				    (int)(img.getWidth(this)*scl),(int)(img.getHeight(this)*scl),null );
		
	}
}
