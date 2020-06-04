package com.example.flab_ulous.ReportBook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.flab_ulous.R;
import com.example.flab_ulous.API.ReportResponseModel;

public class ReportBookListAdapter extends RecyclerView.Adapter<ReportBookListAdapter.ReportListViewHolder> {
    private Context mContext;
    ReportResponseModel.Detail detailList;

    public ReportBookListAdapter(Context mContext, ReportResponseModel.Detail details) {
        this.mContext = mContext;
        this.detailList = details;
    }
    @NonNull
    @Override
    public ReportListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reportbook_view, parent, false);
        return new ReportListViewHolder(view.getRootView());
    }
    @Override
    public void onBindViewHolder(@NonNull ReportListViewHolder holder, int position) {
//        final ReportResponseModel.Detail detail = detailList.get(position);
        TextView tvLogDate = holder.itemView.findViewById(R.id.tvtest);
        tvLogDate.setText(detailList.getWeight().toString());


        CardView cardLogBookView = holder.itemView.findViewById(R.id.reportbookView);
        cardLogBookView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext,ReportRecordActivity.class));
            }
        });

    }
    @Override
    public int getItemCount() {
        if (detailList == null ){
            return  0;
        }else {
            return 1;
        }
    }
    public class ReportListViewHolder extends RecyclerView.ViewHolder {
        public ReportListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
