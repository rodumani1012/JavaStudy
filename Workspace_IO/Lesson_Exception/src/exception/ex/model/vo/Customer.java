package exception.ex.model.vo;

public class Customer {
	private String name;
	private int age;
	private char gender;
	private String grade;
	
	public Customer() {
		
	}
	
	public Customer(String name, int age, char gender, String grade) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.grade = grade;
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

	public char getGender() {
		return gender;
	}

	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 나이: " + age + ", 성별: " + gender + ", 등급: " + grade + ", 입장료: " + KHBar.PRICE + " 원";
	}
	
}
