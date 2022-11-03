import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Mutated Fish trying to kill Player.
 * 
 * @author Kamil 
 * @version 3
 */
public class Fish extends Actor
{
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        attackPlayer();
        if(isTouching(Subnautic.class))
        {
            removeTouching(Subnautic.class);
        }
        move(3);
        if(isAtEdge() )
        {
            turn(17);
        }
    }
    
    public void attackPlayer()
    {
        
        if(!getObjectsInRange(200, Subnautic.class).isEmpty())
        {
             Actor player = (Actor) getObjectsInRange(200, Subnautic.class).get(0); 
             if(player != null)
             {  
                 followPlayer();
                 move(2);
             }
        }
    }
    
    public void followPlayer()
    {
        List <Subnautic> group = getObjectsInRange(200,Subnautic.class);
          if(group.size()>0){
                  Actor guy = group.get(0);
                  int targetX = guy.getX();
                  int targetY = guy.getY();
                  turnTowards(targetX,targetY);
              }
    }
}
