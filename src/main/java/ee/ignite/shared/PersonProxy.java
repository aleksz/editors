package ee.ignite.shared;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

import ee.ignite.server.Person;


@ProxyFor(Person.class)
public interface PersonProxy extends EntityProxy {

	PersonProxy getManager();

	void setManager(PersonProxy manager);

	Integer getAge();

	void setAge(Integer age);

	AddressProxy getAddress();

	String getName();

	void setName(String name);

	void setAddress(AddressProxy address);
}
