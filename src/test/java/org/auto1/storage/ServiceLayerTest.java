package org.auto1.storage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.auto1.validator.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceLayerTest {

    InMemoryStorage storage = Mockito.mock(InMemoryStorage.class);
    Validator validator = Mockito.mock(Validator.class);

    @Test
    void givenKeyAsStringWhenPutThenCallStorageOnce() {
        // given
        ServiceLayer serviceLayer = new ServiceLayer(storage, validator);
        // when
        String key = "mY-cUsTom-kEy";
        String secret = "My secret no one should know!";
        serviceLayer.put(key, secret);

        doNothing().when(validator).validate(key);
        // then
        verify(storage, Mockito.times(1)).put(any(), any());
    }


    @Test
    void givenKeyAsIntegerWhenPutThenCallStorageOnce() {

        // given
        ServiceLayer serviceLayer = new ServiceLayer(storage, validator);
        // when
        Integer key = 255;
        String secret = "My secret no one should know!";
        serviceLayer.put(key, secret);

        doNothing().when(validator).validate(key);
        // then
        verify(storage, Mockito.times(1));

    }

}
