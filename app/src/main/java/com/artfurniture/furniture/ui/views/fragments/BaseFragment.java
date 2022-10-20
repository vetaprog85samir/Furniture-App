package com.artfurniture.furniture.ui.views.fragments;

import com.artfurniture.furniture.ui.views.activities.BaseActivity;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public BaseActivity baseActivity;

    public void setUpActivity() {
        baseActivity = (BaseActivity) getActivity();

        baseActivity.baseFragment = this;
    }

    public void onBack() {
        baseActivity.superBackPressed();
    }

}
