package com.example.hp.fruitsorder;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.eightbitlab.bottomnavigationbar.BottomBarItem;
import com.eightbitlab.bottomnavigationbar.BottomNavigationBar;

public class Homepage extends AppCompatActivity implements View.OnClickListener {

    BottomNavigationBar bottomNavigationBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        bottomNavigationBar=findViewById(R.id.bottom_bar);

        addFragment(new Fragmenthome());
        BottomBarItem item=new BottomBarItem(R.drawable.fruit,R.string.fruitsa);
        BottomBarItem item1=new BottomBarItem(R.drawable.vegetables,R.string.vegetablesa);
        BottomBarItem item2=new BottomBarItem(R.drawable.bag,R.string.baga);
        BottomBarItem item3=new BottomBarItem(R.drawable.ic_account_circle_black_24dp,R.string.profilea);

        bottomNavigationBar.addTab(item);
        bottomNavigationBar.addTab(item1);
        bottomNavigationBar.addTab(item2);
        bottomNavigationBar.addTab(item3);

        bottomNavigationBar.setOnSelectListener(new BottomNavigationBar.OnSelectListener() {
            @Override
            public void onSelect(int position) {
                switch (position) {
                    case 0: {
                        replaceFragment(new Fragmenthome());
                        break;
                    }
                    case 1: {
                        replaceFragment(new Fragmenthome());
                        break;
                    }
                    case 2: {
                        replaceFragment(new Fragmenthome());
                        break;
                    }
                    case 3: {
                        replaceFragment(new Fragmenthome());
                        break;
                    }
                }
            }
        });
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.framelayout,fragment);
        transaction.commit();
    }
    void replaceFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout,fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {


    }
}
