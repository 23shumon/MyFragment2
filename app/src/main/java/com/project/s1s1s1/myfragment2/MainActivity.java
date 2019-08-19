package com.project.s1s1s1.myfragment2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ItemListFragment.ListFragmentInterface {

    FragmentManager manager=getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState==null) {
            ItemListFragment listFragment = new ItemListFragment();
            manager.beginTransaction().replace(R.id.fragmentContainer,listFragment).commit();
        }
    }

    @Override
    public void sendString(String name) {
        Bundle bundle=new Bundle();
        bundle.putString("name",name);
        DetailsFragment detailsFragment=new DetailsFragment();
        detailsFragment.setArguments(bundle);
        manager.beginTransaction().replace(R.id.fragmentContainer,detailsFragment).addToBackStack(null).commit();

    }
}
