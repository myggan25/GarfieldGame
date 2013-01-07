package garfieldgame;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;

public class Game {
<<<<<<< HEAD
    public static void main(String[] args) {
        final GameBoard board = new GameBoard(1200, 600);
        final Frame frame = new Frame(board);
        final Timer clockTimer;

        final Action doOneStep = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                board.tick();
                frame.updateFrame(board);
            }
        };
        clockTimer = new Timer(10, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();
    }
=======
	public static void main(String[] args) {
            final GameBoard board = new GameBoard(1200,600);
            final Frame frame = new Frame(board);
            final Timer clockTimer;
		
            final Action doOneStep = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    board.tick();
                    frame.updateFrame(board);
                }
            };
            clockTimer = new Timer(10, doOneStep);
            clockTimer.setCoalesce(true);
            clockTimer.start();
	}
>>>>>>> Fixat kompletteringen
}
