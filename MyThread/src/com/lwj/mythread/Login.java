package com.lwj.mythread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceActivity.Header;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {
	String name = "";
	String pw = "";
	EditText edit_username;
	EditText edit_password;
	Button btn_login;
	Button btn_get;
	HttpClient httpClient;
	org.apache.http.Header[] headers = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		edit_username = (EditText) findViewById(R.id.user);
		edit_password = (EditText) findViewById(R.id.password);
		btn_login = (Button) findViewById(R.id.btn_login);

		btn_login.setOnClickListener(this);
		btn_get = (Button) this.findViewById(R.id.btn_get);
		btn_get.setOnClickListener(this);
	}

	// 按钮监听
	@SuppressWarnings("unchecked")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// Intent intent=new Intent();
		// intent.setClass(getApplicationContext(), )
		switch (v.getId()) {
		case R.id.btn_login:
			name = edit_username.getText().toString();
			pw = edit_password.getText().toString();
			new myasyn().execute("");
			break;
		case R.id.btn_get:

			new myasyn2().execute("");
			break;
		default:
			break;
		}

	}

	class myasyn extends AsyncTask {
		String str = "";
		// Header[] headers;
		String s = "";
		String url = "http://182.136.86.13:8080/lg0812/LoginAction?method=login";

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			// url = edit.getText().toString();

		}

		@Override
		protected Object doInBackground(Object... params1) {
			// TODO Auto-generated method stub
			try {
				// url =
				// "http://182.136.86.13:8080/lg0812/BranchAction?pagenum=1";
				// HttpGet httpGet = new HttpGet(url);

				HttpPost httpRequst = new HttpPost(url);// 创建HttpPost对象

				// httpRequst.setHeader("Content-Type", "charset=UTF-8");

				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("nickname", name));
				params.add(new BasicNameValuePair("password", "e10adc3949ba59abbe56e057f20f883e"));

				httpRequst.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

				httpClient = new DefaultHttpClient();
				// httpClient.getParams().set
				HttpResponse httpResponse = httpClient.execute(httpRequst);
				// httpResponse.setHeader("Content-Type", "charset=UTF-8");
				if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					str = EntityUtils.toString(httpResponse.getEntity());
					// str = "200";
					// cookieStore = new BasicCookieStore();

					headers = httpResponse.getAllHeaders();
					for (Object o : headers) {
						s = s + o.toString();
					}
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
			// super.onPostExecute(result);
			edit_username.setText(s);
			Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
		}

	}

	class myasyn2 extends AsyncTask {
		String str = "";
		int pagenum = 0;
		String url = "http://182.136.86.13:8080/lg0812/AttentionAction?method=search&pageNum=" + 0;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			// url = edit.getText().toString();

		}

		@Override
		protected Object doInBackground(Object... params1) {
			// TODO Auto-generated method stub
			try {
				// url =
				// "http://182.136.86.13:8080/lg0812/BranchAction?pagenum=1";
				HttpGet httpGet = new HttpGet(url);
				httpGet.setHeaders(headers);
				httpClient = new DefaultHttpClient();
				// httpClient.
				HttpResponse httpResponse = httpClient.execute(httpGet);
				// httpResponse.setHeader("Content-Type", "charset=UTF-8");
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
			// super.onPostExecute(result);
			edit_username.setText(str);
			// Toast.makeText(getApplicationContext(), str,
			// Toast.LENGTH_SHORT).show();
		}

	}

}

// "http://182.136.86.13:8080/lg0812/AttentionAction?method=search&pageNum="+pagenum;
