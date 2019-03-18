package com.devn.delivery.screens.feedback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devn.delivery.R;

public class ComplaintsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_complaint_fragment, container, false);

        RecyclerView complaint = view.findViewById(R.id.Complaint);

        String[] feedback = {"Massage#1","Massage#2"};
        complaint.setAdapter(new ComplaintsAdapter(feedback));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        complaint.setLayoutManager(layoutManager);

        return view;
    }
}
