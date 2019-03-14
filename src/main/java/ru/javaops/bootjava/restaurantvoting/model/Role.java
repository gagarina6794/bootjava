package ru.javaops.bootjava.restaurantvoting.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_TRAINER,
    ROLE_PUPIL;

    @Override
    public String getAuthority() {
        return name();
    }
}