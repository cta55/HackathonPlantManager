package com.example.plantmanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.plantmanager.dummy.ListenerViewModel;

/**
 * Simple fragment that adds a specifically sized button, takes a string input for the button text
 * and utilises ListenerViewModel to take an onClickListener input.
 */
public class FooterButtonFragment extends Fragment {

    // Key for passing button text string through bundle
    private static final String BUTTON_TEXT_KEY = "button_text";
    // Default value for button text, shouldn't appear in finished product
    private static final String DEFAULT_BUTTON_TEXT = "DEFAULT_TEXT";

    // View model for sharing onClickListener with parent
    private ListenerViewModel viewModel;

    // Button variables
    private String footerButtonText;
    private Button footerButton;

    /**
     * Private constructor to ensure all fragment construction is done via static method
     */
    private FooterButtonFragment() {
    }

    /**
     * Static constructor method to allow for the passing of bundled string values
     * @param footerButtonText : The text to appear on the button
     * @return : A button with specific text that awaits a listener
     */
    public static FooterButtonFragment newFooter(String footerButtonText) {
        // Standard object creation
        FooterButtonFragment fragment = new FooterButtonFragment();
        // Adding string to bundle
        Bundle args = new Bundle();
        args.putString(BUTTON_TEXT_KEY, footerButtonText);
        fragment.setArguments(args);
        // Returning setup fragment
        return fragment;
    }

    /**
     * Standard view function that runs when created. Takes string from bundle and saves it to
     * variable.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            footerButtonText = getArguments().getString(BUTTON_TEXT_KEY);
        } else {
            footerButtonText = DEFAULT_BUTTON_TEXT;
        }
    }

    /**
     * Standard fragment function that runs when added to screen. Gets button from id and applies
     * text to it.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_footer_button, container, false);
        // Getting button
        footerButton = root.findViewById(R.id.footerButton);
        footerButton.setText(footerButtonText);
        return root;
    }

    /**
     * Standard fragment function. Gets listener from parent's ListenerViewModel and applies it to
     * button. Will probably crash if parent never sets a ListenerViewModel
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ListenerViewModel.class);
        footerButton.setOnClickListener(viewModel.getListener());
    }
}