package com.fission.testapp;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentOne extends Fragment {





Button btnlogout;
	TextView tvname;
EditText userName;

	//public static final String IMAGE_RESOURCE_ID = "iconResourceID";
	public static final String ITEM_NAME = "itemName";


public FragmentOne() {

	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_layout_one, container, false);

        TextView tv=(TextView)view.findViewById(R.id.welcometxt);

       String name= getActivity().getIntent().getExtras().getString("username");
        System.out.println("================="+name);
        

        tv.setText(name   +   " welcome to the android tutorial  ");


        return view;



	}





}














