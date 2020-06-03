package com.example.flab_ulous.ReportBook;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flab_ulous.API.APIController;
import com.example.flab_ulous.API.APIInstance;
import com.example.flab_ulous.API.ReportResponseModel;
import com.example.flab_ulous.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportBookFragment extends Fragment {
    RecyclerView reportbook;
    View view;
    APIController apiController;

    public static ReportBookFragment newInstance() {
        ReportBookFragment fragment = new ReportBookFragment();
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_reportbook, container, false);
        setUpViews();
        return view;
    }
    private void setUpViews() {
        apiController = APIInstance.getRetrofitInstance().create(APIController.class);
        reportbook = view.findViewById(R.id.reportbook);
        reportbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReportRecordActivity.class);
                startActivity(intent);
            }
        });
        getReportBook();
    }
    private void getReportBook() {
        apiController.getReport(205).enqueue(new Callback<ReportResponseModel>() {
            @Override
            public void onResponse(Call<ReportResponseModel> call, Response<ReportResponseModel> response) {
                if (response.body().getDetails() != null) {
                    setUpReports(response.body());
                }
            }

            @Override
            public void onFailure(Call<ReportResponseModel> call, Throwable t) {
            }
        });
    }
    private void setUpReports(ReportResponseModel details) {
        reportbook.setAdapter(new ReportBookListAdapter(getContext(), details.getDetails()));
        reportbook.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }


}
