import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q394字符串解码 {
    public static void main(String[] args) {
        String q1 = "15[a]2[bc]";
        String q2 = "3[a2[c]]";
        String q3 = "2[abc]3[cd]ef";
        System.out.println(decodeString(q1));

    }

    static String src;
    static int ptr;
    public static String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public static String getString(){
        if(ptr == src.length() || src.charAt(ptr) == ']'){
            return "";
        }
        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if(Character.isDigit(cur)){
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits();
            ++ptr;
            String str = getString();
            ++ptr;
            while(repTime-->0){
                ret+=str;
            }
        }
        else if(Character.isLetter(cur)){
            ret = String.valueOf(src.charAt(ptr++));
        }
        return ret + getString();
    }

    public static int getDigits(){
        int ret = 0;
        while(ptr<src.length()&&Character.isDigit(src.charAt(ptr))){
            ret = ret*10+src.charAt(ptr++)-'0';

        }
        return ret;
    }
//    public static String decodeString(String s) {
//        // 创建正则表达式Pattern对象
//        Pattern pattern = Pattern.compile("(\\d+)\\[([a-z]+)\\]");
//        // 创建matcher对象
//        Matcher matcher;
//
//        // 使用循环来查找和替换所有匹配项
//        while (s.contains("[")) {
//            matcher = pattern.matcher(s);
//            StringBuffer sb = new StringBuffer();
//
//            // 查找所有匹配，并进行替换
//            while (matcher.find()) {
//                int n = Integer.parseInt(matcher.group(1));
//                String str = matcher.group(2);
//                StringBuilder replacement = new StringBuilder();
//                for (int i = 0; i < n; i++) {
//                    replacement.append(str);
//                }
//                // 为了避免特殊字符在替换时产生问题，需要使用 quoteReplacement
//                matcher.appendReplacement(sb, Matcher.quoteReplacement(replacement.toString()));
//            }
//            matcher.appendTail(sb); // 将最后一部分拼接到结果中
//            s = sb.toString(); // 更新s为新的替换后的字符串
//        }
//        return s;
//    }
}
