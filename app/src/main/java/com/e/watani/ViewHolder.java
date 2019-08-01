package com.e.watani;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return false;
            }
        });
    }

    public void setDetails(Context ctx, String title, String description,String image, String date, String source, String jam){
        TextView mTitleTv = mView.findViewById(R.id.rTitleTv);
        TextView mDetailTv = mView.findViewById(R.id.rDescription);
        ImageView mImageIv = mView.findViewById(R.id.rImageView);
        TextView mDateTv = mView.findViewById(R.id.rDateTv);
        TextView mSumberTv = mView.findViewById(R.id.rSumberTv);
        TextView mJamTv = mView.findViewById(R.id.rJamTv);

        mTitleTv.setText(title);
        mDetailTv.setText(description);
        mDateTv.setText(date);
        mSumberTv.setText(source);
        mJamTv.setText(jam);
        Picasso.get().load(image).into(mImageIv);

    }


    private ClickListener mClickListener;

    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);

    }

    public void setOnClickListener(ClickListener clickListener){
        mClickListener = clickListener;
    }
}
