import java.util.ArrayList;

public class Q283移动零 {
    public static void main(String[] args) {
        int[] nums = {1,0,2,0,0,0,0,0};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
    public static void moveZeroes(int[] nums) {
        ArrayList<Integer> zeroList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroList.add(i);
            }
        }

        for (int i = 0; i < zeroList.size(); i++) {
            for (int j = i + 1; j < nums.length; j++) {
                nums[j-1] = nums[j];
            }
        }
        int zeroLength = zeroList.size();
        for(int i = nums.length-1;zeroLength>0;zeroLength--,i--){
            nums[i] = 0;
        }
    }
}
