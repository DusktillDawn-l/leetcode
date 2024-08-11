import java.util.HashMap;
import java.util.HashSet;

public class Q3无重复字符的最长子串 {
    public static void main(String[] args) {
        String a = "abcabcbb";
        String b = "bbbbbb";
        String c = "pwwkew";
        System.out.println(lengthOfLongestSubstring(a));
        System.out.println(lengthOfLongestSubstring(b));
        System.out.println(lengthOfLongestSubstring(c));
    }
    public static int  lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
        /*
        效果不够好，没有足够优化
        如果出现重复了，没必要 left 直接到下一个，right 又从 left+1开始继续遍历
        left+1来跳过左边的重复元素，right 直接从上次重复的位置开始即可，绝对不会重复
         */
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int maxLength = 1;
//        int currentMaxLength = 1;
//        int left = 0;
//        int right = left + 1;
//        HashSet<Character> characters = new HashSet<>();
//        for (left = 0; left < s.length()-1; ++left) {
//            characters.add(s.charAt(left));
//            for (; right < s.length(); ++right) {
//                if(characters.contains(s.charAt(right))){
//                    ++right;
//                    break;
//                }
//                characters.add(s.charAt(right));
//                currentMaxLength++;
//            }
//            maxLength = Math.max(maxLength, currentMaxLength);
//            currentMaxLength = 1;
//            characters.clear();
//        }
//        return maxLength;
    }
}
