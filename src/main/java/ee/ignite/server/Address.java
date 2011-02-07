package ee.ignite.server;

public class Address {

	private Long id;
	private Integer version = 1;
	private String city;
	private String street;

	public Address() {
	}

	public Address(Long id, String city, String street) {
		this.id = id;
		this.city = city;
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getId() {
		return id;
	}

	public static Address findEntity(Long id) {
		return new Address(id, "City nr. " + id, "Street nr. " + id);
	}

	public Integer getVersion() {
		return version;
	}
}
