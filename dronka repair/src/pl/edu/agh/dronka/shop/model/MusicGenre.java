package pl.edu.agh.dronka.shop.model;

public enum MusicGenre {
    ROCK("Rock"),POP("Pop"),RAP("Rap"),DISCOPOLO("Discopolo");
    private final String displayName;

    public String getDisplayName() {
        return displayName;
    }
    public static MusicGenre parseGenre(String genre){
        return (switch (genre){
            case "Rock"->MusicGenre.ROCK;
            case "Pop"->MusicGenre.POP;
            case "Discopolo"->MusicGenre.DISCOPOLO;
            case "Rap"->MusicGenre.RAP;
            default -> throw new IllegalArgumentException("Nieznany gatunek muzyczny: " + genre);
        });
    }
    private MusicGenre(String displayName) {
        this.displayName = displayName;
    }
}
