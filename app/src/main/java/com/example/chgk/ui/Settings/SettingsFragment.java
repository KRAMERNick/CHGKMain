package com.example.chgk.ui.Settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.chgk.LoginActivity;
import com.example.chgk.R;


public class SettingsFragment extends Fragment {

    private Button exit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings_fragment, container, false);
        exit = v.findViewById(R.id.button2);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Уничтожение соеденения
                Intent i = new Intent (getContext(), LoginActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        return v;
    }
}
