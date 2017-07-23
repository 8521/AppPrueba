package com.ilaquidain.cronometro;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ilaquidain on 20/11/2015.
 */
public class button_fragment extends Fragment  {
    Button button_countdown;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button, container, false);
        button_countdown = (Button) v.findViewById(R.id.button_countdown);
        button_countdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),countdown_activity.class);
                startActivity(intent);
            }
        });
        return v;
    }


}
