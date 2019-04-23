import java.awt.*;
import java.awt.geom.*;
import java.util.*;
/**
 * Class bouncebox - a graphical ball which bounces around in a box whilst remaining
 * inside it.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Ali Khan
 *
 * @version 2019.03.31
 */

public class bouncebox
{ 
     
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
   
    private Canvas canvas;
    private int ySpeed = 7;                // speed about y-axis
    private int xSpeed = 7;                // speed about x-axis
    /**
     * Constructor for objects of class bouncebox
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * 
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public bouncebox(int xPos, int yPos, int ballDiameter, Color ballColor,
                        Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    
 
     /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void movee()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
         yPosition += ySpeed;
         xPosition += xSpeed;
        

        // check if it hit the ground and bounce off if so.
        if(yPosition >= (399 - diameter)){
            ySpeed = ySpeed - (ySpeed*2); 
             
       }
       //check if it hit the top and bounce off if so.
       else if(yPosition <=(2)){
            ySpeed = ySpeed + (ySpeed*-2);
         
       
       }
       //check if it hit the right and bounce off if so.
        else if(xPosition >= (597 - diameter)){
            xSpeed = xSpeed - (xSpeed*2); 
       }
       //check if it hit the left and bounce off if so.
        else if(xPosition <=(2)){
            xSpeed = xSpeed + (xSpeed*-2);
        }   
        // draw again at new position
        draw();
        

    }

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
