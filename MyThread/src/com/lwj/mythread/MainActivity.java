package com.lwj.mythread;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	//public int i=0;
	public Button btn_request;
	public EditText edit;
	public TextView tv;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_request=(Button)findViewById(R.id.btn1);
		edit=(EditText)findViewById(R.id.edit);
		tv=(TextView) findViewById(R.id.tv1);
		//请求按钮监听
		btn_request.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new myasyn().execute("");
			}
		});
//		Intent intent=new Intent();
//		intent.setClass(MainActivity.this, MyService.class);
//		startService(intent);
	}
	
	class myasyn extends AsyncTask
	{
		String str="";
		String url="";
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			url = edit.getText().toString();
		}

		@Override
		protected Object doInBackground(Object... params) {
			// TODO Auto-generated method stub
			try {
//				url = "http://182.136.86.13:8080/lg0812/BranchAction?pagenum=1";
				HttpGet httpGet = new HttpGet(url);

				HttpClient httpClient = new DefaultHttpClient();
				HttpResponse httpResponse = httpClient.execute(httpGet);

				if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					str = EntityUtils.toString(httpResponse.getEntity());
					// str = "200";
				}

			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			//super.onPostExecute(result);
			tv.setText(str);
			Toast.makeText(getApplicationContext(), "wwww", Toast.LENGTH_SHORT).show();
		}
		
	}
	
}