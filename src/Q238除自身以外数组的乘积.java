public class Q238除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] n1 = {1,2,3,4};
        System.out.println(productExceptSelf(n1));
    }
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] pre = new int[length];
        pre[0] = 1;
        int[] post = new int[length];
        post[length-1] = 1;
        for(int i = 1;i<length;i++){
            pre[i] = pre[i-1]*nums[i-1];
        }
        for(int i=length-2;i>=0;i--){
            post[i] = post[i+1]*nums[i+1];
        }
        int[] ret = new int[length];
        for(int i=0;i<length;i++){
            if(i==0)
                ret[i] = post[i];
            else if (i==length-1) {
                ret[i] = pre[i];
            }
            else {
                ret[i] = pre[i]*post[i];
            }
        }
        return ret;
    }
}
