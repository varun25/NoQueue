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
 * Created by Varun on 24-08-2016.
 */
public class DisplayFoodMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    int[] imgres = {R.drawable.pic1, R.drawable.pic2,R.drawable.pic3, R.drawable.pic2,R.drawable.pic1, R.drawable.pic3};
    String[] fname = {"Chhole bathure ","masala dosa","plain dosa","pizza","burger","bas kitna khaaoge aur"};
    String[] price = {"10","20","30","40","50","60"};
    ArrayList<FoodListProvider> arrayList = new ArrayList<FoodListProvider>();
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.foodmain);
        recyclerView = (RecyclerView) findViewById(R.id.recyclervv);

        int i=0 ;
        for(String name : fname)
        {
            FoodListProvider dataprovider = new FoodListProvider(imgres[i], fname[i], price[i]);
            arrayList.add(dataprovider);
            i++;
        }

        adapter = new FoodList(fname, price);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
