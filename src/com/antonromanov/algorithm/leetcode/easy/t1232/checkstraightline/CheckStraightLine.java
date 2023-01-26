package com.antonromanov.algorithm.leetcode.easy.t1232.checkstraightline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CheckStraightLine {

    class Coord {
        private int x;
        private int y;
        private boolean checkable;

        public Coord(int x, int y, boolean checkable) {
            this.x = x;
            this.y = y;
            this.checkable = checkable;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setCheckable(boolean checkable) {
            this.checkable = checkable;
        }
    }

    public boolean checkStraightLine(int[][] coordinates) {

        List<Coord> list = new ArrayList<>();

        for (int row = 0; row < coordinates.length; row++) {
            if (row < 2) {
                list.add(new Coord(coordinates[row][0], coordinates[row][1], false));
            } else {
                list.add(new Coord(coordinates[row][0], coordinates[row][1], false));
            }
        }

        list.sort(Comparator.comparing(Coord::getX)
                .thenComparing(Coord::getY));

        list.get(0).setCheckable(true);
        list.get(1).setCheckable(true);

        int displacementX = 0;
        int displacementY = 0;

        displacementX = list.get(1).getX() - list.get(0).getX();
        displacementY = list.get(1).getY() - list.get(0).getY();

        Integer prevX = null;
        Integer prevY = null;
        for (Coord coord : list) {
            System.out.println("coordinates[" + coord.getX() + "][" + coord.getY() + "]");
            if (!coord.checkable) {
                if (prevX != null && prevY != null) {
                    int currentDispX = coord.getX() - prevX;
                    int currentDispY = coord.getY() - prevY;
                    if (currentDispX != 0 || currentDispY != 0) {
                        if (currentDispX != displacementX || currentDispY != displacementY) {
                            System.out.println("false");
                            return false;
                        }
                    }
                }
            }
            prevX = coord.getX();
            prevY = coord.getY();
        }


        /*for (int row = 2; row < coordinates.length; row++) {
            for (int col = 0; col < coordinates[row].length; col++) {

                System.out.println("coordinates[" + row + "][" + col + "] = " + coordinates[row][col]);

                if (coordinates[row][col]-coordinates[row-1][col] != displacementX){
                    System.out.println("false");
                    System.out.println("coordinates["+row+"]["+col+"]-coordinates["+(row-1)+"]["+col+"] != "+displacementX+"");
                    return false;
                 }
            }
        }*/

        return true;
    }
}
