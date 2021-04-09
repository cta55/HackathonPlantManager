package com.example.plantmanager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plantmanager.R;

/**
 * Simple fragment that handles the placement of a text header
 */

public class HeaderFragment extends Fragment {

    // String key for passing in header text
    private static final String HEADER_TEXT_CODE = "header_text";
    // Default value, shouldn't appear in finished product
    private static final String DEFAULT_HEADER_TEXT = "DEFAULT_TEXT";

    // Inputted text to show in header
    private String headerText;
    // TextView that exists in header layout
    private TextView headerTextView;

    /**
     * Private basic constructor used in the static method.
     */
    private HeaderFragment() {
    }

    /**
     * Static method used to instantiate new header fragments with a specific value for header text
     * @param headerText : The text to appear in the header
     * @return : A HeaderFragment object bundled with a specific header text
     */
    public static HeaderFragment newHeader(String headerText) {
        // Instantiating basic object
        HeaderFragment fragment = new HeaderFragment();
        Bundle args = new Bundle();
        // Adding inputted headerText value into object
        args.putString(HEADER_TEXT_CODE, headerText);
        fragment.setArguments(args);

        // Passing fragment back out
        return fragment;
    }

    /**
     * Standard view method that runs when fragment is added to screen. Takes headerText from bundle
     * and saves it into the headerText field.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieving headerText value from bundle
        if (getArguments() != null) {
            headerText = savedInstanceState.getString(HEADER_TEXT_CODE);
        } else {
            headerText = DEFAULT_HEADER_TEXT;
        }
    }

    /**
     * Standard fragment method that runs when fragment is added to view. Gets TextView from id and
     * assigns it the value that was stored in headerText
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_header, null);

        // Getting text view
        headerTextView = (TextView) root.findViewById(R.id.headerTextView);
        headerTextView.append(headerText);
        return root;
    }
}