package org.auto1.storage;

import java.util.HashMap;
import org.auto1.model.Key;

public class InMemoryStorage implements Storage {

    private HashMap<Key, String> storage;


    public InMemoryStorage(HashMap<Key, String> storage) {
        this.storage = storage;
    }

    @Override
    public void put(Key key, String secret) {
        storage.put(key, secret);
    }

    @Override
    public String get(Key key) {
        return storage.get(key);
    }

}
