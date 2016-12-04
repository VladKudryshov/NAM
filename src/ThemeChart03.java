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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThemeChart03 implements ExampleChart<XYChart> {

    public static void main(String[] args) {

        ExampleChart<XYChart> exampleChart = new ThemeChart03();
        XYChart chart = exampleChart.getChart();
        new SwingWrapper<XYChart>(chart).displayChart();
    }

    @Override
    public XYChart getChart() {
       // InterpolNuton interpolNuton = new InterpolNuton(new double[]{4.558,4.197,4.129,3.066,3.111,2.305,2.348,1.414,0.926,9.659,0.067,-0.818,-1.014,-1.389,-1.748,-2.831,-2.854,-3.215,-3.981,-4.229,-4.843});
        //InterpolNuton interpolNuton = new InterpolNuton();
        // Create Chart
        Approcsimations approcsimations = new Approcsimations(new double[]{1.16, 1.88, 2.60, 3.32, 4.04, 4.76, 5.48, 6.20},new double[]{0.18, 0.26, 0.32, 0.36, 0.40, 0.43, 0.95, 0.85});
        approcsimations.ResultFunctionSquere();



        XYChart chart = new XYChartBuilder().width(1000).height(1000).theme(Styler.ChartTheme.Matlab).title("Approcsimations").xAxisTitle("X").yAxisTitle("Y").build();

        // Customize Chart
        chart.getStyler().setPlotGridLinesVisible(false);
        chart.getStyler().setXAxisTickMarkSpacingHint(100);

        double dx = 0.001;
        double touch = 1/dx;
        int n = (int)(5.04*touch);
        double[] x = new double[n];
        double[] y = new double[n];
        x[0] = 1.16;
        y[0] = approcsimations.polinom(x[0]);


        for (int i = 1; i < n; i++) {
            x[i] = x[i-1]+dx;
            y[i] = approcsimations.polinom(x[i]);
        }

        double[] x0 = approcsimations.getX();
        double[] y0 = approcsimations.getY();

        /*double[] x1 = new double[16];
        double[] y1 = new double[16];


        for(int i = 2,index = 0; i<18;i++,index++){
            x1[index] = x0[i];
            y1[index] = y0[i];
        }*/

        XYSeries series= chart.addSeries("Interpolation", x, y);
        series.setMarker(SeriesMarkers.NONE);
        series = chart.addSeries("Linear", x0, y0);
        series.setMarker(SeriesMarkers.NONE);
        series.setLineColor(XChartSeriesColors.GREEN);
        series.setMarkerColor(Color.ORANGE);
        series.setMarker(SeriesMarkers.CIRCLE);
        chart.getStyler().setMarkerSize(16);
        series.setLineStyle(SeriesLines.SOLID);
        // Series

        return chart;
    }



}