package quizMiniGame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class MiniGameGameStatePanel.
 */
public class MiniGameGameStatePanel extends JPanel implements ActionListener {

	/** The mini game. */
	MiniGame miniGame;
	
	/** The controller. */
	Controller controller;

	/** The question label. */
	JLabel questionLabel;
	
	/** The answer A button. */
	JButton answerAButton;
	
	/** The answer B button. */
	JButton answerBButton;
	
	/** The answer C button. */
	JButton answerCButton;

	/** The correct answer count label. */
	JLabel correctAnswerCountLabel;
	
	/**
	 * Instantiates a new mini game game state panel.
	 *
	 * @param miniGame the mini game
	 * @param controller the controller
	 */
	public MiniGameGameStatePanel(MiniGame miniGame, Controller controller) {
		
		this.miniGame = miniGame;
		this.controller = controller;
		
		this.questionLabel = new JLabel(miniGame.getCurrentQuestionAndAnswerPair().question);
		this.add(this.questionLabel);

		answerAButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerA);
		answerBButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerB);
		answerCButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerC);

		answerAButton.setActionCommand("answerA");
		answerAButton.addActionListener(this);

		answerBButton.setActionCommand("answerB");
		answerBButton.addActionListener(this);

		answerCButton.setActionCommand("answerC");
		answerCButton.addActionListener(this);

		this.add(answerAButton);
		this.add(answerBButton);
		this.add(answerCButton);
		
		this.correctAnswerCountLabel = new JLabel("SCORE ADDED: " + String.valueOf(miniGame.correctAnswerCount));
		this.add(this.correctAnswerCountLabel);
		
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		
		this.setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		correctAnswerCountLabel.setText("SCORE ADDED: " + String.valueOf(miniGame.correctAnswerCount));
		questionLabel.setText(miniGame.getCurrentQuestionAndAnswerPair().question);
		answerAButton.setText(miniGame.getCurrentQuestionAndAnswerPair().answerA);
		answerBButton.setText(miniGame.getCurrentQuestionAndAnswerPair().answerB);
		answerCButton.setText(miniGame.getCurrentQuestionAndAnswerPair().answerC);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("answerA")) {
			controller.miniGameGameState.setMiniGameCurrentPlayerAnswer("A");
		}

		else if (e.getActionCommand().equals("answerB")) {
			controller.miniGameGameState.setMiniGameCurrentPlayerAnswer("B");
		}

		else if (e.getActionCommand().equals("answerC")) {
			controller.miniGameGameState.setMiniGameCurrentPlayerAnswer("C");
		}
	}
}
