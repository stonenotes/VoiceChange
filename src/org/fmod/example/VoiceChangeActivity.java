package org.fmod.example;

import java.io.File;

import org.fmod.FMOD;

import com.stone.voicerchange.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

public class VoiceChangeActivity extends Activity {

	private boolean started;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FMOD.init(this);
		
		setContentView(R.layout.activity_main);
	}
	
	public void mFix(View  btn){
		//这不是我-炎亚纶.mp3
		//匆匆那年.mp3
		if (started) {
			EffectUtils.close();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		final int id = btn.getId();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				started = true;
				String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "这不是我-炎亚纶.mp3";
				Log.i("stone", "url: " + path);
				switch (id) {
				case R.id.btn_normal:
					EffectUtils.fix(path, EffectUtils.MODE_NORMAL);
					break;
					
				case R.id.btn_luoli:
					EffectUtils.fix(path, EffectUtils.MODE_LUOLI);
					break;	
					
				case R.id.btn_dashu:
					EffectUtils.fix(path, EffectUtils.MODE_DASHU);
					break;	
					
				case R.id.btn_jingsong:
					EffectUtils.fix(path, EffectUtils.MODE_JINGSONG);
					break;	
					
				case R.id.btn_gaoguai:
					EffectUtils.fix(path, EffectUtils.MODE_GAOGUAI);
					break;	
					
				case R.id.btn_kongling:
					EffectUtils.fix(path, EffectUtils.MODE_KONGLING);
					break;		

				default:
					break;
				}
			}
		}).start();
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		EffectUtils.close();
		FMOD.close();
	}
	
}
