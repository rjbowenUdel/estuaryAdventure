package controller;

import java.io.File;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.LandAnimal;
import models.Player;


public class GameWrapper {
	
	private static Controller controller;
	
	public static void main(String[] args) {
		setUpGame();
		startGame();
	}
	
	private static void setUpGame() {
		Settings settings = new Settings();
		
		Player playerModel = new LandAnimal();
		ArrayList<Background> backgroundModels = new ArrayList<Background>(generateBackgroundModels());
		ArrayList<Interactable> interactableModels = new ArrayList<Interactable>(generateInteractableModels());
		
		controller = new Controller(playerModel, backgroundModels, interactableModels);
	}
	
	private static void startGame() {
		for(int tickNumber = 0; tickNumber < 1000; tickNumber++){
			try {
				controller.tick(tickNumber);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static ArrayList<Background> generateBackgroundModels() {
		ArrayList<Background> backgroundModels = new ArrayList<Background>();
    	File[] backgroundImageFiles = new File("./backgrounds").listFiles();
    	
    	for (int backgroundImageFileIndex = 0; backgroundImageFileIndex < backgroundImageFiles.length; backgroundImageFileIndex++) {
    		backgroundModels.add(new Background(backgroundImageFiles[backgroundImageFileIndex],
    				Settings.getBackgroundXPositionDefault(backgroundImageFileIndex),
    				Settings.getBackgroundYPositionDefault(backgroundImageFileIndex),
    				backgroundImageFileIndex));
    	}
    	
    	return backgroundModels;
	}
	
	private static ArrayList<Interactable> generateInteractableModels() {
		
		ArrayList<Interactable> interactableModels = new ArrayList<Interactable>();
		
    	for (int interactableIndex = 0; interactableIndex < 100; interactableIndex++) {
    		interactableModels.add(new Interactable(interactableIndex * 5));
    	}
    	
    	return interactableModels;
	}
	
}
