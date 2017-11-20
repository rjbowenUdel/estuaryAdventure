package models;

import java.util.Random;

import controller.Settings;

public class Interactable implements GameModel {
	private int xPosition;
	private int yPosition;
	private boolean isFood;
	private String
	
	Random random = new Random();
	
	public Interactable() {
		this.xPosition = random.nextInt(Settings.getViewDimensionDefault());
		this.yPosition = Settings.getInteractableStartYPosition();
		this.isFood = random.nextBoolean();
		
		if (isFood) {
			
		} else {

		}
		
	}
	
	public int getxPosition() {
		return xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public boolean isFood() {
		return isFood;
	}
	@Override
	public void onTick() {
		this.xPosition -= Settings.getInteractableSpeed();
	}
	
}