package ss.week5.tictactoe;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import ss.week5.*;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2y
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
    	System.setIn(new UncloseableInputStream());
    	Player p1 = new HumanPlayer(args[0], Mark.OO);
    	if (args[0].equals("-N")) {
    		p1 = new ComputerPlayer(Mark.OO, new NaiveStrategy());
    		System.out.println("Computer player (p1) found!");
    	} else if (args[0].equals("-S")) {
    		p1 = new ComputerPlayer(Mark.OO, new SmartStrategy());
    		System.out.println("Computer player (p1) found!");    		
    	}
    	Player p2 = new HumanPlayer(args[1], Mark.XX);
    	if (args[1].equals("-N")) {
    		p2 = new ComputerPlayer(Mark.XX, new NaiveStrategy());
    		System.out.println("Computer player (p2) found!");
    	} else if (args[1].equals("-S")) {
    		p2 = new ComputerPlayer(Mark.XX, new SmartStrategy());
    		System.out.println("Computer player (p2) found!");    		
    	}
    	Game game = new Game(p1, p2);
    	game.start();
    }
    
    /**
     * Wraps an input stream to prevent it from being closed.
     */
    private static class UncloseableInputStream extends FilterInputStream {

        /**
         * Creates a wrapper around {@link System.in}.
         */
        UncloseableInputStream() {
            this(System.in);
        }

        /**
         * Creates a wrapper around an arbitrary {@link InputStream}.
         * @param stream The stream to wrap.
         */
        UncloseableInputStream(InputStream stream) {
            super(stream);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void close() throws IOException {
            // Don't do anything
        }
    }
    
}
