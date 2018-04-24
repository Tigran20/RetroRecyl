package com.alextroy.tf_alextroy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alextroy.tf_alextroy.adapter.CurrencyAdapter;
import com.alextroy.tf_alextroy.api.App;
import com.alextroy.tf_alextroy.model.Currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String KEY = "a449de2a9b582986de1c3ee42bb6eb7f";
    private static final String TAG = "MyTag";

    private RecyclerView recyclerView;
    private CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_list);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CurrencyAdapter(this);
        recyclerView.setAdapter(adapter);

        getCurrency();
    }

    public void getCurrency() {
        App.getApi().loadCurrency(KEY).enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                List<Currency.Items> list = response.body().getList();
                adapter.setDataChanged(list);

                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
