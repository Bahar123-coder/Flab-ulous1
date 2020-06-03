package com.example.flab_ulous.DietList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flab_ulous.API.DietPlanResponseModel;
import com.example.flab_ulous.R;

public class DietListAdapter extends RecyclerView.Adapter<DietListAdapter.DietListViewHolder>{
    private Context mContext;
    DietPlanResponseModel.Details dietList;
    public DietListAdapter(Context mContext, DietPlanResponseModel.Details details) {
        this.mContext = mContext;
        this.dietList = details;
    }
    @NonNull
    @Override
    public DietListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dietlist, parent, false);
        return new DietListViewHolder(view.getRootView());
    }

    @Override
    public void onBindViewHolder(@NonNull DietListViewHolder holder, int position) {
//        final DietPlanResponseModel.Details diet = dietList.get(position);
        TextView tvBreakfastPlan = holder.itemView.findViewById(R.id.tvBreakfastPlan);
        tvBreakfastPlan.setText(dietList.getBreakfast());
        TextView tvBreakfastTime = holder.itemView.findViewById(R.id.tvBreakfastTime);
        tvBreakfastTime.setText(dietList.getBreakfasttime());


        TextView tvLunchPlan = holder.itemView.findViewById(R.id.tvLunchPlan);
        tvLunchPlan.setText(dietList.getLunch());
        TextView tvLunchTime = holder.itemView.findViewById(R.id.tvLunchTime);
        tvLunchTime.setText(dietList.getLunchtime());


        TextView tvSnacksPlan = holder.itemView.findViewById(R.id.tvSnacksPlan);
        tvSnacksPlan.setText(dietList.getSnacks());
        TextView tvSnacksTime = holder.itemView.findViewById(R.id.tvSnacksTime);
        tvSnacksTime.setText(dietList.getSnackstime());


        TextView tvDinnerPlan = holder.itemView.findViewById(R.id.tvDinnerPlan);
        tvDinnerPlan.setText(dietList.getDinner());
        TextView tvDinnerTime = holder.itemView.findViewById(R.id.tvDinnerTime);
        tvDinnerTime.setText(dietList.getDinnertime());

    }
    @Override
    public int getItemCount() {
        if (dietList == null) {
            return 0;
        } else {
            return 1;
        }
    }
    public class DietListViewHolder extends RecyclerView.ViewHolder {
        public DietListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



}
