package james;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class sprinterSpeed_2020s1_v2 {
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
    public static void main (String[] args) throws FileNotFoundException,NullPointerException {
        String test_data_path="test_data/2020/s1/";
        File f = new File(test_data_path);
        String[] filelist =f.list();

        Set<String> hash_Set = new HashSet<String>();
        for (String s : filelist) {
            String fn = s.split("\\.")[0].concat(".").concat(s.split("\\.")[1]);
            hash_Set.add(fn);
        }

        String[] sortedfiles = hash_Set.toArray(String[]::new);
        SortFiles(sortedfiles);

        for(String fn : sortedfiles){
            String input = test_data_path.concat(fn.concat(".in"));
            String output = test_data_path.concat(fn.concat(".out"));
            //System.out.println(fn);
            Scanner inscan = new Scanner(new File(input));
            Scanner outscan=new Scanner(new File(output));
            float result = outscan.nextFloat();
            //////////////////////////////////////////////
            int n = inscan.nextInt();
            int[][] lines=new int[n][2];
            double speed = 0;

            for (int i = 0; i < n; i++){
                lines[i][0] = inscan.nextInt();
                lines[i][1] = inscan.nextInt();
            }

            Arrays.sort(lines, Comparator.comparingDouble(row -> row[0]));

            for( int i =1; i<lines.length;i++){
                int t0 = lines[i-1][0];
                int p0 = lines[i-1][1];
                int t1 = lines[i][0];
                int p1 = lines[i][1];

                double v = Math.abs(p1-p0*1.0)/Math.abs(t1-t0*1.0);
                if(v>speed)
                    speed =v;
            }

            System.out.println(speed);
            if(Math.abs(speed-result)/result<0.00001){
                System.out.println(fn+" passed test");
            }
            else{
                System.out.println(fn+" failed test");
                System.out.println("Expected result: "+Float.toString(result));
            }
            System.out.println("------------------------------------------");
        }
    }



}
