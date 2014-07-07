package name.bagi.levente.pedometer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;

public class Foodeaten extends Activity {
public static int tot;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodeaten);
		tot = 0;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	

	public void breakfast(View view)
	{
		
		setContentView(R.layout.breakfast);
	}
	public void breakfast_submit(View view)
	{
	int x=0;
	x+=((CheckBox)findViewById(R.id.Idli)).isChecked()?200:0;
	x+=((CheckBox)findViewById(R.id.Masala)).isChecked()?250:0;
	x+=((CheckBox)findViewById(R.id.Puri)).isChecked()?225:0;
	x+=((CheckBox)findViewById(R.id.Paratha)).isChecked()?300:0;
	x+=((CheckBox)findViewById(R.id.Sambhar)).isChecked()?150:0;
	x+=((CheckBox)findViewById(R.id.Subji)).isChecked()?150:0;
	tot += x;
	SharedPreferences.Editor editor = MainActivity.settings.edit();
	editor.putInt("consumption", (MainActivity.settings.getInt("consumption",0)+tot));
	editor.commit();
	startActivity(new Intent(this,Foodeaten.class));
	
	
	}
	
	public void north(View view)
	{
		
		setContentView(R.layout.north);
	}
	public void north_submit(View view)
	{
		int x =0;
		x+=((CheckBox)findViewById(R.id.Bhel)).isChecked()?150:0;
		x+=((CheckBox)findViewById(R.id.Samosa)).isChecked()?100:0;
		x+=((CheckBox)findViewById(R.id.Pani)).isChecked()?150:0;
		tot += x;
		SharedPreferences.Editor editor = MainActivity.settings.edit();
		editor.putInt("consumption", (MainActivity.settings.getInt("consumption",0)+tot));
		editor.commit();
		startActivity(new Intent(this,Foodeaten.class));
	}
	public void beverages(View view)
	{
		
		setContentView(R.layout.beverages);
	}
	public void beverages_submit(View view)
	{
		int x = 0;
		x+=((CheckBox)findViewById(R.id.Beer)).isChecked()?200:0;
		x+=((CheckBox)findViewById(R.id.Soda)).isChecked()?10:0;
		x+=((CheckBox)findViewById(R.id.Tea)).isChecked()?40:0;
		x+=((CheckBox)findViewById(R.id.Alcohol)).isChecked()?75:0;
		x+=((CheckBox)findViewById(R.id.Soft)).isChecked()?100:0;
		x+=((CheckBox)findViewById(R.id.Coffee)).isChecked()?40:0;
		tot += x;
		SharedPreferences.Editor editor = MainActivity.settings.edit();
		editor.putInt("consumption", (MainActivity.settings.getInt("consumption",0)+tot));
		editor.commit();
		startActivity(new Intent(this,Foodeaten.class));
	}
	public void misc(View view)
	{
		
		setContentView(R.layout.misc);
	}
	public void misc_submit(View view)
	{
		int x = 0;
		x+=((CheckBox)findViewById(R.id.Butter)).isChecked()?50:0;
		x+=((CheckBox)findViewById(R.id.Sweets)).isChecked()?150:0;
		x+=((CheckBox)findViewById(R.id.Friednuts)).isChecked()?300:0;
		x+=((CheckBox)findViewById(R.id.Biscuits)).isChecked()?30:0;
		x+=((CheckBox)findViewById(R.id.Ghee)).isChecked()?50:0;
		x+=((CheckBox)findViewById(R.id.Jam)).isChecked()?30:0;
		tot += x;
		SharedPreferences.Editor editor = MainActivity.settings.edit();
		editor.putInt("consumption", (MainActivity.settings.getInt("consumption",0)+tot));
		editor.commit();
		startActivity(new Intent(this,Foodeaten.class));
	}
	public void dinner(View view)
	{
		
		setContentView(R.layout.misc);
	}
	public void dinner_submit(View view)
	{
		int x = 0;
		x+=((CheckBox)findViewById(R.id.Dal)).isChecked()?150:0;
		x+=((CheckBox)findViewById(R.id.Curry)).isChecked()?150:0;
		x+=((CheckBox)findViewById(R.id.Curd)).isChecked()?100:0;
		x+=((CheckBox)findViewById(R.id.Soup)).isChecked()?75:0;
		x+=((CheckBox)findViewById(R.id.Nan)).isChecked()?150:0;
		x+=((CheckBox)findViewById(R.id.Rice)).isChecked()?120:0;
		x+=((CheckBox)findViewById(R.id.FriedRice)).isChecked()?150:0;
		tot += x;
		SharedPreferences.Editor editor = MainActivity.settings.edit();
		editor.putInt("consumption", (MainActivity.settings.getInt("consumption",0)+tot));
		editor.commit();
		startActivity(new Intent(this,Foodeaten.class));
	}
	public void international(View view)
	{
		
		setContentView(R.layout.international);
	}
	public void international_submit(View view)
	{
		int x = 0;
		x+=((CheckBox)findViewById(R.id.Pizza)).isChecked()?400:0;
		x+=((CheckBox)findViewById(R.id.FriedChicken)).isChecked()?200:0;
		x+=((CheckBox)findViewById(R.id.Hamburger)).isChecked()?250:0;
		x+=((CheckBox)findViewById(R.id.BakedDish)).isChecked()?400:0;
		x+=((CheckBox)findViewById(R.id.PotatoFried)).isChecked()?200:0;
		x+=((CheckBox)findViewById(R.id.Noodles)).isChecked()?450:0;
		x+=((CheckBox)findViewById(R.id.Spaghetti)).isChecked()?450:0;
		tot += x;
		SharedPreferences.Editor editor = MainActivity.settings.edit();
		editor.putInt("consumption", (MainActivity.settings.getInt("consumption",0)+tot));
		editor.commit();
		Log.e("x",""+x);
		Log.e("consumption",""+(MainActivity.settings.getInt("consumption",0)));
		startActivity(new Intent(this,Foodeaten.class));
	}
	public void end(View view)
	{
		startActivity(new Intent(this,Pedometer.class));
	}
	
}
