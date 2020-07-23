package com.kalley.social.sellit.ui.entity.productType;

import com.kalley.social.sellit.backend.entity.ProductType;
import com.kalley.social.sellit.ui.AbstractGrid;

public class ProductTypeGrid extends AbstractGrid<ProductType> {

	/**
	 * Default serial ID verison.
	 */
	private static final long serialVersionUID = 1L;

	public ProductTypeGrid() {
		super(ProductType.class);
		addClassName("product-type-grid");
		addColumn("name");
	}
	
}
