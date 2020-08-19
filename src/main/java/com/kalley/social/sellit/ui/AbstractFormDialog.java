package com.kalley.social.sellit.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public abstract class AbstractFormDialog extends Dialog {

	/**
	 * Default Serial ID version.
	 */
	private static final long serialVersionUID = 1L;
	
	private VerticalLayout content;
	
	private Button confirm;
	
	private Button cancel;
	
	public AbstractFormDialog(boolean useTitle) {
		content = new VerticalLayout();
		if (useTitle) {
			Component title = createTitle();
			if (title != null) {
				content.add(title);
			}
		}
		content.add(createFormLayout());
		content.add(createButtonsLayout());
		add(content);
		setDraggable(true);
		setResizable(true);
	}

	private Component createButtonsLayout() {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setJustifyContentMode(JustifyContentMode.END);
		layout.add(createConfirmButton());
		layout.add(createCancelButton());
		layout.setWidthFull();
		return layout;
	}

	private Component createCancelButton() {
		cancel = new Button("Cancel");
		cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		cancel.addClickListener(e -> onCancel());
		return cancel;
	}

	protected void onCancel() {
		close();
	}

	private Component createConfirmButton() {
		confirm = new Button("Save");
		confirm.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		confirm.addClickListener(e -> onConfirm());
		return confirm;
	}

	protected void onConfirm() {
	}

	private Component createTitle() {
		String strTitle = getTitle();
		if (strTitle != null) {
			return new Label(getTitle());
		}
		return null;
	}
	
	protected abstract Component createFormLayout();

	protected abstract String getTitle();

	public Button getConfirm() {
		return confirm;
	}

	public void setConfirm(Button confirm) {
		this.confirm = confirm;
	}

}
