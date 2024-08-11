import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q438找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abcde","bac"));

    }
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < pLen; i++) {
            ++sCount[p.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }


//        int sLen = s.length(), pLen = p.length();
//
//        if (sLen < pLen) {
//            return new ArrayList<Integer>();
//        }
//        ArrayList<Integer> ans = new ArrayList<>();
//        char[] pCharArray = p.toCharArray();
//        Arrays.sort(pCharArray);
//
//
//        for (int i = 0,j=p.length()-1; j < sLen; i++,j++) {
//            String substring = s.substring(i, j+1);
//            char[] sCharArray = substring.toCharArray();
//            Arrays.sort(sCharArray);
//            if (Arrays.equals(sCharArray,pCharArray)) {
//                ans.add(i);
//            }
//        }
//
//        return ans;
//    }
}
