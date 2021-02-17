import java.util.Scanner;

public class S2_18_sunflowers {
    static int[][] input;
    static int[][] output;
    static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N=scan.nextInt();
        input=new int[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++) {
                input[i][j]=scan.nextInt();
            }
        }

        output=new int[N][N];
        if (inOrder()==1) rotate(1);
        else if (inOrder()==2) rotate(2);
        else if (inOrder()==3) rotate(3);

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++) {
                System.out.print(output[i][j]);
                System.out.print(" "); //maybe fix
            }
            System.out.println();
        }
    }

    public static int inOrder(){
        int x=0;
        int[] corners=new int[4];
        corners[0]=input[0][0];
        corners[1]=input[N-1][0];
        corners[2]=input[0][N-1];
        corners[3]=input[N-1][N-1];
        int min=corners[0];
        int minIndex=0;

        for (int i=1; i<4; i++){
            if (corners[i]<min) {
                min = corners[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void rotate(int index){
        if (index==1){
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++) {
                    output[i][j]=input[N-1-j][i];
                }
            }
        }
        if (index==2){
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++) {
                    output[i][j]=input[j][N-1-i];
                }
            }
        }
        if (index==3){
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++) {
                    output[i][j]=input[N-1-i][N-1-j];
                }
            }
        }
    }
}
/*
3
4 3 1
6 5 2
9 7 3
 */