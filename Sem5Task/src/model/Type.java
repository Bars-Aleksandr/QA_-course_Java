package model;

public enum Type {
    STUDENT("Student"),
    TEACHER("Teacher");

    private final String typeValueString;

    Type(String typeValueString) {
        this.typeValueString = typeValueString;
    }

    public String getTypeValueString() {
        return typeValueString;
    }
}
