package org.neosoft.com.JHU.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.neosoft.com.JHU.R;

public class LeaderDescriptionFragment extends Fragment{


    String name,title;
    int img;

    public LeaderDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_leader_description, container, false);

        TextView nameHolder = (TextView) view.findViewById(R.id.name);
        TextView titleHolder = (TextView) view.findViewById(R.id.title);
        ImageView image =(ImageView) view.findViewById(R.id.thumbnail);

        nameHolder.setText(name);
        titleHolder.setText(title);
        image.setImageResource(img);

        return view;
    }

    public void setValues(String name,String title,int img) {
        this.name=name;
        this.title=title;
        this.img=img;
    }
}
