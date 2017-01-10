package ss.week5;

import java.util.HashSet;
import java.util.Set;

import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;

public class SmartStrategy implements Strategy {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}

	@Override
	public int determineMove(Board b, Mark m) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < b.DIM * b.DIM; i++) {
			if (b.isEmptyField(i)) {
				set.add(i);
			}
		}
		
		int setMove = -1;
		
		Board bCopy;
		// check for guarantee win
		for (Integer s : set) {
			bCopy = b.deepCopy();
			bCopy.setField(s, m);
			if (bCopy.hasWinner()) {
				setMove = s;
				break;
			}
		}
		
		// no guaranteed win. Block opponent?
		if (setMove == -1) {
			for (Integer s : set) {
				bCopy = b.deepCopy();
				bCopy.setField(s, m.other());
				if (bCopy.hasWinner()) {
					setMove = s;
					break;
				}
			}			
		}

		// Opponent cannot win, so check if the middle field is empty.
		if (setMove == -1 && b.isEmptyField((b.DIM * b.DIM - 1) / 2)) {
			setMove = (b.DIM * b.DIM - 1) / 2;
		}
		
		// Middle field is not empty, so select a random field.
		if (setMove == -1) {
			int r = (int) (Math.random() * set.size());
			int i = 0;
			for (Integer s : set) {
				if (r == i) {
					setMove = s;
					break;
				}
				i++;
			}
		}
		
		return setMove;
	}

}
