import java.util.Arrays;

public class SubmatrixProblem {
    public static void main(String[] args){

        //the max sum of the sub matrix should be 80 matrix[3][2] + matrix[4][2]
        int matrix[][] = new int[][]{
                {1,    2,   -1, -4, -20},
                {-8,  -3,    4,  2,   1},
                {-83, 40,  -10,  1,   3},
                {-4,  40,   -1,  7,  -6},
                {-4, -60,   -1,  7,  -6}};
        printMatrix(matrix);
        System.out.println("Sum of the largest submatrix: " + maxSubmatrix(matrix));

        //sum of the largest max matrix should be 151 sum of the submatrix in top left 2x3
        int matrix2[][] = new int[][]{
                {1,     2,  51,  -4,  -20},
                {60,   33,   4,  -2,   -1},
                {-83, -40, -10,  -1,   -3},
                {-4,   40,  -1,   7,   -6},
                {-4,   40,  -1,   7,   -6}};
        printMatrix(matrix);
        System.out.println("Sum of the largest submatrix: " + maxSubmatrix(matrix2));
    }
    public static void printMatrix(int[][] matrix){
        System.out.println("\noriginal matrix: ");
        for(int[] row: matrix)
            System.out.println(Arrays.toString(row));
    }

    public static int maxSubmatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //base case
        if(row == 0)
            return 0;
        //initialize the "height" variable to [0][0]
        int[][] height = new int[row][col];
        height[0] = matrix[0];
        /*
        time complexity of this is O(n^2)
         */
        for(int i = 1; i < row; ++i){
            for(int j = 0; j < col; ++j){
                height[i][j] = matrix[i][j] + height[i-1][j];
            }
        }
        /*
        time complexity of this is O(n^3) as it calls the method maxMatrix which has another for-loop
         */
        int ans = 0;
        int[] minus;
        for(int i = 0; i < row; ++i){
            for(int j = i; j < row; ++j){
                minus = new int[col];
                if(i > 0)
                    minus = height[i - 1];
                ans = Math.max(ans, maxMatrix(height[j],minus));
            }
        }
        return ans;
    }
    private static int maxMatrix(int[] heights, int[] minus){
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < heights.length; ++i){
            int h = heights[i] - minus[i];
            if(sum + h < h)
                sum = h;
            else{
                sum += h;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

/*
time complexity:    O(n^2 + n^3) =>  O(n^3)
space complexity:   O(n)
 */
