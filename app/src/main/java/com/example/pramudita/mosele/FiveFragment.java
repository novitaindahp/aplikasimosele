package com.example.pramudita.mosele;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pramudita.mosele.R;

/**
 * Created by noonart on 10/09/2016.
 */
public class FiveFragment extends Fragment {

    public FiveFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.nav_modul, container, false);
    }
}

