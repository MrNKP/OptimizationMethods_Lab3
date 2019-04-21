import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        double srcA, srcB, srcEps;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter A : ");
        srcA = in.nextDouble();
        System.out.print("Enter B : ");
        srcB = in.nextDouble();
        System.out.print("Enter EPS : ");
        srcEps = in.nextDouble();
        GoldenSection method = new GoldenSection(srcA, srcB, srcEps);
        method.start();
    }
}
