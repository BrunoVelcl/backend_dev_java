public enum MainMenu {
    UNOS_PROFESORA(1),
    UNOS_STUDENTA(2),
    FILTRIRANJE(3),
    ISPIS(4),
    NADJI_PO_OIBU(5),
    IZLAZ(6);

    private final int option;

    MainMenu(int option) {
        this.option = option;
    }
    
    public static MainMenu getSelection(int option) throws IllegalArgumentException{
        for(MainMenu o: MainMenu.values()){
            if(o.option == option){
                return o;
            }
        }
        throw new IllegalArgumentException("Odabrana nepostojeća opcija.");
    }
}
