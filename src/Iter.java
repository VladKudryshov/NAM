/**
 * Created by programming on 16.3.16.
 */public class Iter {
    private double x;
    private double y;
    private double[] lambda;
    public Iter(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private double[] systemLambda(){
        return new double[]{0.8254068607110466,-0.1785714285714286,1.5591018480097547,-0.8928571428571429};
    }

    private double F1(){
        return Math.sin(x+y)-1.5*x+0.1;
    }

    private double F2(){
        return x*x+y*y-1;
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

    public void Iteration(){
        double eps = 0.00001;
        lambda = systemLambda();
        if(lambda[0]*lambda[3]-lambda[1]*lambda[2]!=0){
            while(Math.abs(F1())>eps && Math.abs(F2())>eps) {
                x += lambda[0] * F1() + lambda[1] * F2();
                y += lambda[2] * F1() + lambda[3] * F2();
            }
            System.out.println("x="+x+"\ny="+y);
        }
        else System.out.println("Ошибка");
    }
}

