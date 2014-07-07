package name.bagi.levente.pedometer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity 
{
	public EditText name_field;
	public EditText age_field;
	public EditText weight_field;
	public EditText height_field;
	public CheckBox if_male;
	public static SharedPreferences settings;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		name_field = (EditText)findViewById(R.id.Name);
		age_field = (EditText)findViewById(R.id.Age);
		weight_field = (EditText)findViewById(R.id.Weight);
		height_field = (EditText)findViewById(R.id.Height);
		if_male = (CheckBox)findViewById(R.id.male);
		settings = getSharedPreferences("PREFS", 0);
		String s = settings.getString("name", "nil");
		if(!s.equals("nil"))
		{
			Intent skip = new Intent(this,Pedometer.class);
			startActivity(skip);
		}
		else
		{
			SharedPreferences.Editor editor = MainActivity.settings.edit();
			editor.putInt("calories",0);
			editor.commit();
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void submit(View view)
	{
		String name = name_field.getText().toString();
		int age = Integer.parseInt(age_field.getText().toString());
		int weight = Integer.parseInt(weight_field.getText().toString());
		int height = Integer.parseInt(height_field.getText().toString());
		char gender = (Boolean.parseBoolean(if_male.toString()))?'m':'f';
		
		
		
		
		
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("name", name);
		editor.putInt("age", age);
		editor.putFloat("height", height);
		editor.putInt("weight", weight);
		editor.putString("gender", ""+gender);
		editor.commit();
		Intent a=new Intent(this,Targetscreen.class);
		startActivity(a);
	}
}
