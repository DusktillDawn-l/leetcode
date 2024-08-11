import java.util.ArrayList;

public class Q48旋转图像 {
    public static void main(String[] args) {

    }
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int total = row*column;
        ArrayList<Integer> ans = new ArrayList<>(total);
        for(int i=column-1;i>=0;i--){
            for(int j=row-1;j>=0;j--){
                ans.add(matrix[j][i]);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                matrix[i][j] = ans.remove(0);
            }
        }

    }
}
