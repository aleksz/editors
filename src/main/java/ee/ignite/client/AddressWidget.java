package ee.ignite.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import ee.ignite.shared.AddressProxy;

public class AddressWidget extends Composite implements Editor<AddressProxy> {

	private static AddressWidgetUiBinder uiBinder =
		GWT.create(AddressWidgetUiBinder.class);

	interface AddressWidgetUiBinder extends UiBinder<Widget, AddressWidget> {
	}

	@UiField
	TextBox city;

	@UiField
	TextBox street;

	public AddressWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
