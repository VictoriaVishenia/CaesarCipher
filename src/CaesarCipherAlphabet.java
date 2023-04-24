class CaesarCipherAlphabet { // Just a variant of cipher. I don't use it in this project(only opportunity)
    private static final String ALPHABET = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзиклмнопрстуфхцчшщъыьэюя,.:;!?";
    private static final char[] ALPHABET_CHAR = ALPHABET.toCharArray();
    public static String getAlphabet(){
        return ALPHABET;
    }
    public static char [] getAlphabetChar(){
        return ALPHABET_CHAR;
    }
    static String cipher(String message, int offset) {
        StringBuilder result = new StringBuilder();

        char[] messageChar = message.toCharArray();
        for (char symbal : messageChar) {
            if ((symbal != ' ') && symbal == CaesarCipherAlphabet.getAlphabetChar()[CaesarCipherAlphabet.getAlphabet().indexOf(symbal)]) {
                symbal = CaesarCipherAlphabet.getAlphabetChar()[(CaesarCipherAlphabet.getAlphabet().indexOf(symbal) + offset) %
                        CaesarCipherAlphabet.getAlphabet().length()];
                result.append(symbal);
            }  else
                result.append(symbal);
        }
        return result.toString();
    }
    static String deCipher (String message, int offset) {
        return cipher(message, CaesarCipherAlphabet.getAlphabet().length() -(offset% CaesarCipherAlphabet.getAlphabet().length()));
    }
}

