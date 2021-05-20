import java.util.Arrays;
import java.util.Random;

public class GameLogic implements Constants {
	private final int[][] matrix;

	private final int width;
	private final int height;


	public GameLogic(int width, int height) {
		this.width = width;
		this.height = height;

		matrix = new int[width][height];
		resetMatrix();
	}

	public void resetMatrix() {
		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
				matrix[w][h] = DEFAULT_STATE;
			}
		}
		if (ANTS != null && AUTOMATON_CHOICE == LANGTONS_ANT) {
			for (Ant a : ANTS) {
				if (a != null) {
					a.reset();
				}
			}
		}
	}

	public int[][] getMooreNeighbours(int targetValue) {
		boolean onTopBorder = false;
		boolean onBottomBorder = false;
		boolean onLeftBorder = false;
		boolean onRightBorder = false;
		int[][] result = new int[width][height];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				onLeftBorder = (x == 0);
				onTopBorder = (y == 0);
				onRightBorder = (x + 1 == width);
				onBottomBorder = (y + 1 == height);

				result[x][y] = 0;

				int cellIndexLeft, cellIndexRight, cellIndexUp, cellIndexDown;

				if (!onLeftBorder) {
					cellIndexLeft = x - 1;
				}
				else if (SCREEN_WRAP) {
					cellIndexLeft = WIDTH - 1;
				}
				else {
					cellIndexLeft = NO_NEIGHBOUR_INDEX;
					//this is used so I don't need one boolean for every border the cell could be touching
				}

				if (!onTopBorder) {
					cellIndexUp = y - 1;
				}
				else if (SCREEN_WRAP) {
					cellIndexUp = HEIGHT - 1;
				}
				else {
					cellIndexUp = NO_NEIGHBOUR_INDEX;
				}

				if (!onRightBorder) {
					cellIndexRight = x + 1;
				}
				else if (SCREEN_WRAP) {
					cellIndexRight = 0;
				}
				else {
					cellIndexRight = NO_NEIGHBOUR_INDEX;
				}

				if (!onBottomBorder) {
					cellIndexDown = y + 1;
				}
				else if (SCREEN_WRAP) {
					cellIndexDown = 0;
				}
				else {
					cellIndexDown = NO_NEIGHBOUR_INDEX;
				}

				if (cellIndexLeft != NO_NEIGHBOUR_INDEX) {
					if (matrix[cellIndexLeft][y] == targetValue) result[x][y]++;

					if (cellIndexUp != NO_NEIGHBOUR_INDEX) {
						if (matrix[cellIndexLeft][cellIndexUp] == targetValue) result[x][y]++;
					}
					if (cellIndexDown != NO_NEIGHBOUR_INDEX) {
						if (matrix[cellIndexLeft][cellIndexDown] == targetValue) result[x][y]++;
					}
				}

				if (cellIndexUp != NO_NEIGHBOUR_INDEX) {
					if (matrix[x][cellIndexUp] == targetValue) result[x][y]++;
				}
				if (cellIndexDown != NO_NEIGHBOUR_INDEX) {
					if (matrix[x][cellIndexDown] == targetValue) result[x][y]++;
				}

				if (cellIndexRight != NO_NEIGHBOUR_INDEX) {
					if (matrix[cellIndexRight][y] == targetValue) result[x][y]++;

					if (cellIndexUp != NO_NEIGHBOUR_INDEX) {
						if (matrix[cellIndexRight][cellIndexUp] == targetValue) result[x][y]++;
					}
					if (cellIndexDown != NO_NEIGHBOUR_INDEX) {
						if (matrix[cellIndexRight][cellIndexDown] == targetValue) result[x][y]++;
					}
				}

			}

		}
		return result;
	}

	public int[][] getNeumannNeighbours(int targetValue) {
		boolean onTopBorder = false;
		boolean onBottomBorder = false;
		boolean onLeftBorder = false;
		boolean onRightBorder = false;
		int[][] result = new int[width][height];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				onLeftBorder = (x == 0);
				onTopBorder = (y == 0);
				onRightBorder = (x + 1 == width);
				onBottomBorder = (y + 1 == height);

				result[x][y] = 0;

				int cellIndexLeft, cellIndexRight, cellIndexUp, cellIndexDown;

				if (!onLeftBorder) {
					cellIndexLeft = x - 1;
				}
				else if (SCREEN_WRAP) {
					cellIndexLeft = WIDTH - 1;
				}
				else {
					cellIndexLeft = NO_NEIGHBOUR_INDEX;
					//this is used so I don't need one boolean for every border the cell could be touching
				}

				if (!onTopBorder) {
					cellIndexUp = y - 1;
				}
				else if (SCREEN_WRAP) {
					cellIndexUp = HEIGHT - 1;
				}
				else {
					cellIndexUp = NO_NEIGHBOUR_INDEX;
				}

				if (!onRightBorder) {
					cellIndexRight = x + 1;
				}
				else if (SCREEN_WRAP) {
					cellIndexRight = 0;
				}
				else {
					cellIndexRight = NO_NEIGHBOUR_INDEX;
				}

				if (!onBottomBorder) {
					cellIndexDown = y + 1;
				}
				else if (SCREEN_WRAP) {
					cellIndexDown = 0;
				}
				else {
					cellIndexDown = NO_NEIGHBOUR_INDEX;
				}

				if (cellIndexLeft != NO_NEIGHBOUR_INDEX) {
					if (matrix[cellIndexLeft][y] == targetValue) result[x][y]++;
				}

				if (cellIndexUp != NO_NEIGHBOUR_INDEX) {
					if (matrix[x][cellIndexUp] == targetValue) result[x][y]++;
				}
				if (cellIndexDown != NO_NEIGHBOUR_INDEX) {
					if (matrix[x][cellIndexDown] == targetValue) result[x][y]++;
				}

				if (cellIndexRight != NO_NEIGHBOUR_INDEX) {
					if (matrix[cellIndexRight][y] == targetValue) result[x][y]++;
				}

			}

		}
		return result;
	}

	public void generateNextMatrix() {

		int[][] neighboursStateOne = getMooreNeighbours(1);
		int[][] neighboursStateTwo = getMooreNeighbours(2);
		int[][] neighboursStateThree = getMooreNeighbours(3);


		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {

				int cellState = matrix[x][y];
				int cellNeighbours = neighboursStateOne[x][y];

				int cellNeighboursOne = neighboursStateOne[x][y];
				int cellNeighboursTwo = neighboursStateTwo[x][y];
				int cellNeighboursThree = neighboursStateThree[x][y];


				boolean conwaysGameOfLife = (((cellNeighbours >= 2 && cellNeighbours < 4) && cellState == 1) || (cellState == 0 && cellNeighbours == 3));


				boolean dayAndNight = (cellState == 1 && (cellNeighbours == 3 || cellNeighbours == 4 || (cellNeighbours >= 6 && cellNeighbours <= 8))) ||
						(cellState == 0 && (cellNeighbours == 3 || cellNeighbours == 6 || cellNeighbours == 7 || cellNeighbours == 8));

				boolean seeds = (cellNeighbours == 2 && cellState == 0);
				boolean mazeStructures = (cellState == 1 && (cellNeighbours >= 2 && cellNeighbours < 5) ||
						cellState == 0 && cellNeighbours == 3);

				boolean holeStructure = (cellState == 1 && (cellNeighbours >= 4 && cellNeighbours < 8) ||
						cellState == 0 && cellNeighbours == 3);

				boolean crystalStructures = (cellState == 1 && (cellNeighbours >= 2 && cellNeighbours < 7) ||
						cellState == 0 && cellNeighbours == 3);

				boolean meshStructures = cellState == 1 && (cellNeighbours >= 2 && cellNeighbours < 7) ||
						cellState == 0 && cellNeighbours == 2;

				boolean crazyShit = (cellNeighbours % 2 == 0);
				boolean crazyShit2 = (cellNeighbours % 3 == 0);
				boolean manyEyes = (cellNeighbours >= 1 && cellNeighbours <= 6 || cellNeighbours % 2 == 0);
				boolean manyEye2s = (cellNeighbours >= 1 && cellNeighbours <= 5 || cellNeighbours % 2 == 0);


				int state = 0;
				if (conwaysGameOfLife) state = 1;


				matrix[x][y] = state;
			}
		}
	}

	public void generateRandomMatrix(double[] chances) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				setTile(x, y, getArrayIndexByChanceArray(chances));
				//This works because array indices are the same as the according cell states
			}
		}
	}

	public int getArrayIndexByChanceArray(double[] chances) {
		//this array of chances does not need to equal out to 1 in total but it helps to understand the probabilities if you do

		Random rng = new Random();
		double total = Arrays.stream(chances).sum();
		double r = rng.nextDouble() * total;
		int i = 0;

		r -= chances[i];
		while (r >= 0) {
			i++;
			r -= chances[i];
		}
		return i;
	}


	public void nextStep() {
		switch (AUTOMATON_CHOICE) {
			case CONWAYS_GAME_OF_LIFE -> conwayStep();
			case SEEDS -> seedsStep();
			case BRIANS_BRAIN -> briansBrainStep();
			case LANGTONS_ANT -> langtonsAntStep();
			case FLOOD -> waterStep();
		}
	}

	//------------------------------------------------------------------------------------------
	//Algorithms

	public void conwayStep() {

		int[][] neighbours = getMooreNeighbours(1);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {

				int cellState = matrix[x][y];
				int cellNeighbours = neighbours[x][y];


				boolean cellLives = (cellNeighbours >= 2 && cellNeighbours < 4) && cellState == 1
						|| cellNeighbours == 3 && cellState == 0;

				if (cellLives) matrix[x][y] = 1;
				else matrix[x][y] = 0;
			}
		}
	}

	public void seedsStep() {
		final int STATE_DEAD = 0;
		final int STATE_ALIVE = 1;
		final int STATE_DYING = 2;

		int[][] aliveNeighboursArray = getMooreNeighbours(STATE_ALIVE);


		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {

				int cellState = matrix[x][y];
				int aliveNeighbours = aliveNeighboursArray[x][y];

				int state = 0;
				switch (cellState) {
					case STATE_ALIVE -> {
						state = STATE_DYING;
					}
					case STATE_DEAD -> {
						if (aliveNeighbours == 2) {
							state = STATE_ALIVE;
						}
					}
					case STATE_DYING -> {
						state = STATE_DEAD;
					}

				}
				matrix[x][y] = state;
			}
		}
	}

	public void waterStep() {

		final int STATE_DRY = 0;
		final int STATE_WET = 2;

		matrix[width / 2][height / 2] = STATE_WET;

		int[][] wetNeighboursArray = getNeumannNeighbours(STATE_WET);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {

				int cellState = matrix[x][y];
				int wetNeighbours = wetNeighboursArray[x][y];

				if (cellState == STATE_DRY && wetNeighbours >= 1) {
					cellState = STATE_WET;
				}

				matrix[x][y] = cellState;
			}
		}
	}

	public void briansBrainStep() {
		final int STATE_DEAD = 0;
		final int STATE_ALIVE = 1;
		final int STATE_DYING = 2;

		int[][] neighboursStateOne = getMooreNeighbours(1);


		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {

				int cellState = matrix[x][y];
				int cellNeighbours = neighboursStateOne[x][y];

				int state = 0;
				//Brian's Brain
				switch (cellState) {
					case STATE_ALIVE -> {
						state = STATE_DYING;
					}
					case STATE_DEAD -> {
						if (cellNeighbours == 2) {
							state = STATE_ALIVE;
						}
					}
					case STATE_DYING -> {
						state = STATE_DEAD;
					}
				}


				matrix[x][y] = state;
			}
		}
	}

	public void langtonsAntStep() {
		final int UNVISITED = 0;
		final int BLACK = 1;
		final int WHITE = 2;

		for (Ant a : ANTS) {
			int x = a.getX();
			int y = a.getY();
			try {
				if (matrix[x][y] == UNVISITED || matrix[x][y] == WHITE) {
					a.turnRight();
					matrix[x][y] = BLACK;
					a.step();
				}
				else if (matrix[x][y] == BLACK) {
					a.turnLeft();
					matrix[x][y] = WHITE;
					a.step();
				}
			} catch (ArrayIndexOutOfBoundsException ignored) {
				if (ANT_RETURNS_HOME) {
					a.reset();
				}
				else {
					a.die();
				}
			}
		}
	}


	//------------------------------------------------------------------------------------------
	//These are legacy functions that can still be used for debugging

	public void printMatrix() {
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				System.out.print(matrix[w][h] + "  ");
			}
			System.out.print("\n");
		}
	}

	public void printNeighbourCountNew(int[][] arr) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				System.out.print(arr[x][y] + "  ");
			}
			System.out.print("\n");
		}
	}

	//------------------------------------------------------------------------------------------
	//Mostly simple getters and setters go here :)

	public int[][] getMatrix() {
		return matrix;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setTile(int x, int y, int state) {
		try {
			matrix[x][y] = state;
			if (MIRROR_MATRIX_VERTICAL) {
				matrix[width - 1 - x][y] = state;
			}
			if (MIRROR_MATRIX_HORIZONTAL) {
				matrix[x][height - 1 - y] = state;
			}
			if (MIRROR_MATRIX_HORIZONTAL && MIRROR_MATRIX_VERTICAL) {
				matrix[width - 1 - x][height - 1 - y] = state;
			}
		} catch (ArrayIndexOutOfBoundsException ignored) {
		}
	}
}
