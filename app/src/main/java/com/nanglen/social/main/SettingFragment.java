package com.nanglen.social.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import social.nanglen.com.nanglen.R;
import com.nanglen.social.services.NangLenApplication;

public class SettingFragment extends Fragment {

    private static NangLenApplication app;

    private static SettingFragment fragment;

    public static SettingFragment getInstance() {
        if (fragment == null) {
            fragment = new SettingFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        app = (NangLenApplication) getActivity().getApplication();

        View v = inflater.inflate(R.layout.fragment_add_detail, container, false);

        return v;
    }

}
