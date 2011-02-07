package ee.ignite.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {

	private Long id;
	private String name;
	private Integer age;
	private Address address;
	private Person manager;
	private Integer version = 1;
	private static long idSequence = 1;
	private static Map<Long, Person> allPersons = new HashMap<Long, Person>();

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static List<Person> findAllPersons() {
		return new ArrayList<Person>(allPersons.values());
	}

	public void persist() {
		version++;
		if (getId() == null) {
			this.id = idSequence++;
		}
		allPersons.put(this.getId(), this);
	}

	public static Person findEntity(Long id) {
		return allPersons.get(id);
	}

	public Integer getVersion() {
		return version;
	}
}
