package ee.ignite.shared;

import java.util.List;

import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

import ee.ignite.server.Person;

@Service(Person.class)
public interface PersonRequest extends RequestContext {

	Request<List<PersonProxy>> findAllPersons();

    InstanceRequest<PersonProxy, Void> persist();
}
