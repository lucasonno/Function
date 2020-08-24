import java.util.Scanner;

public class Java_hanoi {
    static void HanoiTower(int n,char a,char b,char c){
        if(n==1){
            System.out.println("Ring "+n+" from "+a+" to "+b);
        }
        else{
            HanoiTower(n-1,a,c,b);
            System.out.println("Ring "+n+" from "+a+" to "+b);
            HanoiTower(n-1,c,b,a);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        HanoiTower(n,'A','B','C');
    }
}
