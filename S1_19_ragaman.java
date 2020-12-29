import java.util.Scanner;

public class S1_19_ragaman {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String w1=scan.nextLine();
        String w2=scan.nextLine();
        char find='A';
        int[] ca=new int[26];
        int ast=0;
        for (int i=0; i<w1.length();i++){
            if (w2.charAt(i)!='*'){
                ca[Character.getNumericValue(w2.charAt(i))-10]+=1;
            }
            else ast++;
        }
        for (int i=0; i<w1.length();i++){
            if (ca[Character.getNumericValue(w1.charAt(i))-10]>0) ca[Character.getNumericValue(w1.charAt(i))-10]--;
            else ast--;
        }
        if (ast!=0) find='N';

            System.out.println(find);
    }
}
