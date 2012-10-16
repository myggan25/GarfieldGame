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
		repaint();
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(gameBoard.getWidth(), gameBoard.getHeight()+gameBoard.getGroundHeight());
	}
	
	public void insertNewGameBoard(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public void paintComponent(final Graphics g){
            Graphics2D g2 = (Graphics2D)g;
            //Rita ut spelplanen
            paintBackground(g2);
            paintPlayer(g2);
            paintObstacle(g2);
            paintPowerbottle(g2);
            paintScore(g2);
        
	}
        
        private void paintScore(Graphics2D g2){
            g2.setPaint(new Color(255,255,255));
            g2.setFont(new Font("Arial", Font.BOLD, 25));
            //Skriver ut poängen på skärmen, -100 är för att flytta in den från kanten
            g2.drawString(Integer.toString(gameBoard.getPlayer().getScore()),gameBoard.getWidth()-100, 20);
            //Skriver ut antalet fångade powerbottles, -200 är för att flytta in den från kanten
            g2.drawString(Integer.toString(gameBoard.getPlayer().getPowerbottles()),gameBoard.getWidth()-200, 20);
        }
        private void paintBackground(Graphics2D g2){
        final Area background = new Area(new Rectangle2D.Float(
				0,0,gameBoard.getWidth(),gameBoard.getHeight()));
            g2.setPaint(new Color(0,0,30));
            g2.fill(background);
            final Area floorArea = new Area(new Rectangle2D.Float(
                                    0,gameBoard.getHeight(),gameBoard.getWidth(),gameBoard.getGroundHeight()));
            g2.setPaint(new Color(0,0,255));
            g2.fill(floorArea);    
        }
	
	private void paintPlayer(Graphics2D g2){
            //Rita ut spelaren
		final Area playerArea = new Area(new Rectangle2D.Float(
				gameBoard.getPlayer().getXCoord(),gameBoard.getPlayer().getYCoord(),
				gameBoard.getPlayer().getWidth(),gameBoard.getPlayer().getHeight()));	
                //255,69,0 är orange
		g2.setPaint(new Color(255,69,0));
		g2.fill(playerArea);
	}
	
	private void paintObstacle(Graphics2D g2){
            //Rita ut hinder
            for(Obstacle obstacle : gameBoard.getObstacles()){
                final Area obstacleArea = new Area(new Rectangle2D.Float(
                            obstacle.getXCoord(),obstacle.getYCoord(),obstacle.getWidth(),obstacle.getHeight()));
                //100,100,100 är grå
                g2.setPaint(new Color(100,100,100));
                g2.fill(obstacleArea);
            }
		
	}
	
	private void paintPowerbottle(Graphics2D g2){
            //Rita ut energiflaska
            for(Powerbottle bottle : gameBoard.getPowerbottles()){
		final Area powerbottleArea = new Area(new Rectangle2D.Float(
                        bottle.getXCoord(),bottle.getYCoord(),bottle.getWidth(),bottle.getHeight()));
                //139,69,19 är brun
		g2.setPaint(new Color(139,69,19));
		g2.fill(powerbottleArea);
            }
	}
}
