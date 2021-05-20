public class Ant implements Constants {

	private int x = WIDTH / 2;
	private int y = HEIGHT / 2;
	private int direction = FACING_UP;
	private boolean isAlive = true;


	public Ant(int direction) {
		this.direction = direction;
	}

	public void reset() {
		isAlive=true;
		x = WIDTH / 2;
		y = HEIGHT / 2;
		direction = FACING_UP;
	}

	public void step() {
		if(isAlive) {
			switch (direction) {
				case FACING_UP -> {
					y--;
				}
				case FACING_DOWN -> {
					y++;
				}
				case FACING_RIGHT -> {
					x++;
				}
				case FACING_LEFT -> {
					x--;
				}
			}
		}
	}

	public void turnRight() {
		switch (direction) {
			case FACING_UP -> {
				direction = FACING_RIGHT;
			}
			case FACING_RIGHT -> {
				direction = FACING_DOWN;
			}
			case FACING_DOWN -> {
				direction = FACING_LEFT;
			}
			case FACING_LEFT -> {
				direction = FACING_UP;
			}
		}
	}

	public void turnLeft() {
		switch (direction) {
			case FACING_UP -> {
				direction = FACING_LEFT;
			}
			case FACING_LEFT -> {
				direction = FACING_DOWN;
			}
			case FACING_DOWN -> {
				direction = FACING_RIGHT;
			}
			case FACING_RIGHT -> {
				direction = FACING_UP;
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void die() {isAlive=false;}
}
