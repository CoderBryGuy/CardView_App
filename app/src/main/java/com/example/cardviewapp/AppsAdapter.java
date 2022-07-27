package com.example.cardviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;
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
        AppsModel appsModel = mAppsModelList.get(position);

//        holder.mImageView.setImageResource(appsModel.getThumbnail());
        holder.mTextViewTitle.setText(appsModel.getName());
        holder.mTextViewCount.setText(appsModel.getNumOfDownloads());

        Glide.with(mContext)
                .load(appsModel
                .getThumbnail())
                .into(holder.mImageView);
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
