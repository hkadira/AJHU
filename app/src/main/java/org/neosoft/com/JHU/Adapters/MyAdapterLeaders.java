package org.neosoft.com.JHU.adapters;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.activity.LeaderboardItemObject;
import org.neosoft.com.JHU.activity.MainDashboardActivity;
import org.neosoft.com.JHU.fragments.LeaderDescriptionFragment;

import java.util.List;

public class MyAdapterLeaders extends RecyclerView.Adapter<MyAdapterLeaders.MyViewHolder> {
    private List<LeaderboardItemObject> leaderList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public TextView txtName;
        public TextView txtTitle;
        public ImageView actionPhoto;

        public MyViewHolder(View view) {
            super(view);
            mView = view;

            txtName = (TextView) view.findViewById(R.id.txtName);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            actionPhoto = (ImageView)view.findViewById(R.id.photo);
        }
    }

    public MyAdapterLeaders(List<LeaderboardItemObject> leaderList) {
        this.leaderList = leaderList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leaders_view_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txtName.setText(leaderList.get(position).getName());
        holder.txtTitle.setText(leaderList.get(position).getTitle());
        holder.actionPhoto.setImageResource(leaderList.get(position).getPhoto());

        final String name=leaderList.get(position).getName();
        final String title=leaderList.get(position).getTitle();
        final int img=leaderList.get(position).getPhoto();

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(v.getContext(), holder.txtName.getText().toString(), Toast.LENGTH_SHORT).show();
                MainDashboardActivity myActivity = (MainDashboardActivity)view.getContext();
                FragmentTransaction transaction = myActivity.getSupportFragmentManager().beginTransaction();
                LeaderDescriptionFragment leaderFrg=new LeaderDescriptionFragment();
                leaderFrg.setValues(name,title,img);
                transaction.replace(R.id.container, leaderFrg);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return leaderList.size();
    }
}
