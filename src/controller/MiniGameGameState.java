package controller;

import quizMiniGame.MiniGame;
import quizMiniGame.MiniGameGameStatePanel;

public class MiniGameGameState {

	public Controller controller;
	public MiniGame miniGame;
	public MiniGameGameStatePanel miniGameGameStatePanel;

	private int tickNumber = 0;

	public MiniGameGameState(Controller controller) {
		this.controller = controller;
		this.miniGame = new MiniGame();
		this.miniGameGameStatePanel = new MiniGameGameStatePanel(this.miniGame, controller);
	}

	public void onTick() {
		this.miniGame.onTick();

		if (this.miniGame.isActive) {
		}

		else {
			controller.changeGameStateFromMiniGameToActive(miniGame.correctAnswerCount);
		}
		this.tickNumber++;
	}

	public void setMiniGameCurrentPlayerAnswer(String currentPlayerAnswer) {
		this.miniGame.setCurrentPlayerAnswer(currentPlayerAnswer);
	}
}
