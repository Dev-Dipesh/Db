package com.example.db;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btn1,btn2,btn3,btn4,btn8,btn5;
	TextView txt,result;
	static String correctAnswer;
	int a;
	int length;
	ArrayList<GetterSetter> arr;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        btn1=(Button)findViewById(R.id.button1);
	        btn2=(Button)findViewById(R.id.button2);
	        btn3=(Button)findViewById(R.id.button3);
	        btn4=(Button)findViewById(R.id.button4);
	        btn8=(Button)findViewById(R.id.button8);
	        btn5=(Button)findViewById(R.id.button5);
	        txt=(TextView)findViewById(R.id.textView1);
	        result = (TextView)findViewById(R.id.textView3);
	        a=0;
	        DBAdapter dbAdapter=DBAdapter.getDBAdapter(this);
			if(!dbAdapter.checkDatabase())
			{
			  dbAdapter.createDatabase(this);	
			}
			dbAdapter.openDatabase(); 
			
			arr=dbAdapter.getInfo();
			
			txt.setText("Welcome to KBC.\nAre You Ready To Start?\nIf Yes then,Click on New Button For New Game.");
	    }


	     public void newgame(View v){
	    	 a=0;
	    	 btn1.setEnabled(true);
  		   btn2.setEnabled(true);
  		   btn3.setEnabled(true);
  		   btn4.setEnabled(true);
	    	 txt.setText(arr.get(a).getQuestion());
				btn1.setText(arr.get(a).getOption1());
				btn2.setText(arr.get(a).getOption2());
				btn3.setText(arr.get(a).getOption3());
				btn4.setText(arr.get(a).getOption4());
				btn8.setText(arr.get(a).getSrno());
				correctAnswer=arr.get(a).getAnswer();
				btn5.setEnabled(true);
				result.setText("");
	     }
	     public void chkans1(View v)
	     {
	    	if(btn1.getText().toString().equals(correctAnswer)) {
	    		a=a+1;
	    		result.setText("Correct Answer");
	    		btn5.setEnabled(true);
	    		
	    	}
	    	else
	    	{
	    		result.setText("Wrong Answer");
	    		Toast.makeText(getApplicationContext(), "Game Over, Try Again",Toast.LENGTH_LONG).show();
	    		btn5.setEnabled(false);
	    	}
	    	
	     }
	     public void chkans2(View v)
	     {
	    	if(btn2.getText().toString().equals(correctAnswer)) {
	    		a=a+1;
	    		result.setText("Correct Answer");
	    		btn5.setEnabled(true);
	    		
	    	}
	    	else
	    	{
	    		result.setText("Wrong Answer");
	    		Toast.makeText(getApplicationContext(), "Game Over, Try Again",Toast.LENGTH_LONG).show();
	    		btn5.setEnabled(false);
	    		}
	    	
	     }
	     public void chkans3(View v)
	     {
	    	if(btn3.getText().toString().equals(correctAnswer)) {
	    		a=a+1;
	    		result.setText("Correct Answer");
	    		btn5.setEnabled(true);
	    		
	    	}
	    	else
	    	{
	    		result.setText("Wrong Answer");
	    		Toast.makeText(getApplicationContext(), "Game Over, Try Again",Toast.LENGTH_LONG).show();
	    		btn5.setEnabled(false);
	    	}
	    	
	     }
	     public void chkans4(View v)
	     {
	    	if(btn4.getText().toString().equals(correctAnswer)) {
	    		a=a+1;
	    		result.setText("Correct Answer");
	    		btn5.setEnabled(true);
	    	}
	    	else
	    	{
	    		result.setText("Wrong Answer");
	    		Toast.makeText(getApplicationContext(), "Game Over, Try Again",Toast.LENGTH_LONG).show();
	    		btn5.setEnabled(false);
	    	}
	    	
	     }
	     public void next(View v)
	     {
	    	 length = arr.size();
	    	   if(a<length)
	    		   {txt.setText(arr.get(a).getQuestion());
				btn1.setText(arr.get(a).getOption1());
				btn2.setText(arr.get(a).getOption2());
				btn3.setText(arr.get(a).getOption3());
				btn4.setText(arr.get(a).getOption4());
				btn8.setText(arr.get(a).getSrno());
				correctAnswer=arr.get(a).getAnswer();
				result.setText("");
	    		   }
	    	   else{
	    		   result.setText("Congrats You Win.");
	    		   a=0;
	    		   btn1.setEnabled(false);
	    		   btn2.setEnabled(false);
	    		   btn3.setEnabled(false);
	    		   btn4.setEnabled(false);
	    		   btn5.setEnabled(false);
	    		   Toast.makeText(getApplicationContext(), "You Won !!! ",Toast.LENGTH_LONG).show();
	    	   }
	     }
	     public void addqs(View v)
	     {
	    	 Intent ints = new Intent(getApplicationContext(),Addqs.class);
	    	 startActivity(ints);
	     }
	     
	     }


