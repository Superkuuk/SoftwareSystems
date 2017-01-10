package ss.week5;

import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;

public class ComputerPlayer extends ss.week5.tictactoe.Player {

	Strategy strategy;
	Mark mark;
	
	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName() + "-" + mark, mark);
		this.strategy = strategy;
		this.mark = mark;
	}

	public ComputerPlayer(Mark mark) {
		super("NaiveStrategy-" + mark, mark);
		this.mark = mark;
		this.strategy = new NaiveStrategy();
	}
	
	@Override
	public int determineMove(Board board) {
		return strategy.determineMove(board, mark);
	}

}
