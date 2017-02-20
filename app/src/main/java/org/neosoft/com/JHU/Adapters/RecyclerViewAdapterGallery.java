package org.neosoft.com.JHU.adapters;

/**
 * Created by Neyomal on 12/21/2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.activity.DashboardGalleryItemObject;

import java.util.List;

public class RecyclerViewAdapterGallery extends RecyclerView.Adapter<RecyclerViewHoldersGallery> {

    private List<DashboardGalleryItemObject> itemList;
    private Context context;

    public RecyclerViewAdapterGallery(Context context, List<DashboardGalleryItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHoldersGallery onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_card_view_list_item, null);
        RecyclerViewHoldersGallery rcv = new RecyclerViewHoldersGallery(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHoldersGallery holder, int position) {
        holder.actionName.setText(itemList.get(position).getName());
        holder.actionPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}