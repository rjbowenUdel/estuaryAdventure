package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Settings;
import models.Interactable;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractableComponent.
 */
public class InteractableComponent extends JComponent implements Serializable {

	/** The interactable models. */
	private ArrayList<Interactable> interactableModels;

	private transient BufferedImage foodImage;
	private transient BufferedImage notFoodImage;

	/**
	 * Instantiates a new interactable component.
	 *
	 * @param interactableModels the interactable models
	 */
	public InteractableComponent(ArrayList<Interactable> interactableModels) {
		this.interactableModels = interactableModels;
		this.setSpriteImage();
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());

		this.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		for (Interactable interactableModel : interactableModels) {
			if (interactableModel.isActive() == true) {
				
				if (interactableModel.isFood()) {
					g.drawImage(this.foodImage, interactableModel.getXPosition(), interactableModel.getYPosition(), null);
				}
				
				else {
					g.drawImage(this.notFoodImage, interactableModel.getXPosition(), interactableModel.getYPosition(), null);
				}
			}
		}
	}

	protected void setSpriteImage() {

		ImageScaler imageScaler = new ImageScaler();
		
		BufferedImage foodImage = null;
		BufferedImage notFoodImage = null;

		try {
			
			File foodFile = new File("./sprites/foodSprite.jpg");
			File notFoodFile = new File("./sprites/notFoodSprite.jpg");

			if(foodFile.exists() == true){
				foodImage = ImageIO.read(foodFile);
			}

			if(notFoodFile.exists() == true){
				notFoodImage = ImageIO.read(notFoodFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}			

		double xRatio = ((double) this.interactableModels.get(0).getWidth()) / ((double) foodImage.getWidth());
		double yRatio = ((double) this.interactableModels.get(0).getHeight()) / ((double) foodImage.getHeight());
		
		this.foodImage = imageScaler.scaleImageToInputRatio(foodImage, xRatio, yRatio);
		this.notFoodImage = imageScaler.scaleImageToInputRatio(notFoodImage, xRatio, yRatio);
		
	}
}






