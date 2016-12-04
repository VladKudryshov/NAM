import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by programming on 30.3.16.
 */
public class Viewe extends JPanel {

    private int [] x;
    private int [] y;

    public Viewe(){
        setPreferredSize(new Dimension(1280,600));
    }




    public void paintComponent(Graphics g){
        super.paintComponents(g);


        Graphics2D g2d=(Graphics2D)g;
        double dx = 1;
        double x0=0;
        double x1=x0+dx;
        double y1,y0;
        InterpolNuton interpolNuton = new InterpolNuton();
        double[] x = new double[]{0,1,2,3};
        double[] y = new double[]{-2,-5,0,-4};
        for(int i = 0; i<x.length-1;i++){
           /* y0= Math.abs(interpolNuton.Newton(x0))/100;
            y1= Math.abs(interpolNuton.Newton(x1))/100;*/
            /*x0+=dx;
            x1+=dx;*/
        }


    }
}
