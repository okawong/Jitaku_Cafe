package com.okawong.restuarant.dish;

public class Dish {
	private String name;
	private Double price;
	private String description;
	private String category;
	private String tags;
	private Integer id;

	public Dish(String name, Double price) {
		this(name, price, "", "", "");
	}

	public Dish(String name, Double price, String description, String category, String tags) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
