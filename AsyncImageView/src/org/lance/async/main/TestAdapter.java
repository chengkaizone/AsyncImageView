package org.lance.async.main;

import java.util.ArrayList;

import org.lance.async.R;
import org.lance.async.lib.AsyncBitmapLoader;
import org.lance.async.lib.AsyncImageView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 网格测试适配器
 * @author lance
 *
 */
public class TestAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private ArrayList<String> images = new ArrayList<String>();
	private AsyncBitmapLoader loader;
	public TestAdapter(Context context) {
		inflater = LayoutInflater.from(context);
		loader=new AsyncBitmapLoader();
	}

	public TestAdapter(Context context, ArrayList<String> images) {
		this(context);
		this.images = images;
	}

	public void setStrings(ArrayList<String> images) {
		this.images = images;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return images.size();
	}

	@Override
	public String getItem(int position) {
		return images.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder = null;
		if (convertView == null) {
			holder = new Holder();
			convertView = inflater.inflate(R.layout.adapter_image, null);
			holder.image = (AsyncImageView) convertView
					.findViewById(R.id.image);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		if(parent.getChildCount()==position){//防止多次调用
			String url = images.get(position);
			holder.image.setLoadingDrawable(R.drawable.empty_photo);
			loader.loadBitmap(holder.image, url,250);
		}
		return convertView;
	}

	private class Holder {
		AsyncImageView image;
	}
}
