package com.example.plantmanager.layouts.fragments;

import android.app.Activity;
import android.os.Bundle;

import com.example.plantmanager.enums.PlantBreed;
import com.example.plantmanager.layouts.PlantTypeDetailActivity;
import com.example.plantmanager.layouts.PlantTypeListActivity;
import com.example.plantmanager.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plantmanager.dummy.PlantTypeObject;

/**
 * A fragment representing a single PlantType detail screen.
 * This fragment is either contained in a {@link PlantTypeListActivity}
 * in two-pane mode (on tablets) or a {@link PlantTypeDetailActivity}
 * on handsets.
 */
public class PlantTypeDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private PlantBreed mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlantTypeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = (PlantBreed) getArguments().getSerializable(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.planttype_detail, container, false);

        // Show the dummy content as text in a TextView.
//        if (mItem != null) {
//            (rootView.findViewById(R.id.planttype_detail)).setText(mItem.getName());
//        }
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.typefield)).setText(mItem.getPlantType().toString());
        }
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.descfield)).setText(mItem.getDescriptionID());
        }
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.waterfield)).setText(mItem.getWaterLevel().toString());
        }
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.sunfield)).setText(mItem.getSunlightLevel().toString());
        }

        return rootView;
    }
}