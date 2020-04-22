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
    
    public void drawFlag(){
        Color first = makeColor(" top/leftmost");
        Color second = makeColor(" middle");
        Color last = makeColor(" last");
        double vert = UI.askDouble("Ratio for height (ie if ratio is 1:2, enter 1): ");
        double hori = UI.askDouble("Ratio for width: ");
        String direction = UI.askString("Are the stripes on the flag horizontal "
        + "or vertical?" );
        UI.setLineWidth(1);
        UI.setColor(last);
        if (direction == "Horizontal") {
           drawHorizontal(vert, hori * 50, second, first);
        }
        else {
            drawVertical(vert * 50, hori, second, first);
        }
    }
    
    public Color makeColor(String whatStripe) {
        int r = UI.askInt("Enter RGB values for the"
        + whatStripe + " stripe. R: ");
        int g = UI.askInt("G: ");
        int b = UI.askInt("B: ");
        Color col = new Color(r, g, b);
        return col;
    }
    
    public void drawHorizontal(double vert, double stripeWidth, Color second, Color first) {
         double stripeLength = vert * 50 / 3;
         double bottom = Y + vert * 50;
         double middle = bottom - stripeLength;
         double top = middle - stripeLength;
         UI.fillRect(X, bottom, stripeWidth, stripeLength);
         UI.setColor(second);
         UI.fillRect(X, middle, stripeWidth, stripeLength);
         UI.setColor(first);
         UI.fillRect(X, top, stripeWidth, stripeLength);
    }
    
    public void drawVertical(double stripeLength, double hori, Color second, Color first) {
        double stripeWidth = hori * 50 /3;
        double middle = X + stripeWidth;
        double lastStripe = middle + stripeWidth;
        UI.fillRect(lastStripe, Y, stripeWidth, stripeLength);
        UI.setColor(second);
        UI.fillRect(middle, Y, stripeWidth, stripeLength);
        UI.setColor(first);
        UI.fillRect(X, Y, stripeWidth, stripeLength);
    }



    /**
     * Main routine
     *
     */
    public static void main(String[] args){
        GeneralFlags obj = new GeneralFlags();
        obj.drawFlag();
    }

}

