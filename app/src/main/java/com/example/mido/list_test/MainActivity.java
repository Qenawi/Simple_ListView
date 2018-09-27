package com.example.mido.list_test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list_id);
        ArrayList<Model> models = new ArrayList<Model>();
        models.add(new Model("Mido", "Student"));
        models.add(new Model("Medhat", "Student"));
        models.add(new Model("Mohamed", "Student"));
        MyCustommAdapter adapter = new MyCustommAdapter(models, MainActivity.this);

        list.setAdapter(adapter);
    }


    class MyCustommAdapter extends BaseAdapter {
        ArrayList<Model> models = new ArrayList<Model>();
        Context c;

        public MyCustommAdapter(ArrayList<Model> models, Context context) {
            this.models = models;
            c = context;
        }

        @Override
        public int getCount() {
            if (models==null||models.isEmpty()){return 1;}
            // app will crash if list was empty
            return models.size();
        }

        @Override
        public Object getItem(int i) {
            return models.get(i).Name;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            if (view ==null)
            {
                //only inflate view if it was empty
                view = LayoutInflater.from(c).inflate(R.layout.my_view, viewGroup,false);

            }

            TextView name = (TextView) view.findViewById(R.id.name);
            TextView des = (TextView) view.findViewById(R.id.desc);

            name.setText(models.get(i).Name);
            des.setText(models.get(i).Desc);

            return view;
        }
    }
}
