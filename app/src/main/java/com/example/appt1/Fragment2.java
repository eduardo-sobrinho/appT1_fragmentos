package com.example.appt1;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    String item;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_2, null);
        TextView tv = view.findViewById(R.id.txtFrag2);
        final Spinner spinner = view.findViewById(R.id.spinner1);
        tv.setText("Fragmento 2");

        String sons[] = new String[]{"Alarme", "telefone tocando", "sirene policial", "uivo canino"};
        ArrayAdapter<String> adapterSons = new ArrayAdapter<String>
                (view.getContext(), android.R.layout.simple_expandable_list_item_1, sons);
        spinner.setAdapter(adapterSons);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object obj = parent.getItemIdAtPosition(position);
                item = obj.toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final Button saveBtn = (Button) view.findViewById(R.id.btnSom);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                MediaPlayer mediaPlayer;
                if (item.compareTo("1") == 0) {
                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.ringing_phone);
                    mediaPlayer.start();
                } else if (item.compareTo("2") == 0) {
                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.cop_car_siren);
                    mediaPlayer.start();
                } else if (item.compareTo("3") == 0) {
                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.dog_howling);
                    mediaPlayer.start();
                }
            }
        });
        return view;
    }
}
