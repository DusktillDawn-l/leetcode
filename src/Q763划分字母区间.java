import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q763划分字母区间 {
    public static List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        int length = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put(s.charAt(0), 0);
        for (int i = 1; i < length; i++) {
            hashMap.put(s.charAt(i), i);
        }
        List<Integer> partitions = new ArrayList<>();
        // 初始化第一个片段的结束位置和片段的长度
        int end = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            // 更新片段的结束位置
            end = Math.max(end, hashMap.get(s.charAt(i)));

            // 当到达当前片段的结束位置时
            if (i == end) {
                // 计算片段的长度并添加到结果中
                partitions.add(end - start + 1);
                // 更新下一个片段的开始位置
                start = i + 1;
            }
        }
        return partitions;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        String s1 = "eccbbbbdec";
        System.out.println(partitionLabels(s));
        System.out.println(partitionLabels(s1));
    }

}
