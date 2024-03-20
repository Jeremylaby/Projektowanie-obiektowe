package pl.edu.agh.dronka.shop.model;

import java.util.Map;

public class Music extends Item{
    private MusicGenre genre;
    private boolean videoAvailable;

    public Music(String name, Category category, int price, int quantity, boolean secondhand, boolean polish, MusicGenre genre, boolean videoAvailable) {
        super(name, category, price, quantity, secondhand, polish);
        this.genre = genre;
        this.videoAvailable = videoAvailable;
    }

    public Music() {

    }

    @Override
    public void setOneRest(boolean first) {
        setVideoAvailable(first);
    }

    public MusicGenre getGenre() {
        return genre;
    }

    @Override
    public void getAllProperities(Map<String, Object> propertiesMap) {
        super.getAllProperities(propertiesMap);
        propertiesMap.put("Gatunek muzyczny",getGenre().getDisplayName());
        propertiesMap.put("Dostępność video",Boolean.toString(isVideoAvailable()));
    }

    @Override
    public boolean checkRest(Item item) {
        Music music = (Music) item;
        return !this.isVideoAvailable() || music.isVideoAvailable();
    }

    public void setVideoAvailable(boolean videoAvailable) {
        this.videoAvailable = videoAvailable;
    }

    public boolean isVideoAvailable() {
        return videoAvailable;
    }
}
