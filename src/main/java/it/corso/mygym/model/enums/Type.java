package it.corso.mygym.model.enums;

public enum Type {
    WEIGHT_ROOM("WEIGHT_ROOM"),
    OPEN("OPEN");

    private String type;
    Type(String type){
        this.type = type;
    }
    @Override
    public String toString(){
        return type;
    }
}
