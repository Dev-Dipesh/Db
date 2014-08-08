package com.example.db;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Addqs extends Activity {
EditText qs,op1,op2,op3,op4,ans;
ArrayList<GetterSetter> arr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addqs);
	}

	public void addqs(View vs){

		qs=(EditText)findViewById(R.id.editText1);
		op1=(EditText)findViewById(R.id.editText2);
		op2=(EditText)findViewById(R.id.editText4);
		op3=(EditText)findViewById(R.id.editText5);
		op4=(EditText)findViewById(R.id.editText3);
		ans=(EditText)findViewById(R.id.editText6);
		DBAdapter dbAdapter=DBAdapter.getDBAdapter(this);
			 if(!dbAdapter.checkDatabase())
			{
			  dbAdapter.createDatabase(this);	
			}
			dbAdapter.openDatabase();
			
			arr=dbAdapter.getInfo();
			
			

			dbAdapter.setInfo(qs.getText().toString(),op1.getText().toString(),op2.getText().toString(),op3.getText().toString(),op4.getText().toString(),ans.getText().toString());
			Toast.makeText(getApplicationContext(), "Question and options arr aded succesfully. Restart App to confirm Submit.",Toast.LENGTH_LONG).show();
		finish();
	}

}
