package com.example.murodjonrahimov.hackathon.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.ModelIndoorPools;
import java.util.List;

/**
 * Created by murodjon.rahimov on 3/4/18.
 */

public class IndoorPoolsAdapter extends RecyclerView.Adapter<IndoorPoolsViewHolder> {

  private List<ModelIndoorPools> indoorPoolsList;

  public IndoorPoolsAdapter(List<ModelIndoorPools> indoorPools) {
    this.indoorPoolsList = indoorPools;
  }

  @Override
  public IndoorPoolsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.indoor_itempools, parent, false);
    return new IndoorPoolsViewHolder(view);
  }

  @Override
  public void onBindViewHolder(IndoorPoolsViewHolder holder, int position) {
    ModelIndoorPools pools = indoorPoolsList.get(position);

    holder.onBind(pools);
  }

  @Override
  public int getItemCount() {
    return indoorPoolsList.size();
  }
}

class IndoorPoolsViewHolder extends RecyclerView.ViewHolder {

  private TextView poolsName;
  private TextView poolsAddress;
  private TextView poolsPhone;
  private ImageView poolsImage;

  public IndoorPoolsViewHolder(View itemView) {
    super(itemView);

    poolsName =itemView.findViewById(R.id.textview_indoor_name);
    poolsAddress =itemView.findViewById(R.id.textview_indoor_address);
    poolsPhone =itemView.findViewById(R.id.textview_indoor_phone);
    poolsImage = itemView.findViewById(R.id.imageview_indoorpools);
  }

  public void onBind(ModelIndoorPools modelIndoorPools) {
    poolsName.setText("name: " + modelIndoorPools.getName());
    poolsAddress.setText("address: " + modelIndoorPools.getLocation());
    poolsPhone.setText("phone: " + modelIndoorPools.getPhone());
    poolsImage.setImageResource(R.drawable.swimming_pool);
  }
}
