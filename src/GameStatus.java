import java.awt.*;

public class GameStatus implements Constants{
	public boolean isPaused=true;
	public boolean mouseClicked=false;

	public int speedMultiplierIndex = SPEED_DEFAULT_INDEX;
	private long lastSpeedChangeTime = MULTIPLIER_FADE_DELAY;

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	private int mouseX;
	private int mouseY;

	public long getTimeSinceLastSpeedChange() {
		return  System.currentTimeMillis()-lastSpeedChangeTime;
	}

	public void scroll(int direction) {
		lastSpeedChangeTime = System.currentTimeMillis();
		speedMultiplierIndex -= direction;

		speedMultiplierIndex = Math.min(speedMultiplierIndex,SPEED_MULTIPLIERS.length-1);
		speedMultiplierIndex = Math.max(speedMultiplierIndex,0);
	}

	public void setMouseClicked(boolean mouseClicked,int xCoordinate, int yCoordinate, boolean updateMousePosition) {
		this.mouseClicked = mouseClicked;
		if(updateMousePosition) {
			updateMousePos(xCoordinate,yCoordinate);
		}
	}

	public void updateMousePos(int xCoordinate, int yCoordinate) {
		Insets insets = FRAME.getInsets();
		xCoordinate-=(insets.left);
		yCoordinate-=(insets.top);

		xCoordinate/=CELL_SIZE;
		yCoordinate/=CELL_SIZE;

		mouseX=xCoordinate;
		mouseY=yCoordinate;
	}

	//------------------------------------------------------------------------------------------
    //Mostly simple getters and setters go here :)

	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean paused) {
		isPaused = paused;
	}

	public int getSpeedMultiplierIndex() {
		return speedMultiplierIndex;
	}

}
