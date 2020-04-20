/* Based on the VUW ecs100 template
 * 
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** 
 * This class is for me to get the hang of creating a flag with programming,
 * before I create a version with variables that the user inputs
 *
 * @author Brook Thomson
 * @version 1
 */
public class France{
    public static final double VERT = 2;
    public static final double HORI = 3;
    public static final double X = 300;
    public static final double Y = 150;

    /**
     * Constructor for objects of class France 
     */
    public France(){
    UI.initialise();
    UI.addButton("Quit", UI::quit);    // Comment out to checkstyle
    }
    
    /**
     * draw flag of france
     */
    public void Draw() {
        double totalLength = VERT * 50;
        double width = HORI * 50;
        double stripeLength = totalLength/3;
        double bottomStripe = Y + totalLength;
        double middleStripe = bottomStripe - stripeLength;
        double topStripe = middleStripe - stripeLength;
        
        UI.setLineWidth(1);
        UI.setColor(Color.blue);
        UI.fillRect(X, bottomStripe, width, stripeLength);
        UI.setColor(Color.white);
        UI.fillRect(X, middleStripe, width, stripeLength);
        UI.setColor(Color.red);
        UI.fillRect(X, topStripe, width, stripeLength);

    }   


    /**
     * Main routine
     *
     */
    public static void main(String[] args){
        France obj = new France();
        obj.Draw();
    }

}

