import javax.swing.*;
import java.awt.*;

public interface Constants{


	boolean ANT_RETURNS_HOME = true;


	//Resolution and Size--------------------------------------------------------------------------------

	int CELL_SIZE = 1;
	boolean SCREEN_WRAP = true;
	boolean MIRROR_MATRIX_VERTICAL = true;
	boolean MIRROR_MATRIX_HORIZONTAL = true;

	int RESOLUTION_X = 1200;
	int RESOLUTION_Y = 850;

	int WIDTH = RESOLUTION_X / CELL_SIZE;
	int HEIGHT = RESOLUTION_Y / CELL_SIZE;


	//Delay and speed---------------------------------------------------------------------------------------------

	int DELAY_DEFAULT = 100;
	double[] SPEED_MULTIPLIERS =
			{0.1, 0.3, 0.5, 0.75, 1.0, 1.5, 2.0, 3.0, 10.0, 20.0, 30.0, 50.0, 100.0}; //This cannot go above 100 or things will explode!
	int SPEED_DEFAULT_INDEX = 4;


	//Other--------------------------------------------------------------------------------------------------------

	long MULTIPLIER_FADE_DELAY = 1000; //delay in ms
	long BRUSH_FADE_DELAY = 500; //delay in ms
	int NO_NEIGHBOUR_INDEX = -13; //entirely arbitrary

	int DEFAULT_STATE = 0;

	///Cell States and Colours--------------------------------------------------------------------------------------

	Color[] PRESET_DEFAULT_BLACK_WHITE = {
			Color.white,
			Color.black,
			Color.white.darker(),
			Color.white.darker().darker(),
			Color.blue.darker(),
	};

	Color[] PRESET_NIGHT_BLUE = {
			Color.black,
			Color.blue,
			Color.cyan,
			Color.green,
			Color.green,
	};

	Color[] FLOODING_MAZE = {
			Color.white.darker(),
			Color.black,
			Color.blue.darker(),
			Color.white,
			Color.black,
	};

	Color[] OKSANAS_GREEN = {
			Color.black,
			Color.green.darker(),
			Color.blue.darker(),
			Color.green,
			Color.green,
	};

	Color[][] THEME_LIST = {
			PRESET_DEFAULT_BLACK_WHITE,
			PRESET_NIGHT_BLUE,
			FLOODING_MAZE,
			OKSANAS_GREEN
	};

	int ANT_COLOR_INDEX = 4;


	//Ant--------------------------------------------------------------------------------------------------------

	int FACING_UP = 0;
	int FACING_DOWN = 1;
	int FACING_RIGHT = 2;
	int FACING_LEFT = 3;


	//Necessary Objects--------------------------------------------------------------------------------------------



	Ant ANT1 = new Ant(FACING_UP);

	Ant[] ANTS = {ANT1};


	GameStatus GAME_STATUS = new GameStatus();
	Listener LISTENER = new Listener();
	JFrame FRAME = new JFrame();
	Renderer RENDERER = new Renderer();
	GameLogic GAME_LOGIC = new GameLogic(WIDTH, HEIGHT);
}
