package controller;

import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import views.View;

public class ActiveGameState {
	
	private Controller controller;
	private Player playerModel;
	private ArrayList<Interactable> interactableModels;
	private ArrayList<Background> backgroundModels;
	private View view;
	
	private int tickNumber = 0;
	
	public ActiveGameState(Controller controller, Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels) {
		this.playerModel = playerModel;
		this.interactableModels = interactableModels;
		this.backgroundModels = backgroundModels;
		this.view = new View(playerModel, backgroundModels, this.controller, interactableModels);
	}
	
	public void onTick() {
		tickModels();
		checkGameState();
		tickView();
		this.tickNumber++;
	}
	
	private void tickModels() {
		tickBackgroundModels();
		tickInteractableModels();
		tickPlayerModel();
		detectCollisions();
	}

	private void tickBackgroundModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.onTick();
		}
	}

	private void tickInteractableModels() {
		for (Interactable interactableModel :interactableModels) {

			if (interactableModel.getActivationTick() == tickNumber) {
				interactableModel.activate();
			}

			if (interactableModel.isActive()) {
				interactableModel.onTick();				
			}
		}
	}

	private void tickPlayerModel() {
		this.playerModel.onTick();
	}

	private void detectCollisions() {
		detectPlayerInteractableCollisions();
	}

	private void detectPlayerInteractableCollisions() {
		for (Interactable interactableModel : interactableModels) {

			if (interactableModel.isActive()) {
				if (playerModel.getHitbox().isOverlapping(interactableModel.getHitbox())) {
					playerModel.onCollisionWithInteractableModel(interactableModel);
					interactableModel.onCollisionWithPlayerModel(playerModel);
				}
			}
		}
	}
	
	private void checkGameState() {
		if (playerModel.getHealth() <= 0) {
			view.setVisible(false);
			this.controller.changeGameStateFromActiveToGameOver();
		}

		if (playerModel.getScoreStreak() >= Settings.getMiniGameRequiredScoreStreak()) {
			view.setVisible(false);
			this.controller.changeGameStateFromActiveToMinigame();;
		}
	}
	
	private void tickView(){
		view.repaint();
	}
	
	public void activateThisGameState() {
		this.view.setVisible(true);
	}
	
	
}
