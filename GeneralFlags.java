/* Based on the VUW ecs100 template
 *
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** 
 * creates any 3 striped flag based on parameters entered by the user
 *
 * @author Brook Thomson
 * @version 21/04/20
 */
public class GeneralFlags{
    public static final double X = 100;
    public static final double Y = 100;

    /**
     * Constructor for objects of class GeneralFlags 
     */
    public GeneralFlags(){
    UI.initialise();
    UI.addButton("Quit", UI::quit);    // Comment out to checkstyle
    }
    
    public void getInfo(){
        Color first = makeColor();
        Color second = makeColor();
        Color last = makeColor();
        double vert = UI.askDouble("Ratio for height (ie if ratio is 1:2, enter 1): ");
        double hori = UI.askDouble("Ratio for width: ");
        String direction = UI.askString("Are the stripes on the flag horizontal "
        + "or vertical?" );
        UI.setLineWidth(1);
        UI.setColor(last);
        if (direction == "Horizontal") {
            double stripeLength = vert * 50 / 3;
            double stripeWidth = hori * 50;
            double bottom = Y + vert * 50;
            double middle = bottom - stripeLength;
            double top = middle - stripeLength;
            UI.fillRect(X, bottom, stripeWidth, stripeLength);
            UI.setColor(second);
            UI.fillRect(X, middle, stripeWidth, stripeLength);
            UI.setColor(first);
            UI.fillRect(X, top, stripeWidth, stripeLength);
        }
        else {
            double stripeLength = vert * 50;
            double stripeWidth = hori * 50 /3;
            double middle = X + stripeWidth;
            double lastStripe = middle + stripeWidth;
            UI.fillRect(lastStripe, Y, stripeWidth, stripeLength);
            UI.setColor(second);
            UI.fillRect(middle, Y, stripeWidth, stripeLength);
            UI.setColor(first);
            UI.fillRect(X, Y, stripeWidth, stripeLength);
        }
        
        
    }
    
    public Color makeColor() {
        int firstR = UI.askInt("Enter RGB values for the"
        + " top/leftmost stripe. R: ");
        int firstG = UI.askInt("G: ");
        int firstB = UI.askInt("B: ");
        Color col = new Color(firstR, firstG, firstB);
        return col;
    }



    /**
     * Main routine
     *
     */
    public static void main(String[] args){
        GeneralFlags obj = new GeneralFlags();
        obj.getInfo();
    }

}

