import java.util.Scanner;

public class S1_17_sum {
    public static void main (String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] sw=new int[n];
        int[] sem=new int[n];
        for (int i=0; i<2; i++){
            for (int j=0; j<n; j++){
                if (i==0) sw[j]=scan.nextInt();
                else sem[j]=scan.nextInt();
            }
        }

        int sum1=0;
        int sum2=0;
        int k=0;
        for (int i=0; i<n; i++){
            sum1+=sw[i];
            sum2+=sem[i];
            if (sum1==sum2) k=i+1;
        }
        System.out.println(k);
    }
}

