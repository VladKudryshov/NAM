/**
 * Created by programming on 21.4.16.
 */
public class ParabolSpline {
    private double[] x;
    private double[] y;

    public ParabolSpline() {
        x = new double[]{-5.0, -4.0, -3.0, -2.0, -1.0, 0.0, 1.0, 2.0, 3.0, 4.0};
        y = new double[]{12.5, 7.8, 2.3, 0.4, -4.1, 0.2, 1.9, 4.8, 9.4 ,10.5};
    }

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }


}
