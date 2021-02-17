import java.util.Arrays;
import java.util.Scanner;

public class S2_17_tide {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] tide=new int[n];
        //int[] low=new int[n];
        //int[] high=new int[n];
        for (int i=0; i<n; i++){
            tide[i]=scan.nextInt();
        }
        Arrays.sort(tide);

        int j=0; //last index of low
        if (n%2==0){
            j=n/2-1;
            for (int i=j; i>=0; i--){
                System.out.print(tide[i]+" "+tide[n-1-i]+" ");
            }
        }
        else if (n%2==1){
            j=(n-1)/2;
            for (int i=j; i>=1; i--){
                System.out.print(tide[i]+" "+tide[n-i]+" ");
            }
            System.out.print(tide[0]);
        }
    }
}
/*
" "+tide[n-i]+" "

9
10 50 40 7 3 110 90 2
 */