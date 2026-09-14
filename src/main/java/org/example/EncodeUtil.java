package org.example;

public class EncodeUtil {
    /**
     * Encodes the input string
     * Output will list each character followed by the number of consecutive occurrences.
     * As no requirement for being able to decode the value exists, digits will have a 'dg' added before them.
     * having 2 consecutive non-digit characters make it easy for decoding the content - no requirement just for hashing.
     * This is so the decode value can be recreated. If decoding is not wanted we can change the algorithm.
     *
     * @param input the string used for encoding
     * @return the encoded value
     */
    public static String encode(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= input.length(); i++) {
            if (i < input.length() && input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                char character = input.charAt(i - 1);
                // in case number is a digit, append 'dg' so it can be decoded later
                if (Character.isDigit(character)) {
                    output.append("dg");
                }
                output.append(character);
                output.append(count);
                count = 1;
            }
        }

        return output.toString();
    }
}
