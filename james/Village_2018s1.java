package james;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Village_2018s1 {
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
        String test_data_path="test_data/2018/s1/";
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
            double result;
            result = outscan.nextDouble();
            ////////////////////////////////////////////////////
            int n = inscan.nextInt();
            int[] villages = new int[n];

            for (int i = 0; i < n; i++)
                villages[i] = inscan.nextInt();

            Arrays.sort(villages);
            double size=Integer.MAX_VALUE;

            for(int i=1; i<n-1;i++){
                double temp=(villages[i]-villages[i-1])*1.0/2+(villages[i+1]-villages[i])*1.0/2;
                if (temp<size){
                    size=temp;
                }
            }
            size = Math.round(size*100)/100.0;
            System.out.println(size);
            if(Math.abs(size-result)<0.1){
                System.out.println(fn+" passed test");
            }
            else{
                System.out.println(fn+" failed test");
                System.out.println("Expected result: "+Double.toString(result));
            }
            System.out.println("------------------------------------------");
        }
    }
}
