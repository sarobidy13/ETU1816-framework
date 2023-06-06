package model;

import etu1816.framework.MethodAnnotation.*;
import java.util.HashMap;

public class Emp {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Annotation(url = "/EmpAll")
    public void getname() {

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("data", "Sarobidy");
    }

}
