package lviv.lgs.ua;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DeputyGroup {
	private String deputyGroupName;

	public DeputyGroup(String deputyGroupName) {
		this.deputyGroupName = deputyGroupName;
	}

	public String getDeputyGroupName() {
		return deputyGroupName;
	}

	public void setDeputyGroupName(String deputyGroupName) {
		this.deputyGroupName = deputyGroupName;
	}

	ArrayList<Deputy> deputyGroupArray = new ArrayList<Deputy>();

	Supplier<Deputy> createDeputy = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите фамилию депутата:");
		String surname = scanner.next();
		System.out.println("Введите имя депутата:");
		String name = scanner.next();
		System.out.println("Введите возраст депутата:");
		int age = scanner.nextInt();
		System.out.println("Введите рост депутата:");
		int height = scanner.nextInt();
		System.out.println("Введите вес депутата:");
		int weight = scanner.nextInt();
		System.out.println("Берет ли депутат взятки (true/false):");
		boolean bribeTaker = scanner.nextBoolean();
		
		return new Deputy(surname, name, age, height, weight, bribeTaker);
	};

	Supplier<Deputy> getDeputy = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите фамилию депутата:");
		String surname = scanner.next();
		System.out.println("Введите имя депутата:");
		String name = scanner.next();
		
		return new Deputy(surname, name);
	};

	public void addDeputy() {
		Deputy deputy = createDeputy.get();

		if (deputy.isBribeTaker()) {
			deputy.giveBribe();
		}

		deputyGroupArray.add(deputy);
		System.out.println("Депутат " + deputy.toString() + " успешно добавлен во фракцию!");
	}

	public void removeDeputy() {
		Deputy DeputyTyped = getDeputy.get();
		
		Predicate<Deputy> isEqualSurnameName = deputy -> deputy.getSurname().equalsIgnoreCase(DeputyTyped.getSurname()) && deputy.getName().equalsIgnoreCase(DeputyTyped.getName());
		Optional<Deputy> deputyFound = deputyGroupArray.stream().filter(isEqualSurnameName).findFirst();

		if (deputyFound.isPresent()) {
			deputyGroupArray.remove(deputyFound.get());
			System.out.println("Депутат " + deputyFound.get().toString() + " успешно удален из фракции!");

		} else {
			System.out.println("Введенного депутата нет в данной фракции!");
		}
	}

	public void getBribeTakers() {
		System.out.println("Депутаты фракции, берущие взятки:");
		List<Deputy> bribeTakers = deputyGroupArray.stream().filter(Deputy::isBribeTaker).collect(Collectors.toList());
		bribeTakers.forEach(System.out::println);
	}

	public void getLargestBribeTaker() {
		Comparator<Deputy> deputyBribeSizeComparator = (deputy1,
				deputy2) -> (deputy1.getBribeSize() > deputy2.getBribeSize()) ? 1
						: (deputy1.getBribeSize() == deputy2.getBribeSize()) ? 0 : -1;
		Optional<Deputy> largestBribeTaker = deputyGroupArray.stream().filter(Deputy::isBribeTaker)
				.max(deputyBribeSizeComparator);

		if (largestBribeTaker.isPresent()) {
			System.out.println("Самый большой взяточник фракции " + largestBribeTaker.get().toString());
		} else {
			System.out.println("В данной партии взяточников нет!");
		}
	}

	public void getAllDeputies() {
		System.out.println("Депутаты, состоящие в данной фракции:");
		deputyGroupArray.forEach(System.out::println);
	}

	public void clearDeputyGroup() {
		deputyGroupArray.clear();
		System.out.println("Все депутаты были успешно удалены из фракции!");
	}

	@Override
	public String toString() {
		return "Фракция \"" + deputyGroupName + "\"";
	}
	
	
}
