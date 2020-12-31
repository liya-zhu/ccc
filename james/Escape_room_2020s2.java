package james;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Escape_room_2020s2 {
    static int[][] array;
    static int row,col;
    static boolean[][] tried;
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
        String test_data_path="test_data/2020/j5_s2/";
        File f = new File(test_data_path);
        String[] filelist =f.list();

        Set<String> hash_Set = new HashSet<String>();
        for (String s : filelist) {
            String fn = s.split("\\.")[0].concat(".").concat(s.split("\\.")[1]).concat(".").concat(s.split("\\.")[2]);
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

            String result=outscan.next();
            row = inscan.nextInt();
            col = inscan.nextInt();
            array = new int[row][col];
            tried = new boolean[row][col];

            for(int i =0;i<row;i++)
                for(int j =0;j<col;j++){
                    array[i][j] = inscan.nextInt();
                    tried[i][j]=false;
                }

            tried[0][0] = true;
            boolean esacped = factor(array[0][0]);

            if(esacped==true && result.equals("yes") || esacped==false && result.equals("no"))
                System.out.println(fn+" passed test");
            else
                System.out.println(fn+" failed test");
            System.out.println("------------------------------------------");
        }
    }

     static boolean factor(int n){
            if (n<=0)
                return false;
            /*
            int m;
            if(n==225150 || n==525225 || n==88440 || n==265860 || n==208116)
                m=10;

             */
            for(int i=1;i<Math.sqrt(n);i++){
                if(n % i==0){
                  int j = n/i;

                  if(i==row && j==col || i==col&&j==row)
                      return true;

                  if (i>row && i>col || j>row && j>col ) continue;


                  try {

                      if(i<=row && j<=col )
                          if( tried[i-1][j-1]==false){
                                tried[i-1][j-1] = true;
                                if(factor(array[i-1][j-1])==true)
                                    return true;
                      }
                      if(j<=row && i<=col )
                          if (tried[j-1][i-1]==false){
                                tried[j-1][i-1] = true;
                                if(factor(array[j-1][i-1])==true)
                                    return true;
                      }

                  }catch (IndexOutOfBoundsException e) {
                      //System.out.println("Exception : "+e.getMessage());
                      continue;
                  }catch (StackOverflowError e) {
                      //System.out.println("Exception : "+e.getMessage());
                      continue;
                  }catch (NullPointerException e) {
                      //System.out.println("Exception : "+e.getMessage());
                      continue;
                  }


                }
            }

        return false;
    }
}
