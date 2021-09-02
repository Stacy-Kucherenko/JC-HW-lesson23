package lviv.lgs.ua.task2;

import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		Supplier<Integer> menu = () -> {
			System.out.println();
			System.out.println("¬ведите 1, чтобы добавить товар на полку");
			System.out.println("¬ведите 2, чтобы удалить товар с полки");
			System.out.println("¬ведите 3, чтобы заменить товар на полке");
			System.out.println("¬ведите 4, чтобы посортировать товары на полке по их названию");
			System.out.println("¬ведите 5, чтобы посортировать товары на полке по их длине");
			System.out.println("¬ведите 6, чтобы посортировать товары на полке по их ширине");
			System.out.println("¬ведите 7, чтобы посортировать товары на полке по их весу");
			System.out.println("¬ведите 8, чтобы вывести товар по его пор€дковому номеру размещени€ на полке");
			System.out.println("¬ведите 9, чтобы выйти из программы");

			Scanner scanner = new Scanner(System.in);
			int menuChoise = scanner.nextInt();

			return menuChoise;
		};

		Shelf shelf = new Shelf();

		while (true) {

			switch (menu.get()) {

			case 1: {
				shelf.addCommodity();
				break;
			}

			case 2: {
				shelf.removeCommodity();
				break;
			}

			case 3: {
				shelf.replaceCommodity();
				break;
			}

			case 4: {
				shelf.sortByName();
				break;
			}

			case 5: {
				shelf.sortByLength();
				break;
			}

			case 6: {
				shelf.sortByWidth();
				break;
			}

			case 7: {
				shelf.sortByWeight();
				break;
			}

			case 8: {
				shelf.getCommodity();
				break;
			}

			case 9: {
				System.exit(0);
				break;
			}

			default: {
				System.out.println("¬ведите число от 1 до 9!");
				break;
			}
			}
		}

	}
	
}
