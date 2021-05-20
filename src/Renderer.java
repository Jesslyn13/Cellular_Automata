import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Renderer extends JPanel implements Constants {
	private Color[] theme;
	private boolean hideGraphics = false;
	private RenderingHints qualityHints;

	public Renderer(Color[] theme) {
		this.theme=theme;
		qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	}

	public void paint(Graphics ga) {
		Graphics2D g = (Graphics2D) ga;
		g.setRenderingHints(qualityHints);
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, FRAME.getWidth(), FRAME.getHeight());

		if(!hideGraphics) {
			for (int y = 0; y < GAME_LOGIC.getHeight(); y++) {
				for (int x = 0; x < GAME_LOGIC.getWidth(); x++) {
					int currentCellState = GAME_LOGIC.getMatrix()[x][y];
					if (currentCellState != 0) {
						g.setColor(theme[currentCellState]);
						g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
					}
				}
			}
			//drawing the ant
			if (AUTOMATON_CHOICE == LANGTONS_ANT) {
				for (Ant a : ANTS) {
					g.setColor(theme[ANT_COLOR_INDEX]);
					g.fillRect(a.getX() * CELL_SIZE, a.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
				}
			}


			//drawing the pause button
			if (GAME_STATUS.isPaused()) {
				g.setColor(Color.BLUE.darker());
				g.fillRect(FRAME.getWidth() - 40, 20, 10, 30);
				g.fillRect(FRAME.getWidth() - 55, 20, 10, 30);
			}

			//drawing the speed indicator
			if (GAME_STATUS.getTimeSinceLastSpeedChange() < MULTIPLIER_FADE_DELAY) {
				g.setColor(Color.BLUE.darker());
				g.setFont(new Font("Arial", Font.BOLD, 20));
				double multiplier = SPEED_MULTIPLIERS[GAME_STATUS.getSpeedMultiplierIndex()];
				if (multiplier % 1 == 0.0) {
					g.drawString((int) multiplier + "x", 20, 40);
				}
				else {
					g.drawString(multiplier + "x", 20, 40);
				}

			}
		}
		else {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Display disabled.", GAME_LOGIC.getWidth()/2, GAME_LOGIC.getHeight()/2);
		}
	}


	public void toggleHideGraphics() {
		hideGraphics=!hideGraphics;
	}

	public void takeScreenshot() {
		BufferedImage img = new BufferedImage(FRAME.getContentPane().getWidth(), FRAME.getContentPane().getHeight(), BufferedImage.TYPE_INT_RGB);
		FRAME.paint(img.getGraphics());
		File outputFile = new File("saved.png");
		try {
			ImageIO.write(img, "png", outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setTheme(Color[] theme) {
		this.theme=theme;
	}

}