public class Q11盛最多水的容器 {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if(height[left]>height[right]){
                right++;
            }
            else {
                left++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

    }
}
