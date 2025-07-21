public enum Titula {
    STUDENT("Student"),
    PROFESOR("Profesor");

    private final String titula;

    Titula(String titula){
        this.titula = titula;
    }

    public static Titula fromText(String text) throws IllegalArgumentException{
        for(Titula t : Titula.values()){
            if(t.titula.equals(text)){
                return t;
            }
        }
        throw new IllegalArgumentException("Titula ne postoji.");
    }


    @Override
    public String toString() {
        return this.titula;
    }
}
