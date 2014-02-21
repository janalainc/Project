package com.theapperclass.sqlitedatabase;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class LogsActivity extends Activity {
	
	final DBInterface db = new DBInterface(this);

	ArrayList<String> datas = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logscreen);
		
		GridView GV = (GridView)findViewById(R.id.gridView1);
		Button btnClear = (Button)findViewById(R.id.button1);
		btnClear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				datas.clear();
				adapter.notifyDataSetChanged();
				
			}
		});
		
		
		List<Entry> entries = db.getAllEntries();
		datas.add("ID");
		datas.add("Name");
		datas.add("Dept");
		datas.add("Stamp");
		
		for(Entry entry:entries){
			datas.add(entry.getId()+"");
			datas.add(entry.getName().toString());
			datas.add(entry.getDept().toString());
			datas.add(entry.getStamp()+"");
			//Toast.makeText(getApplicationContext(), entry.getName(), Toast.LENGTH_SHORT).show();
		}
		
		adapter = new ArrayAdapter<String>(LogsActivity.this,
                R.layout.text, R.id.tv1, datas);
		GV.setAdapter(adapter);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		

		
	}

}
