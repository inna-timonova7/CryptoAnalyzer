package ru.javarush.timonova.cryptoanalyzer.constants;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CypherAlphabet {
    public static final char[] CYPHER_ALPHABET = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
            'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В',
            'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К',
            'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ь',
            'Э', 'Ю', 'Я', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', '0', ' ', '.', ',', '!', '?',
            ':', ';', '*', '<', '>', '@', '#', '№', '$',
            '^', '&', '(', ')', '_', '-', '+', '=', '\'',
            '|', '{', '}',
    };

    public int getAlphabetLength() {
        return CYPHER_ALPHABET.length;
    }
}