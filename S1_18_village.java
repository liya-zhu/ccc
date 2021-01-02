import java.util.Arrays;
import java.util.Scanner;

public class S1_18_village {
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        int[] villages = new int[n];

        for (int i = 0; i < n; i++) {
            villages[i]=scan.nextInt();
        }
        Arrays.sort(villages);
        double size=Integer.MAX_VALUE;

        for(int i=1; i<n-1;i++){
            double temp=(villages[i]-villages[i-1])*1.0/2+(villages[i+1]-villages[i])*1.0/2;
            if (temp<size){
                size=temp;
            }
        }
        System.out.println(Math.round(size*10)/10.0);
    }
}
