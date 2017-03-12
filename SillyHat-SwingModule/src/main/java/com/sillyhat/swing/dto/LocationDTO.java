package com.sillyhat.swing.dto;

import java.io.Serializable;

public class LocationDTO implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -5183550414785492583L;
	
	private int width;
	
	private int height;

	public LocationDTO(){
		
	}
	
	public LocationDTO(int width,int height){
		setWidth(width);
		setHeight(height);
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}
