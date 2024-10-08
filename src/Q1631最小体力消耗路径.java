import java.util.LinkedList;
import java.util.Queue;

public class Q1631最小体力消耗路径 {
    public static void main(String[] args) {

    }

    public int minimumEffortPath(int[][] heights) {
        int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int m = heights.length;
        int n = heights[0].length;
        int left = 0,right = 9999,ans=0;
        while(left<=right){
            int mid = (left + right)/2;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{0,0});
            boolean[] seen = new boolean[m*n];
            seen[0] = true;
            while(!queue.isEmpty()){
                int[] cell = queue.poll();
                int x = cell[0],y = cell[1];
                for(int i = 0;i < 4;++i){
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if(nx>=0 && nx<m && ny>=0 && ny<n && !seen[nx*n+ny] && Math.abs(heights[x][y]-heights[nx][ny])<=mid){
                        queue.offer(new int[]{nx,ny});
                        seen[nx*n+ny]=true;
                    }

                }
            }
            if(seen[m*n-1]){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;

    }
}
