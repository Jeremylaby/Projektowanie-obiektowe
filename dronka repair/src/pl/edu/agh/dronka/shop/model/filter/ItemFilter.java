package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.*;

public class ItemFilter {

	private Item itemSpec = new Item();
    public void setItem(Category category){
        switch (category){
            case MUSIC -> itemSpec=new Music();
            case BOOKS -> itemSpec=new Books();
            case FOOD, SPORT -> itemSpec=new Item();
            case ELECTRONICS -> itemSpec=new Elektronics();
        }
        itemSpec.setCategory(category);
    }
	public Item getItemSpec() {
		return itemSpec;
	}
	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		return itemSpec.checkRest(item);
	}

}