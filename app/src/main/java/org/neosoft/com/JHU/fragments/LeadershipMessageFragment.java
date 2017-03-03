package org.neosoft.com.JHU.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.neosoft.com.JHU.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeadershipMessageFragment extends Fragment {
View view;

    public LeadershipMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.fragment_leadership_message, container, false);

        ImageView thumbnailView = (ImageView) view.findViewById(R.id.icon);
        TextView messageView = (TextView) view.findViewById(R.id.message_view);
        String text = getString(R.string.LeadersMessage);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        FlowTextHelper.tryFlowText(text, thumbnailView, messageView, display,20);

        return view;
    }

}
