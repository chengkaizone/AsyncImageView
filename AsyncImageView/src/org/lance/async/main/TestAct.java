package org.lance.async.main;

import java.util.ArrayList;

import org.lance.async.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * 异步加载测试界面 如果图片地址不存在亲更换成有用的地址
 * @author lance email: 1094226429@qq.com
 *	
 */
public class TestAct extends Activity implements OnItemClickListener {
	private GridView gridView;
	private TestAdapter testAdapter;
	
	public void onCreate(Bundle saved){
		super.onCreate(saved);
		setContentView(R.layout.act_test);
		gridView=(GridView)findViewById(R.id.gridView);
		ArrayList<String> urls=new ArrayList<String>();
		for(int i=0;i<Images.imageThumbUrls.length;i++){
			urls.add(Images.imageThumbUrls[i]);
		}
		testAdapter=new TestAdapter(this, urls);
		
		gridView.setAdapter(testAdapter);
		gridView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		System.out.println("点击项--->"+arg2);
	}

}
