import java.util.HashMap;

public class SmallestSubString {
    // __define-ocg__
    public static String StringChallenge(String[] strArr) {
        String N = strArr[0];
        String K = strArr[1];
        String varOcg = "";

        // Create a hashmap to store character frequencies of K
        HashMap<Character, Integer> charFreqK = new HashMap<>();
        for (int i = 0; i < K.length(); i++) {
            char charK = K.charAt(i);
            charFreqK.put(charK, charFreqK.getOrDefault(charK, 0) + 1);
        }

        // Create a hashmap to store character frequencies of the current substring
        HashMap<Character, Integer> charFreqSubstr = new HashMap<>();
        int leftPtr = 0;
        int foundChars = 0;

        // Sliding window technique to find the smallest substring
        for (int rightPtr = 0; rightPtr < N.length(); rightPtr++) {
            char charRight = N.charAt(rightPtr);
            charFreqSubstr.put(charRight, charFreqSubstr.getOrDefault(charRight, 0) + 1);

            // Check if the current character is in K and its frequency in substring matches its frequency in K
            if (charFreqK.containsKey(charRight) && charFreqSubstr.get(charRight) <= charFreqK.get(charRight)) {
                foundChars++;
            }

            // If all characters in K are found in the substring
            while (foundChars == K.length()) {
                String currentSubstring = N.substring(leftPtr, rightPtr + 1);

                // Update the minimum substring
                if (varOcg.isEmpty() || currentSubstring.length() < varOcg.length()) {
                    varOcg = currentSubstring;
                }

                char charLeft = N.charAt(leftPtr);
                charFreqSubstr.put(charLeft, charFreqSubstr.get(charLeft) - 1);

                // If the removed character is in K and its frequency in substring becomes less than its frequency in K
                if (charFreqK.containsKey(charLeft) && charFreqSubstr.get(charLeft) < charFreqK.get(charLeft)) {
                    foundChars--;
                }

                leftPtr++;
            }
        }

        return varOcg;
    }

    public static void main(String[] args) {
        // Test the function
        System.out.println(StringChallenge(new String[]{"aaabaaddae", "aed"})); // Output: "dae"
    }
}

