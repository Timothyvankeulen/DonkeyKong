import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    private GreenfootImage imageLeft;
    private GreenfootImage imageRight;
    private GreenfootImage imageMoveLeft;
    private GreenfootImage imageMoveRight;
    private GreenfootImage imageJumpLeft;
    private GreenfootImage imageJumpRight;
    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Mario(){
        imageLeft = new GreenfootImage("marioleft.png");
        imageRight = new GreenfootImage("marioright.png");
        imageMoveLeft = new GreenfootImage("mariomoveleft.png");
        imageMoveRight = new GreenfootImage("mariomoveright.png");
        imageJumpLeft = new GreenfootImage("mariojumpleft.png");
        imageJumpRight = new GreenfootImage("mariojumpright.png");
        setImage(imageRight);
    }
    public void act() 
    {
        death();
        gravity();
        movingAndTurning();
    } 
    protected void gravity(){
        if (!foundBar()){
            setRotation(90);
            move(1);
            setRotation(0);
        }
    }
    protected void death(){
        if (foundBarrel()){
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
    protected void win(){
        if (foundDonkeyKong()){
            Greenfoot.stop();
        }
    }
    protected void movingAndTurning(){
        if(Greenfoot.isKeyDown("up")){
            if(getImage() == imageLeft || getImage() == imageMoveLeft){
                setImage(imageJumpLeft);
            } 
            else if (getImage() == imageRight || getImage() == imageMoveRight){
                setImage(imageJumpRight);
            }
            if (foundLadder()){
                setRotation(90);
                move(-2);
                setRotation(0);
            }else if (foundBar()){
                setRotation(90);
                move(-42);
                setRotation(0);
            }
        }
        if(Greenfoot.isKeyDown("right" )){
            if(getImage() == imageLeft || getImage() == imageMoveLeft){
                setImage(imageRight);
            } 
            else if (getImage() == imageRight || getImage() == imageJumpRight || getImage() == imageJumpLeft){
                setImage(imageMoveRight);
            }
            setRotation(0);
            move(2);
            if (foundBar()){
                setRotation(90);
                move(-2);
                setRotation(0);
            }
        }
        else if(Greenfoot.isKeyDown("left")){
            if(getImage() == imageRight || getImage() == imageMoveRight){
                setImage(imageLeft);
            }
            else if (getImage() == imageLeft || getImage() == imageJumpLeft || getImage() == imageJumpRight){
                setImage(imageMoveLeft);
            }
            setRotation(0);
            move(-2);
            if (foundBar()){
                setRotation(90);
                move(-2);
                setRotation(0);
            }
        }
    }
    protected boolean foundBar(){
        if(getOneObjectAtOffset(0,10, Bar.class) != null){
            return true;
        }
        return false;
    }
    protected boolean foundLadder(){
        if(getOneObjectAtOffset(0,5, Ladder.class) != null){
            return true;
        }
        return false;
    }
    protected boolean foundBarrel(){
        if(getOneObjectAtOffset(0,0, Barrel.class) != null){
            return true;
        }
        return false;
    }
    protected boolean foundDonkeyKong(){
        if (getOneObjectAtOffset(0,0, DonkeyKong.class) != null){
            return true;
        }
        return false;
    }
}