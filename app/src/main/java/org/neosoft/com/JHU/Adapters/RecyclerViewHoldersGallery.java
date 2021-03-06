package org.neosoft.com.JHU.adapters;

/**
 * Created by Neyomal on 12/21/2016.
 */

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.neosoft.com.JHU.R;
import org.neosoft.com.JHU.activity.MainDashboardActivity;
import org.neosoft.com.JHU.fragments.EventFragment;
import org.neosoft.com.JHU.fragments.GraphFragment;
import org.neosoft.com.JHU.fragments.HistoryFragment;
import org.neosoft.com.JHU.fragments.LeadersAllListFragment;
import org.neosoft.com.JHU.fragments.LeadershipMessageFragment;
import org.neosoft.com.JHU.fragments.MembershipFragment;
import org.neosoft.com.JHU.fragments.NewsFragment;
import org.neosoft.com.JHU.fragments.ProfileFragment;

public class RecyclerViewHoldersGallery extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView actionName;
    public ImageView actionPhoto;

    public RecyclerViewHoldersGallery(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        actionName = (TextView)itemView.findViewById(R.id.action_name);
        actionPhoto = (ImageView)itemView.findViewById(R.id.action_photo);
    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(view.getContext(), "Clicked Country Position = " + getPositi on(), Toast.LENGTH_SHORT).show();
        MainDashboardActivity myActivity = (MainDashboardActivity)view.getContext();
        FragmentTransaction transaction = myActivity.getSupportFragmentManager().beginTransaction();

        switch(getPosition()){
            case 1:
                transaction.replace(R.id.container, new HistoryFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 2:
                //transaction.replace(R.id.container, new TestFragment());
                transaction.replace(R.id.container, new LeadersAllListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 3:
                transaction.replace(R.id.container, new LeadershipMessageFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 4:
                transaction.replace(R.id.container, new MembershipFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 5:
                transaction.replace(R.id.container, new GraphFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 6:
                transaction.replace(R.id.container, new EventFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 7:
                transaction.replace(R.id.container, new ProfileFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 8:
                transaction.replace(R.id.container, new NewsFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            default:
                Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}