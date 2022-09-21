package com.cms.listwebbackend.enums;

public enum ObjectResultStatus {
    SUCCESS("1", "Success"),
    FAILED("0", "Failed");

    private final String code;
    private final String desc;

    private ObjectResultStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
