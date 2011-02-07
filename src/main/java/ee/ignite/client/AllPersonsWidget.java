package ee.ignite.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Widget;

import ee.ignite.client.PersonWidget.PersonWidgetUiBinder;
import ee.ignite.shared.MyRequestFactory;
import ee.ignite.shared.PersonProxy;

public class AllPersonsWidget extends Composite {

	private static AllPersonsWidgetUiBinder uiBinder =
		GWT.create(AllPersonsWidgetUiBinder.class);

	interface AllPersonsWidgetUiBinder extends UiBinder<Widget, AllPersonsWidget> {
	}

	private final MyRequestFactory requestFactory;

	@UiField
	Button createNewPerson;

	@UiField(provided = true)
	PersonListWidget personList;

	private final PersonWidget personWidget;

	public AllPersonsWidget(MyRequestFactory requestFactory, PersonWidget personWidget) {
		this.requestFactory = requestFactory;
		this.personWidget = personWidget;
		personList = new PersonListWidget(requestFactory);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("createNewPerson")
	public void createNewPerson(ClickEvent click) {
		personWidget.createNew();
	}

	@UiHandler("personList")
	public void editPerson(ValueChangeEvent<PersonProxy> event) {
		personWidget.edit(event.getValue());
	}
}
