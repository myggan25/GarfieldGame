package garfieldgame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    GraphicalViewer gameArea;
    GameBoard board;

    /**
     * Action: Superjump
     * Is only allowed to jump if the player is standing
     */
    final Action superJump = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            if (!(board.getPlayer().getStatus().equals(PlayerStatus.FALLING) || board.getPlayer().getStatus().equals(PlayerStatus.SUPERJUMPING) ||
                    board.getPlayer().getStatus().equals(PlayerStatus.JUMPING) || board.getPlayer().getCrouchStatus().equals(PlayerCrouchStatus.CROUCHING))) {
                board.getPlayer().superJump();
            }
        }
    };
    /**
     * Action: Jump
     * Is only allowed to jump if the player is standing
     */
    final Action jump = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            if (!(board.getPlayer().getStatus().equals(PlayerStatus.FALLING) || board.getPlayer().getStatus().equals(PlayerStatus.SUPERJUMPING) ||
                    board.getPlayer().getStatus().equals(PlayerStatus.JUMPING) || board.getPlayer().getCrouchStatus().equals(PlayerCrouchStatus.CROUCHING))) {
                board.getPlayer().jump();
            }
        }
    };
    /**
     * Action: crouch
     * Makes the player crouch
     */
    final Action crouch = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            board.getPlayer().crouch();
        }
    };
    /**
     * Action: unchrouch
     * Makes the player stand up
     */
    final Action uncrouch = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            board.getPlayer().unCrouch();
        }
    };

    /**
     * Action: goRight
     * Makes the player move right
     */
    final Action goRight = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            board.getPlayer().goRight();
        }
    };
    /**
     * Action: goLeft
     * Makes the player move right
     */
    final Action goLeft = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            board.getPlayer().goLeft();
        }
    };

    /**
     * Creates a frame with a menu and creates key listeners.
     * Sets the size of the frame and inserts a gameBoard
     * @param board
     */
    public Frame(GameBoard board) {
        super("Garfield's journey");
        this.board = board;
        gameArea = new GraphicalViewer(board);
        createMenu();

        gameArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "jump");
        gameArea.getActionMap().put("jump", jump);

        gameArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "superjump");
        gameArea.getActionMap().put("superjump", superJump);

        gameArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "crouchPressed");
        gameArea.getActionMap().put("crouchPressed", crouch);

        gameArea.getInputMap().put(KeyStroke.getKeyStroke("released DOWN"), "crouchReleased");
        gameArea.getActionMap().put("crouchReleased", uncrouch);

        gameArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right");
        gameArea.getActionMap().put("right", goRight);

        gameArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
        gameArea.getActionMap().put("left", goLeft);

        board.addBoardListener(gameArea);
        this.add(gameArea);
        this.setSize(gameArea.getPreferredSize());
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Adds a new GameBoard and makes it visible
     * If the game is lost, an option dialog pops up and asks if you want to restart or exit
     * @param board
     */
    public void updateFrame(GameBoard board) {
        this.board = board;
        Object[] options = {"Restart", "Exit"};
        if (board.isGameOver()) {
            int answer = JOptionPane.showOptionDialog
                    (new java.awt.Frame(), "Do you want to restart the game?", "You Died!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (answer == JOptionPane.NO_OPTION) {
                System.exit(0);
            } else {
                board.reset();
            }
        }
        gameArea.insertNewGameBoard(board);
        this.setVisible(true);
    }

    /**
     * Creates the menu with an exit button and a restart button
     */
    private void createMenu() {
        final JMenuBar menuBar = new JMenuBar();

        final JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenuItem restartActionItem = new JMenuItem("Restart");
        JMenuItem exitActionItem = new JMenuItem("Exit");
        gameMenu.add(restartActionItem);
        gameMenu.addSeparator();
        gameMenu.add(exitActionItem);

        setJMenuBar(menuBar);

        // Listeners for the menu buttons
        restartActionItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.reset();
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
