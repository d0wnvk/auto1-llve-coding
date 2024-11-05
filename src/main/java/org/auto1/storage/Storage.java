package org.auto1.storage;

import org.auto1.model.Key;

public interface Storage {

    void put(Key key, String secret);

    String get(Key key);

}
