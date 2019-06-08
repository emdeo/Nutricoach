package com.example.nutricoach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
   
    /** Ajout de la deuxième activité */
    /** Called when the user taps the Send (chez nous : "Valider") button */
    public void sendMessage(View view) {
        // Do something in response to button
    }
}
