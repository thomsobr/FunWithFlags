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

    /**
     * Constructor for objects of class GeneralFlags 
     */
    public GeneralFlags(){
    UI.initialise();
    UI.addButton("Quit", UI::quit);    // Comment out to checkstyle
    }
    
    public void getInfo(){
        ArrayList<Double> firstColor = UI.askNumbers("Enter RGB values for the"
        + " top/leftmost stripe: ");
        ArrayList<Double> middleColor = UI.askNumbers("Enter RGB values for the"
        + " middle stripe: ");
         ArrayList<Double> lastColor = UI.askNumbers("Enter RGB values for the"
        + " last stripe: ");
        double vert = UI.askDouble("Ratio for height (ie if ratio is 1:2, enter 1): ");
        double hori = UI.askDouble("Ratio for width: ");
        String direction = UI.askString("Are the stripes on the flag horizontal "
        + "or vertical?" );
        if (direction == "Horizontal") {
            double stripeLength = vert * 50 / 3;
            double stripeWidth = hori * 50;
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

