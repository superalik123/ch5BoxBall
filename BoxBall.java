import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.HashSet;
import java.util.Random;

/**
 * Models a ball bouncing within a box by calling on the boxbounce() method.
 *
 * @author (Ali Khan)
 * @version (3/31/2019)
 */
public class BoxBall
{
    //declare variables
    
    private Canvas myCanvas;  
    private HashSet<bouncebox> ballStore;
    private bouncebox ball;
    private int n;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
   
    private Canvas canvas;
    private int ySpeed = 10;                //speed about y-axis
    private int xSpeed = 10;                //speed about x-axis  
    
    
    /**
     * Simulate a given amount of zero-gravity bouncing balls within a box
     * @param ballcount allows to choose number of bouncing balls to display
     */
    public void boxBounce(int ballcount)
    {
        //Random generator
        Random random = new Random();
        //values by which to draw box
        int top = 1;
        int left = 1;
        int right = 1;
        int groundPosition = 400;
         
        //create the canvas
        myCanvas = new Canvas("Ball Demo", 600, 500);
        
        //draw the box
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(1, groundPosition, 598, groundPosition);
        myCanvas.drawLine(left, top, 598, top);
        myCanvas.drawLine(left, 1, left,groundPosition );
        myCanvas.drawLine(598, right, 598, groundPosition);
        
        //hashmap creation for ball storage
        ballStore = new HashSet<bouncebox>();
        
        //Creating balls for the hash map
        for(int i = 0; i < ballcount;i++){
             
            
            
            //Random color generator
            int r = random.nextInt(200);
            int g = random.nextInt(200);
            int b = random.nextInt(200);
            color = new Color(r, g, b);
            
            diameter = random.nextInt(20) +10;
            xPosition = random.nextInt(500);
            yPosition = random.nextInt(500);
            bouncebox ball = new bouncebox(random.nextInt(400-diameter), random.nextInt(400-diameter), random.nextInt(100), color, myCanvas); 
            ballStore.add(ball); 
            ball.draw(); 
         }
         
        myCanvas.wait(50); //delay
        

        // make the balls bounce
        boolean finished =  false;
        while(!ballStore.isEmpty()) {
            myCanvas.wait(50);           // small delay
            
            for(bouncebox ball : ballStore){
            ball.movee();
             
        }
            // redraw the rectangle
            myCanvas.setForegroundColor(Color.BLACK);
            myCanvas.drawLine(1, groundPosition, 598, groundPosition);
            myCanvas.drawLine(left, top, 598, top);
            myCanvas.drawLine(left, 1, left,groundPosition );
            myCanvas.drawLine(598, right, 598, groundPosition);
        }
    }
    
}

