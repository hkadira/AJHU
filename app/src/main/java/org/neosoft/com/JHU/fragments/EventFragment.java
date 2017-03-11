package org.neosoft.com.JHU.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import org.neosoft.com.JHU.App;
import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.adapters.EventsExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */


public class EventFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    String itemclicked,header;
    HashMap<String, List<String>> listDataChild;
    int position;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //FacebookSdk.sdkInitialize(getApplicationContext());

        view = inflater.inflate(R.layout.fragment_event, container, false);
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.exp_listview);
        // preparing list data
        preparedlist();
        listAdapter = new EventsExpandableListAdapter(App.getsContext(), listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setDividerHeight(2);
        expListView.setGroupIndicator(null);
        expListView.setClickable(true);
        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Toast.makeText(App.getsContext(),
                        "Group Clicked " + listDataHeader.get(groupPosition),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(App.getsContext(),listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(App.getsContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });
        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                header=listDataHeader.get(groupPosition);
                // TODO Auto-generated method stub
                Toast.makeText(
                        App.getsContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition),Toast.LENGTH_SHORT).show();
                return false;
            }

        });

        return view;
    }

    private void preparedlist()
    {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Business");
        List<String> Business=new ArrayList<String>();
        Business.add("Breaking Business News");
        Business.add("International Business News");

        listDataHeader.add("Entertainment");
        List<String> Entertainment=new ArrayList<String>();
        Entertainment.add("Arts");
        Entertainment.add("Books");
        Entertainment.add("Breaking Entertaiment");
        Entertainment.add("Movies");
        Entertainment.add("Music");
        Entertainment.add("Television");
        Entertainment.add("Weried");


        listDataHeader.add("Health");
        List<String> Health=new ArrayList<String>();
        Health.add("Aging News");
        Health.add("Breaking Health News");
        Health.add("Cancer News");
        Health.add("Fitness News");
        Health.add("Healthcare News");
        Health.add("Medical News");
        Health.add("Natural Health News");
        Health.add("Physcology News");
        Health.add("Public Health News");

        listDataHeader.add("Markets");
        List<String> Markets=new ArrayList<String>();
        Markets.add("Breaking Financial Market News");
        Markets.add("Stock Markets News");
        Markets.add("Commodities News");
        Markets.add("Foreign Exchange News");
        Markets.add("Tech Markets News");
        Markets.add("UK Market News");
        Markets.add("US Market News");
        Markets.add("World Market News");

        listDataChild.put(listDataHeader.get(0), Business); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Entertainment);
        listDataChild.put(listDataHeader.get(2), Health);
        listDataChild.put(listDataHeader.get(3), Markets);
    }

}