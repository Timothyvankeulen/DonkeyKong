import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.FontMetrics;
import java.awt.Dimension;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Score extends Actor
{
    public Dimension getTextDimensions(GreenfootImage image, String tekst)
    {
           int height, width;
           Font font;
           
           font = image.getFont();
           FontMetrics metrics = image.getAwtImage().getGraphics().getFontMetrics();
           width = metrics.stringWidth(tekst);
           height = metrics.getLeading() + metrics.getAscent() + metrics.getDescent();
           return new Dimension(width, height);
    }
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
}
