package com.project.s1s1s1.myfragment2;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemListFragment extends Fragment {
    private ListView itemLV;
    private ArrayAdapter<CharSequence> adapter;
    private List<String> data;
    private Context context;
    private ListFragmentInterface listFragmentInterface;


    public ItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        try {
            listFragmentInterface = (ListFragmentInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        itemLV = view.findViewById(R.id.itemLV);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        data = Arrays.asList(getResources().getStringArray(R.array.fruits)); //fetching array from string.xml to arraylist
        Collections.shuffle(data);
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, data);
        itemLV.setAdapter(adapter);

        itemLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedFruit=data.get(position);
                String selectedFruit = parent.getItemAtPosition(position).toString();//here parent = listView
//                Toast.makeText(getActivity(), ""+selectedFruit, Toast.LENGTH_SHORT).show();
                listFragmentInterface.sendString(selectedFruit);
            }
        });
    }

    public interface ListFragmentInterface {
        void sendString(String name);
    }
}
