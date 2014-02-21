package com.theapperclass.sqlitedatabase;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	String full="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final DBInterface db = new DBInterface(this);
		
		Button LogInBtn = (Button)findViewById(R.id.GoBtn);
		Button LogBtn = (Button)findViewById(R.id.LogBtn);
		
		final Entry entry = new Entry(1, "Jan Alain", "SEA");
		//Toast.makeText(this, entry.getName().toString(), Toast.LENGTH_SHORT).show();
		
		LogBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				full = "";
				List<Entry> entries = db.getAllEntries();
				for(Entry entry:entries){
					full+=entry.getName().toString() + "\n";
					//Toast.makeText(getApplicationContext(), entry.getName(), Toast.LENGTH_SHORT).show();
				}
				//Toast.makeText(getApplicationContext(), full, Toast.LENGTH_SHORT).show();
				Intent log = new Intent(MainActivity.this, LogsActivity.class);
				startActivity(log);
			}
		});
		
		LogInBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText name = (EditText)findViewById(R.id.editText1);
				String _name = name.getText().toString();
				EditText dept = (EditText)findViewById(R.id.editText2);
				String _dept = dept.getText().toString();
				EditText idfield = (EditText)findViewById(R.id.editText3);
			    int idnum = Integer.parseInt(idfield.getText().toString());
				Entry temp = new Entry(idnum, _name, _dept);
				//Toast.makeText(getApplicationContext(), temp.getId() + " " + temp.getName(), Toast.LENGTH_SHORT).show();
				db.addEntry(temp);
				name.setText("");
				dept.setText("");
				idfield.setText("");
				Toast.makeText(getApplicationContext(), "You are now Added! " + temp.getName()+" BOOM", Toast.LENGTH_SHORT).show();
				
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		

		
	}

}
