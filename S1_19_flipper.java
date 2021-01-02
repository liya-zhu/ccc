import java.util.Scanner;

public class S1_19_flipper {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int a=1;
        int b=2;
        int c=3;
        int d=4;
        String or=scan.next();
        for (int i=0; i<or.length(); i++){
            if (or.charAt(i)=='H'){
                int temp=a;
                a=c;
                c=temp;
                temp=b;
                b=d;
                d=temp;
            }
            if (or.charAt(i)=='V'){
                int temp=a;
                a=b;
                b=temp;
                temp=c;
                c=d;
                d=temp;
            }
        }
        System.out.println(a+" "+b);
        System.out.println(c+" "+d);
    }
}
