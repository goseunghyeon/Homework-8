package com.example.app_project;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabmou,tabsea,tabother;
    MyTabFragment myFrag[]=new MyTabFragment[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sounds);
        ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        tabmou=bar.newTab();
        tabmou.setText("산");
        tabmou.setTabListener(this);
        bar.addTab(tabmou);
        tabsea=bar.newTab();
        tabsea.setText("바다");
        tabsea.setTabListener(this);
        bar.addTab(tabsea);
        tabother=bar.newTab();
        tabother.setText("기타");
        tabother.setTabListener(this);
        bar.addTab(tabother);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab,FragmentTransaction ft) {
        MyTabFragment myTabfrag=null;
        if(myFrag[tab.getPosition()]==null){
            myTabfrag=new MyTabFragment();
            Bundle data=new Bundle();
            data.putString("tabName",tab.getText().toString());
            myTabfrag.setArguments(data);
            myFrag[tab.getPosition()]=myTabfrag;
        }
        else
            myTabfrag=myFrag[tab.getPosition()];

        ft.replace(android.R.id.content, myTabfrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    public static class MyTabFragment extends android.app.Fragment{
        String tabName;

        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            Bundle data=getArguments();
            tabName=data.getString("tabName");

        }
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout baseLayout=new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            if(tabName=="산") baseLayout.setBackgroundColor(Color.BLUE);
            if(tabName=="바다") baseLayout.setBackgroundColor(Color.RED);
            if(tabName=="기타") baseLayout.setBackgroundColor(Color.BLUE);


            return baseLayout;

        }
    }
}