package views;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageScaler.
 */
public class ImageScaler {
	/**
	 * Instantiates a new image scaler.
	 */
	public ImageScaler() {
	}
	
	/**
	 * Scale image to input ratio.
	 *
	 * @param nonScaledImage the non scaled image
	 * @param xRatio the x ratio to scale the image to
	 * @param yRatio the y ratio to scale the image to
	 * @return the buffered image
	 */
	public BufferedImage scaleImageToInputRatio(BufferedImage nonScaledImage, double xRatio, double yRatio) {
		Image img = nonScaledImage;

        BufferedImage bi = new BufferedImage((int) (xRatio * img.getWidth(null)),
        									(int) (yRatio * img.getHeight(null)),
        									BufferedImage.TYPE_INT_ARGB);

        Graphics2D grph = (Graphics2D) bi.getGraphics();
        grph.scale(xRatio, yRatio);

        // everything drawn with grph from now on will get scaled.

        grph.drawImage(img, 0, 0, null);
        grph.dispose();

        return bi;
	}
}
