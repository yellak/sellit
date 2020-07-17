package com.kalley.social.sellit.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Defines the type of a product.
 * 
 * @author Kálley Wilkerson
 */
@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType extends AbstractEntity {
	
	@Column(name = "PRODUCT_TYPE_NAME", nullable = false)
	@NotNull(message = "The name of the product type has to be given.")
	@NotEmpty(message = "The name of the product can't be empty.")
	private String name;

	public ProductType() {
	}

	/**
	 * Constructs a new {@link ProductType}.
	 * 
	 * @param name The name of the type.
	 */
	public ProductType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name != null ? name : super.toString();
	}

	/**
	 * @return The name of the type.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the type.
	 * 
	 * @param name The new name.
	 */
	public void setName(String name) {
		this.name = name;
	}

}
