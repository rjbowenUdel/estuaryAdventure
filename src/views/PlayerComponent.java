package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Settings;
import models.Player;

class PlayerComponent extends JComponent{
	
	Player playerModel;
	BufferedImage playerImage;
	
	PlayerComponent(Player playerModel){
		
		this.playerModel = playerModel;
		this.setBounds(0,0,Integer.parseInt(Settings.globalSettings.getProperty("mainFrameDimension")),Integer.parseInt(Settings.globalSettings.getProperty("mainFrameDimension")));
		
		try {
			File imageFile = new File(playerModel.getSpriteFile());
			if(imageFile.exists() == true){
				playerImage = ImageIO.read(imageFile);
			}
		}			
		catch (IOException e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(playerImage, playerModel.getXPosition(), playerModel.getYPosition(), null);
	}
}
