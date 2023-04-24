class CaesarCipherASCII {
    static String cipherASCII(String message, int offset) {

        char[] messageChar = message.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char character : messageChar) {
            if (character != ' ') {
                int ascii = (int) character;
                int newChar = ascii + offset;
                char newCharacter = (char) (newChar);
                builder.append(newCharacter);
            } else builder.append(character);
        }
        return builder.toString();
    }
    static String deCipherASCII(String message, int offset) {
        return cipherASCII(message, -offset);
    }
}

