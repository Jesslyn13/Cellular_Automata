public interface AlgorithmDefaults {

	//Automaton Choice-----------------------------------------------------------------------------------------------------

	int CONWAYS_GAME_OF_LIFE = 0;
	int SEEDS = 1;
	int BRIANS_BRAIN = 2;
	int LANGTONS_ANT = 3;
	int FLOOD = 4;

	int AUTOMATON_CHOICE = FLOOD;


	//Game of Life ------------------------------------------------------------------------------------------------------

	int MAXIMUM_CELL_INDEX_GAME_OF_LIFE = 1;
	int DEFAULT_THEME_INDEX_GAME_OF_LIFE = 0;
	double[] LIVE_CELL_CHANCES_CONWAY = {0.7, 0.3};


	//Seeds ------------------------------------------------------------------------------------------------------

	int MAXIMUM_CELL_INDEX_SEEDS = MAXIMUM_CELL_INDEX_GAME_OF_LIFE;
	int DEFAULT_THEME_INDEX_SEEDS = DEFAULT_THEME_INDEX_GAME_OF_LIFE;
	double[] LIVE_CELL_CHANCES_SEEDS = {0.5, 0.5};


	//Brian's Brain ------------------------------------------------------------------------------------------------------

	int MAXIMUM_CELL_INDEX_BRIANS_BRAIN = 2;
	int DEFAULT_THEME_INDEX_BRIANS_BRAIN = 1;
	double[] LIVE_CELL_CHANCES_BRIANS_BRAIN = {0.1, 0.9};


	//Langton's Ant ------------------------------------------------------------------------------------------------------

	int MAXIMUM_CELL_INDEX_LANGTONS_ANT = 1;
	int DEFAULT_THEME_INDEX_LANGTONS_ANT = 2;
	double[] LIVE_CELL_CHANCES_LANGTONS_ANT = {0.2, 0.8};

	//Flood ------------------------------------------------------------------------------------------------------

	int MAXIMUM_CELL_INDEX_FLOOD = 2;
	int DEFAULT_THEME_INDEX_FLOOD = 3;
	double[] LIVE_CELL_CHANCES_FLOOD = {0.3, 0.7};

}
