package ch8;

import java.util.Arrays;
import java.util.Comparator;

public class Solution04{
/*
 * Complete the function below.
 */
    //Class represent Box
    static class Box{
       public int width;
       public int length;
       public int height;
       public Box(int width,int length,int height){
            this.width = width;
            this.length = length;
            this.height = height;           
        }
    }
    
   static class WidthComparator implements Comparator<Box> { //compare the width of Box
          @Override
           public int compare(Box b1, Box b2) { 
               return b1.width > b2.width ? 1 :(b1.width == b2.width ? 0 : -1);
            } 
    }    
    static long highestStack(int[][] boxes) {
        Box [] boxArrays = new Box[boxes.length];
        int[] S = new int[boxes.length];//store the max height each box can reach
       
        for(int i = 0; i < boxes.length; i++){
            boxArrays[i] = new Box(boxes[i][0],boxes[i][1],boxes[i][2]); //create Boxes from input
        }
        WidthComparator w  = new WidthComparator(); 
        Arrays.sort(boxArrays,w);//sort the Box array by width
        S[0] = boxArrays[0].height; 
        long ans = S[0];//store the answer which means the max height of all boxes
        for(int i = 1; i < boxArrays.length; i++){
            S[i] = 0;
            //Obtain the max height from boxes which can on top of box i
            for(int j = 0; j < i;j ++){
                // if box i can on top of box j
                if( boxArrays[j].length < boxArrays[i].length&&boxArrays[j].width < boxArrays[i].width){ 
                    S[i] = Math.max(S[i],S[j]);
                }
            }
            S[i] = S[i] + boxArrays[i].height;//plus the height of itself
            if(S[i] > ans)//Obtain the overall max height
           {
               ans = S[i];
            }
        }   
        return ans;
    }
}