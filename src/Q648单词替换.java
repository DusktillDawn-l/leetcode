import java.util.*;

public class Q648单词替换 {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>(Arrays.asList("cat","bat","rat","bird"));
        String sentense = "the cat was rattled by the battery";
        System.out.println(replaceWords1(dictionary,sentense));
    }

    public static String replaceWords1(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<String>();
        for (String root : dictionary) {
            dictionarySet.add(root);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (dictionarySet.contains(word.substring(0, 1 + j))) {
                    words[i] = word.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] s = sentence.split(" ");
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        int sentenceLength = s.length;
        int dictionaryLength = dictionary.size();
        for (int i = 0; i < sentenceLength; i++) {
            for (int j = 0; j < dictionaryLength; j++) {
                if (s[i].startsWith(dictionary.get(j))){
                    s[i] = dictionary.get(j);
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < sentenceLength; i++) {
            stringBuilder.append(s[i]);
            stringBuilder.append(" ");

        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
