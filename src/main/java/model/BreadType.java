package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape= JsonFormat.Shape.STRING)
public enum BreadType {
    TURKISH_BREAD, WRAP, BOTERHAMMEKES,None;

    @JsonCreator
    public static BreadType forValue(String value){
        return BreadType.valueOf(value.toUpperCase());
    }
}

