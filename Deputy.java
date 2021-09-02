package lviv.lgs.ua;

import java.util.Scanner;
import java.util.function.Supplier;

public class Deputy extends Human{
	
	private String surname;
	private String name;
	private int age;
	private boolean bribeTaker;
	private int bribeSize;

	public Deputy(String surname, String name) {
		this.surname = surname;
		this.name = name;
	}

	public Deputy(String surname, String name, int age, int height, int weight, boolean bribeTaker) {
		super(weight, height);
		this.surname = surname;
		this.name = name;
		this.age = age;
		this.bribeTaker = bribeTaker;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBribeTaker() {
		return bribeTaker;
	}

	public String bribeTakerToString() {
		if (this.bribeTaker) {
			return "взяточник";
		} else { return "честный человек";
		}
	}
	
	public void setBribeTaker(boolean bribeTaker) {
		this.bribeTaker = bribeTaker;
	}

	public int getBribeSize() {
		return bribeSize;
	}

	public void setBribeSize(int bribeSize) {
		this.bribeSize = bribeSize;
	}

	public void giveBribe() {
		if (this.bribeTaker == false) {
			System.out.println("Как Вам не стыдно! Этот депутат чеснейший человек, а Вы тут со своим конвертом!");
		}

		if (this.bribeTaker == true) {
			System.out.println("Введите сумму взятки:");
			int bribeAmount = getBribeAmount.get();
			
			if (bribeAmount > 5000) {
				System.out.println("Сотрудники НАБУ уже выезжают на задержание взяточника!");
			} else {
				this.bribeSize = bribeAmount;
			}
		}
	}

	Supplier<Integer> getBribeAmount = () -> {
		Scanner scanner = new Scanner(System.in);
		int bribeAmount = scanner.nextInt();
		
		return bribeAmount;
	};  
	
	@Override
	public String toString() {
		return surname + " " + name + ", " + age + " лет, рост " + super.getHeight() + " см, вес " + super.getWeight()
				+ " кг, " + bribeTakerToString();
	}
}
