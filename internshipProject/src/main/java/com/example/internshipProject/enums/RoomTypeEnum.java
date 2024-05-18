package com.example.internshipProject.enums;

public enum RoomTypeEnum {
    SINGLE(1),
    DOUBLE(2),
    SUITE(3),
    MATRIMONIAL(4);

    public int label;

    RoomTypeEnum(int label) {
        this.label = label;
    }

    public void setLabel (int label) {
        this.label = label;
    }
    public int getLabel () {return this.label;}

    static public RoomTypeEnum toEnum(int type) {
        RoomTypeEnum roomTypeEnum = null;
        for(RoomTypeEnum currentType : RoomTypeEnum.values()) {
            if(type == currentType.getLabel()) {
                return currentType;
            }
        }
        return roomTypeEnum;
    }
}