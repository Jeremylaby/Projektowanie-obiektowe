package pl.edu.agh.dronka.shop.model;

import javax.swing.*;
import java.util.Map;

public class Elektronics extends Item {
    private boolean mobile;
    private boolean warranty;

    public Elektronics(String name, Category category, int price, int quantity, boolean secondhand, boolean polish, boolean mobile, boolean warranty) {
        super(name, category, price, quantity, secondhand, polish);
        this.mobile = mobile;
        this.warranty = warranty;
    }

    @Override
    public void getAllProperities(Map<String, Object> propertiesMap) {
        super.getAllProperities(propertiesMap);
        propertiesMap.put("Mobilny",Boolean.toString(isMobile()));
        propertiesMap.put("Gwarancja", Boolean.toString(isWarranty()));
    }

    public boolean isMobile() {
        return mobile;
    }

    public boolean isWarranty() {
        return warranty;
    }
}
