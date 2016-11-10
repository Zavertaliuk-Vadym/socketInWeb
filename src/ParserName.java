class ParserName {
    static String parseName(String parameters) {
        int index = parameters.indexOf("=");
        index += 1;
        String result = parameters.substring(index);
        return result.isEmpty() ? " world!" : ", " + result + "=)";
    }
}