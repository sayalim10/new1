package com.devn.delivery.screens.feedback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.devn.delivery.R;

public class CompanyFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_company_fragment, container, false);

        RecyclerView company = view.findViewById(R.id.company);

        String[] feedback = {"Massage#1","Massage#2"};
        company.setAdapter(new CompanyAdapter(feedback));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        company.setLayoutManager(layoutManager);

        return view;
    }
}
