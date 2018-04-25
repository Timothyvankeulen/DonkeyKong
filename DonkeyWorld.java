import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DonkeyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DonkeyWorld extends World
{
    private Counter counter;
    private EndScore endScore;
    /**
     * Constructor for objects of class DonkeyWorld.
     * 
     */
    public DonkeyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        generateWorld();
    }
    protected void generateWorld(){
        int regel, kolom;
        for(int i  = 0; i < 38; i ++){
            //First bar
            addObject(new Bar(), 7+i*16, getHeight()-7);
        }
        for(int i  = 0; i < 34; i ++){
            //Second bar
            addObject(new Bar(), 7+i*16, getHeight()-81+(i/2));
        }
        for(int i  = 0; i < 34; i ++){
            //Third bar
            if(i != 9){
                //Replace the 9th bar with a ladder
                addObject(new Bar(), 65+i*16, getHeight()-140-(i/2));
            }
            if(i == 9){
                for(int teller = 0; teller < 2; teller++){
                    addObject(new Ladder(), 209, getHeight()-144+(teller*15));
                }
            }
        }
        for(int i  = 0; i < 34; i ++){
            //Fourth bar
            addObject(new Bar(), 7+i*16, getHeight()-230+(i/2));
        }
        for(int i  = 0; i < 34; i ++){
            //Fifth bar
            if(i != 16){
                //Replace the 16th bar with a ladder
                addObject(new Bar(), 65+i*16, getHeight()-290-(i/2));
            }
            if(i == 16){
                for(int teller = 0; teller < 2; teller++){
                    addObject(new Ladder(), 321, getHeight()-297+(teller*15));
                }
            }
        }
        for(int i  = 0; i < 4; i ++){
            //First ladder
            addObject(new Ladder(), getWidth()-50, getHeight()-65+i*15);
        }
        for(int i  = 0; i < 4; i ++){
            //Second ladder
            addObject(new Ladder(), 50, getHeight()-140+i*15);
        }
        for(int i  = 0; i < 4; i ++){
            //Third ladder
            addObject(new Ladder(), getWidth()-50, getHeight()-215+i*15);
        }
        for(int i  = 0; i < 4; i ++){
            //Fourth ladder
            addObject(new Ladder(), 50, getHeight()-290+i*15);
        }
        //Adds Donkey kong and mario on the world.
        addObject(new DonkeyKong(), getWidth()-50, getHeight()-339);
        addObject(new Mario(), 50, getHeight()-25);
     
        //Adding the counter so it will display on the screen.
        counter = new Counter();
        regel = getHeight() - counter.getImage().getHeight() / 2 - 2;
        kolom = counter.getImage().getWidth() / 2 + 1;
        addObject(counter, kolom, regel);
        
        //Paint order in which each object is spawned on the world.
        setPaintOrder(EndScore.class, Counter.class, Mario.class, Barrel.class, DonkeyKong.class, Bar.class, Ladder.class);
    }
    public void started(){
        for (EndScore endscore : this.getObjects(EndScore.class)) this.removeObject(endscore);
        endScore = new EndScore();
        //Creates a new Mario when the game starts.
        addObject(new Mario(), 50, getHeight()-25);
    }
     public void stopped(){
         int score;
         //Setting the counter when the game ends.
         score = counter.getScore();
         endScore.setEndImage(score);
         addObject(endScore, getWidth()/2, getHeight()/2);
         //Removes Mario at the end of the game.
         for (Mario mario : this.getObjects(Mario.class)) this.removeObject(mario);
    }
}