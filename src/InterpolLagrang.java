import java.util.ArrayList;
import java.util.List;

/**
 * Created by programming on 6.4.16.
 */
public class InterpolLagrang {
    private double[] x;
    private double[] y;

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    public InterpolLagrang() {
        x = new double[]{0.41, 0.46, 0.52, 0.60, 0.65, 0.72};
        y = new double[]{2.57418, 2.32513, 2.09336, 1.86203, 1.74926, 1.62098};
    }


    public double f(double arg) {
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            double k = 1;
            for (int j = 0; j < y.length; j++) {
                if (j != i) {
                    k *= (arg - x[j]) / (x[i] - x[j]);
                }
            }
            result += k * y[i];
        }
        return result;
    }

    private double determinant(double[][] row){

        return row[0][0]*row[1][1]-row[1][0]*row[0][1];

    }

    public double Etken(double arg){

        ArrayList<Double> tmp = new ArrayList<>();
        for (int j = 0; j<5;j++){
            double res = 1/(x[j+1]-x[j])*determinant(new double[][]{{y[j],x[j]-arg},{y[j+1],x[j+1]-arg}});
            tmp.add(res);
        }


        for (int i = 0; i<4;i++){

            for (int j = 0; j<4-i;j++){
                double res = 1/(x[j+1+i]-x[j])*determinant(new double[][]{{tmp.get(j),x[j]-arg},{tmp.get(j+1),x[j+1+i]-arg}});
                tmp.add(res);
            }
            for(int k = 0; k < 5-i;k++){
                tmp.remove(0);
            }

        }
        return tmp.get(0);
    }
}
