package com.cms.listwebbackend.converters;

import com.cms.listwebbackend.enums.SaveStatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SaveStatusConverter implements AttributeConverter<SaveStatusEnum, String> {
    @Override
    public String convertToDatabaseColumn(SaveStatusEnum saveStatusEnum) {
        if (saveStatusEnum == null) {
            return null;
        }
        return saveStatusEnum.getCode();
    }

    @Override
    public SaveStatusEnum convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return SaveStatusEnum.fromCode(s);
    }
}
