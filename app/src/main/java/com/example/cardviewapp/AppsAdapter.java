package com.example.cardviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.ViewHolder> {

    private Context mContext;
    private List<AppsModel> mAppsModelList;

    public AppsAdapter(Context context, List<AppsModel> appsModelList) {
        mContext = context;
        mAppsModelList = appsModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       final AppsModel appsModel = mAppsModelList.get(position);

//        holder.mImageView.setImageResource(appsModel.getThumbnail());
        holder.mTextViewTitle.setText(appsModel.getName());
        holder.mTextViewCount.setText(appsModel.getNumOfDownloads() + " users");

        Glide.with(mContext)
                .load(appsModel
                .getThumbnail())
                .into(holder.mImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display a toast message to the user
                //display the title of the card
                Toast.makeText(mContext, "You clicked: " + appsModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAppsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextViewTitle, mTextViewCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.thumbnail);
            mTextViewTitle = itemView.findViewById(R.id.title);
            mTextViewCount = itemView.findViewById(R.id.count);
        }

    }
}
