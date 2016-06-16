package com.ankitarot;

import java.util.Random;

import com.ankitarot.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Second extends Activity implements OnClickListener{
	private Button btn4;
	private Button btn5;
	private TextView textshow;
	private ImageView imageshow;
	public int i;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        textshow=(TextView)findViewById(R.id.textshow);
        imageshow=(ImageView)findViewById(R.id.imageshow);
        panduan();
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
	};
	public void panduan() {
		Random rand = new Random();
		i = rand.nextInt(22);
		switch (i) {
		case 0:
			imageshow.setImageResource(R.drawable.a);
			textshow.setText(R.string.a);
			break;
		case 1:
			imageshow.setImageResource(R.drawable.b);
			textshow.setText(R.string.b);
			break;
		case 2:
			imageshow.setImageResource(R.drawable.c);
			textshow.setText(R.string.c);
			break;
		case 3:
			imageshow.setImageResource(R.drawable.d);
			textshow.setText(R.string.d);
			break;
		case 4:
			imageshow.setImageResource(R.drawable.e);
			textshow.setText(R.string.e);
			break;
		case 5:
			imageshow.setImageResource(R.drawable.f);
			textshow.setText(R.string.f);
			break;
		case 6:
			imageshow.setImageResource(R.drawable.g);
			textshow.setText(R.string.g);
			break;
		case 7:
			imageshow.setImageResource(R.drawable.h);
			textshow.setText(R.string.h);
			break;
		case 8:
			imageshow.setImageResource(R.drawable.i);
			textshow.setText(R.string.i);
			break;
		case 9:
			imageshow.setImageResource(R.drawable.j);
			textshow.setText(R.string.j);
			break;
		case 10:
			imageshow.setImageResource(R.drawable.k);
			textshow.setText(R.string.k);
			break;
		case 11:
			imageshow.setImageResource(R.drawable.l);
			textshow.setText(R.string.l);
			break;
		case 12:
			imageshow.setImageResource(R.drawable.m);
			textshow.setText(R.string.m);
			break;
		case 13:
			imageshow.setImageResource(R.drawable.n);
			textshow.setText(R.string.n);
			break;
		case 14:
			imageshow.setImageResource(R.drawable.o);
			textshow.setText(R.string.o);
			break;
		case 15:
			imageshow.setImageResource(R.drawable.p);
			textshow.setText(R.string.p);
		case 16:
			imageshow.setImageResource(R.drawable.q);
			textshow.setText(R.string.q);
			break;
		case 17:
			imageshow.setImageResource(R.drawable.r);
			textshow.setText(R.string.r);
			break;
		case 18:
			imageshow.setImageResource(R.drawable.s);
			textshow.setText(R.string.s);
			break;
		case 19:
			imageshow.setImageResource(R.drawable.t);
			textshow.setText(R.string.t);
			break;
		case 20:
			imageshow.setImageResource(R.drawable.u);
			textshow.setText(R.string.u);
			break;
		case 21:
			imageshow.setImageResource(R.drawable.v);
			textshow.setText(R.string.v);
			break;
		default:
			break;
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn4:
			Second.this.finish();
			break;
		case R.id.btn5:
			dialog();
		default:
			break;
		}
	}
	
	//弹出对话框
    public void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Second.this);
        switch (i) {
		case 0:
			builder.setMessage(R.string.TheFool);
			break;
		case 1:
			builder.setMessage(R.string.TheMagician);
			break;
		case 2:
			builder.setMessage(R.string.TheHighPriestess);
			break;
		case 3:
			builder.setMessage(R.string.TheEmpress);
			break;
		case 4:
			builder.setMessage(R.string.TheEmperor);
			break;
		case 5:
			builder.setMessage(R.string.TheHierophant);
			break;
		case 6:
			builder.setMessage(R.string.TheLovers);
			break;
		case 7:
			builder.setMessage(R.string.TheChariot);
			break;
		case 8:
			builder.setMessage(R.string.Strength);
			break;
		case 9:
			builder.setMessage(R.string.TheHermit);
			break;
		case 10:
			builder.setMessage(R.string.TheWheelofFortune);
			break;
		case 11:
			builder.setMessage(R.string.Justice);
			break;
		case 12:
			builder.setMessage(R.string.TheHangedMan);
			break;
		case 13:
			builder.setMessage(R.string.Death);
			break;
		case 14:
			builder.setMessage(R.string.Temperance);
			break;
		case 15:
			builder.setMessage(R.string.TheDevil);
			break;
		case 16:
			builder.setMessage(R.string.TheTower);
			break;
		case 17:
			builder.setMessage(R.string.TheStar);
			break;
		case 18:
			builder.setMessage(R.string.TheMoon);
			break;
		case 19:
			builder.setMessage(R.string.TheSun);
			break;
		case 20:
			builder.setMessage(R.string.Judgement);
			break;
		case 21:
			builder.setMessage(R.string.TheWorld);
			break;
		default:
			break;
		}
        
        builder.setTitle("牌面详解");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

}
