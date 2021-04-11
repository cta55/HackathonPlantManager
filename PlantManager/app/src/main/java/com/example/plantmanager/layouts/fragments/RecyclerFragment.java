package com.example.plantmanager.layouts.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.plantmanager.viewModels.PlantImageFragmentViewModel;

import java.util.List;

public class RecyclerFragment extends Fragment {

    PlantImageFragmentViewModel viewModel;
    List<PlantInstancePictureFragment> plantInstancePictureFragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(PlantImageFragmentViewModel.class);
        plantInstancePictureFragments = viewModel.getList();
    }

}
