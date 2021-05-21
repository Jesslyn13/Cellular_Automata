import javax.swing.*;
import java.awt.event.*;

public class Listener implements Constants, MouseListener, KeyListener, MouseMotionListener,MouseWheelListener {

	public Listener() {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case (KeyEvent.VK_SPACE) -> GAME_STATUS.setPaused(!GAME_STATUS.isPaused());
			case (KeyEvent.VK_R) -> {
				GAME_STATUS.setPaused(true);
				try {
					Thread.sleep(10);
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
				GAME_LOGIC.resetMatrix();
			}
			case (KeyEvent.VK_N) -> {
				GAME_STATUS.setPaused(true);
				try {
					Thread.sleep(10);
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
				GAME_LOGIC.generateRandomMatrix(LIVE_CELL_CHANCES);
			}
			case (KeyEvent.VK_S) -> RENDERER.takeScreenshot();
			case (KeyEvent.VK_D) -> RENDERER.toggleHideGraphics();
			case (KeyEvent.VK_T) -> GAME_STATUS.cycleTheme();
			case (KeyEvent.VK_PLUS) -> GAME_STATUS.changeSpeedIndex(-1);
			case (KeyEvent.VK_MINUS) -> GAME_STATUS.changeSpeedIndex(+1);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GAME_STATUS.updateMousePosition(e.getX(),e.getY());
		boolean isAlive = !SwingUtilities.isRightMouseButton(e);

		//GAME_LOGIC.setTile(GAME_STATUS.mouseX,GAME_STATUS.mouseY, isAlive);
		if(isAlive) {
			GAME_LOGIC.paintTile(GAME_STATUS.getMouseX(),GAME_STATUS.getMouseY());
		}
		else {
			GAME_LOGIC.eraseTile(GAME_STATUS.getMouseX(),GAME_STATUS.getMouseY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		GAME_STATUS.updateMousePosition(0,0);
		//the mouse position is not updated because it's not necessary to know the mouse position until a mouse button is pressed again

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		GAME_STATUS.updateMousePosition(e.getX(), e.getY());
		boolean isAlive = !SwingUtilities.isRightMouseButton(e);

		if (isAlive) {
			GAME_LOGIC.paintTile(GAME_STATUS.getMouseX(), GAME_STATUS.getMouseY());
		}
		else {
			GAME_LOGIC.eraseTile(GAME_STATUS.getMouseX(), GAME_STATUS.getMouseY());
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		GAME_STATUS.scrollBrushIndex((int) e.getPreciseWheelRotation());
	}
}
