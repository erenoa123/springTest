package com.tuyano.springboot;

import java.util.List;

public class ChartData {

	String[] labels;
	List<ChartBean> datasets;


	public String[] getLabels() {
		return labels;
	}
	public void setLabels(String[] labels) {
		this.labels = labels;
	}
	public List<ChartBean> getDatasets() {
		return datasets;
	}
	public void setDatasets(List<ChartBean> datasets) {
		this.datasets = datasets;
	}


}
