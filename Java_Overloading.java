import java.util.Scanner;

public class Java_Overloading {
    static int add(int a,int b){
        return a+b;
    }
    static int add(int a,int b,int c){
        return a+b+c;
    }
    static double add(int a,int b,double c){
        return a+b+c;
    }
    public static void main(String[] args) {
        int a,b,c;
        double d;
        a=1;
        b=2;
        c=3;
        d=3.5;
        //add 方法多載
        System.out.println(add(a,b));   //int + int
        System.out.println(add(a,b,c)); //int +int +int
        System.out.println(add(a,b,d)); //int +int +double
    }
}