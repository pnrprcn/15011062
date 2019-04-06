package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends Activity{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager LayoutManager;
    private List<Lectures> dersInfoList;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        LayoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) LayoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        LayoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(LayoutManager);


        dersInfoList = new ArrayList<Lectures>();
        dersInfoList.add(new Lectures("BBG1","DC","CC",50));
        dersInfoList.add(new Lectures("BBG2","CC","CB",60));
        dersInfoList.add(new Lectures("VERİYAPILARI","CB","DC",70));
        dersInfoList.add(new Lectures("ALGORİTMA ANALİZİ","BB","DC",55));
        dersInfoList.add(new Lectures("MOBİLPROGRAMLAMA","BA","CC",50));
        dersInfoList.add(new Lectures("DEVRE TEORİSİ","AA","CC",40));

        myAdapter = new MyAdapter(dersInfoList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }


}
