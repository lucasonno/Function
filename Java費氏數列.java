import java.util.Scanner;

public class Java費氏數列 {
    public static long F(int n){
        if(n==1||n==2){
            return 1;
        }
        else{
            return F(n-1) + F(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print(F(i)+" ");
        }
        System.out.println();
    }
}
