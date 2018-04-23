package com.alextroy.tf_alextroy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alextroy.tf_alextroy.adapter.CurrencyAdapter;
import com.alextroy.tf_alextroy.api.App;
import com.alextroy.tf_alextroy.model.Currency;
import com.alextroy.tf_alextroy.model.JSONResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String KEY = "a449de2a9b582986de1c3ee42bb6eb7f";
    private static final String TAG = "MyTag";

    private RecyclerView recyclerView;
    private ArrayList<Currency> list;
    private CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_list);

        list = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new CurrencyAdapter(MainActivity.this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

        getCurrency();
    }

    public void getCurrency() {
        App.getApi().loadCurrency(KEY).enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                list.addAll(response.body().getCurrencies());
                adapter.updateData(list);

                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
