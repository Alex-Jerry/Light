package com.light.proxy;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;

import com.light.body.Light;
import com.light.body.LightConfig;
import com.light.core.LightCompressEngine;
import com.light.core.Utils.L;
import com.light.core.Utils.MatrixUtil;
import com.light.core.listener.ICompressEngine;
import com.light.core.listener.ICompressProxy;

/**
 * Created by xiaoqi on 2017/11/25.
 */

public class BitmapCompressProxy implements ICompressProxy {

	private Bitmap bitmap;
	private int width;
	private int height;
	private LightConfig lightConfig;
	private ICompressEngine compressEngine;

	public BitmapCompressProxy() {
		lightConfig = Light.getInstance().getConfig();
		compressEngine = new LightCompressEngine();
	}

	@Override
	public boolean compress(String outPath) {
		int resultWidth;
		int resultHeight;
		if(width > 0 && height >0){
			resultWidth = width;
			resultHeight = height;
		}else {
			resultWidth = lightConfig.getMaxWidth();
			resultHeight = lightConfig.getMaxHeight();
		}
		return compressEngine.compress2File(bitmap, outPath, lightConfig.getDefaultQuality(), resultWidth, resultHeight);
	}

	@Override
	public Bitmap compress() {
		int resultWidth;
		int resultHeight;
		if(width > 0 && height >0){
			resultWidth = width;
			resultHeight = height;
		}else {
			resultWidth = lightConfig.getMaxWidth();
			resultHeight = lightConfig.getMaxHeight();
		}
		Bitmap result = compressEngine.compress2Bitmap(bitmap, resultWidth, resultHeight);
		float scaleSize = MatrixUtil.getScale(resultWidth, resultHeight, result.getWidth(), result.getHeight());
		if(scaleSize < 1){
			return new MatrixUtil.Build().scale(scaleSize, scaleSize).bitmap(result).build();
		}
		return result;
	}

	public static class Build {
		private Bitmap bitmap;
		private int width;
		private int height;

		public BitmapCompressProxy.Build resource(Bitmap bitmap) {
			this.bitmap = bitmap;
			return this;
		}

		public BitmapCompressProxy.Build width(int width) {
			this.width = width;
			return this;
		}

		public BitmapCompressProxy.Build height(int height) {
			this.height = height;
			return this;
		}

		public BitmapCompressProxy build(){
			if(bitmap == null){
				throw new RuntimeException("bitmap is empty");
			}
			BitmapCompressProxy proxy = new BitmapCompressProxy();
			proxy.width = width;
			proxy.height = height;
			proxy.bitmap = bitmap;
			return proxy;
		}
	}
}
