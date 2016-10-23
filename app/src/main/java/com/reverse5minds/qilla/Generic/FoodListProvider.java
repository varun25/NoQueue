package com.reverse5minds.qilla.Generic;

/**
 * Created by Varun on 23-08-2016.
 */
public class FoodListProvider {

    private int imageres;
    private String abc, def;

    public FoodListProvider(int imageres, String abc, String def)
    {
        this.imageres = imageres;
        this.abc = abc;
        this.def = def;
    }

    public int getImageres() { return imageres;  }

    public void setImageres(int imageres) {
        this.imageres = imageres;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }
}

