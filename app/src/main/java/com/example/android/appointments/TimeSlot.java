package com.example.android.appointments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeSlot extends AppCompatActivity {

    Button timebtn;

    RecyclerView recyclerView;
    ArrayList<String> sectionList = new ArrayList<>();
    HashMap<String,ArrayList<String>> itemList = new HashMap<>();
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);

        timebtn = (Button)findViewById(R.id.timebtn);
        timebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
//                Bundle b = new Bundle();
//
//                Intent i=new Intent(TimeSlot.this, MainActivity.class);
//
//                b.putStringArray("array" , sectionList.toArray(new String[0]));
//                i.putExtras(b);
//                startActivity(i);
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        //Add section value
        sectionList.add("Morning");
        sectionList.add("Afternoon");

        //Start Array list
        ArrayList<String> arrayList = new ArrayList<>();

        //Morning Value
        arrayList.add("08:00am - 9:00pm");
        arrayList.add("09:00am - 10:00pm");
        arrayList.add("10:00am -11:00pm");
        arrayList.add("11:00am - 12:00pm");

        itemList.put(sectionList.get(0),arrayList);

        //Add Afternoon Value
        arrayList = new ArrayList<>();
        arrayList.add("12:00 - 01:00pm");
        arrayList.add("01:00 - 02:00pm");
        arrayList.add("02:00 - 03:00pm");
        arrayList.add("03:00 - 04:00pm");
        arrayList.add("04:00 - 05:00pm");


        itemList.put(sectionList.get(1),arrayList);

        adapter = new MainAdapter(this,sectionList,itemList);
        GridLayoutManager manager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);
        adapter.setLayoutManager(manager);
        adapter.shouldShowHeadersForEmptySections(false);
        recyclerView.setAdapter(adapter);

    }


}