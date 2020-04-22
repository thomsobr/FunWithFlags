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
 * @version 22/04/20
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
    
    /**
     * Draws any 3 stripe flag
     */
    
    public void drawFlag(){
        Color first = makeColor(" top/leftmost"); // creates color for first stripe
        Color second = makeColor(" middle"); // second stripe
        Color last = makeColor(" last"); // third stripe
        
        // find ratio
        double vert = UI.askDouble("Ratio for height (ie if ratio is 1:2, enter 1): ");
        double hori = UI.askDouble("Ratio for width: ");
        
        String direction = UI.askString("Are the stripes on the flag horizontal "
        + "or vertical?" );
        
        // set up to draw
        UI.setLineWidth(1);
        UI.setColor(last);
        if (direction.equalsIgnoreCase("horizontal")) {
           drawHorizontal(vert, hori * 50, second, first); // hori multiplied by 50 for scale
        }
        else {
            drawVertical(vert * 50, hori, second, first); // vert multiplied by 50 for scale
        }
    }
    
    /**
     * Asks for RGB values and creates a new color from them
     * 
     * parameter whatStripe - string to complete message asking for stripe colors
     * returns the new color
     */
    
    public Color makeColor(String whatStripe) {
        int r = UI.askInt("Enter RGB values for the"
        + whatStripe + " stripe. R: ");
        int g = UI.askInt("G: ");
        int b = UI.askInt("B: ");
        Color col = new Color(r, g, b);
        return col;
    }
    
    /**
     * Draws a flag with horizontal stripes
     * 
     * Parameters:
     * double vert - to find stripe lengths and position
     * double stripeWidth - width of flag
     * Colors second and first  - colors of the middle and top flag
     * 
     */
    public void drawHorizontal(double vert, double stripeWidth, Color second, Color first) {
         // vert is multiplied by 50 as hori was earlier, so the flag is 50 times the size as the ratio given
         double stripeLength = vert * 50 / 3; // divided by 3 to find individual lengths of the 3 stripes
         // find y value for bottom stripe
         double bottom = Y + vert * 50;
         // y value for middle stripe
         double middle = bottom - stripeLength;
         // y value for top stripe
         double top = middle - stripeLength;
         UI.fillRect(X, bottom, stripeWidth, stripeLength);
         UI.setColor(second);
         UI.fillRect(X, middle, stripeWidth, stripeLength);
         UI.setColor(first);
         UI.fillRect(X, stripeLength, stripeWidth, stripeLength);
    }
    
    /**
     * Draws a flag with vertical stripes
     * 
     * Parameters:
     * double stripeLength - length of flag
     * double hori - to find stripe widths and position
     * Colors second and first  - colors of the middle and top flag
     * 
     */
    public void drawVertical(double stripeLength, double hori, Color second, Color first) {
        double stripeWidth = hori * 50 / 3;
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

