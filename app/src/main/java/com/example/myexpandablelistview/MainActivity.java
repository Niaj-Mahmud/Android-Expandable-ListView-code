package com.example.myexpandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ExpandableListView expandableListView;
    List<String> listdataHead;

    private CustomAdapter customAdapter;
    HashMap<String, List<String>> hashListDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        expandableListView = findViewById(R.id.expanded_menu_ID);
        prepareListDAta();
        customAdapter = new CustomAdapter(this, listdataHead, hashListDataChild);


        expandableListView.setAdapter(customAdapter);

    }

    private void prepareListDAta() {
        String[] headData = getResources().getStringArray(R.array.header_name);
        String[] childdata = getResources().getStringArray(R.array.child_Details);

        listdataHead = new ArrayList<>();
        hashListDataChild = new HashMap<>();

        for (int i = 0; i < headData.length; i++) {



            listdataHead.add(headData[i]);

            List<String> child = new ArrayList<>();
            child.add(childdata[i]);

            hashListDataChild.put(listdataHead.get(i), child);

        }


    }
}