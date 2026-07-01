package com.example.socialapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {


    FirebaseAuth auth;
    DatabaseReference checkVideocallRef;
    String senderuid;
    int page = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        try {

            SharedPreferences sharedPreferences = getSharedPreferences("SharedPrefs",MODE_PRIVATE);


            final boolean isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn",false);


            if (isDarkModeOn){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            }
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                        //    Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            Toast.makeText(MainActivity.this, "Token is missing", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();
                        FirebaseDatabase.getInstance().getReference("Token").child(uid).child("token").setValue(token);

                    }
                });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new Fragment4()).commit();
                page = 4;

    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNav = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selected = null;
            switch (item.getItemId()){
                case R.id.profile_bottom:
                    if(page != 1) {
                        selected = new Fragment1();
                        page = 1;
                    }
                    break;

                case R.id.ask_bottom:
                    if(page != 2) {
                        selected = new Fragment2();
                        page = 2;
                    }
                    break;

                case R.id.queue_bottom:
                    if(page != 3) {
                        selected = new Fragment3();
                        page = 3;
                    }
                    break;

                case R.id.home_bottom:
                    if(page != 4) {
                        selected = new Fragment4();
                        page = 4;
                    }
                    break;

                case R.id.info_bottom:
                    if(page != 5) {
                        selected = new Fragment5(); 
                        page = 5;
                    }
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }

            if (selected != null) {
                // Replace the current fragment with the selected fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, selected)
                        .commit();
            }

            return true; // Return true to indicate that you've handled the navigation event
        }
    };



}
