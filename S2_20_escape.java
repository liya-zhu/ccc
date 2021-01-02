import java.util.Scanner;

public class S2_20_escape {
    static int[][] room;
    static boolean[][] tried;
    static int m,n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt(); //#rows
        n = scan.nextInt(); //#columns

        room = new int[m][n];
        tried = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                room[i][j] = scan.nextInt();
            }
        }
        boolean x=escape(m-1,n-1);
        if (x==true) System.out.println("yes");
        else System.out.println("no");

    }
    public static boolean escape(int a, int b){ //index
        if (a==0&&b==0) return true;
        int find=(a+1)*(b+1);
        for (int i=0; i<room.length; i++) {
            for (int j=0; j<room[0].length; j++){
                if (tried[i][j]==true)
                    return false;
                if (room[i][j]==find) {
                    if (tried[i][j]==true) return false;
                    tried[i][j]=true;
                    if (escape(i,j)==true) return true;
                }
            }
        }
        return false;
    }


    /*
    public static void findfactor(int x,int[][] room){
        boolean escape=true;
        int[][] ft=new int[(int)Math.sqrt(x)][2];
        int j=0;
        int m=room.length;
        int n=room[0].length;
        boolean[][] tried=new boolean[m][n];
        tried[0][0]=true;

        for (int i=1; i<=Math.sqrt(x); i++){
            if (x%i==0){
                int f=x/i;
                if (i<=m && f<=n) {
                    ft[j][0] = i;
                    ft[j][1] = f;
                    j++;
                }
            }
        }

        for (int i=0; i<ft.length; i++){
            if (ft[i][0]!=0){
                if (ft[i][0]==m&&ft[i][0]==n){
                    escape=true;
                    break;
                }
                else if (tried[ft[i][0]][ft[i][1]]==true) return;
                else {
                    findfactor(room[ft[i][0]][ft[i][1]], room);
                    tried[ft[i][0]][ft[i][1]] = true;
                    if (ft[i][1] <= m && ft[i][0] <= n) {
                        findfactor(room[ft[i][1]][ft[i][0]], room);
                        tried[ft[i][1]][ft[i][0]] = true;
                    }
                }
            }
            return;
        }
        System.out.println(escape);
    }
     */
}
