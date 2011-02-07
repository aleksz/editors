package ee.ignite.shared;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

import ee.ignite.server.Address;

@ProxyFor(Address.class)
public interface AddressProxy extends EntityProxy {

	String getCity();

	void setCity(String city);

	String getStreet();

	void setStreet(String street);
}
