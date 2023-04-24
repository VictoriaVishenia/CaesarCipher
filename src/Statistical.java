import java.util.TreeMap;
import java.util.Map;
class Statistical {
    static int offset; //
    private static TreeMap<Double, Character> DISTRIBUTION_LETTERS = new TreeMap<>();
    // Frequencies of using letters of alphabet
    private static TreeMap<Character, Integer> DISTRIBUTION_MESSAGE = new TreeMap<>();
    // Frequencies of using letters in coded message
    static TreeMap<Double, Character> fillMap() {

        // Fill map with key - frequency of using letters and value - letters

        DISTRIBUTION_LETTERS.put(8.01, 'а');
        DISTRIBUTION_LETTERS.put(1.59, 'б');
        DISTRIBUTION_LETTERS.put(4.54, 'в');
        DISTRIBUTION_LETTERS.put(1.70, 'г');
        DISTRIBUTION_LETTERS.put(2.98, 'д');
        DISTRIBUTION_LETTERS.put(8.45, 'е');
        DISTRIBUTION_LETTERS.put(0.041, 'ё');
        DISTRIBUTION_LETTERS.put(0.94, 'ж');
        DISTRIBUTION_LETTERS.put(1.65, 'з');
        DISTRIBUTION_LETTERS.put(7.35, 'и');
        DISTRIBUTION_LETTERS.put(1.21, 'й');
        DISTRIBUTION_LETTERS.put(3.49, 'к');
        DISTRIBUTION_LETTERS.put(4.40, 'л');
        DISTRIBUTION_LETTERS.put(3.21, 'м');
        DISTRIBUTION_LETTERS.put(6.70, 'н');
        DISTRIBUTION_LETTERS.put(10.97, 'о');
        DISTRIBUTION_LETTERS.put(2.81, 'п');
        DISTRIBUTION_LETTERS.put(4.73, 'р');
        DISTRIBUTION_LETTERS.put(5.47, 'с');
        DISTRIBUTION_LETTERS.put(6.26, 'т');
        DISTRIBUTION_LETTERS.put(2.62, 'у');
        DISTRIBUTION_LETTERS.put(0.26, 'ф');
        DISTRIBUTION_LETTERS.put(0.97, 'х');
        DISTRIBUTION_LETTERS.put(0.48, 'ц');
        DISTRIBUTION_LETTERS.put(1.44, 'ч');
        DISTRIBUTION_LETTERS.put(0.73, 'ш');
        DISTRIBUTION_LETTERS.put(0.36, 'щ');
        DISTRIBUTION_LETTERS.put(0.04, 'ъ');
        DISTRIBUTION_LETTERS.put(1.90, 'ы');
        DISTRIBUTION_LETTERS.put(1.74, 'ь');
        DISTRIBUTION_LETTERS.put(0.32, 'э');
        DISTRIBUTION_LETTERS.put(0.64, 'ю');
        DISTRIBUTION_LETTERS.put(2.01, 'я');

        return DISTRIBUTION_LETTERS;
    }
    static TreeMap<Character, Integer> findFrequencyInMessage(String message) {
        // Fill TreeMap with key - letters and value - it's frequency in encoded message
        char[] messageChar = message.toCharArray();

        for (char character : messageChar) {
            int count = 1;
            for (int i = 1; i < messageChar.length; i++) {
                if (character == messageChar[i]) {
                    count++;
                }
            }
            DISTRIBUTION_MESSAGE.put(character, count);
        }
        return DISTRIBUTION_MESSAGE;
    }
    static Character popularLetterInMessage(TreeMap<Character, Integer> distributionMessage) {
        /* Find the most popular letter in encoded message
        Delete all empty spaces, because it is the most popular, but we don't need it */

        distributionMessage.remove(' '); //

        Map.Entry<Character, Integer> maxEntry = null;
        for (Map.Entry<Character, Integer> entry : distributionMessage.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }
    static int findOffset(char a, char b) {
        //find offset between the most popular letter in our message and the most popular letter in the alphabet

        a = DISTRIBUTION_LETTERS.get(DISTRIBUTION_LETTERS.lastKey()); //the most popular letter in the alphabet
        b = popularLetterInMessage(DISTRIBUTION_MESSAGE); // the most popular letter in coded text

        int numA = (int) a;
        int numB = (int) b;

        offset = numB - numA;
        return offset;
    }
    static String statisticalDeCipher (String message) {
        DISTRIBUTION_MESSAGE = findFrequencyInMessage(message);
        DISTRIBUTION_LETTERS = fillMap();
        int  offset = findOffset(popularLetterInMessage(DISTRIBUTION_MESSAGE), DISTRIBUTION_LETTERS.get(DISTRIBUTION_LETTERS.lastKey()));
        return CaesarCipherASCII.cipherASCII(message, - offset);
    }
}

