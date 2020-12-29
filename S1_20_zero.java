import java.util.Scanner;

public class S1_20_zero {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] nums=new int[n];
        int sum=0;

        for (int i=0; i<n; i++){
            int a=scan.nextInt();
            nums[i]=a;
            sum+=a;
        }
        for (int i=0; i<n; i++) {
            if (nums[i]==0){
                for (int j=i; j>=0; j--) {
                    if (nums[j]>0) {
                        sum -=nums[j];
                        nums[j]=-1;
                        break;
                    }
                }
            }
        }



        /*

        int j;
        for (int i=0; i<n; i++){
            if (num[i]==0){
                j=i;
                while (true) {
                    del++;
                    j++;
                    if (j == n) break;
                    else if (num[j] != 0) break; //yk how many to delete
                }
                for (int k=1;k<=del;k++){
                    sum-=num[i-k];
                }
                i+=del;
                del=0;
            }
            if (i>=n) break;
            sum+=num[i];
        }

         */
        System.out.println(sum);
    }
}
