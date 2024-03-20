package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.Item;

import java.util.Map;

public class Books extends Item {
    private boolean hardCover;
    private int pagesNumber;

    public Books(String name, Category category, int price, int quantity,boolean secoundhand, boolean polish, boolean isHardCover, int pagesNumber) {
        super(name, category, price, quantity,secoundhand,polish);
        this.hardCover = isHardCover;
        this.pagesNumber = pagesNumber;
    }

    public Books() {
    }

    @Override
    public void setOneRest(boolean first) {
        setHardCover(first);
    }

    public void setHardCover(boolean hardCover) {
        this.hardCover = hardCover;
    }

    @Override
    public void getAllProperities(Map<String, Object> propertiesMap) {
        super.getAllProperities(propertiesMap);
        propertiesMap.put("Twarda oprawa",Boolean.toString(this.isHardCover()));
        propertiesMap.put("Liczba stron",Integer.toString(this.getPagesNumber()));
    }

    @Override
    public boolean checkRest(Item item) {
        Books book = (Books) item;
        return !this.isHardCover() || book.isHardCover();
    }

    public boolean isHardCover() {
        return hardCover;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }
}
