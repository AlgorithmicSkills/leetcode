import static com.antonromanov.algorithm.leetcode.easy.t1672.reachestcustomer.Solution.maximumWealth;

public class Main {
    public static void main(String[] args) {

        int[][] table = {{1, 2, 3}, {3, 2, 9}};
        // int[] arr = {1, 4, 2, 5, 3};

        System.out.println("Ответ = " + maximumWealth(table));
    }
}