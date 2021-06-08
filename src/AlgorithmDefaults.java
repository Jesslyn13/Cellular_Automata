import java.util.Map;

public interface AlgorithmDefaults {

	//Automaton Choice-----------------------------------------------------------------------------------------------------


	//Game of Life ------------------------------------------------------------------------------------------------------

	int GAME_OF_LIFE= 0;
	int MAXIMUM_CELL_INDEX_GAME_OF_LIFE = 1;
	int DEFAULT_THEME_INDEX_GAME_OF_LIFE = 0;
	double[] LIVE_CELL_CHANCES_CONWAY = {0.1, 0.9};

	AlgorithmSettings GAME_OF_LIFE_SETTINGS = new AlgorithmSettings(1,0, new double[]{0.1, 0.9});

	//Seeds ------------------------------------------------------------------------------------------------------

	int SEEDS = 1;
	int MAXIMUM_CELL_INDEX_SEEDS = MAXIMUM_CELL_INDEX_GAME_OF_LIFE;
	int DEFAULT_THEME_INDEX_SEEDS = DEFAULT_THEME_INDEX_GAME_OF_LIFE;
	double[] LIVE_CELL_CHANCES_SEEDS = {0.5, 0.5};

	AlgorithmSettings SEEDS_SETTINGS = new AlgorithmSettings(1,0, new double[]{0.5, 0.5});

	//Brian's Brain ------------------------------------------------------------------------------------------------------

	int BRIANS_BRAIN = 2;
	int MAXIMUM_CELL_INDEX_BRIANS_BRAIN = 2;
	int DEFAULT_THEME_INDEX_BRIANS_BRAIN = 1;
	double[] LIVE_CELL_CHANCES_BRIANS_BRAIN = {0.5, 0.5};

	AlgorithmSettings BRIANS_BRAIN_SETTINGS = new AlgorithmSettings(1,0, new double[]{0.1, 0.9});

	//Langton's Ant ------------------------------------------------------------------------------------------------------

	int LANGTONS_ANT = 3;
	int MAXIMUM_CELL_INDEX_LANGTONS_ANT = 1;
	int DEFAULT_THEME_INDEX_LANGTONS_ANT = 2;
	double[] LIVE_CELL_CHANCES_LANGTONS_ANT = {0.2, 0.8};

	AlgorithmSettings LANGTONS_ANT_SETTINGS = new AlgorithmSettings(1,0, new double[]{0.1, 0.9});

	//Flood ------------------------------------------------------------------------------------------------------

	int FLOOD = 4;
	int MAXIMUM_CELL_INDEX_FLOOD = 2;
	int DEFAULT_THEME_INDEX_FLOOD = 3;
	double[] LIVE_CELL_CHANCES_FLOOD = {0.3, 0.7};

	AlgorithmSettings FLOOD_SETTINGS = new AlgorithmSettings(1,0, new double[]{0.1, 0.9});

	Map<Integer,AlgorithmSettings> AlgorithmList = Map.of(
			GAME_OF_LIFE, GAME_OF_LIFE_SETTINGS
			, SEEDS, SEEDS_SETTINGS
			, BRIANS_BRAIN, BRIANS_BRAIN_SETTINGS
			, LANGTONS_ANT, LANGTONS_ANT_SETTINGS
			, FLOOD, FLOOD_SETTINGS
	);

	int AUTOMATON_CHOICE = BRIANS_BRAIN;



}
