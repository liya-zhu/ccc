package james;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Flipper_2019s1 {
    public static void SortFiles(String[] myArray){
        int size = myArray.length;

        for(int i = 0; i<size-1; i++) {
            for (int j = i+1; j<myArray.length; j++) {
                if(myArray[i].compareTo(myArray[j])>0) {
                    String temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        String test_data_path="test_data/2019/s1/";
        File f = new File(test_data_path);
        String[] filelist =f.list();

        Set<String> hash_Set = new HashSet<String>();
        for (String s : filelist) {
            String fn = s.split("\\.")[0].concat(".").concat(s.split("\\.")[1]);
            hash_Set.add(fn);
        }

        String[] sortedfiles = hash_Set.toArray(String[]::new);
        SortFiles(sortedfiles);

        for(String fn : sortedfiles) {
            String input = test_data_path.concat(fn.concat(".in"));
            String output = test_data_path.concat(fn.concat(".out"));
            //System.out.println(fn);
            Scanner inscan = new Scanner(new File(input));
            Scanner outscan = new Scanner(new File(output));

            //output
            int a1,b1,c1,d1;
            a1=outscan.nextInt();
            b1=outscan.nextInt();
            c1=outscan.nextInt();
            d1=outscan.nextInt();
            ////////////////////////////////////////////////////

            int a=1;
            int b=2;
            int c=3;
            int d=4;
            String or=inscan.next();
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

            if(a==a1 && b==b1 && c==c1 && d==d1){
                System.out.println(fn+" passed test");
            }
            else{
                System.out.println(fn+" failed test");
            }
            System.out.println("------------------------------------------");
        }
    }
}
