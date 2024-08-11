import java.util.ArrayList;

public class Q73矩阵置零 {
    public static void main(String[] args) {

    }
    public static void setZeroes(int[][] matrix) {
        ArrayList<Integer> rowZeros = new ArrayList<>();
        ArrayList<Integer> columnZeros = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowZeros.add(i);
                    columnZeros.add(j);
                }
            }
        }

        for (int i = 0; i < rowZeros.size(); i++) {
            for(int j=0;j<matrix[0].length;j++){
                matrix[rowZeros.get(i)][j] = 0;
            }
        }

        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<columnZeros.size();j++){
                matrix[i][columnZeros.get(j)] = 0;
            }
        }



    }
}
