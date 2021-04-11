package com.example.plantmanager.layouts.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantmanager.R;

import java.util.List;

public class PlantPictureAdapter extends RecyclerView.Adapter<PlantPictureAdapter.ViewHolder>{

    private final List<PlantInstancePictureFragment> fragmentList;
    private final FragmentManager manager;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentContainerView containerView;

        public ViewHolder(@NonNull View plantImageFragmentLayoutView) {
            super(plantImageFragmentLayoutView);
            containerView = (FragmentContainerView) plantImageFragmentLayoutView.findViewById(R.id.plantInstanceImageFragmentContainerView);
        }

        public FragmentContainerView getContainerView() {
            return containerView;
        }
    }

    public PlantPictureAdapter(List<PlantInstancePictureFragment> fragmentList, FragmentManager manager) {
        this.fragmentList = fragmentList;
        this.manager = manager;
    }


    @NonNull
    @Override
    public PlantPictureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_image_fragment_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantPictureAdapter.ViewHolder holder, int position) {
        manager.beginTransaction()
                .setReorderingAllowed(true)
                .add(holder.containerView.getId(), fragmentList.get(position))
                .commit();
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
