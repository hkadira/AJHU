package org.neosoft.com.JHU.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.activity.DashboardGalleryItemObject;
import org.neosoft.com.JHU.adapters.RecyclerViewAdapterGallery;
import org.neosoft.com.JHU.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rView;
    private GridLayoutManager lLayout;
    private FragmentMainBinding mBinding;


    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        //Items
        List<DashboardGalleryItemObject> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(getContext(), 3);

        rView= mBinding.recyclerViewGallery;
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapterGallery rcAdapter = new RecyclerViewAdapterGallery(getContext(), rowListItem);
        rView.setAdapter(rcAdapter);

        return mBinding.getRoot();
    }

    //Adding items to the grid
    private List<DashboardGalleryItemObject> getAllItemList(){
        List<DashboardGalleryItemObject> allItems = new ArrayList<DashboardGalleryItemObject>();
        allItems.add(new DashboardGalleryItemObject(getResources().getString(R.string.values), R.drawable.one));
        allItems.add(new DashboardGalleryItemObject(getResources().getString(R.string.history), R.drawable.two));
        allItems.add(new DashboardGalleryItemObject(getResources().getString(R.string.leaders), R.drawable.three));
        allItems.add(new DashboardGalleryItemObject(getResources().getString(R.string.message), R.drawable.four));
        allItems.add(new DashboardGalleryItemObject(getResources().getString(R.string.membership), R.drawable.five));
        allItems.add(new DashboardGalleryItemObject(getResources().getString(R.string.poll), R.drawable.six));
        allItems.add(new DashboardGalleryItemObject(getResources().getString(R.string.events), R.drawable.seven));
        allItems.add(new DashboardGalleryItemObject(getResources().getString(R.string.profile), R.drawable.eight));
        allItems.add(new DashboardGalleryItemObject(getResources().getString(R.string.news), R.drawable.one));

        return allItems;
    }

}
