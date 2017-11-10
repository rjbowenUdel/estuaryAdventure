package controller;


import models.*;
import views.View;

import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class Controller {
	
    String birdSprite = "sprite.png";
    String fishSprite = "sprite.png";
    String crabSprite = "sprite.png";
    
    //models
    private Interactable interactables[];
    private ArrayList<Arena> backgrounds;
    Player playerModel;
    
    //view
    private View view;
    
    
    public Controller(Player model, View view) {
		this.playerModel = model;
		this.view = view;
	}
    
    public void update(){
    	updateModel();
    	updateView();
    }
	
	public void updateModel() {
		
	}
	
	public void updateView(){
		view.updatePlayer(playerModel.getXPosition(), playerModel.getYPosition());
		view.updateBackgrounds();
	}
    
	
}
