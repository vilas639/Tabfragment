package com.example.hp_pc.sqllite_sharepref;

import java.io.Serializable;

public class Profile  implements Serializable{
   int id;
    String name,Age;
    byte[] image;

    public Profile()
    {

    }


    public Profile(String name, String age, byte[] image) {

        this.name = name;
        Age = age;
        this.image = image;
    }


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

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
