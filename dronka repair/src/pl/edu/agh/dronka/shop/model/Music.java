package pl.edu.agh.dronka.shop.model;

public class Music extends Item{
    private MusicGenre genre;
    private boolean videoAvailable;

    public Music(String name, Category category, int price, int quantity, boolean secondhand, boolean polish, MusicGenre genre, boolean videoAvailable) {
        super(name, category, price, quantity, secondhand, polish);
        this.genre = genre;
        this.videoAvailable = videoAvailable;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public boolean isVideoAvailable() {
        return videoAvailable;
    }
}
