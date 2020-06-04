package com.example.flab_ulous.ReportBook;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flab_ulous.API.APIController;
import com.example.flab_ulous.API.APIInstance;
import com.example.flab_ulous.API.ReportResponseModel;
import com.example.flab_ulous.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportRecordActivity  extends AppCompatActivity {

    RecyclerView rrReportRecord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_records);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rrReportRecord = findViewById(R.id.rrReportRecord);

        APIController apiController = APIInstance.getRetrofitInstance().create(APIController.class);
        apiController.getReport(205).enqueue(new Callback<ReportResponseModel>() {
            @Override
            public void onResponse(Call<ReportResponseModel> call, Response<ReportResponseModel> response) {
                if (response.body().getDetails() != null){
                    setUpReportRecords(response.body());
                }
            }

            @Override
            public void onFailure(Call<ReportResponseModel> call, Throwable t) {
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "Bye!", Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpReportRecords(ReportResponseModel details) {
        rrReportRecord.setAdapter(new ReportListAdapter(this,details.getDetails()));
        rrReportRecord.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
    }
}
