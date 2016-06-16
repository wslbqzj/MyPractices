package com.lwj.mybase;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<ItemBean> itemBeanList = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			itemBeanList.add(new ItemBean(
					R.drawable.cong, 
					"我是标题"+i, 
					"我是内容"+i
					));
		}
		ListView listView=(ListView) findViewById(R.id.lv_main);
		listView.setAdapter(new MyAdapter(this, itemBeanList));
	}
}
