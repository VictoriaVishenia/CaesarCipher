class BruteForce {
    private static final String[] VARIETY_LIST = new String[31];
    private static String result;
    static String[] varietyList(String message) { //Receive array of results with all possible shifts

        for (int offset = 1; offset < 32; offset++) {
            CaesarCipherASCII.cipherASCII(message,offset);
            BruteForce.VARIETY_LIST[offset-1] = CaesarCipherASCII.cipherASCII(message,-offset);
        }
        return VARIETY_LIST;
    }
    static String bruteForce (String [] list) {  //From the array of variants select appropriate variant

        for (int i = 0; i < BruteForce.VARIETY_LIST.length; i++) {
            if (BruteForce.VARIETY_LIST[i].matches(".+,\s.+[!?.]")) {
                result = BruteForce.VARIETY_LIST[i];
            }
        }
        return result;
    }
}

