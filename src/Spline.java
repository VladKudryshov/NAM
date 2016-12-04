/**
 * Created by programming on 6.4.16.
 */
public class Spline {
    private double[] x;
    private double[] y;
    private final double h = 1;
    private int n;
    double[] a, b, c;

    public Spline() {
        x = new double[]{-5.0, -4.0, -3.0, -2.0, -1.0, 0.0, 1.0, 2.0, 3.0, 4.0};
        y = new double[]{12.5, 7.8, 2.3, 0.4, -4.1, 0.2, 1.9, 4.8, 9.4, 10.5};
        a = new double[x.length-1];
        b = new double[x.length-1];
        c = new double[x.length-1];
        this.n = 9;
        coef();
    }

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }


    double Sx(double xx) {
        double S = 1;
        for (int i = 0; i < 9 || xx>x[i]; i++) {
            S = a[i] + b[i] * (xx - x[i]) + c[i] * (xx - x[i]) * (xx - x[i]);
        }
        return S;
    }

    void coef() {
        for (int i = 0; i < y.length - 1; i++) {
            a[i] = y[i];
        }
        b[0] = (y[1]-y[0])/(x[1]-x[0]);
        for (int i = 1; i < 9; i++) {
            b[i] = (2 * (y[i] - y[i-1]) /(x[i]-x[i-1])) - b[i-1];
        }
        for (int i = 0; i < 8; i++) {
            c[i] = (b[i + 1] - b[i]) / (2 *(x[i+1]-x[i]));
        }
        c[n - 1] = ((y[n] - y[n - 1]) / ((x[n]-x[n-1])*(x[n]-x[n-1]))) - (b[n - 1] / (x[n]-x[n-1]));

    }
}


