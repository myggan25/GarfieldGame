package garfieldgame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.Timer;



public class Game {
       

	public static void main(String[] args) {
            //H�R SKA VI GEJMA!
            final GameBoard board = new GameBoard(1200,600);
            final Frame frame = new Frame(board);
            final Timer clockTimer;// = new Timer(10, doOneStep);;
		
            final Action doOneStep = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    //board.getMap().moveMapLeft();
                    board.tick();
                     /*if(board.isGameOver()){
                         System.out.print("stanna tiden då förfan");
                        clockTimer.stop();
                        
                     }*/
                    frame.updateFrame(board);
                }
            };
            clockTimer = new Timer(10, doOneStep);
            clockTimer.setCoalesce(true);
            clockTimer.start();
            
            
	}
}
