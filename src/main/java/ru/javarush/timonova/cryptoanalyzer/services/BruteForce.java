package ru.javarush.timonova.cryptoanalyzer.services;
import ru.javarush.timonova.cryptoanalyzer.constants.CypherAlphabet;

import java.util.Set;
import java.util.regex.Pattern;

public class BruteForce {

    private final static Set<String> TEST_WORDS = Set.of("доказать", "договор", "любовь", "радость");
    private BruteForce() {
    }
        public static String bruteForce(String textForDecryption) {
            int spaceIndex = CypherAlphabet.ALPHABET.indexOf(' ');
            int shift;
            for (Character c : CypherAlphabet.ALPHABET) {
                int charIndex = CypherAlphabet.ALPHABET.indexOf(c);
                shift = shiftCalculation(spaceIndex, charIndex);

                String[] words = textForDecryption.split(Pattern.quote(String.valueOf(c)));
                for (String word : words) {
                    if (TEST_WORDS.contains(shiftWord(word, shift))) {
                        return shiftWord(textForDecryption, shift);
                    }
                }
            }
            throw new RuntimeException("Brute Force failed");
        }

    private static String shiftWord(String word, int shift) {
        String result = "";

        char[] chars = word.toCharArray();
        for (char c : chars) {
            if(c == '\n') {
                result += c;
                continue;
            }
            int index = shiftCalculation(shift, CypherAlphabet.ALPHABET.indexOf(c));
            result = result + CypherAlphabet.ALPHABET.get(index);
        }
        return result;
    }

    private static int shiftCalculation(int current, int required) {
        if (required >= current) {
            return required - current;
        } else {
            return CypherAlphabet.ALPHABET.size() - current + required;
        }
    }
}

