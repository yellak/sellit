package com.kalley.social.sellit.ui;

import com.kalley.social.sellit.backend.entity.ProductType;
import com.kalley.social.sellit.backend.service.ProductTypeService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("")
@SuppressWarnings("serial")
public class MainView extends VerticalLayout {
	
	private ProductTypeService prodTypeService;

	// Will be changed soon
	private Grid<ProductType> grid = new Grid<>(ProductType.class);
	private TextField filterText = new TextField();
	
	/**
	 * Creates a new View to the project.
	 */
    public MainView(ProductTypeService prodTypeService) {
    	this.prodTypeService = prodTypeService;
    	addClassName("main-view");
    	setSizeFull();
    	add(createFilter(), createGrid());
    }	

	private Component createGrid() {
		grid.addClassName("product-type-grid");
		grid.setSizeFull();
		grid.setColumns("name");
		grid.setItems(prodTypeService.findAll());
		return grid;
	}

	private Component createFilter() {
		filterText.setPlaceholder("Filter by name...");
		filterText.setClearButtonVisible(true);
		filterText.setValueChangeMode(ValueChangeMode.LAZY);
		filterText.addValueChangeListener(e -> updateList());
		return filterText;
	}

	private void updateList() {
		grid.setItems(prodTypeService.findAll(filterText.getValue()));
	}
	
}
