import java.awt.*;

public class GameStatus implements Constants {
	private boolean isPaused = true;
	private int currentThemeIndex = 0;
	private int brushIndex = 1;

	public int speedMultiplierIndex = SPEED_DEFAULT_INDEX;
	private long lastSpeedChangeTime = MULTIPLIER_FADE_DELAY;
	private long lastBrushChangeTime = BRUSH_FADE_DELAY;

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	private int mouseX;
	private int mouseY;

	public long getTimeSinceLastSpeedChange() {
		return System.currentTimeMillis() - lastSpeedChangeTime;
	}

	public long getTimeSinceLastBrushChange() {
		return System.currentTimeMillis() - lastBrushChangeTime;
	}

	public void scrollBrushIndex(int direction) {
		lastBrushChangeTime = System.currentTimeMillis();
		int newBrushIndex = brushIndex;
		newBrushIndex -= direction;
		newBrushIndex = Math.min(newBrushIndex, BRUSH_COUNT - 1);
		newBrushIndex = Math.max(newBrushIndex, 1);

		brushIndex = newBrushIndex;
	}

	public void changeSpeedIndex(int direction) {
		lastSpeedChangeTime = System.currentTimeMillis();

		int newSpeedMultiplierIndex = speedMultiplierIndex;
		newSpeedMultiplierIndex -= direction;
		newSpeedMultiplierIndex = Math.min(newSpeedMultiplierIndex, SPEED_MULTIPLIERS.length - 1);
		newSpeedMultiplierIndex = Math.max(newSpeedMultiplierIndex, 0);

		speedMultiplierIndex = newSpeedMultiplierIndex;
	}


	public void updateMousePosition(int xCoordinate, int yCoordinate) {
		updateMousePos(xCoordinate, yCoordinate);
	}

	public void updateMousePos(int xCoordinate, int yCoordinate) {
		Insets insets = FRAME.getInsets();
		xCoordinate -= (insets.left);
		yCoordinate -= (insets.top);

		xCoordinate /= CELL_SIZE;
		yCoordinate /= CELL_SIZE;

		mouseX = xCoordinate;
		mouseY = yCoordinate;
	}

	public void cycleTheme() {
		if (currentThemeIndex != THEME_LIST.length - 1) {
			currentThemeIndex++;
		}
		else {
			currentThemeIndex = 0;
		}
	}

	//------------------------------------------------------------------------------------------
	//Mostly simple getters and setters go here :)

	public void setBrushIndex(int brushIndex) {
		this.brushIndex = brushIndex;
	}

	public int getBrushIndex() {
		return brushIndex;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public int getCurrentThemeIndex() {
		return currentThemeIndex;
	}

	public void setPaused(boolean paused) {
		isPaused = paused;
	}

	public int getSpeedMultiplierIndex() {
		return speedMultiplierIndex;
	}

}
