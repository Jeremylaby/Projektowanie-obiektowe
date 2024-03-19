package pl.edu.agh.dronka.shop.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Food extends Item{
    private Date expirationDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Food(String name, Category category, int price, int quantity, boolean secondhand, boolean polish, Date expirationDate) {
        super(name, category, price, quantity, secondhand, polish);
        this.expirationDate = expirationDate;
    }

    @Override
    public void getAllProperities(Map<String, Object> propertiesMap) {
        super.getAllProperities(propertiesMap);
        propertiesMap.put("Data ważności",dateFormat.format(getExpirationDate()));
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
