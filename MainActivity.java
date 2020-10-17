package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {


    SwitchCompat switch_T;
    ImageView imageView;
    View screenView;
    /*Button clickthemes;*/
    int index = -1;
    /*int[] color = new int[]{RED,Color.BLACK, Color.BLUE,Color.GREEN};*/
    int frames[] ={R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenView = findViewById(R.id.rView);
        imageView = findViewById(R.id.imageView);

        switch_T =findViewById(R.id.toggleSwitch);
        switch_T.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                            .getColor(R.color.colorPrimaryDark)));
                }
                else{
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                            .getColor(R.color.colorAccent)));
                }
            }
        });


        /*clickthemes =findViewById(R.id.themes);
        clickthemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aryLength = color.length;
                Random random = new Random();
                int rNum = random.nextInt(aryLength);
                screenView.setBackgroundColor(color[rNum]);
            }
        });*/

        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.my_menu,menu);
            return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.framem:
                        if(index<frames.length-1)
                            index++;
                        else
                            index = 0;
                        imageView.setImageResource(frames[index]);

                Toast.makeText(MainActivity.this,"frame changed",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.backgroundcolor:
                if (item.getItemId() == R.id.red) {
                    int[] color = new int[]{Color.RED};
                    int aryLength = color.length;
                    Random random = new Random();
                    int rNum = random.nextInt(aryLength);
                    screenView.setBackgroundColor(color[rNum]);
                    Toast.makeText(MainActivity.this, "next frame", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return super.onOptionsItemSelected(item);


            default:
            return super.onOptionsItemSelected(item);
        }


    }
}