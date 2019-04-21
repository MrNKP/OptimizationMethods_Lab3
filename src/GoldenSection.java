import java.awt.*;

import static java.lang.Math.abs;
import static java.lang.Math.nextAfter;
import static java.lang.Math.sqrt;

public class GoldenSection {
    private static class functs{
        static double f1(double X) {
            return (127/4)*X*X - (61/4)*X +2; //Example
        }
        static double f2(double X) {
            return (X-1)*(X-1); //Example2
        }
        static double f3(double X) {
            return X*X*X*X + 2*X*X +4*X +1; //Example3
        }
    }
    private double F(double X) {
        return functs.f1(X);
    }
    private double eps;
    private double a;
    private double b;
    private double yk;
    private double zk;
    private double lastF;
    private boolean right;
    private int N;

    public GoldenSection(double A, double B, double EPS){
        eps = EPS;
        a = A;
        b = B;
    }

    public void start(){
        firststep();
        if (abs(a-b)<=eps){
            N = 2;
            System.out.println("Xmin = " + (a + b)/2);
            System.out.println("N = " + N);
        }
        else {
            while (abs(a-b)>eps)
            {
                nextstep();
            }
            System.out.println("Xmin = " + (a + b)/2);
            System.out.println("N = " + N);
        }
    }

    private void firststep(){
        N = 0;
        //yk = a + ((3+sqrt(5))/2)*(b-a);
        yk = a + 0.382*(b-a);
        zk = a + b - yk;
        if (F(yk) <= F(zk)) {
            lastF = F(yk);
            b = zk;
            zk = yk;
            yk = a + b - yk;
            right = true;
        }
        else {
            lastF = F(zk);
            a = yk;
            yk = zk;
            zk = a + b - yk;
            right = false;
        }
    }

    private void nextstep(){
        N++;
        if (right){
            if (F(yk) <= lastF) {
                lastF = F(yk);
                b = zk;
                zk = yk;
                yk = a + b - yk;
                right = true;
            }
            else {
                lastF = F(zk);
                a = yk;
                yk = zk;
                zk = a + b - yk;
                right = false;
            }
        }
        else {
            if (lastF <= F(zk)){
                lastF = F(yk);
                b = zk;
                zk = yk;
                yk = a + b - yk;
                right = true;
            }
            else {
                lastF = F(zk);
                a = yk;
                yk = zk;
                zk = a + b - yk;
                right = false;
            }
        }
    }
}
