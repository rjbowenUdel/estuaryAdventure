package controller;

import java.io.File;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.LandAnimal;
import models.NonLandAnimal;
import models.Player;

/*
 * This class essentially wraps the game up into a presentable/runnable product, Player model is
 * defined as well as the background. 
 */
public class GameWrapper {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Settings settings = new Settings();
		
		Player playerModel = new LandAnimal();
		
		ArrayList<Background> backgroundModels = new ArrayList<Background>();
    	File[] backgroundImageFiles = new File("./backgrounds").listFiles();
    	
    	for (int backgroundImageFileIndex = 0; backgroundImageFileIndex < backgroundImageFiles.length; backgroundImageFileIndex++) {
    		backgroundModels.add(new Background(backgroundImageFiles[backgroundImageFileIndex],
    				Settings.getBackgroundXPositionDefault(backgroundImageFileIndex),
    				Settings.getBackgroundYPositionDefault(backgroundImageFileIndex),
    				backgroundImageFileIndex));
    	}
    	
    	ArrayList<Interactable> interactableModels = new ArrayList<Interactable>();
    	for (int interactableIndex = 0; interactableIndex < 100; interactableIndex++) {
    		interactableModels.add(new Interactable());
    	}
    	
		Controller controller = new Controller(playerModel, backgroundModels, interactableModels);

		for(int i = 0; i < 1000; i++){
			try {
				controller.tick();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
