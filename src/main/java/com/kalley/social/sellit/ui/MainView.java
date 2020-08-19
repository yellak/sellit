package com.kalley.social.sellit.ui;

import com.kalley.social.sellit.backend.service.ProductTypeService;
import com.kalley.social.sellit.ui.entity.productType.ProductTypeForm;
import com.kalley.social.sellit.ui.entity.productType.ProductTypeGrid;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("")
@SuppressWarnings("serial")
public class MainView extends VerticalLayout {
	
	private ProductTypeService prodTypeService;

	// Will be changed soon
	private ProductTypeGrid grid = new ProductTypeGrid();
	private TextField filterText = new TextField();
	
	/**
	 * Creates a new View to the project.
	 */
    public MainView(ProductTypeService prodTypeService) {
    	this.prodTypeService = prodTypeService;
    	addClassName("main-view");
    	setSizeFull();
    	add(createFilter(), createFormButton(), createGrid());
    }

	private Component createFormButton() {
		return new Button("Edit", event -> new ProductTypeForm().open());
	}

	private Component createGrid() {
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
