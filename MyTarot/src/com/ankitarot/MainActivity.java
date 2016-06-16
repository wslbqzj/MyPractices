package com.ankitarot;

import com.ankitarot.MainActivity;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private Button btn1;
	private Button btn2;
	private Button btn3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1=(Button)findViewById(R.id.btn1);
		btn2=(Button)findViewById(R.id.btn2);
		btn3=(Button)findViewById(R.id.btn3);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn1:
			Intent intent = new Intent();
            intent.setClass(MainActivity.this,Second.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
			break;
		case R.id.btn2:
			Toast.makeText(MainActivity.this,"软件名：简易塔罗牌。\n制作人：lwj",Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn3:
			MainActivity.this.finish();
			//完全退出
//            ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//            manager.killBackgroundProcesses(getPackageName());
		default:
			break;
		}
	}
}
