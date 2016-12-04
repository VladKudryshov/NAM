import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Theme implements ExampleChart<XYChart> {

    public static void main(String[] args) {

        ExampleChart<XYChart> exampleChart = new Theme();
        XYChart chart = exampleChart.getChart();
        new SwingWrapper<XYChart>(chart).displayChart();
    }

    @Override
    public XYChart getChart() {
        XYChart chart = new XYChartBuilder().width(1000).height(1000).theme(Styler.ChartTheme.Matlab).title("Newton's polynomial").xAxisTitle("X").yAxisTitle("Y").build();
        Spline spline = new Spline();
        // Customize Chart
        chart.getStyler().setPlotGridLinesVisible(false);
        chart.getStyler().setXAxisTickMarkSpacingHint(100);



        double[] x0 = spline.getX();
        double[] y0 = spline.getY();

       /* spline.BuildSpline(10);
        System.out.println(spline.f(3.0));
*/
        System.out.println(spline.Sx(-5));
        ArrayList<Double> tmp1 = new ArrayList<>();
        ArrayList<Double> tmp2 = new ArrayList<>();
        for(double i=-5.0; i<=4.0;i+=0.01){
            tmp1.add(i);
            tmp2.add(spline.Sx(i));
        }
        double x[] = new double[tmp1.size()];
        double y[] = new double[tmp1.size()];

        for (int i = 0; i<tmp1.size();i++){
            x[i] = tmp1.get(i);
            y[i] = tmp2.get(i);
        }


        XYSeries series= chart.addSeries("Interpolation", x, y);
        series.setMarker(SeriesMarkers.NONE);
        series = chart.addSeries("Linear", x0, y0);
        series.setMarker(SeriesMarkers.NONE);
        series.setLineColor(XChartSeriesColors.GREEN);
        series.setMarkerColor(Color.ORANGE);
        series.setMarker(SeriesMarkers.CIRCLE);
        chart.getStyler().setMarkerSize(16);
        series.setLineStyle(SeriesLines.SOLID);
        return chart;
    }



}