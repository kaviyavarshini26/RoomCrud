package com.example.roomcrud;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
    public interface UserDao {
        @Insert
        void insert(User user);
        @Query("SELECT * FROM user_db")
        List<User> getAllUsers();
    @Query("SELECT * FROM user_db WHERE  uid LIKE :id")
    User findbyid(int id);
    @Update
    void Update(User user);
    @Delete
    void Delete(User user);
   @Insert
    void readmultipleuser(List<User> users);
}


