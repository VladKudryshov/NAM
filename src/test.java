/**
 * Created by programming on 16.3.16.
 */
public class test {

    private double x;
    private double y;

    public test(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private double F1(){
        return 0.1*x*x+x+0.2*y*y-0.3;
    }

    private double F2(){
        return 0.2*x*x+y-0.1*x*y-0.7;
    }


    private double Derivative1X(){
        return 0.2*x+1;
    }

    private double Derivative1Y(){
        return 0.4*y;
    }

    private double Derivative2X(){
        return 0.4*x-0.1*y;
    }

    private double Derivative2Y(){
        return 1-0.1*x;
    }


    private double[][] ober_matr(double[][] a)
    {
        double det, aa;
        det = a[0][0]*a[1][1] - a[0][1]*a[1][0];

        a[0][1] = -a[0][1]/det;
        a[1][0] = -a[1][0]/det;

        return a;
    }

    public void nuton()
    {
        double eps = 0.0001;
        int i = 1;
        double a[][] = new double[2][2], dx, dy, b[] = new double[2], norm;
        do
        {
            a[0][0] = Derivative1X();
            a[0][1] = Derivative1Y();
            a[1][0] = Derivative2X();
            a[1][1] = Derivative2Y();
            a = ober_matr(a);
            dx = -a[0][0]*F1() + -a[0][1]*F2();
            dy = -a[1][0]*F1() + -a[1][1]*F2();
            x = x + dx;
            y = y + dy;
            b[0] =  F1();
            b[1] =  F2();
            norm = Math.sqrt(b[0]*b[0]+b[1]*b[1]);
            i++;
        }
        while (norm >= eps);
        System.out.println("x="+x+"\ny="+y);
    }
}
