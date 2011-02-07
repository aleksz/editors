package ee.ignite.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.requestfactory.client.RequestFactoryEditorDriver;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import ee.ignite.shared.MyRequestFactory;
import ee.ignite.shared.PersonProxy;
import ee.ignite.shared.PersonRequest;

public class PersonWidget extends Composite implements Editor<PersonProxy> {

	private static PersonWidgetUiBinder uiBinder =
		GWT.create(PersonWidgetUiBinder.class);

	interface PersonWidgetUiBinder extends UiBinder<Widget, PersonWidget> {
	}

	// Empty interface declaration, similar to UiBinder
	interface Driver extends RequestFactoryEditorDriver<PersonProxy, PersonWidget> {
	}

	// Create the Driver
	Driver driver = GWT.create(Driver.class);

	@UiField
	TextBox name;

	@Ignore
	@UiField
	Label errors;

	@UiField
	ValueBoxEditorDecorator<Integer> age;

	@UiField
	AddressWidget address;

	@UiField(provided = true)
	PersonListWidget manager;

	@UiField
	Button save;

	@UiField
	Button generateManager;

	private final MyRequestFactory requestFactory;

	public PersonWidget(MyRequestFactory requestFactory) {
		this.requestFactory = requestFactory;
		manager = new PersonListWidget(requestFactory);
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void createNew() {
		PersonRequest context = requestFactory.personRequest();
		PersonProxy newPerson = context.create(PersonProxy.class);
		edit(newPerson, context);
	}

	public void edit(PersonProxy p, RequestContext context) {
		driver.initialize(this);
		driver.edit(p, context);
	}

	public void edit(PersonProxy p) {
		edit(p, requestFactory.personRequest());
	}

	@UiHandler("save")
	public void save(ClickEvent event) {
		RequestContext context = driver.flush();
		if (driver.hasErrors()) {
			errors.setText(driver.getErrors().toString());
			return;
		}

		errors.setText("");

		context.fire();
	}
}
