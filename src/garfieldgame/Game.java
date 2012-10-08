package garfieldgame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;



public class Game {

	public static void main(String[] args) {
            //H�R SKA VI GEJMA!
            final GameBoard board = new GameBoard(1200,800);
            final Frame frame = new Frame(board);
		
            final Action doOneStep = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    //board.getMap().moveMapLeft();
                    board.tick();
                    frame.updateFrame(board);
                    //System.out.println(board.getMap().getObstacle().getXCoordMap());
                    //tFrame.updateFrame(board);
                }
            };
            //frame.setVisible(true);
            final Timer clockTimer = new Timer(100, doOneStep);
            clockTimer.setCoalesce(true);
            clockTimer.start();	
	}

}
