import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor
{
    /**
     * Act - do whatever the Barrel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int dir = 0;
    int fall = 0;
    public void act() 
    {
        move();
    }
    protected void move(){
        if (atWorldEdge()){
            if(dir == 0){
                dir = 1;
            }else{
                dir = 0;
            }
            fall++;
            
        }
            if(!foundBar() && !foundLadder()){
                setRotation(90);
                move(3);
                setRotation(0);
            }else{
                setRotation(0);
                if (dir == 0) move(-2);
                if (dir == 1) move(2);
            }
            if(fall == 4) getWorld().removeObject(this);
    }
    protected boolean foundBar(){
        Actor rock;
        rock = getOneObjectAtOffset(0,6, Bar.class);
        if(rock != null){
            return true;
        }
        return false;
    }
    protected boolean foundLadder(){
        Actor rock;
        rock = getOneObjectAtOffset(0,6, Ladder.class);
        if(rock != null){
            return true;
        }
        
       
        return false;
    }
    protected boolean atWorldEdge(){
        int x, i, y, wx, wy;
        
        x = getX(); //Vraag op waar Gnomus is ten opzichte van de linkerrand
        i = getImage().getWidth()/2; //Vraag de breedte van de afbeelding en deel deze door twee
        if(x <= i) {
            return true;
        }
        //Bovenkant
        y = getY();
        if(y <= i) {
            return true;
        }
        //Rechterkant
        wx = getWorld().getWidth() - i;
        if(x >= wx) {
            return true;
        }
        //Onderkant
        wy = getWorld().getHeight() - i;
        if(y >= wy) {
            return true;
        }
        return false;
    }
}
