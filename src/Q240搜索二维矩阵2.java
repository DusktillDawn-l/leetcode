public class Q240搜索二维矩阵2 {
    public static void main(String[] args) {

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row,target);
            if(index>0)
                return true;
        }
        return false;
    }

    private static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<high) {
            int mid = (low+high)/2;
            int num = nums[mid];
            if (num == target){
                return mid;
            }
            else if (num > target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }
}

//        int row = matrix.length;
//        int col = matrix[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if(matrix[i][0]>target){
//                    return false;
//                }
//                else if(matrix[i][col-1]<target && i+1<row){
//                    ++i;
//                    j=0;
//                }
//                if(matrix[i][j]==target){
//                    return true;
//                }
//            }
//        }
//        return false;
