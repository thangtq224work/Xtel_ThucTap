package javacore.BaiLam.model;

public class Student {
	private String name;
	private boolean gender;
	private String hometown;
	private int age;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, boolean gender, String hometown, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.hometown = hometown;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", hometown=" + hometown + ", age=" + age + "]";
	}

}
