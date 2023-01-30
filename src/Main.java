import static com.antonromanov.algorithm.leetcode.easy.t1572.matrixdiagonalsum.Solution.diagonalSum;
import static com.antonromanov.algorithm.leetcode.easy.t1672.reachestcustomer.Solution.maximumWealth;

public class Main {
    public static void main(String[] args) {

        int[][] table = {{1, 2, 3}, {4, 5, 6}, {7,8,9}};
        // int[] arr = {1, 4, 2, 5, 3};

     //   System.out.println("Ответ = " + maximumWealth(table));
        System.out.println("Ответ = " + diagonalSum(table));
    }
}