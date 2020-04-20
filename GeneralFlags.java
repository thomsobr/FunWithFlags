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
        int firstR = UI.askInt("Enter RGB values for the"
        + " top/leftmost stripe. R: ");
        int firstG = UI.askInt("G: ");
        int firstB = UI.askInt("B: ");
        Color first = new Color(firstR, firstG, firstB);
        int secondR = UI.askInt("Enter RGB values for the"
        + " middle stripe. R: ");
        int secondG = UI.askInt("G: ");
        int secondB = UI.askInt("B: ");
        Color second = new Color(secondR, secondG, secondB);
        int lastR = UI.askInt("Enter RGB values for the"
        + " last stripe. R: ");
        int lastG = UI.askInt("G: ");
        int lastB = UI.askInt("B: ");
        Color last = new Color(lastR, lastG, lastB);
        double vert = UI.askDouble("Ratio for height (ie if ratio is 1:2, enter 1): ");
        double hori = UI.askDouble("Ratio for width: ");
        String direction = UI.askString("Are the stripes on the flag horizontal "
        + "or vertical?" );
        if (direction == "Horizontal") {
            double stripeLength = vert * 50 / 3;
            double stripeWidth = hori * 50;
            double bottom = Y + vert * 50;
            double middle = bottom - stripeLength;
            double top = middle - stripeLength;
            UI.setLineWidth(1);
            UI.setColor(last);
            UI.fillRect(X, bottom, stripeWidth, stripeLength);
            UI.setColor(second);
            UI.fillRect(X, middle, stripeWidth, stripeLength);
            UI.setColor(first);
            UI.fillRect(X, top, stripeWidth, stripeLength);
        }
        else {
            double stripeLength = vert * 50;
            double stripeWidth = hori * 50 /3;
        }
        
        
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

