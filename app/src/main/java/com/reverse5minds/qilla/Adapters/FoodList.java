package com.reverse5minds.qilla.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reverse5minds.qilla.R;

/**
 * Created by Varun on 23-08-2016.
 */
public class FoodList extends RecyclerView.Adapter<FoodList.RecyclerViewHolder> {

    String[] cname, ccapital;


    public FoodList(String[] cnamess, String[] ccapitalss)
    {
        this.cname = cnamess;
        this.ccapital = ccapitalss;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.myplaterow,viewGroup,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {
        viewHolder.txcoun.setText(cname[i]);
        viewHolder.txcap.setText(ccapital[i]);
    }

    @Override
    public int getItemCount() {
        return cname.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{


        TextView txcoun, txcap;
        ImageView imageView;
        public RecyclerViewHolder(View view)
        {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.foodpic);
            txcoun = (TextView) view.findViewById(R.id.itemname);
            txcap = (TextView) view.findViewById(R.id.price);
        }
    }
}

