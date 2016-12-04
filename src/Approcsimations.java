
import java.rmi.MarshalException;
import java.util.Arrays;

/**
 * Created by programming on 18.5.16.
 */
public class Approcsimations {
    private double[] x,y;
    private double Matrix[][];
    private double MatrixT[][];
    private double Alpha[][];
    private double Betta[];
    private double LongMatr[][];
    private double Coof[];

    public double[] getY() {
        return y;
    }

    public double[] getX() {
        return x;
    }

    public Approcsimations(double[] x, double[] y){
        this.x = x;
        this.y = y;

    }

    private double FOne(){return 1.0;}
    private double X(double x){return x;}
    private double XX(double x){return x*x;}
    private double X1(double x){return 1.0/x;}
    private double ln(double x){return Math.log(Math.abs(x));}
    private double EXP(double x){return Math.exp(x);}
    private double EXP2(double x){return Math.exp(2*x);}
    private double EXP3(double x){return Math.exp(3*x);}

    private double[][] Transp(){
        MatrixT = new double[Matrix[0].length][Matrix.length];
        for (int i = 0; i < MatrixT.length; i++) {
            for (int j = 0; j < MatrixT[i].length; j++) {
                MatrixT[i][j]=Matrix[j][i];
            }
        }
       return MatrixT;
    }
    
    private double[][] Multiplicator(double[][] FT,double[][] F){

        double[][] tmp = new double[FT.length][F[0].length];
        double sum = 0;
        for (int i = 0; i < FT.length; i++) {
            for (int j = 0; j < F[0].length; j++) {
                for (int k = 0; k < F.length; k++) {
                    sum+=FT[i][k]*F[k][j];
                }
                tmp[i][j] = sum;
                sum=0;
            }
        }
        return tmp;
    }
    private double[] Multiplicator(double[][] FT,double[] F){

        double[] tmp = new double[FT.length];
        double sum = 0;
        for (int i = 0; i < FT.length; i++) {
                for (int k = 0; k < F.length; k++) {
                    sum+=FT[i][k]*F[k];
                }
                tmp[i] = sum;
                sum=0;
        }
        return tmp;
    }

    void PlusAddedString(int j, int strNum)
    {
        double multiplier_0 = -LongMatr[j + strNum][j];
        double multiplier_1 = LongMatr[j][j];
        for (int i = 0; i < LongMatr[0].length; i++){
            LongMatr[j + strNum][i] += LongMatr[j][i] * multiplier_0 / multiplier_1;
        }
    }

    public double[] GetRoots()
    {
        double[] c = new double[LongMatr[0].length-1];

        for (int j = 0; j < LongMatr.length; j++){
            for (int i =j+1; i < LongMatr[0].length; i++){//M
                if(j+i<LongMatr.length)PlusAddedString(j,i);
            }
        }

        for (int j = LongMatr.length-1; j >= 0; j--){
            double sum = 0;
            for (int i = LongMatr.length-1; i > j; i--){sum += LongMatr[j][i] * c[i]; }
            c[j] = (LongMatr[j][LongMatr[0].length-1] -sum)/LongMatr[j][j];
            for (int n = 0; n < LongMatr[0].length; n++){LongMatr[j][n] = 0; }
            LongMatr[j][j] = 1;
            LongMatr[j][LongMatr[0].length-1] = c[j];

        }

//for (int j = 0; j < M-1; j++) c[j] = matrix[j,M-1] / matrix[j,j];

        return c;
    }

    public void ResultFunctionLiner(){
        Matrix = new double[x.length][2];
        for (int i = 0; i < x.length; i++) {
                Matrix[i][0] = FOne();
                Matrix[i][1] = X(x[i]);
        }
        Transp();
        Alpha = Multiplicator(MatrixT,Matrix);
        Betta = Multiplicator(MatrixT,y);
        LongMatr = new double[Alpha.length][Alpha[0].length+1];

        for (int i = 0; i < LongMatr.length; i++) {
            for (int j = 0; j < LongMatr[0].length-1; j++) {
                LongMatr[i][j] = Alpha[i][j];
            }
            LongMatr[i][LongMatr[0].length-1] = Betta[i];
        }
        Coof = GetRoots();

        for (int i = 0; i < Coof.length; i++) {
            for (int j = 0; j < Betta[0]; j++) {
                System.out.print(Coof[i]/*[j]*/+" ");
           }
            //System.out.println();
        }
    }

    public void ResultFunctionSquere(){
        Matrix = new double[x.length][3];
        for (int i = 0; i < x.length; i++) {
                Matrix[i][0] = FOne();
                Matrix[i][1] = X(x[i]);
                Matrix[i][2] = XX(x[i]);
        }
        Transp();
        Alpha = Multiplicator(MatrixT,Matrix);
        Betta = Multiplicator(MatrixT,y);
        LongMatr = new double[Alpha.length][Alpha[0].length+1];

        for (int i = 0; i < LongMatr.length; i++) {
            for (int j = 0; j < LongMatr[0].length-1; j++) {
                LongMatr[i][j] = Alpha[i][j];
            }
            LongMatr[i][LongMatr[0].length-1] = Betta[i];
        }
        Coof = GetRoots();

    }

    public double polinom(double x){
        double result = 0;

        for (int i = 1; i < Coof.length; i++) {
            result+=Coof[i]*Math.pow(x,i);
        }

        return result+Coof[0];
    }
}
