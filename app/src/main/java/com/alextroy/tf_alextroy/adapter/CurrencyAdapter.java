package com.alextroy.tf_alextroy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alextroy.tf_alextroy.R;
import com.alextroy.tf_alextroy.model.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Currency> currencies;

    public CurrencyAdapter(Context context, ArrayList<Currency> currencies) {
        this.context = context;
        this.currencies = currencies;
    }

    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CurrencyAdapter.ViewHolder holder, int position) {
        holder.currencyTitle.setText(currencies.get(position).getBase());
        holder.currencyDate.setText(currencies.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView currencyTitle;
        public TextView currencyDate;

        public ViewHolder(View itemView) {
            super(itemView);
            currencyTitle = itemView.findViewById(R.id.currency_title);
            currencyDate = itemView.findViewById(R.id.currency_date);
        }
    }

    public void updateData(ArrayList<Currency> curr){
        currencies.clear();
        currencies.addAll(curr);
        notifyDataSetChanged();
    }
}
