package ss.week5;
import ss.week5.tictactoe.*;

public interface Strategy {
	String getName();
	int determineMove(Board b, Mark m);
}
