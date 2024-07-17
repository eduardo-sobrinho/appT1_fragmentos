package com.example.appt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Fragment1 frag1 = new Fragment1();
            ft.add(R.id.layout_direito, frag1);
        }
        String[] lista = new String[]{"Fragmento 1", "Fragmento 2", "Fragmento 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, lista);
        ListView lv = findViewById(R.id.list1);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Fragment1 frag1 = new Fragment1();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.layout_direito, frag1, "frag1");
                    ft.commit();
                } else if (position == 1) {
                    Fragment2 frag2 = new Fragment2();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.layout_direito, frag2, "frag2");
                    ft.commit();
                } else if (position == 2) {
                    Fragment3 frag3 = new Fragment3();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.layout_direito, frag3, "frag3");
                    ft.commit();
                }
            }
        });
    }
}
