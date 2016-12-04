import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.*;

/**
 * Created by programming on 16.3.16.
 */
public class Main {
        //interpolNuton.Polinom();
        //System.out.println(interpolNuton.Newton(3));

        public static void main(String[] args)  throws Exception {

            /*InterpolNuton interpolNuton = new InterpolNuton();

            double[] x = new double[10];
            double[] y = new double[10];
            x[0] = 0.0;
            //y[0] = interpolNuton.Newton(x[0]);
            double dx = 0.1;

            for (int i = 1; i < 10; i++) {
                x[i] = x[i-1]+dx;
               // y[i] = interpolNuton.Newton(x[i]);
            }
            // Create Chart
            XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", x, y);

            // Show it
            new SwingWrapper(chart).displayChart();*/

            Spline spline = new Spline();
            System.out.println(spline.Sx(3.1));

        }
}
