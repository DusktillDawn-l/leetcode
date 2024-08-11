import java.util.HashMap;

public class Q13罗马数字转整数 {
    public static void main(String[] args) {
        String input = "MCMXCIV";
        System.out.println(romanToInt(input));
    }
    public static int romanToInt(String s) {
        int length = s.length();
        HashMap<String, Integer> numberMap = new HashMap<>();
        numberMap.put("I",1);
//        numberMap.put("IV",4);
        numberMap.put("V",5);
        numberMap.put("X",10);
//        numberMap.put("XL",40);
        numberMap.put("L",50);
//        numberMap.put("XC",90);
        numberMap.put("C",100);
//        numberMap.put("CD",400);
        numberMap.put("D",500);
//        numberMap.put("CM",900);
        numberMap.put("M",1000);

        int ans = 0;
        for (int i = 0; i < length; i++) {
            System.out.println(s.charAt(i));
            int value = numberMap.get(String.valueOf(s.charAt(i)));
            if( i+1<length && value<numberMap.get(String.valueOf(s.charAt(i+1)))){
                ans = ans-value+numberMap.get(String.valueOf(s.charAt(i+1)));
                i++;
            }
            else {
                ans+=value;
            }
        }
        return ans;

    }
}
