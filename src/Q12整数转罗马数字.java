import javax.swing.text.EditorKit;
import java.util.HashMap;
import java.util.Map;

public class Q12整数转罗马数字 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");

        int carry = 1;
        while(num!=0){
            int digit = num%10;
            int realDigit = digit*carry;
            if (map.containsKey(realDigit)){
                sb.insert(0,map.get(realDigit));
            }
            else{
                if (digit<5){
                    for (int i = 0; i < digit; i++) {
                        sb.insert(0,map.get(carry));
                    }
                } else if (digit>5) {
                    int remainder = digit-5;
                    for (int i = 0; i < remainder; i++) {
                        sb.insert(0,map.get(carry));
                    }
                    sb.insert(0,map.get(5*carry));
                }
            }
            carry*=10;
            num/=10;
        }

        return sb.toString();
    }
}
