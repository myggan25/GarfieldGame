package garfieldgame;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.Font;
import java.awt.font.TextLayout;

import javax.swing.*;

import java.util.ArrayList;

public class GraphicalViewer extends JComponent implements BoardListener {
	
	GameBoard gameBoard;
	
	public GraphicalViewer (GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public void boardChanged(){
            //System.out.println("ska repainta");
		repaint();
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(gameBoard.getWidth(), gameBoard.getHeight()+gameBoard.getGroundHeight());
	}
	
	public void insertNewGameBoard(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public void paintComponent(final Graphics g){
            //System.out.println("ritar ut");
            Graphics2D g2 = (Graphics2D)g;
            //Rita ut spelplanen
            //paintScore(g2);
            paintBackground(g2);
            paintPlayer(g2);
            paintObstacle(g2);
            paintPowerbottle(g2);
            paintScore(g2);
        
	}
        
        private void paintScore(Graphics2D g2){
            //TextLayout tl = new TextLayout("hello", new Font("Arial", Font.BOLD, 50), g2.getFontRenderContext());
            //Shape outline = tl.getOutline(null);
            g2.setPaint(new Color(255,255,255));
            g2.setFont(new Font("Arial", Font.BOLD, 25));
            g2.drawString(Integer.toString(gameBoard.getPlayer().getScore()),gameBoard.getWidth()-100, 20);
            g2.drawString(Integer.toString(gameBoard.getPlayer().getPowerbottles()),gameBoard.getWidth()-200, 20);
            /*g2.setStroke(new BasicStroke(2.5f));
            g2.setColor(Color.WHITE);
            g2.draw(outline);*/
        }
        private void paintBackground(Graphics2D g2){
        final Area background = new Area(new Rectangle2D.Float(
				0,0,gameBoard.getWidth(),gameBoard.getHeight()));
		/*h�r g�r det att �ndra v�rdet p� 100 f�r att flytta bakgrunden*/
            g2.setPaint(new Color(0,0,30));
            g2.fill(background);
            final Area floorArea = new Area(new Rectangle2D.Float(
                                    0,gameBoard.getHeight(),gameBoard.getWidth(),gameBoard.getGroundHeight()));
            g2.setPaint(new Color(0,0,255));
            g2.fill(floorArea);    
        }
	
	private void paintPlayer(Graphics2D g2){
		//Rita ut spelaren
            System.out.println(gameBoard.getPlayer().getXCoord());
           // System.out.println(gameBoard.getPlayer().get)
		final Area playerArea = new Area(new Rectangle2D.Float(
				gameBoard.getPlayer().getXCoord(),gameBoard.getPlayer().getYCoord(),
				gameBoard.getPlayer().getWidth(),gameBoard.getPlayer().getHeight()));		
		g2.setPaint(new Color(255,69,0));
		g2.fill(playerArea);
                /*final Area testArea = new Area(new Rectangle2D.Float(
                        gameBoard.getPlayer().getXCoord()+gameBoard.getPlayer().getWidth(),gameBoard.getPlayer().getYCoord()-100,
			1,gameBoard.getPlayer().getHeight()));
                            
                g2.setPaint(new Color(0,150,0));
                g2.fill(testArea);
                final Area test2Area = new Area(new Rectangle2D.Float(
                        gameBoard.getPlayer().getXCoord()+gameBoard.getPlayer().getWidth(),gameBoard.getPlayer().getYCoord()+gameBoard.getPlayer().getHeight(),
			gameBoard.getPlayer().getWidth(),1));
                g2.setPaint(new Color(0,150,0));
                g2.fill(test2Area);
                */
	}
	
	private void paintObstacle(Graphics2D g2){
            //Rita ut hinder
            for(Obstacle obstacle : gameBoard.getObstacles()){
                final Area obstacleArea = new Area(new Rectangle2D.Float(
                            obstacle.getXCoord(),obstacle.getYCoord(),obstacle.getWidth(),obstacle.getHeight()));
                //System.out.println(obstacle.getXCoord());
                g2.setPaint(new Color(100,100,100));
                g2.fill(obstacleArea);
                /*final Area testArea = new Area(new Rectangle2D.Float(
                            obstacle.getXCoord(),obstacle.getYCoord()-100,1,obstacle.getHeight()));
                g2.setPaint(new Color(0,150,0));
                g2.fill(testArea);
                */
            }
		
	}
	
	private void paintPowerbottle(Graphics2D g2){
		//Rita ut energiflaska
            for(Powerbottle bottle : gameBoard.getPowerbottles()){
		final Area powerbottleArea = new Area(new Rectangle2D.Float(
                        bottle.getXCoord(),bottle.getYCoord(),bottle.getWidth(),bottle.getHeight()));
				//gameBoard.getCurrentPowerbottle().getXCoordMap(),gameBoard.getCurrentPowerbottle().getYCoord(),gameBoard.getCurrentPowerbottle().getWidth(),gameBoard.getCurrentPowerbottle().getHeight()));
		g2.setPaint(new Color(210,105,30));
		g2.fill(powerbottleArea);
            }
	}
	
}
