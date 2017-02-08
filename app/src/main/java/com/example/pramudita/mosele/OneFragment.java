package com.example.pramudita.mosele;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pramudita.mosele.R;

/**
 * Created by noonart on 10/09/2016.
 */
public class OneFragment extends Fragment {

    public OneFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.nav_home, container, false);
    }
}

