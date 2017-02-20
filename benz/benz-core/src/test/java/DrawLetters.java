import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
public class DrawLetters {public static void main(String []args)throws IOException{
        int[]CODE={123,127,39,94,103,99,47,91,3,28,195,7,1083,59,63,115,121,243,109,1056,31,280,1055,768,93,548};
        Map map = new HashMap<Integer,Object>();
        while (true) {
            map.clear();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            char[] letters = br.readLine().toCharArray();
            for (int i = 0; i < letters.length; i++) {
                map.put(i, decodeView(CODE[Character.toUpperCase(letters[i]) - 'A']));
            }
            draw(map);
        }
    }
     static void draw(Map map){
        for(int i=0;i<9;i++){
            for(int k=0;k<map.size();k++){
                int [][]num =(int[][])map.get(k);
                for(int j=0;j<9;j++){
                    if(num[i][j]==0){
                        System.out.print(' ');
                    }
                    else{
                        System.out.print('*');
                    }
                }
                System.out.print("       ");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            System.out.println();
        }
    }
    static int[][] decodeView(int  n){
        int [][]v = new int[9][9];
        if((n&1)==1){
            s(v,9,0,0,0,0);
        }
        if((n>>1&1) ==1){
            s(v,9,0,0,0,4);
        }
        if((n>>2&1) ==1){
            s(v,8,0,0,0,0);
        }
        if((n>>3&1) ==1){
            s(v,9,8,0,0,4);
        }
        if((n>>4&1) ==1){
            s(v,9,8,0,0,0);
        }
        if((n>>5&1) ==1){
            s(v,0,0,0,0,0);
        }
        if((n>>6&1) ==1){
            s(v,4,0,0,0,0);
        }
        if((n>>7&1) ==1){
            s(v,9,9,4,4,0);
            s(v,9,9,6,6,0);
            s(v,9,9,8,8,0);
        }
        if((n>>8&1) ==1){
            s(v,9,9,0,0,0);
            s(v,9,9,2,2,0);
            s(v,9,9,4,4,0);
            s(v,9,9,6,6,0);
            s(v,9,9,8,8,0);
        }
        if((n>>9&1) ==1){
            s(v,9,9,0,8,0);
            s(v,9,9,2,6,0);
            s(v,9,9,4,4,0);
            s(v,9,9,6,2,0);
            s(v,9,9,8,0,0);
        }
        if((n>>10&1) ==1){
            s(v,9,4,0,0,0);
            s(v,9,4,0,0,4);
        }
        return v;
    }
    // r:行 c：列 x:特征点
    static void s(int[][]n,int r,int c,int x,int y,int ys){
        if (r <9){
            for(int j=0;j<9;j++){
                n[r][j]=1;
            }
            return;
        }
        if(c<9){
            for (int i=0;i<5;i++){
                n[ys++][c]=1;
            }
            return;
        }
        n[x][y] = 1;
    }
}