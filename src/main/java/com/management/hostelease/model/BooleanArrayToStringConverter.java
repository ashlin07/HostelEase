package com.management.hostelease.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;

@Converter
public class BooleanArrayToStringConverter implements AttributeConverter<boolean[], String> {

    @Override
    public String convertToDatabaseColumn(boolean[] attribute) {
        if (attribute == null) {
            return null;
        }
        return Arrays.toString(attribute);
    }

    @Override
    public boolean[] convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        int [] intArray=Arrays.stream(dbData.substring(1, dbData.length() - 1).split(","))
                .map(Boolean::parseBoolean)
                .mapToInt(b -> b ? 1 : 0)
                .toArray();
        boolean[] booleanArray = new boolean[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            booleanArray[i] = intArray[i] == 1;
        }
        return booleanArray;
    }
}
