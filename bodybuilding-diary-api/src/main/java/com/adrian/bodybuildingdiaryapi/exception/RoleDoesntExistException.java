package com.adrian.bodybuildingdiaryapi.exception;

public class RoleDoesntExistException extends Exception {

    public RoleDoesntExistException(String role) {
        super(role + " role doesn't exist");
    }
}
