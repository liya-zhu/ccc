import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class S1_20_speed {
    static Scanner scan=new Scanner(System.in);
    public static void main (String[] args){
        int n=scan.nextInt();
        double speed = 0;


        int[] tsort=new int[n];
        int[] position=new int[n];

        /*
        for (int i=0; i<n; i++){
            tsort[i]=scan.nextInt();
            position[i]=scan.nextInt();
        }

        int[] tcopy=Arrays.copyOf(tsort,n);
        int[] psort=new int[n];
        Arrays.sort(tsort);

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (tsort[i]==tcopy[j]){
                    psort[i]=position[j];
                }
            }
        }
        for (int i=1; i<n; i++) {
            double temp=Math.abs((1.0*(position[i]-position[i-1]))/(1.0*(tsort[i]-tsort[i-1])));
            if (temp>speed){
                speed=temp;
            }
        }
        System.out.println(speed);
        */


        int[][] tp=new int[n][2];
        for (int i=0; i<n; i++){
            tp[i][0]=scan.nextInt();
            tp[i][1]=scan.nextInt();
        }
        Arrays.sort(tp, Comparator.comparingDouble(row -> row[0]));

        for (int i=1; i<n; i++){
            double temp=Math.abs(1.0*(tp[i][1]-tp[i-1][1]))/(1.0*(tp[i][0]-tp[i-1][0]));
            if (temp>speed) speed=temp;
        }
        System.out.println(speed);



    }
}
