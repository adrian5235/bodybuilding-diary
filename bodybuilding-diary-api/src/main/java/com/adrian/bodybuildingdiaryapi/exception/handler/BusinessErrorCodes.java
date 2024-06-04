package com.adrian.bodybuildingdiaryapi.exception.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum BusinessErrorCodes {

    USER_EXISTS(300, CONFLICT, "User of the given username already exists"),
    TOKEN_INVALID(301, BAD_REQUEST, "Invalid token"),
    TOKEN_EXPIRED(302, BAD_REQUEST, "Activation token has expired. A new token has been sent to the same email address"),
    USER_NOT_FOUND(303, BAD_REQUEST, "Couldn't find user"),
    ROLE_DOES_NOT_EXIST(304, BAD_REQUEST, "Role doesn't exist"),
    BAD_CREDENTIALS(305, FORBIDDEN, "Username and / or password is incorrect"),
    ACCOUNT_LOCKED(306, FORBIDDEN, "User account is locked"),
    ACCOUNT_DISABLED(307, FORBIDDEN, "User account is disabled"),
    ENTITY_NULL(308, BAD_REQUEST, "Wanted data doesn't exist");

    private final int code;
    private final String description;
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
