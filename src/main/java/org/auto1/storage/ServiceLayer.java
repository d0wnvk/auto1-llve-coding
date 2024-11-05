package org.auto1.storage;

import org.auto1.model.Key;
import org.auto1.validator.Validator;

public class ServiceLayer {

    private Storage storage;
    private Validator validator;

    public ServiceLayer(Storage storage, Validator validator) {
        this.storage = storage;
        this.validator = validator;
    }

    public void put(String key, String secret) {
        validator.validate(key);
        Key key1 = new Key(key);
        storage.put(key1, secret);
    }

    public String get(String key) {
        Key key1 = new Key(key, null);
        return storage.get(key1);
    }

    public void put(Integer key, String secret) {
        validator.validate(key);
        Key key1 = new Key( null, key);
        storage.put(key1, secret);
    }

    public String get(Integer key) {
        Key key1 = new Key( null, key);
        return storage.get(key1);
    }


}
