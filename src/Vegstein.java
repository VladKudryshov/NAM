/**
 * Created by programming on 21.3.16.
 */
public class Vegstein {
    private double x;

    private double f(double x){
        return 2*x-Math.cos(x);
    }

    public Vegstein(double x) {
        this.x = x;
    }

    public void result(){
        double eps = 0.00001;

        while(Math.abs(f(x))>=eps){
            x-=(f(x)*f(x))/(f(x)-f(x-f(x)));
        }
        System.out.println(x);



    }
}
