import java.util.ArrayList;
import java.util.List;

public class Q902最大为N的数字组合 {
    static List<String> strList = new ArrayList<>();
    public static void main(String[] args) {
        String[] str1 = {"1", "3", "5", "7"};
        String[] str2 = {"1", "4", "9"};
        String[] str3 = {"7"};
//        System.out.println(atMostNGivenDigitSet(str1,100));
        System.out.println(atMostNGivenDigitSet(str2,1000000000));
//        System.out.println(atMostNGivenDigitSet(str3,8));
    }
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        for (int i = 0; i < digits.length; i++) {
            if (Integer.parseInt(digits[i])<n)
                strList.add(digits[i]);
        }
        boolean smaller = true;
        while(smaller){
            ArrayList<String> newStrList = new ArrayList<>();
            for (String digit : digits) {
                for (String s : strList) {
                    StringBuilder sb = new StringBuilder(s);
                    sb.insert(0,digit);
                    String newStr = sb.toString();
                    if (Long.parseLong(newStr)>n)
                        smaller = false;
                    else if(!strList.contains(newStr))
                        newStrList.add(newStr);
                }

            }
            strList.addAll(newStrList);
            newStrList.clear();
        }
        return strList.size();
    }
}
