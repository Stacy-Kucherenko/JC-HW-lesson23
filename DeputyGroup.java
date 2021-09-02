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
		System.out.println("������� ������� ��������:");
		String surname = scanner.next();
		System.out.println("������� ��� ��������:");
		String name = scanner.next();
		System.out.println("������� ������� ��������:");
		int age = scanner.nextInt();
		System.out.println("������� ���� ��������:");
		int height = scanner.nextInt();
		System.out.println("������� ��� ��������:");
		int weight = scanner.nextInt();
		System.out.println("����� �� ������� ������ (true/false):");
		boolean bribeTaker = scanner.nextBoolean();
		
		return new Deputy(surname, name, age, height, weight, bribeTaker);
	};

	Supplier<Deputy> getDeputy = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������� ������� ��������:");
		String surname = scanner.next();
		System.out.println("������� ��� ��������:");
		String name = scanner.next();
		
		return new Deputy(surname, name);
	};

	public void addDeputy() {
		Deputy deputy = createDeputy.get();

		if (deputy.isBribeTaker()) {
			deputy.giveBribe();
		}

		deputyGroupArray.add(deputy);
		System.out.println("������� " + deputy.toString() + " ������� �������� �� �������!");
	}

	public void removeDeputy() {
		Deputy DeputyTyped = getDeputy.get();
		
		Predicate<Deputy> isEqualSurnameName = deputy -> deputy.getSurname().equalsIgnoreCase(DeputyTyped.getSurname()) && deputy.getName().equalsIgnoreCase(DeputyTyped.getName());
		Optional<Deputy> deputyFound = deputyGroupArray.stream().filter(isEqualSurnameName).findFirst();

		if (deputyFound.isPresent()) {
			deputyGroupArray.remove(deputyFound.get());
			System.out.println("������� " + deputyFound.get().toString() + " ������� ������ �� �������!");

		} else {
			System.out.println("���������� �������� ��� � ������ �������!");
		}
	}

	public void getBribeTakers() {
		System.out.println("�������� �������, ������� ������:");
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
			System.out.println("����� ������� ��������� ������� " + largestBribeTaker.get().toString());
		} else {
			System.out.println("� ������ ������ ����������� ���!");
		}
	}

	public void getAllDeputies() {
		System.out.println("��������, ��������� � ������ �������:");
		deputyGroupArray.forEach(System.out::println);
	}

	public void clearDeputyGroup() {
		deputyGroupArray.clear();
		System.out.println("��� �������� ���� ������� ������� �� �������!");
	}

	@Override
	public String toString() {
		return "������� \"" + deputyGroupName + "\"";
	}
	
	
}
