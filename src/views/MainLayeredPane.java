package views;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import models.Background;
import models.Player;

public class MainLayeredPane extends JLayeredPane {
	
	PlayerComponent playerComponent;
	BackgroundLayeredPane backgroundLayeredPane;
	
	public MainLayeredPane(Player playerModel, ArrayList<Background> backgroundModels) {
		
		backgroundLayeredPane = new BackgroundLayeredPane(backgroundModels);
		playerComponent = new PlayerComponent(playerModel);
		this.add(backgroundLayeredPane, new Integer(0));
		this.add(playerComponent, new Integer(1));
	}
	
	@Override
	public void paint(Graphics g) {
		playerComponent.paint(g);
		backgroundLayeredPane.paint(g);
	}
	
}