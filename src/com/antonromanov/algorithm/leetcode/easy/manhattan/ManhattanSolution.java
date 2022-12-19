package com.antonromanov.algorithms.some.easy.manhattan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ManhattanSolution {


    public static int nearestValidPoint(int x, int y, int[][] points) {

        ArrayList<Coord> resultList = new ArrayList<>();
        for (int xI = 0; xI < points.length; xI++) {

            if ((points[xI][0] == x) || (points[xI][1] == y)) {
                Coord localCoord = new Coord(points[xI][0], points[xI][1], xI);
                resultList.add(localCoord);
            }
        }

        if (!resultList.isEmpty()) {
            if (resultList.size() > 1) {
                return calculateManhattan(resultList, x, y);
            } else {
                return resultList.get(0).baseIndex;
            }
        } else {
            return -1;
        }
    }

    public static int calculateManhattan(ArrayList<Coord> resultList, int x, int y) {

        List<Coord> sorted = resultList.stream()
                .peek(v -> v.distanceIndex = Math.abs(x - v.coordX) + Math.abs(y - v.coordY))
                .sorted(new CoordComparator()).collect(Collectors.toList());

        int lastIndex = sorted.get(0).distanceIndex;
        if (sorted.stream().filter(v -> v.distanceIndex == lastIndex).count() > 1) {
            List<Coord> sameIndexes = sorted.stream().filter(v -> v.distanceIndex == lastIndex).collect(Collectors.toList());
            Comparator<Coord> indexComparator = Comparator.comparing(h -> h.baseIndex);
            return sameIndexes.stream().min(indexComparator).get().baseIndex;
        } else {
            return sorted.get(0).baseIndex;
        }
    }


    private static class Coord {
        public Integer coordX;
        public Integer coordY;
        public int distanceIndex;
        public int baseIndex;

        public Coord(int coordX, int coordY, int baseIndex) {
            this.coordX = coordX;
            this.coordY = coordY;
            this.baseIndex = baseIndex;
        }
    }

    public static class CoordComparator implements Comparator<Coord> {
        @Override
        public int compare(Coord first, Coord second) {
            return Integer.compare(first.distanceIndex, second.distanceIndex);
        }

    }
}
