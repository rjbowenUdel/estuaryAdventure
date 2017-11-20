package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Settings;
import models.Interactable;

public class InteractableComponent extends JComponent {
	
	private ArrayList<Interactable> interactableModels;
	private BufferedImage foodSprite;
	private BufferedImage notFoodSprite;
	
	public InteractableComponent(ArrayList<Interactable> interactableModels) {
		this.interactableModels = interactableModels;
		
		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		
		try {
			File foodFile = new File("./sprites/foodSprite.jpg");
			File notFoodFile = new File("./sprites/notFoodSprite.jpg");
			
			if(foodFile.exists() == true){
				foodSprite = ImageIO.read(foodFile);
			}
			
			if(notFoodFile.exists() == true){
				notFoodSprite = ImageIO.read(notFoodFile);
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for (Interactable interactableModel : interactableModels) {
			if (interactableModel.isActive() == true) {
				
				g.fillRect(interactableModel.getXPosition() - 5, interactableModel.getYPosition(),5,5); //DEBUGGING
				
				if (interactableModel.isFood() == true) {
					g.drawImage(foodSprite, interactableModel.getXPosition(), interactableModel.getYPosition(), null);
				}
				
				else {
					g.drawImage(notFoodSprite, interactableModel.getXPosition(), interactableModel.getYPosition(), null);
				}
			}
		}
	}
}





