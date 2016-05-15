package com.nickjwpark.classlist;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {

    HashMap<String, String[]> classlist;
    String tag = "debugging";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classlist= new HashMap<String, String[]>();
        classlist.put("철수", new String[] {"일성초등학교", "chulsoo@gmail.com", "010-2534-2975"});
        classlist.put("영희", new String[] {"민원중학교", "younghee@gmail.com", "010-4249-7252"});
        classlist.put("민수", new String[] {"세종고등학교", "minsoo@gmail.com", "010-9824-1232"});
        classlist.put("셋별", new String[] {"남원대학교", "saetbyul@gmail.com", "010-8822-1893"});

        ArrayList<String> names = new ArrayList<String>();

        for (String key : classlist.keySet()) {
            names.add(key);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);

    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);

        String name = o.toString();
        String school = classlist.get(name)[0];
        String email = classlist.get(name)[1];
        String phone = classlist.get(name)[2];

        Activity fromActivity = MainActivity.this;
        Class toActivity = DetailActivity.class;
        Intent intent = new Intent(fromActivity,toActivity);

        intent.putExtra("name", name);
        intent.putExtra("school", school);
        intent.putExtra("email", email);
        intent.putExtra("phone", phone);

        startActivity(intent);
    }
}
