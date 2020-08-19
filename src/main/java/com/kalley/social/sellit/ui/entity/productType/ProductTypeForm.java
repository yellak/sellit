package com.kalley.social.sellit.ui.entity.productType;

import com.kalley.social.sellit.ui.AbstractFormDialog;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ProductTypeForm extends AbstractFormDialog {
	
	/**
	 * Default Serial ID version.
	 */
	private static final long serialVersionUID = 1L;

	public ProductTypeForm() {
		super(true);
	}

	@Override
	protected String getTitle() {
		return "Edit Product Type";
	}

	@Override
	protected Component createFormLayout() {
		FormLayout form = new FormLayout();
		form.add(createNameField());
		return form;
	}

	private Component createNameField() {
		TextField field = new TextField("Name");
		return field;
	}

}
