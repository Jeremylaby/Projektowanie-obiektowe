package pl.edu.agh.dronka.shop.model;

import java.util.Map;

public class Elektronics extends Item {
    private boolean mobile;
    private boolean warranty;

    public Elektronics(String name, Category category, int price, int quantity, boolean secondhand, boolean polish, boolean mobile, boolean warranty) {
        super(name, category, price, quantity, secondhand, polish);
        this.mobile = mobile;
        this.warranty = warranty;
    }

    public Elektronics() {
    }

    @Override
    public void setRest(boolean first, boolean second) {
        if (second) {
            setMobile(first);
        } else {
            setWarranty(first);
        }
    }

    @Override
    public void getAllProperities(Map<String, Object> propertiesMap) {
        super.getAllProperities(propertiesMap);
        propertiesMap.put("Mobilny",Boolean.toString(isMobile()));
        propertiesMap.put("Gwarancja", Boolean.toString(isWarranty()));
    }

    @Override
    public boolean checkRest(Item item) {
        Elektronics elektronics = (Elektronics) item;
        if (this.isWarranty() && !elektronics.isWarranty()) {
            return false;
        }
        if (this.isMobile() && !elektronics.isMobile()) {
            return false;
        }
        return true;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public boolean isMobile() {
        return mobile;
    }

    public boolean isWarranty() {
        return warranty;
    }
}
