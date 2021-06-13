package com.example.fastrestowner.fragments.members;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fastrestowner.R;
import com.example.fastrestowner.controllers.PersonalProvider;

public class MembersFragment extends Fragment {

    RecyclerView recyclerView;
    MembersAdapter membersAdapter;
    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_members, container, false);

        recyclerView = root.findViewById(R.id.list);
        membersAdapter = new MembersAdapter(PersonalProvider.getInstance().getRestaurants(), requireContext(), getResources().getDisplayMetrics().density);
        recyclerView.setAdapter(membersAdapter);

        return root;
    }
}