package com.example.cs441project5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoRVAdapter extends RecyclerView.Adapter<VideoRVAdapter.ViewHolder> {

    private ArrayList<VideoRVModel> videoRVModelArrayList;
    private Context context;
    private VideoClickInterface videoClickInterface;

    public VideoRVAdapter(ArrayList<VideoRVModel> videoRVModelArrayList, Context context, VideoClickInterface videoClickInterface) {
        this.videoRVModelArrayList = videoRVModelArrayList;
        this.context = context;
        this.videoClickInterface = videoClickInterface;
    }

    @NonNull
    @Override
    public VideoRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoRVAdapter.ViewHolder holder, int position) {
        VideoRVModel videoRVModel = videoRVModelArrayList.get(position);
        holder.thumbNailIV.setImageBitmap(videoRVModel.getThumbNail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoClickInterface.onVideoClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {

        return videoRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView thumbNailIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbNailIV = itemView.findViewById(R.id.idIVThumNail);
        }
    }

    public interface VideoClickInterface{
        void onVideoClick(int position);
    }
}
