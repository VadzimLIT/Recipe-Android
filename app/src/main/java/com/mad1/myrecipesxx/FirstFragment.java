package com.mad1.myrecipesxx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private RecyclerView categories_recycler_view;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//**************************************************************************
        categories_recycler_view = view.findViewById(R.id.categories_recycle_view);

        titles = new ArrayList<>();
        images = new ArrayList<>();
        titles.add("One");
        titles.add("Two");
        titles.add("Three");
        titles.add("Four");

        images.add(R.drawable.dinner_categories);
        images.add(R.drawable.drinks_categories);
        images.add(R.drawable.soup_categories);
        images.add(R.drawable.head_image);

        adapter = new Adapter(getContext(), titles, images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2, GridLayoutManager.VERTICAL, false);
        categories_recycler_view.setLayoutManager(gridLayoutManager);
        categories_recycler_view.setAdapter(adapter);
//*******************************************************************************
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}