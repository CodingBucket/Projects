package com.example.hasanpc.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpanListView extends AppCompatActivity {

    ExpandableListView expandableListView;

    List<String> langs;
    Map<String, List<String>> topics;

    ExpandableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expan_list_view);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.exListView);
        fillData();

        listAdapter = new MyExListAdapter(this, langs, topics);

        expandableListView.setAdapter(listAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(ExpanListView.this,langs.get(groupPosition) + " : " + topics.get(langs.get(groupPosition)).get(childPosition),Toast.LENGTH_SHORT).show();

                Toast.makeText(ExpanListView.this,"Clicked",Toast.LENGTH_SHORT).show();

                return false;
            }
        });

    }

    public void fillData(){
        langs = new ArrayList<>();
        topics = new HashMap<>();

        langs.add("Java");
        langs.add("C");

        List<String> java = new ArrayList<>();
        List<String> python = new ArrayList<>();

        java.add("Android");
        java.add("Spring");

        python.add("Django");
        python.add("pyGame");;

        topics.put(langs.get(0),java);
        topics.put(langs.get(1),python);

    }

}
