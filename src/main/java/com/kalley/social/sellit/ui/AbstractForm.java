package com.kalley.social.sellit.ui;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public abstract class AbstractForm extends VerticalLayout {

	/**
	 * Default Serial ID version.
	 */
	private static final long serialVersionUID = 1L;
	
	protected FormLayout form;

	public AbstractForm() {
		createTitle();
		form = new FormLayout();
		form.setResponsiveSteps(new FormLayout.ResponsiveStep("50px", 1), new FormLayout.ResponsiveStep("450px", 2),
				new FormLayout.ResponsiveStep("800px", 3));
	}

	private void createTitle() {
		String strTitle = getTitle();
		if (strTitle != null) {
			add(new Label(getTitle()));
		}
	}

	protected abstract String getTitle();

}
