package models;

import controller.Settings;

public class NonLandAnimal extends Player {

	@Override
	public void onTick() {
		this.fallDown();
	}
	
	private void fallDown() {
		this.yPosition += Settings.getNonLandAnimalFallSpeed();
	}
	
	@Override
	public void onViewClicked() {
		this.flap();
	}
	
	private void flap() {
		this.yPosition -= Settings.getNonLandAnimalFlapSpeed();
	}
	
}
