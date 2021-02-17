import java.util.Arrays;
import java.util.Scanner;

public class S3_20_string {
    static String H;
    static String N;
    static int count=0;
    static int [] letters=new int[26];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N=scan.next();
        H=scan.next();

        for (int i=0; i<H.length()-N.length(); i++){
            reset();
            if (isPerm(i)) count++;
        }

        System.out.println(count);
    }

    public static void reset(){
        Arrays.fill(letters,0);
        for (int i=0; i<N.length(); i++){
            int index = (int) N.charAt(i)-97;
            letters[index]+=1;
        }
    }

    public static boolean isPerm(int i){
        for (int j=0; j<N.length(); j++){
            int index=(int) H.charAt(j+i)-97;
            if (letters[index]>0) letters[index]--;
            else return false;
        }
        return true;

    }
}
/*aab
abacabaa
 */