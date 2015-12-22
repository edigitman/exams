package ro.ghasachi.bt.persistence.service;

import ro.ghasachi.bt.persistence.IOperations;
import ro.ghasachi.bt.persistence.model.Foo;

public interface IFooService extends IOperations<Foo> {

    Foo retrieveByName(String name);

}
