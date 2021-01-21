package com.example.fd1.Order;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fd1.R;

public class OrderList extends RecyclerView.Adapter<OrderHolder> implements View.OnClickListener {
    private Context mContext;
    private final String TaG = "ADAPTER";

    public OrderList(Context context) {
        mContext = context;
    }

    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_orderlist, parent,false);
        OrderHolder orderHolder = new OrderHolder(view);
        return orderHolder;
    }

    @Override
    public void onBindViewHolder(final OrderHolder holder, int position) {

        int id = ShoppingOrderItem.getInstance(mContext).getFoodInOrder().get(position);
    }

    public void deleteData(int position) {
        int id = ShoppingOrderItem.getInstance(mContext).getFoodInOrder().get(position);
        Food curFood = ShoppingOrderItem.getInstance(mContext).getFoodById(id);
        ShoppingOrderItem.getInstance(mContext).setFoodNumber(curFood, 0);

        //HomepageActivity.cartNumber.setText(String.valueOf(ShoppingCartItem.getInstance(mContext).getSize()));
        //OrderFragment.cart_total.setText(String.valueOf(ShoppingCartItem.getInstance(mContext).getPrice()));
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return ShoppingOrderItem.getInstance(mContext).getFoodTypeSize();
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

    private AllFoodAdapter.OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(AllFoodAdapter.OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view,String.valueOf(view.getTag()));
        }
        else{
            Log.e("CLICK", "ERROR");
        }
    }
}

class OrderHolder extends RecyclerView.ViewHolder {
    TextView mTextName, mTextPrice;
    ImageView mImage;
    TextView mQuantity;
    Button btn_minus;
    Button btn_plus;
    public OrderHolder(View itemView) {
        super(itemView);
        mTextName = (TextView) itemView.findViewById(R.id.food_name);
        mTextPrice = (TextView) itemView.findViewById(R.id.price);
        mQuantity = (TextView) itemView.findViewById(R.id.order_quantity);
        mImage = (ImageView) itemView.findViewById(R.id.image);
        btn_minus = (Button) itemView.findViewById(R.id.order_minus);
        btn_plus = (Button) itemView.findViewById(R.id.order_plus);
    }
}