package javacore.OOP;

/**
 *
 * @author thang
 */
public class Person {
	private String name;
	private Byte age;
	private Float weight;

	public Person(String name, Byte age, Float weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

}
