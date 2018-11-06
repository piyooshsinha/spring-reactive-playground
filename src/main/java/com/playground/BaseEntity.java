package com.playground;

import org.springframework.data.annotation.Id;

public class BaseEntity<T> {

    protected T id;

    @Id
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
