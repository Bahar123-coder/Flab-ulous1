package com.example.flab_ulous.DietList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.flab_ulous.API.APIInstance;
import com.example.flab_ulous.API.DietPlanResponseModel;
import com.example.flab_ulous.R;
import com.example.flab_ulous.API.APIController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DietPlanFragment extends Fragment {
    RecyclerView rvDiet;
    View view;
    APIController apiController;

    public static DietPlanFragment newInstance() {
        DietPlanFragment fragment = new DietPlanFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dietlist, container, false);
        setUpViews();
        return view;
    }
    private void setUpViews() {
        apiController = APIInstance.getRetrofitInstance().create(APIController.class);
        rvDiet = view.findViewById(R.id.rvDietlist);
        getDietPlan();
    }
    private void getDietPlan() {
        apiController.getDietPlan(212).enqueue(new Callback<DietPlanResponseModel>() {
            @Override
            public void onResponse(Call<DietPlanResponseModel> call, Response<DietPlanResponseModel> response) {
                if (response.body() != null) {

                    setUpDietPlan(response.body().getDetails());
                }
            }

            @Override
            public void onFailure(Call<DietPlanResponseModel> call, Throwable t) {

            }
        });
    }

            private void setUpDietPlan(DietPlanResponseModel.Details details) {
                rvDiet.setAdapter(new DietListAdapter(getContext(), details));
                rvDiet.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
            }


        }

