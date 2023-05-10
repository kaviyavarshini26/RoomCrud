package com.example.roomcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="Room Db";
    ExecutorService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void insertuser(View view){
        service= Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                User user;
                user = new User("swaroopa","24");
             UserDatabase.getInstance(MainActivity.this).userDao().insert(user);
            Log.d(TAG,"run:Inserted successfully");
            }
        });

    }
    public void readalluser(View view){
        service= Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                List<User> list=  UserDatabase.getInstance(MainActivity.this)
                        .userDao().getAllUsers();
                Log.d(TAG,list.toString());
            }
        });

    }
    public void updateuser(View view){
        service= Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
              User user=  UserDatabase.getInstance(MainActivity.this)
                        .userDao().findbyid(1);
              user.name="java";
              user.age="8";
                UserDatabase.getInstance(MainActivity.this)
                        .userDao().Update(user);
                Log.d(TAG,"run:updated successfully");

            }

            });

    }
    public void deleteuser(View view){
        service= Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                User user=  UserDatabase.getInstance(MainActivity.this)
                        .userDao().findbyid(4);

                UserDatabase.getInstance(MainActivity.this)
                        .userDao().Delete(user);
                Log.d(TAG,"run:deleted successfully");

            }

        });

    }
    public void readmultipleuser(View view){
        service= Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                List<User> list=new ArrayList<>();
               list.add(new User("kaviya","22"));
                list.add(new User("diva","23"));
                list.add(new User("rina","24"));
                list.add(new User("banaa","25"));
                list.add(new User("keerthaa","26"));
                UserDatabase.getInstance(MainActivity.this).userDao().readmultipleuser(list);
                Log.d(TAG,"run:Multiple user added successfully");
            }
        });

    }

}