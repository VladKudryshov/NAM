import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by programming on 30.3.16.
 */
public class InterpolNuton {
    private double[] x;
    private double[] y;
    private double[] coef;

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    public InterpolNuton() {
        x = new double[]{0,1,2,3};
        y = new double[]{-2,-5,0,-4};
    }

    public InterpolNuton(double[] y) {
        x = new double[21];
        int index = 0;
        for (double i = 0.0; i <= 5.0; i+=0.25) {
            x[index++]=i;
        }
        this.y = y;
        for (int i = 0; i < x.length; i++) {
        }
    }

    public double[] Polinom(){
        double[] rect = new double[x.length];
        int index = x.length-1;
        rect[0]=y[0];
        ArrayList<Double> tmp = new ArrayList<>();
        for (int i = 0; i < x.length - 1; i++) {
            tmp.add((y[i + 1] - y[i]) / (x[i + 1] - x[i]));
        }
        rect[1] = tmp.get(0);
        for (int j=2; j<x.length; j++) {

            for (int i = 0; i < x.length - j; i++) {
                tmp.add((tmp.get(i+1) - tmp.get(i)) / (x[i + j] - x[i]));
            }
            for (int i = 0; i < index; i++) {
                tmp.remove(0);
            }
            index--;
            rect[j] = tmp.get(0);
        }
        return rect;
    }
    public double cof(double t)
    {
        coef = Polinom();
        int n = x.length-1;
        double res = coef[0], F;
        int i, j=0, k;
        for (i = 1; i <= n; i++)
        {
            F = coef[++j];
            for (k = 0; k < i; k++) F *= (t  - x[k]);
            res += F;
        }
        return res;
    }
}
