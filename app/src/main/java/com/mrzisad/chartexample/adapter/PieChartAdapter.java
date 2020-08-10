package com.mrzisad.chartexample.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.mrzisad.chartexample.R;

import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;

public class PieChartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList list;
    public Context context;

    public PieChartAdapter(Context context, ArrayList list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pie_chart_data, parent, false);
        return new ViewHolder(view);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder view = (ViewHolder) holder;
        PieModel pieModel = (PieModel) list.get(position);

        view.tv_title.setText(pieModel.getLegendLabel());
        view.tv_count.setText(""+pieModel.getValue());
        view.view_color.setBackgroundColor(pieModel.getColor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title, tv_count;
        View view_color;

        ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_count = itemView.findViewById(R.id.tv_count);
            view_color = itemView.findViewById(R.id.view_color);
        }

    }

}