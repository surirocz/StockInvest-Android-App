package com.surirocz.stockinvest.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.surirocz.stockinvest.R;
import com.surirocz.stockinvest.modules.Company;

import java.util.List;


public class StockAdapter extends RecyclerView.Adapter<StockAdapter.PostViewHolder> {
    private List<Company> postsList;
    private OnItemClickListener mListener;
    private String userType;
    private Context mContext;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onItemAddMealClick(int position, String status);
        void onItemDelete(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgChangeArrow, btnPopup;
        public TextView companyTicker,companyPrice, companyName, companyPriceChange;
        public TextView postPrice;
        public TextView postStatus;
        public TextView postDescription;
        public Button btnAddMeal;

        public PostViewHolder(View itemView, final OnItemClickListener listener, Context mContext) {
            super(itemView);
            companyTicker = itemView.findViewById(R.id.company_ticker);
            companyPrice = itemView.findViewById(R.id.company_price);
            companyName = itemView.findViewById(R.id.company_name_or_shares);
            companyPriceChange = itemView.findViewById(R.id.company_price_change);
            imgChangeArrow = itemView.findViewById(R.id.img_change_arrow);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);

                        }
                    }
                }
            });

        }
    }

    public StockAdapter() {

    }

    public void setMealsList(List<Company> ordersList){
        postsList = ordersList;
        notifyDataSetChanged();
    }

    // method for filtering our recyclerview items.
    public void filterList(List<Company> filterlist) {
        // below line is to add our filtered
        // list in our course array list.
        postsList = filterlist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company, parent, false);
        //userType = Utils.getPrefsStr(USER_TYPE, "None", parent.getContext());
        mContext = parent.getContext();
        return new PostViewHolder(v, mListener, mContext);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Company currentItem = postsList.get(position);

        //holder.mImageView.setImageURI(Uri.parse(currentItem.getImageUrl()));
        holder.companyTicker.setText(currentItem.getTicker());
        holder.companyPrice.setText(String.valueOf(currentItem.getPrice()));
        holder.companyName.setText(currentItem.getName());
        holder.companyPriceChange.setText(String.valueOf(currentItem.getPrice()));


    }

    @Override
    public int getItemCount() {
        return (postsList != null)?postsList.size():0;
    }
}
