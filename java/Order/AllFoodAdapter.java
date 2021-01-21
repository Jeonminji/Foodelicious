package com.example.fd1.Order;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fd1.R;

import java.util.ArrayList;

public class AllFoodAdapter extends RecyclerView.Adapter<AllHolder> implements View.OnClickListener {
    private Context mContext;
    ArrayList<Food> foods;
    public String TAG = "ALLFOOD";

    public AllFoodAdapter(Context context, ArrayList<Food> foods) {
        mContext = context;
        this.foods = foods;
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view, String.valueOf(view.getTag()));
        }
        else {
            Log.e("CLICK", "ERROR");
        }
    }

    @Override
    public AllHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cardview_orderlist, parent, false);
        AllHolder allHolder = new AllHolder(v);
        v.setOnClickListener(this);
        return allHolder;
    }

    @Override
    public void onBindViewHolder(AllHolder holder, int position) {
        holder.mTextName.setText(foods.get(position).getName());
        holder.mTextPrice.setText(String.valueOf(foods.get(position).getPrice()));
        holder.mImageView.setImageBitmap(foods.get(position).getImage());
        holder.itemView.setTag(foods.get(position).getId());
    }

    @Override
    public int getItemCount() { return foods.size(); }

    public void notifyData(ArrayList<Food> foods) {
        this.foods = foods;
        notifyDataSetChanged();
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemCLickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}

class AllHolder extends RecyclerView.ViewHolder {
    ImageView mImageView;
    TextView mTextName, mTextPrice;

    public AllHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.image);
        mTextName = (TextView) itemView.findViewById(R.id.food_name);
        mTextPrice = (TextView) itemView.findViewById(R.id.price);
    }
}
