import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] strs = line.trim().split(" ");

        int numTree = Integer.parseInt(strs[0]);
        int numM = Integer.parseInt(strs[1]);
        int cutted=0;
        int cutL=0;
        int[] treesL = new int[numTree];

        String linel = scan.nextLine();
        String[] strl = linel.trim().split(" ");

        for(int t=0; t<strl.length;t++){
            treesL[t] = Integer.parseInt(strl[t]);
            if(t != strl.length-1)
                if((Integer.parseInt(strl[t]))>Integer.parseInt(strl[t+1]))
                    cutL=treesL[t];
        }
        do{
            for(int i = 0; i < numTree; i++){
                cutted = cutted + (treesL[i]-cutL);
            }
            cutL=cutL-1;
        }while(cutted<numM);
        System.out.println(cutL);

    }
}