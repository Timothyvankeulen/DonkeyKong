import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class DonkeyKong here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DonkeyKong extends Actor
{
    /**
     * Act - do whatever the DonkeyKong wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int count = 0;
    public void act() 
    {
        lookForMario();
        spawnBarrel();
    }    
    public void spawnBarrel(){
        if (count % 150 == 0) getWorld().addObject(new Barrel(), getWorld().getWidth()-50, 50);
        count++;
    }
    protected void lookForMario(){
        Object mario;
        List list;
        World world;
        Counter counter;
        List lijst;
        list = getObjectsInRange(35, Mario.class);
        if (list.size() != 0){
            mario = list.get(0);
            if(mario != null){
            world = getWorld();
            lijst = world.getObjects(Counter.class);
            counter = (Counter)lijst.get(0);
            counter.addScore();
            Greenfoot.stop();
            }
        }
    }
}
