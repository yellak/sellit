package com.kalley.social.sellit.ui;

import com.vaadin.flow.component.grid.Grid;

@SuppressWarnings("serial")
public abstract class AbstractGrid<T> extends Grid<T> {
	
	public AbstractGrid(Class<T> type) {
		super(type, false);
	}

}
