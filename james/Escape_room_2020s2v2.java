package james;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Escape_room_2020s2v2 {
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
                }


            boolean esacped = escaped(row,col);

            if(esacped==true && result.equals("yes") || esacped==false && result.equals("no"))
                System.out.println(fn+" passed test");
            else
                System.out.println(fn+" failed test");
            System.out.println("------------------------------------------");
        }
    }

    static boolean escaped(int r,int c){
        if(r==1 && c ==1)
            return true;

        if(tried[r-1][c-1])
            return false;

        tried[r-1][c-1] = true;

        int n = r*c;
        for(int i =0;i<row;i++)
            for(int j=0;j<col;j++){
                if(n == array[i][j])
                    if( escaped(i+1,j+1)==true)
                        return true;
                    else
                        continue;
            }
        return false;
    }
}

