package com.thoughtworks.mstorderservice.enums;

public enum OrderStatus {
    CREATED("created"),
    FINISHED("finished");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
