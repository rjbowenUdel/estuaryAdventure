package views;
import javax.swing.JFrame;

import controller.Controller;
import models.Player;

public class View extends JFrame {
	
	public JFrame frame = new JFrame();
	public Player playerModel;
	
	public View(Player playerModel) { //Maybe change this so it accepts an array of models
		this.playerModel = playerModel;
	}
	
	public void registerListenersFromController(Controller controller) {
		frame.getContentPane().addMouseListener(controller.mouseListenerComponent);
		frame.getContentPane().addMouseMotionListener(controller.mouseMotionListenerComponent);
		
	}
	
}
