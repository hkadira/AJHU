package org.neosoft.com.JHU.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.neosoft.com.JHU.Adapters.MyAdapterLeaders;
import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.activity.LeaderboardItemObject;

import java.util.ArrayList;
import java.util.List;

public class LeadersAllListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Context context;;

    public LeadersAllListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_leaders,
                container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_leaders);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Items
        //ArrayList<LeaderboardItemObject> myDataset = getAllItemList();
        List<LeaderboardItemObject> myDataset = getAllLeaderList();

        context = getContext();
        // specify an adapter (see also next example)
        mAdapter = new MyAdapterLeaders(myDataset);
        //mAdapter = new TestAdapter(context,myDataset);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    //Adding items
    public ArrayList<String> getAllItemList() {
        ArrayList<String> allItems = new ArrayList<String>();
        allItems.add("Soma Thero");
        allItems.add("Ahrualiye Rathana Thero");
        allItems.add("Chamipika Ranawaka");
        return allItems;
    }

    private List<LeaderboardItemObject> getAllLeaderList(){
        List<LeaderboardItemObject> allItems = new ArrayList<LeaderboardItemObject>();
        allItems.add(new LeaderboardItemObject(getResources().getString(R.string.pathali),
                getResources().getString(R.string.leader),R.drawable.one));
        allItems.add(new LeaderboardItemObject(getResources().getString(R.string.rathana),
                getResources().getString(R.string.vip),R.drawable.two));

        return allItems;
    }
}

