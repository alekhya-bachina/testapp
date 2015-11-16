package com.fission.testapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

public class FragmentTwo   extends DialogFragment {






   TextView tvItemName;
    Button btnlogout;


	public static final String ITEM_NAME = "itemName";

	public FragmentTwo()
	{


	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view=inflater.inflate(R.layout.fragment_layout_two,container, false);
		
		//ivIcon=(ImageView)view.findViewById(R.id.frag2_icon);
		tvItemName=(TextView)view.findViewById(R.id.btnlogout);


       btnlogout=(Button)view.findViewById(R.id.btnlogout);
        btnlogout.setText(getArguments().getString(ITEM_NAME));












        return view;

    }

    }





