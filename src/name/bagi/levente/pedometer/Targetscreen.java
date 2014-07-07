package name.bagi.levente.pedometer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Context;

@SuppressWarnings("unused")
public class Targetscreen extends Activity 
{
	public static int choice;
	public static float delta;
	public static EditText days_field;
	public static EditText weight_field;
	public static TextView days;
	public static TextView weight;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.targetscreen);
		choice = 0;
		delta = 0;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.target_screen, menu);
		return true;
	}
	
	public void gain(View view)
	{
		choice = 1;
		call(choice);
	}
	public void maintain(View view)
	{
		choice = 0;
		call(choice);
	}
	public void reduce(View view)
	{
		choice = -1;
		call(choice);
	}
	public void call(int ch)
	{
		if(ch == 0)
		{
			delta = 0;
			SharedPreferences.Editor editor = MainActivity.settings.edit();
			editor.putFloat("delta", delta);
			editor.commit();
			startActivity(new Intent(this,Pedometer.class));
		}
		else
		{
			setContentView(R.layout.getdelta);
			days_field = (EditText)findViewById(R.id.days_fields);
			weight_field = (EditText)findViewById(R.id.weight_field);
			weight = (TextView)findViewById(R.id.weight);
			String gain = "How much weight do you want to gain? (kg)";
			String lose = "How much weight do you want to lose? (kg)";
			weight.setText((choice==1)?gain:lose);
			
		}
	}
	public void submit(View view)
	{
		delta = choice*(Float.parseFloat(weight_field.getText().toString()));
		delta = delta/(Float.parseFloat(days_field.getText().toString()));
		delta*=7716.1854;
		Log.d("delta",""+delta);
		
		SharedPreferences.Editor editor = MainActivity.settings.edit();
		editor.putFloat("delta", delta);
		editor.commit();
		startActivity(new Intent(this,Pedometer.class));
	}


}
