package models;

import java.awt.event.MouseEvent;

import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class NonLandAnimal.
 */
public class NonLandAnimal extends Player {
	
	/* (non-Javadoc)
	 * @see models.Player#onTick()
	 */
	@Override
	public void onTick() {
		super.onTick();
		this.fallDown();
	}
	
	/**
	 * Fall down.
	 */
	private void fallDown() {
		int newYPosition = this.getYPosition() + Settings.getNonLandAnimalFallSpeed();
		this.setyPosition(newYPosition);
	}
	
	/* (non-Javadoc)
	 * @see models.Player#onMouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void onMouseReleased(MouseEvent mouseEvent) {
		this.flap();
	}
	
	/**
	 * Flap.
	 */
	private void flap() {
		int newYPosition = this.getYPosition() - Settings.getNonLandAnimalFlapSpeed();
		this.setyPosition(newYPosition);
	}
}