package org.auto1.model;

import java.util.Objects;

public class Key {

    public String s;
    public Integer i;

    public Key(String s, Integer i) { // todo replace with builder
        if (s != null) {
            this.s = s.toLowerCase(); // todo remove to validator
        }
        this.i = i;
    }

    public Key(String s) {
        this.s = s.toLowerCase();
    }

    public Key(Integer s) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Key key = (Key) o;
        return Objects.equals(s, key.s) && Objects.equals(i, key.i);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, i);
    }
}
