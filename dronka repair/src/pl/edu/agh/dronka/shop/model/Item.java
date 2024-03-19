package pl.edu.agh.dronka.shop.model;

import java.util.Map;

public class Item {

	private String name;

	private Category category;

	private int price;

	private int quantity;

	private boolean secondhand;

	private boolean polish;

	public Item(String name, Category category, int price, int quantity,boolean secondhand,boolean polish) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
        this.secondhand=secondhand;
        this.polish=polish;
	}

	public Item() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setSecondhand(boolean secondhand) {
		this.secondhand = secondhand;
	}

	public boolean isSecondhand() {
		return secondhand;
	}

	public void setPolish(boolean polish) {
		this.polish = polish;
	}

	public boolean isPolish() {
		return polish;
	}
    public void putSpecialInformations(Map<String,Object> map){};
    public void getAllProperities(Map<String, Object> propertiesMap){
        propertiesMap.put("Nazwa", this.getName());
        propertiesMap.put("Cena", this.getPrice());
        propertiesMap.put("Kategoria", this.getCategory().getDisplayName());
        propertiesMap.put("Ilość", Integer.toString(this.getQuantity()));
        propertiesMap.put("Tanie bo polskie", this.isPolish());
        propertiesMap.put("Używany", this.isSecondhand());
    }
	@Override
	public String toString() {
		return getName();
	}
}
