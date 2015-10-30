package com.example.listviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity 
{
//	private String[] data ={"Apple","Banana","Orange","Watermelon","Pear","Grape",
//			"Pineapple","Strawberry","Cherry","Mango","Apple"};
//	private List<Fruit> fruitList = new ArrayList<Fruit>();
	private ListView msgListView;
	private EditText inputText;
	private Button send;
	private MsgAdapter adapter;
	private List<Msg> msgList = new ArrayList<Msg>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initMsg();
		adapter = new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.input_button);
		msgListView = (ListView) findViewById(R.id.list_view); 
		msgListView.setAdapter(adapter);
		send.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				String content = inputText.getText().toString();
				if(!"".equals(content))
				{
					Msg msg = new Msg(content,Msg.TYPE_SENT);
					msgList.add(msg);
					adapter.notifyDataSetChanged();
					msgListView.setSelection(msgList.size());
					inputText.setText("");
				}
				// TODO Auto-generated method stub
				
			}
			
		});
//		initFruits();
//		FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
//		ListView listview = (ListView) findViewById(R.id.list_view);
//		listview.setAdapter(adapter);
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
//		ListView listView = (ListView) findViewById(R.id.list_view);
//		listView.setAdapter(adapter);
	}
	
	private void initMsg()
	{
		Msg msg1 = new Msg("Hello guy.",Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2 = new Msg("Hello, who is that?",Msg.TYPE_SENT);
		msgList.add(msg2);
	}
	
//	private void initFruits()
//	{
//		Fruit apple = new Fruit("Apple",R.drawable.apple);
//		fruitList.add(apple);
//		Fruit banana = new Fruit("Banana",R.drawable.banana);
//		fruitList.add(banana);
		
//	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
