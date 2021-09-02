package lviv.lgs.ua;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupremeCouncil  {
	
	
	private static SupremeCouncil instance = new SupremeCouncil();

	private SupremeCouncil() {
	}

	public static SupremeCouncil getInstance() {
		if (instance == null) {
			instance = new SupremeCouncil();
		}

		return instance;
	}

	ArrayList<DeputyGroup> supremeCouncilArray = new ArrayList<DeputyGroup>();

	Supplier<DeputyGroup> getDeputyGroup = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите название фракции:");
		String deputyGroupName = scanner.next();

		return new DeputyGroup(deputyGroupName);
	};

	public Optional<DeputyGroup> findDeputyGroup() {
		DeputyGroup DeputyGroupTyped = getDeputyGroup.get();

		Predicate<DeputyGroup> isEqualDeputyGroupName = deputyGroup -> deputyGroup.getDeputyGroupName().equalsIgnoreCase(DeputyGroupTyped.getDeputyGroupName());
		Optional<DeputyGroup> deputyGroupFound = supremeCouncilArray.stream().filter(isEqualDeputyGroupName).findFirst();

		return deputyGroupFound;
	}

	public void addDeputyGroup() {
		DeputyGroup deputyGroup = getDeputyGroup.get();

		supremeCouncilArray.add(deputyGroup);
		System.out.println(deputyGroup.toString() + " успешно добавлена в Верховну Раду!");
	}

	public void removeDeputyGroup() {
		Optional<DeputyGroup> deputyGroupFound = findDeputyGroup();

		if (deputyGroupFound.isPresent()) {
			supremeCouncilArray.remove(deputyGroupFound.get());
			System.out.println(deputyGroupFound.get().toString() + " успешно удалена из Верховной Рады!");
		} else {
			System.out.println("Введенной фракции в Верховной Раде нет!");
		}
	}

	public void getAllDeputyGroups() {
		System.out.println("Фракции, зарегистрированные в Верхоной Раде:");
		supremeCouncilArray.forEach(System.out::println);
	}

	public void clearDeputyGroup() {
		Optional<DeputyGroup> deputyGroupFound = findDeputyGroup();

		if (deputyGroupFound.isPresent()) {
			deputyGroupFound.get().clearDeputyGroup();
		} else {
			System.out.println("Введенной фракции в Верховной Раде нет!");
		}
	}

	public void getDeputyGroup() {
		Optional<DeputyGroup> deputyGroupFound = findDeputyGroup();

		if (deputyGroupFound.isPresent()) {
			System.out.println(deputyGroupFound.get().toString());
			deputyGroupFound.get().getAllDeputies();
		} else {
			System.out.println("Введенной фракции в Верховной Раде нет!");
		}
	}

	public void addDeputyToDeputyGroup() {
		Optional<DeputyGroup> deputyGroupFound = findDeputyGroup();

		if (deputyGroupFound.isPresent()) {
			deputyGroupFound.get().addDeputy();
		} else {
			System.out.println("Введенной фракции в Верховной Раде нет!");
		}
	}

	public void removeDeputyFromDeputyGroup() {
		Optional<DeputyGroup> deputyGroupFound = findDeputyGroup();

		if (deputyGroupFound.isPresent()) {
			deputyGroupFound.get().removeDeputy();
		} else {
			System.out.println("Введенной фракции в Верховной Раде нет!");
		}
	}

	public void getBribeTakersFromDeputyGroup() {
		Optional<DeputyGroup> deputyGroupFound = findDeputyGroup();

		if (deputyGroupFound.isPresent()) {
			deputyGroupFound.get().getBribeTakers();
		} else {
			System.out.println("Введенной фракции в Верховной Раде нет!");
		}
	}

	public void getLargestBribeTakerFromDeputyGroup() {
		Optional<DeputyGroup> deputyGroupFound = findDeputyGroup();

		if (deputyGroupFound.isPresent()) {
			deputyGroupFound.get().getLargestBribeTaker();
		} else {
			System.out.println("Введенной фракции в Верховной Раде нет!");
		}
	}

	public void getAllDeputiesFromDeputyGroup() {
		Optional<DeputyGroup> deputyGroupFound = findDeputyGroup();

		if (deputyGroupFound.isPresent()) {
			deputyGroupFound.get().getAllDeputies();
		} else {
			System.out.println("Введенной фракции в Верховной Раде нет!");
		}
	}

}
