package com.antonromanov.algorithm.leetcode.easy.t1232.checkstraightline;

public class CheckStraightLine2 {
    public boolean checkStraightLine(int[][] coordinates) {

         for (int row = 0; row <= coordinates.length-2; row++) {

             int x1 = coordinates[row][0];
             int x2 = coordinates[row+1][0];
             int x3 = coordinates[row+2][0];

             int y1 = coordinates[row][1];
             int y2 = coordinates[row+1][1];
             int y3 = coordinates[row+2][1];

             double S1 = (double) (((x1 - x3) * (y2 - y3)) - ((x2 - x3) * (y1 - y3))) / 2;

             if (S1 == 0.0){
                 if (coordinates.length-(row+2)>2){
                     row = row+1;
                 }
             } else {
                 System.out.println("false = " + S1);
                 return false;
             }

             System.out.println("s = " + S1);


         }

        return true;
    }
}
