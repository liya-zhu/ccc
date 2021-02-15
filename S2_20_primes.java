import java.util.Scanner;

public class S2_20_primes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines=scan.nextInt();
        //int[] input=new int[lines];
        int sum;
        System.out.println();
        for (int i=0; i<lines; i++){
            //input[i]=scan.nextInt();
            sum=scan.nextInt()*2;
            for (int a=2;a<sum/2;a++){
                int b=sum-a;
                if (isPrime(a)&&isPrime(b)) {
                    System.out.println(a + " " + b);
                    break;
                }
            }
        }

    }
    public static boolean isPrime(int a){
        boolean x=true;
        for (int i=2; i<=a/2; i++){
            if (a%i==0) x=false;
        }
        return x;
    }
}
