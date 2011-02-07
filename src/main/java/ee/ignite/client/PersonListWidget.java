package ee.ignite.client;

import java.io.IOException;
import java.util.List;

import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.ValueListBox;

import ee.ignite.shared.MyRequestFactory;
import ee.ignite.shared.PersonProxy;
import ee.ignite.shared.PersonRequest;

public class PersonListWidget extends ValueListBox<PersonProxy> {

	private final MyRequestFactory requestFactory;

	public PersonListWidget(MyRequestFactory requestFactory) {
		super(new Renderer<PersonProxy>() {

			@Override
			public String render(PersonProxy p) {
				return p != null ? p.getName() : null;
			}

			@Override
			public void render(PersonProxy p, Appendable appendable)
					throws IOException {
			}
		});
		this.requestFactory = requestFactory;

	    refresh();
	}

	public void refresh() {
		requestFactory.personRequest().findAllPersons().fire(new Receiver<List<PersonProxy>>() {

			@Override
			public void onSuccess(List<PersonProxy> response) {
				setAcceptableValues(response);
			}
		});
	}

}
