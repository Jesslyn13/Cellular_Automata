import javax.swing.*;
import java.awt.*;

public class RunTime extends Thread implements Constants {

	public static void main(String[] args) throws InterruptedException {

		Thread.sleep(500);
		FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		FRAME.addMouseListener(LISTENER);
		FRAME.addKeyListener(LISTENER);
		FRAME.addMouseMotionListener(LISTENER);
		FRAME.addMouseWheelListener(LISTENER);
		FRAME.add(RENDERER);
		FRAME.setVisible(true);

		Insets insets = FRAME.getInsets();
		FRAME.setSize(WIDTH * CELL_SIZE + insets.left + insets.right, HEIGHT * CELL_SIZE + insets.top + insets.bottom);

		while (true) {
			if (!GAME_STATUS.isPaused()) {
				GAME_LOGIC.nextStep();
			}

			long time = System.currentTimeMillis();

			while (RENDERER.displayEnabled() && System.currentTimeMillis() < time + (long) (DELAY_DEFAULT / SPEED_MULTIPLIERS[GAME_STATUS.getSpeedMultiplierIndex()])) {
				RENDERER.repaint();
			}
		}

	}
}
