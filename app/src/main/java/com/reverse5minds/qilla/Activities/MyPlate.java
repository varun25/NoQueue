package com.reverse5minds.qilla.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.reverse5minds.qilla.Adapters.FoodList;
import com.reverse5minds.qilla.Generic.FoodListProvider;
import com.reverse5minds.qilla.R;

import java.util.ArrayList;

/**
 * Created by Varun on 25-08-2016.
 */
public class MyPlate extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    int[] imgres = {R.drawable.pic1, R.drawable.pic2,R.drawable.pic3, R.drawable.pic2,R.drawable.pic1, R.drawable.pic3};
    String[] coun = {"BC ","MC","BC","MC","BC","MC"};
    String[] cap = {"NO FOOD HERE","NO FOOD HERE","NO FOOD HERE","NO FOOD HERE","NO FOOD HERE","NO FOOD HERE"};
    ArrayList<FoodListProvider> arrayList = new ArrayList<FoodListProvider>();
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.foodmain);
        recyclerView = (RecyclerView) findViewById(R.id.recyclervv);

        int i=0 ;
        for(String name : coun)
        {
            FoodListProvider dataprovider = new FoodListProvider(imgres[i], coun[i], cap[i]);
            arrayList.add(dataprovider);
            i++;
        }

        adapter = new FoodList(coun, cap);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}

