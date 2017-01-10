package ss.week5;

import java.util.HashSet;
import java.util.Set;

import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;

public class NaiveStrategy implements Strategy {

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
		int setMove = 0;
		int r = (int) (Math.random() * set.size());
		int i = 0;
		System.out.println("to: " + r);
		for (Integer s : set) {
		    System.out.println(s);
			if (r == i) {
		    	setMove = s;
		    	break;
		    }
			i++;
		}
		return setMove;
	}

}
