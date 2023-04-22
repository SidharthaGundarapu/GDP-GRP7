package com.example.nursingsymposium.fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsymposium.ConferenceDataModel;
import com.example.nursingsymposium.ConferenceSchedulerActivity;
import com.example.nursingsymposium.DashBoardActivity;
import com.example.nursingsymposium.R;
import com.example.nursingsymposium.admin.AdminActivity;
import com.example.nursingsymposium.admin.AdminConferenceAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SchduleFragmentAdapter   extends RecyclerView.Adapter<SchduleFragmentAdapter.ViewHolder>{

    DashBoardActivity activity;
    ArrayList<ConferenceDataModel> list;

    public SchduleFragmentAdapter(DashBoardActivity dashBoardActivity, ArrayList<ConferenceDataModel> arrayList) {
        this.activity=dashBoardActivity;
        this.list=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.schdule_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ConferenceDataModel myListData = list.get(position);
        holder.event_name.setText(myListData.getName());
        holder.event_time.setText(myListData.getTime());
        Picasso.get().load(myListData.getImage()).into(holder.event_image);
       holder.layout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activity, ConferenceSchedulerActivity.class);
            intent.putExtra("name",myListData.getName());
            intent.putExtra("image",myListData.getImage());
            intent.putExtra("location",myListData.getLocation());
            intent.putExtra("date",myListData.getDate());
            intent.putExtra("time",myListData.getTime());
            intent.putExtra("speaker",myListData.getSpeaker());
            intent.putExtra("eventDescription",myListData.getEventDescription());
            intent.putExtra("aboutSpeaker",myListData.getAboutSpeaker());
            activity.startActivity(intent);

        }
    });


}

@Override
public int getItemCount() {
    return list.size();
}

public static class ViewHolder extends RecyclerView.ViewHolder {

    CircleImageView event_image;
    ConstraintLayout layout;
    TextView event_name,event_time;
    public ViewHolder(View itemView) {
        super(itemView);
        this.event_image = (CircleImageView) itemView.findViewById(R.id.event_image);
        this.event_name = (TextView) itemView.findViewById(R.id.event_name);
        this.event_time = (TextView) itemView.findViewById(R.id.event_time);
        this.layout = (ConstraintLayout) itemView.findViewById(R.id.layout);
    }
}
}