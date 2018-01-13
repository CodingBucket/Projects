package com.example.hasanpc.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* Floating button start */
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "This is a custom button", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        /* Floating button start */


        /* ListView Create Start */

            lv = (ListView) findViewById(R.id.programmingList);
            final String values[] = {"Java","Python","C#","Ruby","Swift","PHP","JavaScript","C++","C"};

            ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, Arrays.asList(values));

            lv.setAdapter(arrayAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this,"You clicked on " + values[position],Toast.LENGTH_SHORT).show();
                }
            });

        /* ListView Create End */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ImageListView) {
            // Go to a different activity
            Intent intent = new Intent(MainActivity.this,ListViewImage.class);

            // Call the new activity
            startActivity(intent);
        } else if (id == R.id.ExpandableListView){

            Intent intent = new Intent(MainActivity.this,ExpanListView.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}
