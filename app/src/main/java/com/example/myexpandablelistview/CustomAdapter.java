package com.example.myexpandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {

     List<String> listdataHead;


    HashMap<String,List<String>> hashListDataChild;
   Context context;


    public CustomAdapter(Context context, List<String> listdataHead, HashMap<String, List<String>> hashListDataChild) {

        this.listdataHead = listdataHead;
        this.hashListDataChild = hashListDataChild;
        this.context = context;


    }


    @Override
    public int getGroupCount() {
        return listdataHead.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {


        return hashListDataChild.get(listdataHead.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return  listdataHead.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {


        return hashListDataChild.get(listdataHead.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {


        String headtext = (String) getGroup(groupPosition);


        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.sample, null);


        }

        TextView htextView = convertView.findViewById(R.id.SAmple_TextView_id);
        htextView.setText(headtext);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String chiltext = (String) getChild(groupPosition, childPosition);


        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.child_layout, null);


        }

        TextView CtextView = convertView.findViewById(R.id.Child_TextView_ID);
        CtextView.setText(chiltext);
        CtextView.setTextIsSelectable(true);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
