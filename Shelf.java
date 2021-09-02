package lviv.lgs.ua.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Shelf {
	ArrayList<Commodity> shelf = new ArrayList<Commodity>();

	Supplier<Commodity> getCommodity = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¬ведите название товара:");
		String name = scanner.next();
		System.out.println("¬ведите длинну товара, см:");
		int length = scanner.nextInt();
		System.out.println("¬ведите ширину товара, см:");
		int width = scanner.nextInt();
		System.out.println("¬ведите вес товара, г:");
		int weight = scanner.nextInt();

		return new Commodity(name, length, width, weight);
	};

	public Optional<Commodity> findCommodity() {
		Commodity commodityTyped = getCommodity.get();

		Predicate<Commodity> isEqual = commodity -> commodity.getName().equalsIgnoreCase(commodityTyped.getName())
				&& commodity.getLength() == commodityTyped.getLength()
				&& commodity.getWidth() == commodityTyped.getWidth()
				&& commodity.getWeight() == commodityTyped.getWeight();
		Optional<Commodity> commodityFound = shelf.stream().filter(isEqual).findFirst();

		return commodityFound;
	}

	public void addCommodity() {
		Commodity commodity = getCommodity.get();

		shelf.add(commodity);
		System.out.println("“овар " + commodity.toString() + " успешно добавлен на полку!");
	}

	public void removeCommodity() {
		Optional<Commodity> commodityFound = findCommodity();

		if (commodityFound.isPresent()) {
			shelf.remove(commodityFound.get());
			System.out.println("“овар " + commodityFound.get().toString() + " успешно удален с полки!");
		} else {
			System.out.println("¬веденного товара нет на полке!");
		}
	}

	public void replaceCommodity() {
		Optional<Commodity> commodityFound = findCommodity();

		if (commodityFound.isPresent()) {
			System.out.println("¬ведите товар дл€ замены:");
			Commodity newCommodityTyped = getCommodity.get();

			commodityFound.get().setName(newCommodityTyped.getName());
			commodityFound.get().setLength(newCommodityTyped.getLength());
			commodityFound.get().setWidth(newCommodityTyped.getWidth());
			commodityFound.get().setWeight(newCommodityTyped.getWeight());

			System.out.println("¬веденный товар успешно заменен на " + commodityFound.get().toString() + "!");
		} else {
			System.out.println("¬веденного товара нет на полке!");
		}
	}

	public void sortByName() {
		System.out.println("ƒо сортировки товары располагались на полке в таком пор€дке:");
		shelf.forEach(System.out::println);

		System.out.println("ѕосле сортировки пор€док расположени€ товаров на полке будет следующим:");
		shelf.stream().sorted(Comparator.comparing(Commodity::getName)).forEach(System.out::println);
	}

	public void sortByLength() {
		System.out.println("ƒо сортировки товары располагались на полке в таком пор€дке:");
		shelf.forEach(System.out::println);

		System.out.println("ѕосле сортировки пор€док расположени€ товаров на полке будет следующим:");
		shelf.stream().sorted(Comparator.comparing(Commodity::getLength)).forEach(System.out::println);
	}

	public void sortByWidth() {
		System.out.println("ƒо сортировки товары располагались на полке в таком пор€дке:");
		shelf.forEach(System.out::println);
		
		System.out.println("ѕосле сортировки пор€док расположени€ товаров на полке будет следующим:");
		shelf.stream().sorted(Comparator.comparing(Commodity::getWidth)).forEach(System.out::println);
	}

	public void sortByWeight() {
		System.out.println("ƒо сортировки товары располагались на полке в таком пор€дке:");
		shelf.forEach(System.out::println);

		System.out.println("ѕосле сортировки пор€док расположени€ товаров на полке будет следующим:");
		shelf.stream().sorted(Comparator.comparing(Commodity::getWeight)).forEach(System.out::println);
	}

	public void getCommodity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¬ведите пор€дковый номер товара на полке:");
		int i = scanner.nextInt();

		if (i < 0 || i > (shelf.size() - 1)) {
			System.out.println("“овара с таким пор€дковым номером нет на полке!");
		} else {
			System.out.println("ѕод пор€дковым номером " + i + " на полке находитс€ " + shelf.get(i).toString());
		}
	}
}
