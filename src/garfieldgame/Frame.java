package garfieldgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
	
	GraphicalViewer gameArea;
	GameBoard board;
	
	final Action jump = new AbstractAction()  {
		public void actionPerformed(ActionEvent e){
			//Utf�r hopp
                    //board.getMap().getObstacle().setHeight(board.getMap().getObstacle().getHeight()+1);
			board.setJump(true);
		}
	};
	final Action crouch = new AbstractAction()  {
		public void actionPerformed(ActionEvent e){
			//Utf�r ducka
			board.setCrouch(true);
		}
	};
	final Action balanceRight = new AbstractAction()  {
		public void actionPerformed(ActionEvent e){
			//Utf�r balanskorektion �t h�ger
			System.out.println("h�ger");
		}
	};
	final Action balanceLeft = new AbstractAction()  {
		public void actionPerformed(ActionEvent e){
			//Utf�r balanskorektion �t v�nster
			System.out.println("v�nster");
		}
	};	
	
	public Frame(GameBoard board){
            super("Garfield's journey");
            this.board = board;
            gameArea = new GraphicalViewer(board);
            
            
		
            createMenu();
            //createKeyBoardListeners();
            gameArea = new GraphicalViewer(board);
        
            this.add(gameArea);
            //board.addBoardListener(gameArea);

            gameArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"),
                    "jump");
            gameArea.getActionMap().put("jump",
                    jump);
            gameArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"),
                    "crouch");
            gameArea.getActionMap().put("crouch",
                    crouch);
            gameArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"),
                    "right");
            gameArea.getActionMap().put("right",
                    balanceRight);
            gameArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"),
                    "left");
            gameArea.getActionMap().put("left",
                    balanceLeft);
            board.addBoardListener(gameArea);
            this.add(gameArea);
            this.setSize(gameArea.getPreferredSize());
            this.pack();
            this.setVisible(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void updateFrame(GameBoard board){
		//S�tt in en ny board och g�r den visible
		this.board = board;
		gameArea.insertNewGameBoard(board);
                //den nedan gör att det fungerar men ska inte gå genom denna egentligen
                //gameArea.boardChanged();
		this.setVisible(true);
	}
	
	
	
	private void createMenu(){
		//Skapa meny f�r start och stopp
		final JMenuBar menuBar = new JMenuBar();
		
		final JMenu gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);
		JMenuItem startActionItem = new JMenuItem("Start");
		JMenuItem stopActionItem = new JMenuItem("Stop");
		JMenuItem exitActionItem = new JMenuItem("Exit");
		gameMenu.add(startActionItem);
		gameMenu.add(stopActionItem);
		gameMenu.addSeparator();
		gameMenu.add(exitActionItem);
		
		setJMenuBar(menuBar);
		
		//Lyssnare f�r menyknapparna
		startActionItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Starta spelet h�r");
            }
        }
        );
		stopActionItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("ev. stoppa spelet h�r");
            }
        }
        );
		exitActionItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(DISPOSE_ON_CLOSE);
            }
        }
        );

	}
	
}
