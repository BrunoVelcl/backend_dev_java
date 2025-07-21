public enum FilterOptions {
    IME('1'),
    PREZIME('2');

    private final char opcija;

    FilterOptions(char opcija) {
        this.opcija = opcija;
    }

    public static FilterOptions getSelection(char  opcija) throws IllegalArgumentException{
        for(FilterOptions f : FilterOptions.values()){
            if(f.opcija == opcija){
                return f;
            }
        }
        throw new IllegalArgumentException("Nepostojeća opcija.");
    }
}
