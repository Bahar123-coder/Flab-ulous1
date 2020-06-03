package com.example.flab_ulous.report;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.flab_ulous.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.flab_ulous.DietList.DietPlanFragment;
import com.example.flab_ulous.ReportBook.ReportBookFragment;
import com.example.flab_ulous.preferences.AppPreferences;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashBoardActivity extends AppCompatActivity {
    ReportBookFragment reportBookFragment;
    DietPlanFragment dietPlanFragment;
    BottomNavigationView bottomNavigationView;
    AppPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dietlist);
        appPreferences = new AppPreferences(getApplication());
        reportBookFragment = new ReportBookFragment();
        dietPlanFragment = new DietPlanFragment();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_dash);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_dietPlan:
                                selectedFragment = dietPlanFragment.newInstance();
                                break;
                            case R.id.navigation_reportBook:
                                selectedFragment = reportBookFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.flContentContainer, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                }

        );
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.flContentContainer, dietPlanFragment.newInstance());
                        transaction.commit();
    }

                    @Override
                    public boolean onCreateOptionsMenu(Menu menu) {
                        MenuInflater inflater = getMenuInflater();
                        inflater.inflate(R.menu.option_menu, menu);
                        return true;
                    }

                    @Override
                    public boolean onOptionsItemSelected(MenuItem item) {
                        // Handle item selection
                        switch (item.getItemId()) {
                            case R.id.menu_log_out:
                                startActivity(new Intent(this, LoginActivity.class));
                                appPreferences.setIsUserLoggedIn(false);
                                finish();
                                return true;
                            default:
                                return super.onOptionsItemSelected(item);
                        }
                    }


}
