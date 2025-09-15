public enum Options {
    ADD('1'),
    PRINTALL('2'),
    SEARCH_BY_EMAIL('3'),
    QUIT('Q');

    private final char character;

    Options(char character){this.character = character;}

    public static Options getFromChar(char character) throws IllegalArgumentException{
        for(Options option: Options.values()){
            if(character == option.character)
                return option;
        }
        throw new IllegalArgumentException("Selection does not exist.");
    }
}
