import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class Listener implements Constants, MouseListener, KeyListener, MouseMotionListener, MouseWheelListener {

	private final HashMap<Integer, Boolean> keysPressed = new HashMap<>();

	public boolean keyPressed(int keyValue) {
		return keysPressed.get(keyValue) != null && keysPressed.get(keyValue);
	}

	public void useBrush(MouseEvent e) {
		GAME_STATUS.updateMousePosition(e.getX(), e.getY());

		if (SwingUtilities.isRightMouseButton(e)) {
			GAME_LOGIC.eraseTile(GAME_STATUS.getMouseX(), GAME_STATUS.getMouseY());
		}
		else {
			GAME_LOGIC.paintTile(GAME_STATUS.getMouseX(), GAME_STATUS.getMouseY());
		}
	}

	public void pauseAndWaitForTenMs() {
		GAME_STATUS.setPaused(true);
		try {
			Thread.sleep(10);
		}
		catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keysPressed.put(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keysPressed.put(e.getKeyCode(), false);

		switch (e.getKeyCode()) {
			case (KeyEvent.VK_R) -> {
				pauseAndWaitForTenMs();
				GAME_LOGIC.resetMatrix();
			}
			case (KeyEvent.VK_N) -> {
				pauseAndWaitForTenMs();
				GAME_LOGIC.generateRandomMatrix();
			}
			case (KeyEvent.VK_SPACE) -> GAME_STATUS.setPaused(!GAME_STATUS.isPaused());
			case (KeyEvent.VK_S) -> RENDERER.takeScreenshot();
			case (KeyEvent.VK_D) -> RENDERER.toggleHideGraphics();
			case (KeyEvent.VK_T) -> GAME_STATUS.cycleTheme();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		useBrush(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		useBrush(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (keyPressed(KeyEvent.VK_CONTROL)) {
			GAME_STATUS.changeSpeedIndex(e.getWheelRotation());
		}
		else {
			GAME_STATUS.scrollBrushIndex(e.getWheelRotation());
		}

	}
}
