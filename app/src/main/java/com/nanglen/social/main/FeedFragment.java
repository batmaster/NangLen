package com.nanglen.social.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nanglen.social.R;
import com.nanglen.social.services.NangLenApplication;

public class FeedFragment extends Fragment {

    private static NangLenApplication app;

    private static FeedFragment fragment;

    public static FeedFragment getInstance() {
        if (fragment == null) {
            fragment = new FeedFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        app = (NangLenApplication) getActivity().getApplication();

        View v = inflater.inflate(R.layout.fragment_feed, container, false);

        return v;
    }

}
