# Java自學紀錄 - 方法(Function)

* 設計與呼叫
* 參數的傳遞
* 遞迴
* 多形
* 抽象化

## 設計與呼叫
**有回傳值**
```java=
[存取範圍修飾字] 回傳值型別 function名稱(參數列){
    敘述1;
    敘述2;
    return 回傳值;
}

example:
static int add(int a,int b){
    return a+b;
}
public static void main(String[] args) {
    int a=2,b=3;
    System.out.println(add(a,b)); //呼叫add()
}
```
**無回傳值(void)**
```java=
static void add(int a,int b){
    System.out.println(a+b);
}
public static void main(String[] args) {
    int a=2,b=3;
    add(a,b); //呼叫add()
}
```
### 實例探討 - 組合數 
![](https://i.imgur.com/2wL5LSF.jpg)
圖檔來源 : easyatm.com.tw/wiki/組合數公式
#### 組合數實作
```java=
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
```
>下圖為執行結果

![](https://i.imgur.com/jZRmxMn.png)

----
## 參數的傳遞
Java對於參數的傳遞有兩種方式
1.傳值呼叫(Call By Value)
>傳值呼叫是將```該筆資料複製一份```,然後將複製的資料傳給指定的function,所以該function對所傳遞的參數若有異動,亦不會影響主程式的值。
>參數的異動不會回傳,這就是Java與C++不同的地方,一個function只能return至多一個回傳值,若要回傳兩個或以上的值,那就要使用```陣列```或```物件```的方式。

2.傳址呼叫(Call By Reference)
>傳址呼叫是將```原始資料的位址```傳遞給對應function,所以該function對該參數有所異動,皆可將異動的結果回傳主程式。
----
## 遞迴(Recursion)
>呼叫自己的function稱作為遞迴,遞迴的使用需符合以下兩條件,否則程式不會停下來。

1.問題須具有重複特性,也就是在特定情況下可以呼叫自己。
2.這個重複的問題有結束的條件。
### 實例探討 - 費氏數列
#### 費氏數列規則
>```第n項```為```第n-1項```與```第n-2項```的和

![](https://i.imgur.com/nxyUSBN.png)

```java=
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
```
>下圖為執行結果

![](https://i.imgur.com/AkDqpkN.png)

----
## 多型(Polymorphism)
>意即一種樣式有多種表現方式
>例如下令僕人幫忙開門,但他開門的方式可以是推的拉的...,然後僕人會依照門的結構來完成開門的動作。物件導向的程式設計亦發揚此概念,讓設計者程式設計階段使用同的指令,而編譯器能依照執行階段需求,執行不同的程式片段,此即為多型。

==example==
運用```add```實作來呈現**方法多載**
```java=
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
```
>下圖為執行結果

![](https://i.imgur.com/WUhyazz.png)

----
## 抽象化(Abstraction)
>將一具體的東西,依照某一需求,以另一種具體的形式表現,這就稱作```抽象化```
>例如有一幅畫,要求你把它畫一遍,當然不可能每個細節都抓到,每個人畫出來的也不見得相同,有的人連地上的垃圾都不放過,有的人希望不同時代或背景的人能有不同的體會,這就是為甚麼畢卡索的畫能流傳至今,程式設計的領域不也是如此嗎。
>你的觀念或程式是否能讓不同背景或不同需求的使用者都能夠使用這一程式,且讓他們得到想要的結果,這就是抽象化的最高境界。

### 實例探討 - 河內塔(Hanoi Tower)
#### 河內塔規則
有三根杆子A，B，C。A杆上有 N 個 (N>1) 穿孔圓盤，盤的尺寸由下到上依次變小。要求按下列規則將所有圓盤移至 C 杆

1.每次只能移動一個圓盤。
2.大盤不能疊在小盤上面。

**提示**：可將圓盤臨時置於 B 杆，也可將從 A 杆移出的圓盤重新移回 A 杆，但都必須遵循上述兩條規則。
==example==
![](https://i.imgur.com/q8tslM0.gif)
圖檔來源 : http://gg.gg/lorow

```java=
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
```
>下圖為執行結果

![](https://i.imgur.com/rfROLX9.png)
