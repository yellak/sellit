package com.kalley.social.sellit.ui;

import com.kalley.social.sellit.backend.entity.ProductType;
import com.kalley.social.sellit.backend.service.ProductTypeService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
	
	private ProductTypeService prodTypeService;

	/**
	 * Creates a new View to the project.
	 */
    public MainView(ProductTypeService prodTypeService) {
    	this.prodTypeService = prodTypeService;
    	addClassName("main-view");
    	setSizeFull();
    	add(createGrid());
    }	

	private Component createGrid() {
		Grid<ProductType> grid = new Grid<>(ProductType.class);
		grid.addClassName("product-type-grid");
		grid.setSizeFull();
		grid.setColumns("name");
		grid.setItems(prodTypeService.findAll());
		return grid;
	}

}
