package com.tuyano.springboot;

public class ChartBean {

	private String label;
	private String borderColor;
	private String backgroundColor;
	private int lineTension;
	private boolean fill;
	private int[] data;




	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public int[] getData() {
		return data;
	}
	public void setData(int[] data) {
		this.data = data;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public int getLineTension() {
		return lineTension;
	}
	public void setLineTension(int lineTension) {
		this.lineTension = lineTension;
	}
	public boolean isFill() {
		return fill;
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}



}
