package com.light.body;

import com.light.core.Utils.DisplayUtil;

import java.io.Serializable;

/**
 * Created by xiaoqi on 2017/11/21
 */

public class LightConfig implements Serializable{

	private static final long serialVersionUID = 1L;

	private int maxFileSize = 500;

	private String outputRootDir;

	private int maxWidth;

	private int maxHeight;

	private int defaultQuality = 85;

	private boolean needIgnoreSize = false;

	public static boolean isDebug = true;

	public LightConfig(){
		maxWidth = DisplayUtil.getScreenWidth(Light.getInstance().getContext());
		maxHeight = DisplayUtil.getScreenHeight(Light.getInstance().getContext());
	}

	public LightConfig setMaxFileSize(int maxFileSize) {
		this.maxFileSize = maxFileSize;
		return this;
	}

	public LightConfig setOutputRootDir(String outputRootDir) {
		this.outputRootDir = outputRootDir;
		return this;
	}

	public int getMaxFileSize() {
		return maxFileSize;
	}

	public String getOutputRootDir() {
		return outputRootDir;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	public int getDefaultQuality() {
		return defaultQuality;
	}

	public void setDefaultQuality(int defaultQuality) {
		this.defaultQuality = defaultQuality;
	}

	public boolean isNeedIgnoreSize() {
		return needIgnoreSize;
	}

	public void setNeedIgnoreSize(boolean needIgnoreSize) {
		this.needIgnoreSize = needIgnoreSize;
	}
}
