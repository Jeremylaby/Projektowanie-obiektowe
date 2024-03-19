package pl.edu.agh.dronka.shop.model.provider;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.edu.agh.dronka.shop.model.*;

public class ShopProvider {

	public static Shop getExampleShop() {
		Shop shop = new Shop();

		shop.addUser(getExampleUser());

		Index itemsIndex = new Index();

		for (Item item : getExampleItems()) {
			itemsIndex.addItem(item);
		}

		registerExampleCategories(itemsIndex);
		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<Item> getExampleItems() {
		List<Item> items = new ArrayList<>();

		CSVReader booksReader = new CSVReader("resources/books.csv");
		items.addAll(readItems(booksReader, Category.BOOKS));
		
		CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
		items.addAll(readItems(electronicsReader, Category.ELECTRONICS));
		
		CSVReader foodReader = new CSVReader("resources/food.csv");
		items.addAll(readItems(foodReader, Category.FOOD));
		
		CSVReader musicReader = new CSVReader("resources/music.csv");
		items.addAll(readItems(musicReader, Category.MUSIC));
		
		CSVReader sportReader = new CSVReader("resources/sport.csv");
		items.addAll(readItems(sportReader, Category.SPORT));

		return items;
	}

	public static void registerExampleCategories(Index index) {
		for (Category category : Category.values()) {
			index.registerCategory(category);
		}
	}

	private static List<Item> readItems(CSVReader reader, Category category) {
		List<Item> items = new ArrayList<>();

		try {
			reader.parse();
			List<String[]> data = reader.getData();

			for (String[] dataLine : data) {
	
				String name = reader.getValue(dataLine,"Nazwa");
				int price = Integer.parseInt(reader.getValue(dataLine, "Cena"));
				int quantity = Integer.parseInt(reader.getValue(dataLine,
						"Ilość"));

				boolean isPolish = Boolean.parseBoolean(reader.getValue(
						dataLine, "Tanie bo polskie"));
				boolean isSecondhand = Boolean.parseBoolean(reader.getValue(
						dataLine, "Używany"));
                switch (category){
                    case BOOKS :
                        boolean hardcover = Boolean.parseBoolean(reader.getValue(dataLine,"Twarda oprawa"));
                        int pagesnumber = Integer.parseInt(reader.getValue(dataLine,
                                "Liczba stron"));
                        Books book = new Books(name,category,price,quantity,isSecondhand,isPolish,hardcover,pagesnumber);
                        items.add(book);
                        break;
                    case ELECTRONICS :
                        boolean ismobile = Boolean.parseBoolean(reader.getValue(dataLine,"Mobilny"));
                        boolean iswarranty = Boolean.parseBoolean(reader.getValue(dataLine,"Gwarancja"));
                        Elektronics elektronic=new Elektronics(name,category,price,quantity,isSecondhand,isPolish,ismobile,iswarranty);
                        items.add(elektronic);
                        break;
                    case FOOD:
                        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            Date date = dataFormat.parse(reader.getValue(dataLine,"Data ważności"));
                            Food food = new Food(name,category,price,quantity,isSecondhand,isPolish,date);
                            items.add(food);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case MUSIC:
                        String genre = reader.getValue(dataLine,"Gatunek muzyczny");
                        MusicGenre musicGenre = MusicGenre.parseGenre(genre);
                        Boolean isVideoAveilable = Boolean.parseBoolean(reader.getValue(dataLine,"Dostępność video"));
                        Music music = new Music(name,category,price,quantity,isSecondhand,isPolish,musicGenre,isVideoAveilable);
                        items.add(music);
                        break;
                    case SPORT:
                        Item item = new Item(name, category, price, quantity,isSecondhand,isPolish);
                        items.add(item);
                        break;


                }


			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}

}
