<<<<<<< HEAD
package views;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.Controller;
import controller.Settings;
import models.*;



@SuppressWarnings("serial")
public class View extends JFrame{

	public JLayeredPane layeredPane = new JLayeredPane();
	private PlayerComponent playerComponent;
	private ArrayList<BackgroundComponent> backgroundComponents;
	private int mainFrameDimension = 0;
	
	public View(Player playerModel, ArrayList<Background> backgroundModels) { //Maybe change this so it accepts an array of models
		//setup background components
		
		this.mainFrameDimension = Integer.parseInt(Settings.globalSettings.getProperty("mainFrameDimension"));
		
		setSize(mainFrameDimension, mainFrameDimension);
		playerComponent = new PlayerComponent(playerModel);
		backgroundComponents = new ArrayList<BackgroundComponent>();
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, mainFrameDimension, mainFrameDimension);
		layeredPane.add(playerComponent, 20);

		BackgroundComponent temp = null;
		int loc = 0;
		for(Background currentModel: backgroundModels)
			temp = new BackgroundComponent(currentModel, loc);
			backgroundComponents.add(temp);
			backgroundComponents.iterator().next().setVisible(true);
			layeredPane.add(temp, loc);
			loc += 10;
	
		add(layeredPane);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void registerListenersFromController(Controller controller) {
		//frame.getContentPane().addMouseListener(controller.mouseListenerComponent);
		//frame.addMouseMotionListener(controller.mouseMotionListenerComponent);

	}
	
	public void updateBackgrounds(){
		for(BackgroundComponent currComponent: backgroundComponents){
			System.out.println(currComponent.backgroundNumber  + ": " +currComponent.xPosition);
			currComponent.updateComponent();
		}
	}
	
	public void updatePlayer(int x, int y){
		playerComponent.updateComponent(x, y);
	}

}
=======
package views;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import controller.Settings;
import models.Background;
import models.Interactable;
import models.Player;

public class View extends JFrame {

	public View(Player playerModel, ArrayList<Background> backgroundModels, Controller controller, ArrayList<Interactable> interactableModels) {

		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
>>>>>>> branch 'workBench' of https://github.com/rjbowenUdel/estuaryAdventure.git
