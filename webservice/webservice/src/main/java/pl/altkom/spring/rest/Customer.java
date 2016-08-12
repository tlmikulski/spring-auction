package pl.altkom.spring.rest;

public class Customer {
	private String name;
	private Long id;

	public Customer(Long id) {
		this.setId(id);
		this.name = "Jan Nowak";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
