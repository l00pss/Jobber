package com.jobber.ws.model.entity.user;

public enum Role {
    ROLE_GUEST("GUEST"),
    ROLE_WORKER("WORKER"),
    ROLE_EMPLOYER("EMPLOYER");

    private final String name;
    Role(final String employer) {
        this.name=employer;
    }

    public String get() {
        return name;
    }
}