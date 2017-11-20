package models;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.Settings;

public abstract class Player extends GameModel {
		
	private int health;
	private int score;
	
	public Player() {
		
		this.health = 3;
		this.score = 0;
		
		this.setxPosition(Settings.getPlayerStartXPosition());
		this.setyPosition(Settings.getPlayerStartYPosition());
		this.setSpriteImage();
	}
	
	@Override
	protected void setSpriteImage() {
		BufferedImage spriteImageToUse = null;
		
		try {
			File spriteFile = new File("./sprites/sprite.jpg");
			
			if(spriteFile.exists() == true){
				spriteImageToUse = ImageIO.read(spriteFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setSpriteImage(spriteImageToUse);
	}
	
	public abstract void onMouseReleased(MouseEvent mouseEvent);
	
	public void collisionWithInteractableModel(Interactable interactableModel) {
		if (interactableModel.isFood()) {
			this.score++;
		}
		
		else {
			this.health--;
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getScore() {
		return score;
	}
}
