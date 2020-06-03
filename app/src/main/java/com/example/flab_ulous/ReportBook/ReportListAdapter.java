package com.example.flab_ulous.ReportBook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flab_ulous.API.ReportResponseModel;
import com.example.flab_ulous.R;

public class ReportListAdapter extends RecyclerView.Adapter<ReportListAdapter.RecordViewHolder> {
    private Context mContext;
    ReportResponseModel.Detail detail;

    public ReportListAdapter(Context mContext, ReportResponseModel.Detail detail){
        this.mContext = mContext;
        this.detail = detail;
    }
    @NonNull
    @Override
    public ReportListAdapter.RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record_reportbook_view, parent, false);
        return new RecordViewHolder(view.getRootView());
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        TextView tvWeight = holder.itemView.findViewById(R.id.tvweight);
        tvWeight.setText(detail.getWeight().toString());
        TextView tvBmi = holder.itemView.findViewById(R.id.tvBmi);
        tvBmi.setText(detail.getBmi().toString());
        TextView tvBodyfat = holder.itemView.findViewById(R.id.tvBodyfat);
        tvBodyfat.setText(detail.getBodyfat().toString());
        TextView tvChestsize = holder.itemView.findViewById(R.id.tvChestsize);
        tvChestsize.setText(detail.getChestsize().toString());
        TextView tvArmsize = holder.itemView.findViewById(R.id.tvArmsize);
        tvArmsize.setText(detail.getArmsize().toString());
        TextView tvWaist = holder.itemView.findViewById(R.id.tvWaist);
        tvWaist.setText(detail.getWaist().toString());
        TextView tvHipsize = holder.itemView.findViewById(R.id.tvHipsize);
        tvHipsize.setText(detail.getHip().toString());
        TextView tvtotalcholesterol = holder.itemView.findViewById(R.id.tvTotalcholesterol);
        tvtotalcholesterol.setText(detail.getTotalcholesterol().toString());
        TextView tvHdl = holder.itemView.findViewById(R.id.tvHdl);
        tvHdl.setText(detail.getHdl().toString());
        TextView tvLdl = holder.itemView.findViewById(R.id.tvLdl);
        tvLdl.setText(detail.getLdl().toString());
        TextView tvVldl = holder.itemView.findViewById(R.id.tvVldl);
        tvVldl.setText(detail.getVldl().toString());
        TextView tvtryglycerides = holder.itemView.findViewById(R.id.tvtryglycerides);
        tvtryglycerides.setText(detail.getTriglycerides().toString());

    }

    @Override
    public int getItemCount() {
        if (detail == null ){
            return  0;
        }else {
            return 1;
        }
    }
    public class RecordViewHolder extends RecyclerView.ViewHolder{
        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
