import java.util.Arrays;

public class StringAndArray {
    public static void main (String args[]) {
//        System.out.println(CheckPermutation("god","fog"));
//        System.out.println(CheckPermutation("god","dog"));
//        System.out.println(CheckPermutationHashMap("dog","god"));
//        System.out.println(isUniqueChars("fsdfjjef"));
//        System.out.println(isUniqueCharsSort("125^$&&asdg"));
        System.out.println(isUniqueCharsBrute("125^$&assdg"));
    }

    public static boolean CheckPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String newStr1 = new String(arr1);
        String newStr2 = new String(arr2);

        if (newStr1.equals(newStr2)) {
            return true;
        }
        return false;
    }

    public static boolean CheckPermutationHashMap(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int len = str1.length();
        int[] letters = new int[128];
        for (int i=0; i< len; i++) {
            letters[str1.charAt(i)]++;
        }
        for (int i=0; i< len; i++) {
            letters[str2.charAt(i)]--;
            if (letters[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    // letters[str1.charAt(i)], str1.char seems to be coerced as int.
    // int[128] was due to ASCII code, a starting around 95 to +26, 121.
    // As array doubles the size, 128 seems like effective minimum.


    //String rotation, str1  = xy, str2 = yx,
//    yx is always a substring of str1str1 = xyxy
    public static boolean StringRotation(String str1, String str2) {
        int len = str1.length();

        if (len == str2.length() && len>0) {
            String str1str1 = str1+str1;
//            return isSubstring(str1str1, str2);
//            (assumed to be given inside the problem)
        }
        return false;
    }
    // Write method to check if given string consists of only unique chracters.
    // 1. ASCII (128) Ex ASCII (256) no unique possible if n>128 or 256
    // 2. Case sensitivty
    // 3. Can mutate string
    // 4. Hashmap complexity will be O(n) but actually O(1) or O( min(c,n)) as limited
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128)  return false;

        boolean[] charSet = new boolean[128];
        int len = str.length();
        for(int i=0; i<len; i++) {
            int value = str.charAt(i);
            if (charSet[value] == false ){
                charSet[value] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueCharsSort(String str) {
        if (str.length() > 128) return false;

        char[] arr =str.toCharArray();
        Arrays.sort(arr);
        for (int i=0; i<str.length()-1; i++) {
            if (arr[i] == arr[i+1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isUniqueCharsBrute (String str) {
        if (str.length() >128) return false;

        for (int i=0; i< str.length(); i++) {
            for (int j=i+1; j< str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) return false;
                }
            }
        return true;
    }
}
