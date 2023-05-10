package com.example.roomcrud;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_db")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "age")

    public String age;




    public User(String name, String age) {

        this.name=name;
        this.age=age;
    }



    @Override
    public String toString() {
        return "\n User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}