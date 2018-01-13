package com.example.hasanpc.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewImage extends AppCompatActivity {

    ListView lv;
    Context context;
    ArrayList proglist;

    // Image array for the ListView
    public static Integer [] progImages = {
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher,
        R.drawable.ic_launcher
    };

    // List array for the ListView
    public static String[] progName = {
        "Java",
        "Pyrhon",
        "C#",
        "Ruby",
        "Swift",
        "PHP",
        "JavaScript",
        "C++",
        "C"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_image);

        MyListAdapter adapter = new MyListAdapter(this,progName,progImages);

        lv = (ListView) findViewById(R.id.listView2);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewImage.this,"You clicked on " + progName[position],Toast.LENGTH_SHORT).show();
            }
        });


    }


}
