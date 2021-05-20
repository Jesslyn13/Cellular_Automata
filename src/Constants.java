import javax.swing.*;
import java.awt.*;

public interface Constants {

	//-------------------------------------------------------------------------------------------------
	//Algorithm Choice:--------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------

	int CONWAYS_GAME_OF_LIFE = 0;
	int SEEDS = 1;
	int BRIANS_BRAIN = 2;
	int LANGTONS_ANT = 3;
	int FLOOD = 4;


	boolean ANT_RETURNS_HOME = true;
	int AUTOMATON_CHOICE = FLOOD;


	//Resolution and Size--------------------------------------------------------------------------------


	int CELL_SIZE = 5;
	boolean SCREEN_WRAP = true;
	boolean MIRROR_MATRIX_VERTICAL = false;
	boolean MIRROR_MATRIX_HORIZONTAL = false;

	int RESOLUTION_X = 1920;
	int RESOLUTION_Y = 1280;

	int WIDTH = RESOLUTION_X / CELL_SIZE;
	int HEIGHT = RESOLUTION_Y / CELL_SIZE;


	//Delay and speed---------------------------------------------------------------------------------------------

	int DELAY_DEFAULT = 100;
	double[] SPEED_MULTIPLIERS =
			{0.1, 0.3, 0.5, 0.75, 1.0, 1.5, 2.0, 3.0, 10.0, 20.0, 30.0, 50.0, 100.0}; //This cannot go above 100 or things will explode!
	int SPEED_DEFAULT_INDEX = 4;


	//Other--------------------------------------------------------------------------------------------------------

	double[] LIVE_CELL_CHANCE_LIST_CONWAY = {0.5, 0.5};
	double[] LIVE_CELL_CHANCE_LIST_WATER = {0.69, 0.3, 0.01};
	double[] LIVE_CELL_CHANCE_LIST_DAY_NIGHT = {0.5, 0.5};

	double[] LIVE_CELL_CHANCES = LIVE_CELL_CHANCE_LIST_WATER;

	long MULTIPLIER_FADE_DELAY = 1000; //delay in ms
	int NO_NEIGHBOUR_INDEX = -13; //entirely arbitrary

	int DEFAULT_STATE = 0;

	///Cell States and Colours--------------------------------------------------------------------------------------


	Color[] PRESET_NIGHT_BLUE = {
			Color.black,
			Color.blue,
			Color.cyan,
			Color.green,
			Color.green,
	};

	Color[] PRESET_DEFAULT_BLACK_WHITE = {
			Color.white,
			Color.black,
			Color.white.darker(),
			Color.white.darker().darker(),
			Color.blue.darker(),
	};

	Color[] ANT_IN_THE_WOODS = {
			Color.green.darker().darker().darker().darker().darker(),
			Color.orange.darker().darker(),
			Color.orange.darker().darker().darker(),
			Color.orange.darker().darker().darker().darker(),
			Color.black,
	};

	Color[] FLOODING_MAZE = {
			Color.white,
			Color.black,
			Color.blue.darker(),
	};


	Color[] CURRENT_THEME = FLOODING_MAZE;

	Color BACKGROUND_COLOR = CURRENT_THEME[0];
	int ANT_COLOR_INDEX = 4;


	//Ant--------------------------------------------------------------------------------------------------------

	int FACING_UP = 0;
	int FACING_DOWN = 1;
	int FACING_RIGHT = 2;
	int FACING_LEFT = 3;


	//Necessary Objects--------------------------------------------------------------------------------------------

	GameLogic GAME_LOGIC = new GameLogic(WIDTH, HEIGHT);


	Ant ANT1 = new Ant(FACING_UP);
	//Ant ANT2 = new Ant(FACING_DOWN);
	//Ant ANT3 = new Ant(FACING_UP);
	//Ant ANT4 = new Ant(FACING_DOWN);

	Ant[] ANTS = {ANT1};


	GameStatus GAME_STATUS = new GameStatus();
	Listener LISTENER = new Listener();
	JFrame FRAME = new JFrame();
	Renderer RENDERER = new Renderer(CURRENT_THEME);
}
