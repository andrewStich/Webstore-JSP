package com.cognixia.store.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;

	private String name;
	private String description;
	private String code;

	@Column(precision = 8, scale = 2)
	private BigDecimal price;
	private int inStock;

	public Product() {
	}

	public Product(long productId, String name, String description, String code, BigDecimal price, int inStock) {
		super();
		this.productId = productId;
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.inStock = inStock;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", code=" + code
				+ ", price=" + price + ", inStock=" + inStock + "]";
	}

}
