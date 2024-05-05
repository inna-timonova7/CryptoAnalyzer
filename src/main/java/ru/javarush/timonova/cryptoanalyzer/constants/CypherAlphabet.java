package ru.javarush.timonova.cryptoanalyzer.constants;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CypherAlphabet {
    private static final char[] ALPHABET_RU_LETTERS_LOWER_CASE = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
            'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я',
    };

    private static final char[] ALPHABET_RU_LETTERS_UPPER_CASE = {
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р',
            'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ь', 'Ы', 'Ь', 'Э', 'Ю', 'Я',
    };

    private static final char[] ALPHABET_DIGITS = {
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
    };

    private static final char[] ALPHABET_PUNCTUATION = {
            ' ', '.', ',', '!', '?', ':', ';', '*', '<', '>',
            '@', '#', '№', '$', '^', '&', '(', ')', '_', '-',
            '+', '=', '\'', '|', '{', '}',
    };

    public static final char[] CYPHER_ALPHABET;

    static {
    int length = ALPHABET_RU_LETTERS_LOWER_CASE.length + ALPHABET_RU_LETTERS_LOWER_CASE.length + ALPHABET_DIGITS.length + ALPHABET_PUNCTUATION.length;
    CYPHER_ALPHABET = new char[length];
    }
    public int getAlphabetLength() {
        return CYPHER_ALPHABET.length;
    }
}
