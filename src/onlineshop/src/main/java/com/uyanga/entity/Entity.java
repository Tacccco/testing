package com.uyanga.entity;

import org.apache.commons.lang3.Validate;

public class Entity {
    private final String id;

    public Entity(String id) {
        this.id = Validate.notBlank(id);
    }

    public String getId() {
        return id;
    }
}
