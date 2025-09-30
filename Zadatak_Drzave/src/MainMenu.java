public enum MainMenu {
    ADD_NEW('1'),
    UPDATE_EXISTING('2'),
    DELETE('3'),
    PRINT_ALL('4'),
    QUIT('Q');

    private final char Character;

    MainMenu(char character) {
        Character = character;
    }

    public static MainMenu fromChar(char input) throws IllegalArgumentException{
        for(MainMenu m: MainMenu.values()){
            if(m.Character == input) return m;
        }
        throw new IllegalArgumentException("Invalid character in MainMenu.");
    }
}
