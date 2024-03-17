package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.Item;

public class Books extends Item {
    public boolean hardCover;
    public int pagesNumber;

    public Books(String name, Category category, int price, int quantity,boolean secoundhand, boolean polish, boolean isHardCover, int pagesNumber) {
        super(name, category, price, quantity,secoundhand,polish);
        this.hardCover = isHardCover;
        this.pagesNumber = pagesNumber;
    }
}
