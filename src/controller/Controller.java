package controller;


import java.awt.event.MouseEvent;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import views.GameOverView;
import views.View;

public class Controller {
	
    private ArrayList<Background> backgroundModels;
    private Player playerModel;
    private ArrayList<Interactable> interactableModels;
    
    private GameState gameState;
    
    private View view;
    private GameOverView gameOverView;
    
    public Controller(Player playerModel, ArrayList<Background> backgroundModels, ArrayList<Interactable> interactableModels) {
		this.playerModel = playerModel;
		this.backgroundModels = backgroundModels;
		this.interactableModels = interactableModels;
		this.view = new View(playerModel, backgroundModels, this, interactableModels);
		this.gameOverView = new GameOverView();
		
		this.gameState = GameState.Active;
	}
    
    public void onPlayerComponentMouseReleased(MouseEvent mouseEvent) {
    	playerModel.onMouseReleased(mouseEvent);
    }
    
    public void tick(int tickNumber){
    	if (gameState.equals(GameState.Active)) {
    		GameStateActiveTick(tickNumber);
    	}
    	
    	else { //gameOver
    		GameStateGameOverTick();
    	}
    	
    }
    
    private void checkGameState() {
    	if (playerModel.getHealth() <= 0) {
    		view.setVisible(false);
    		gameOverView.setVisible(true);
    		this.gameState = GameState.GameOver;
    	}
    }
    
    private void GameStateGameOverTick() {
    	gameOverView.repaint();
    }
    
    private void GameStateActiveTick(int tickNumber) {
    	tickModels(tickNumber);
    	checkGameState();
    	tickView();
    }
	
	private void tickModels(int tickNumber) {
		tickBackgroundModels();
		tickInteractableModels(tickNumber);
		tickPlayerModel();
		detectCollisions();
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
	
	private void tickBackgroundModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.onTick();
		}
	}
	
	private void tickInteractableModels(int tickNumber) {
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
	
	private void tickView(){
		view.repaint();
	}
    
	
}
