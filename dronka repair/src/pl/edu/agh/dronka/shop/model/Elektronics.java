package pl.edu.agh.dronka.shop.model;

public class Elektronics extends Item {
    boolean mobile;
    boolean warranty;

    public Elektronics(String name, Category category, int price, int quantity, boolean secondhand, boolean polish, boolean mobile, boolean warranty) {
        super(name, category, price, quantity, secondhand, polish);
        this.mobile = mobile;
        this.warranty = warranty;
    }
}
