package org.auto1.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashMap;
import org.auto1.model.Key;
import org.auto1.validator.Validator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InMemoryStorageTest {

    Validator validator = Mockito.mock(Validator.class);

    @Test
    void givenKeyValuePairWhenPutItThenStorageNotEmpty() {
        // given
        HashMap<Key, String> storage = new HashMap<>();
        InMemoryStorage inMemoryStorage = new InMemoryStorage(storage);
        // when
        String key = null;
        String secret = "My secret no one should know!";
        inMemoryStorage.put(new Key(key, null), secret);
        boolean result = storage.isEmpty();
        // then
        assertFalse(result);
    }


    @Test
    void givenKeyWhenGetThenReturnSecret() {

        // given
        HashMap<Key, String> storage = new HashMap<>();
        InMemoryStorage inMemoryStorage = new InMemoryStorage(storage);
        // when

        String key = "mY-cUsTom-kEy";
        String secret = "My secret no one should know!";
        inMemoryStorage.put(new Key(key, null) , secret);
        String result = inMemoryStorage.get(new Key(key, null));
        // then
        assertEquals(secret, result);

    }
}
