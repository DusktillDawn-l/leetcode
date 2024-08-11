public class Q14最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        int length = strs[0].length();
        int count = strs.length;
        boolean hasPrefix = true;
        int prefixLength = 0;
        for(int i=0;i<length;i++){
            char prefix = strs[0].charAt(i);
            for(int j=0;j<count;j++){
                if(strs[j].length()<=i || strs[j].charAt(i)!=prefix){
                    hasPrefix = false;
                    break;
                }
            }
            if(hasPrefix)
                prefixLength+=1;
            else{
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<prefixLength;i++){
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
