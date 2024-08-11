import java.util.Arrays;

public class Q43rain {
    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
//        System.out.println(Arrays.toString(height));
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            if(height[i]>left[i-1]){
                left[i] = height[i];
            }
            else{
                left[i] = left[i-1];
            }
        }
        for(int j=n-2;j>=0;j--){
            right[j] = Math.max(height[j],right[j+1]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for(int i=0;i<n;i++){
            ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
}
