public class Q58最后一个单词的长度 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));

    }
    public static int lengthOfLastWord(String s) {
        int length = s.length();
        int count = 0;
        for(int i=length-1;i>=0;i--){
            if(s.charAt(i)==' '&& count!=0)
                break;
            else if (s.charAt(i)!=' ') {
                count++;
            }
        }
        return count;
    }
}
