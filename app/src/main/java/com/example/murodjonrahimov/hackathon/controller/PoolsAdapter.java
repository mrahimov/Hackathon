package com.example.murodjonrahimov.hackathon.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.ModelPools;
import java.util.List;

/**
 * Created by murodjon.rahimov on 3/3/18.
 */

public class PoolsAdapter extends RecyclerView.Adapter<PoolsViewHolder> {

  private List<ModelPools> poolsList;

  public PoolsAdapter(List<ModelPools> poolsList) {
    this.poolsList = poolsList;
  }

  @Override
  public PoolsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pools_item_view, parent, false);
    return new PoolsViewHolder(view);
  }

  @Override
  public void onBindViewHolder(PoolsViewHolder holder, int position) {
    ModelPools pools = poolsList.get(position);

    holder.onBind(pools);
  }

  @Override
  public int getItemCount() {
    return poolsList.size();
  }
}

class PoolsViewHolder extends RecyclerView.ViewHolder {

  private TextView poolsName;
  private TextView poolsAddress;
  private TextView poolsPhone;
  private ImageView poolsImage;
  private ImageView imageButton;
  private int imageB;

  public PoolsViewHolder(View itemView) {
    super(itemView);

    poolsName =itemView.findViewById(R.id.textview_pools_name);
    poolsAddress =itemView.findViewById(R.id.textview_pools_address);
    poolsPhone =itemView.findViewById(R.id.textview_pools_phone);
    poolsImage = itemView.findViewById(R.id.imageview_pools);
    imageButton = itemView.findViewById(R.id.image_button);

  }

  public void onBind(final ModelPools modelPools) {
    poolsName.setText("name: " + modelPools.getName());
    poolsAddress.setText("address: " + modelPools.getLocation());
    poolsPhone.setText("phone: " + modelPools.getPhone());
    poolsImage.setImageResource(modelPools.getImage());
    poolsImage.setImageResource(modelPools.getImage());

    setImage(modelPools.isFavorite());

    imageButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {

        boolean newStatus;

        if(modelPools.isFavorite()) {
          newStatus = false;
        } else{
          newStatus = true;
        }

        modelPools.setFavorite(newStatus);
        setImage(newStatus);
      }
    });
  }

  public void setImage(boolean isFavorite){

    if(isFavorite) {
      imageB = R.drawable.favourite;
    } else{
      imageB = R.drawable.unfavourite;
    }
    imageButton.setImageResource(imageB);

  }

}

