import java.util.Scanner;

public class Java_組合數 {
    static int C(int m,int n){
        int ans1=1,ans2=1;
        for (int i = m; i > m-n; i--) {
            ans1 = ans1 * i;
        }
        for(int i=1;i<=n;i++){
            ans2=ans2*i;
        }
        return ans1/ans2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m,n;
        m = in.nextInt();
        n = in.nextInt();
        if(n>m/2){
            n=m-n;
        }
        System.out.println(C(m,n));
    }
}