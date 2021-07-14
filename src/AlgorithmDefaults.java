import java.util.Map;

public interface AlgorithmDefaults {

    //Automaton Choice-----------------------------------------------------------------------------------------------------

    int GAME_OF_LIFE = 0;
    int SEEDS = GAME_OF_LIFE + 1;
    int BRIANS_BRAIN = SEEDS + 1;
    int LANGTONS_ANT = BRIANS_BRAIN + 1;
    int FLOOD = LANGTONS_ANT + 1;
    int CRYSTAL = FLOOD + 1;

    //---------------------------------------------------------------------------------------------------------------------
    int AUTOMATON_CHOICE = BRIANS_BRAIN;
    //-----------------------------------------------------------------------------------------------------------------------

    //Algorithms Values ------------------------------------------------------------------------------------------------------

    AlgorithmSettings GAME_OF_LIFE_SETTINGS = new AlgorithmSettings(1, 0, new double[]{0.7, 0.3});
    AlgorithmSettings SEEDS_SETTINGS = new AlgorithmSettings(1, 0, new double[]{0.5, 0.5});
    AlgorithmSettings BRIANS_BRAIN_SETTINGS = new AlgorithmSettings(1, 1, new double[]{0.5, 0.5});
    AlgorithmSettings LANGTONS_ANT_SETTINGS = new AlgorithmSettings(1, 0, new double[]{0.5, 0.5});
    AlgorithmSettings FLOOD_SETTINGS = new AlgorithmSettings(2, 2, new double[]{0.1, 0.9});
    AlgorithmSettings CRYSTAL_SETTINGS = GAME_OF_LIFE_SETTINGS;

    Map<Integer, AlgorithmSettings> ALGORITHM_LIST_AS_MAP = Map.of(
            GAME_OF_LIFE, GAME_OF_LIFE_SETTINGS,
            SEEDS, SEEDS_SETTINGS,
            BRIANS_BRAIN, BRIANS_BRAIN_SETTINGS,
            LANGTONS_ANT, LANGTONS_ANT_SETTINGS,
            FLOOD, FLOOD_SETTINGS,
            CRYSTAL, CRYSTAL_SETTINGS
    );


}
