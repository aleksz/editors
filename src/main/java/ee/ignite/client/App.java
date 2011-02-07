package ee.ignite.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.user.client.ui.RootPanel;

import ee.ignite.shared.MyRequestFactory;
import ee.ignite.shared.PersonProxy;
import ee.ignite.shared.PersonRequest;

public class App implements EntryPoint {

	final EventBus eventBus = new SimpleEventBus();

	public void onModuleLoad() {

		MyRequestFactory requestFactory = GWT.create(MyRequestFactory.class);
		requestFactory.initialize(eventBus);

		final PersonWidget pw = new PersonWidget(requestFactory);
		AllPersonsWidget all = new AllPersonsWidget(requestFactory, pw);

		RootPanel.get("app").add(pw);
		RootPanel.get("app").add(all);
    }
}
