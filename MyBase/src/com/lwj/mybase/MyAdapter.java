package com.lwj.mybase;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	private List<ItemBean> mList;
	private LayoutInflater minflater;
	public MyAdapter(Context context,List<ItemBean> list) {
		// TODO Auto-generated constructor stub
		mList=list;
		minflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//文艺式
		ViewHolder viewHolder;
		if(convertView==null)
		{
			viewHolder=new ViewHolder();
			convertView = minflater.inflate(R.layout.item,null);	
			viewHolder.imageView=(ImageView) convertView.findViewById(R.id.iv_image);
			viewHolder.title=(TextView) convertView.findViewById(R.id.tv_title);
			viewHolder.content=(TextView) convertView.findViewById(R.id.tv_content);
			convertView.setTag(viewHolder);
		}
		else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		ItemBean bean=mList.get(position);
		viewHolder.imageView.setImageResource(bean.ItemImageResid);
		viewHolder.title.setText(bean.ItemTitle);
		viewHolder.content.setText(bean.Itemcontent);
		return convertView;
	}
	class ViewHolder
	{
		public ImageView imageView;
		public TextView title;
		public TextView content;
	}
}


