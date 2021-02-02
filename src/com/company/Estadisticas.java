package com.company;

public class Estadisticas implements Comparable<Estadisticas> {
    private int objectid;
    private String zona;
    private float AROPE; // At risk of Poverty
    private float area;
    private float length;

    public Estadisticas(int objectid, String zona, float AROPE, float area, float length) {
        this.objectid = objectid;
        this.zona = zona;
        this.AROPE = AROPE;
        this.area = area;
        this.length = length;
    }

    public int getObjectid() {
        return objectid;
    }

    public void setObjectid(int objectid) {
        this.objectid = objectid;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public float getAROPE() {
        return AROPE;
    }

    public void setAROPE(float AROPE) {
        this.AROPE = AROPE;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "ID: " + objectid +
                "\nZona: " + zona +
                "\nAROPE: " + AROPE +
                "\nArea: " + area +
                "\nLength: " + length +
                "\n------------------";
    }

    @Override
    public int compareTo(Estadisticas o) {
        if(getObjectid() > o.getObjectid()) return -1;
        else if(getObjectid() < o.getObjectid()) return 1;
        else return 0;
    }


}
