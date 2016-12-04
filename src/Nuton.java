/**
 * Created by programming on 16.3.16.
 */
public class Nuton {
    private double x;
    private double y;

    public Nuton(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private double F1(){
        return Math.sin(x+y)-1.5*x+0.1;
    }

    private double F2(){
        return y*y+x*x-1;
    }

    private double Derivative1X(){
        return Math.cos(x+y)-1.5;
    }

    private double Derivative1Y(){
        return Math.cos(x+y);
    }

    private double Derivative2X(){
        return 2*x;
    }

    private double Derivative2Y(){
        return 2*y;
    }

    private double[][] ober_matr(double[][] a)
    {
        double det;
        det = a[0][0]*a[1][1] - a[0][1]*a[1][0];
        a[0][0] = a[1][1]/det;
        a[1][1] = a[0][0]/det;
        a[0][1] = -a[0][1]/det;
        a[1][0] = -a[1][0]/det;
        return a;
    }




    public void nuton()
    {
        double eps = 0.00001;
        double a[][] = new double[2][2], norm,iter= 0;
        double dx, dy, b[] = new double[2];
        do
        {
            a[0][0] = Derivative1X();
            a[0][1] = Derivative1Y();
            a[1][0] = Derivative2X();
            a[1][1] = Derivative2Y();
            ober_matr(a);
            dx = -a[0][0]*F1()  -a[0][1]*F2();
            dy = -a[1][0]*F1()  -a[1][1]*F2();
            x = x + dx;
            y = y + dy;
            b[0] = F1();
            b[1] = F2();
            norm = Math.sqrt(b[0]*b[0]+b[1]*b[1]);
            iter++;
        }
        while (norm >= eps);
        System.out.println("x="+x+"\ny="+y+"\n"+ iter);
    }




}