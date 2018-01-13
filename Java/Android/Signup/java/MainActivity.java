package com.example.hasanpc.loginregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etEmail;
    EditText etPass;

    RadioButton r1;
    RadioButton r2;
    RadioGroup rg;

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the button view by id
        b = (Button)findViewById(R.id.btn_sighup);

        etEmail = (EditText) findViewById(R.id.input_email);
        etPass = (EditText)findViewById(R.id.input_password);
        etName = (EditText) findViewById(R.id.input_name);

        r1 = (RadioButton) findViewById(R.id.female_radio);
        r2 = (RadioButton) findViewById(R.id.male_radio);

        rg = (RadioGroup) findViewById(R.id.radioGroup);

        // On click the signup button
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                    // method 1 to get the radio value
                    String gen = "";
                    if(r1.isChecked()){
                        gen = "Female";
                    } else {
                        gen = "Male";
                    }
                */

                // method 2 to get
                int i = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) rg.findViewById(i);

                final String name = etName.getText().toString();
                final String email = etEmail.getText().toString();
                final String pass = etPass.getText().toString();

                // On click button make a toast
                Toast.makeText(MainActivity.this,"Name : " + name + "\n Email : " + email + "\n Gender : " + rb.getText().toString(),Toast.LENGTH_LONG).show();

                // Go to a different activity
                Intent intent = new Intent(MainActivity.this,ShowDataActivity.class);

                // Passing data to another activity
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("pass",pass);
                intent.putExtra("gender",rb.getText().toString());

                // Call the new activity
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.setting:
                Toast.makeText(MainActivity.this,"Setting menu is clicked",Toast.LENGTH_LONG).show();
                return true;
            case R.id.about:
                Toast.makeText(MainActivity.this,"About menu is clicked",Toast.LENGTH_LONG).show();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

}
