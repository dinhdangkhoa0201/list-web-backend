package com.cms.listwebbackend.enums;

public enum SaveStatusEnum {
    SAVED("1", "Save"),
    NOT_SAVE("0", "Not Save"),
    ;

    private final String code;
    private final String desc;

    private SaveStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SaveStatusEnum fromCode(String code) {
        if (code != null) {
            for (SaveStatusEnum status: SaveStatusEnum.values()) {
                if (status.getCode().equals(code)) {
                    return status;
                }
            }
        }
        return null;
    }
}
