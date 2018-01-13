package com.example.hasanpc.loginregistration;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ShowDataActivity extends AppCompatActivity {

    private TextView name,email;

    TextView sv,v,display;

    SeekBar sb;

    Button b1,b2,b3,alertButton;

    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Intent intent = getIntent();

        String sname = intent.getStringExtra("name");
        String semail = intent.getStringExtra("email");

        name = (TextView) findViewById(R.id.txtName);
        email = (TextView) findViewById(R.id.txtEmail);

        name.setText(sname);
        email.setText(semail);

        // Visibility
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);

        // Seekbar
        sb = (SeekBar) findViewById(R.id.sb);
        sv = (TextView) findViewById(R.id.sv);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sv.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ShowDataActivity.this,"Seekbar Started",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ShowDataActivity.this,"Seekbar stoped",Toast.LENGTH_SHORT).show();
            }
        });

        /*
        // Rating
        v = (TextView) findViewById(R.id.v);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                v.setText("Value 123");
            }
        });
        */

        /* Alert box start */
            display = (TextView) findViewById(R.id.display);
            alertButton = (Button)findViewById(R.id.alertButton);
            alertButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    // Builder create
                    AlertDialog.Builder builder = new AlertDialog.Builder(ShowDataActivity.this);

                    builder.setMessage("Are you sure?")
                            .setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which){
                                    display.setText("OK button clicked");
                                }
                            })
                            .setNegativeButton("Cancel",null);

                    AlertDialog alert = builder.create();
                    alert.show();

                }
            });
        /* Alert box end */


    }

    @Override
    public void onBackPressed(){
        // Builder create
        AlertDialog.Builder builder = new AlertDialog.Builder(ShowDataActivity.this);

        builder.setTitle("Really Exit?")
                .setMessage("Are you sure?")
                .setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        ShowDataActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Cancel",null).setCancelable(false);

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void b1Clicked(View v){
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
    }

    public void b2Clicked(View v){
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.VISIBLE);
    }

    public void b3Clicked(View v){
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.INVISIBLE);
    }
}
