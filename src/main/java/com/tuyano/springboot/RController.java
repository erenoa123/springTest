package com.tuyano.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class RController {

	@Autowired
	PlayerService playerService;

	@Autowired
	ManageService manageService;

	@Autowired
	TrainingService trainingService;

	@Autowired
	ResultService resultService;

	// 一覧表示
	@RequestMapping(value = "/playerall")
	public List<Player> playerSelectAll() {
		return playerService.selectAll();
	}

	// 一覧表示
	@RequestMapping(value = "/manageall", method = RequestMethod.GET)
	public List<Manage> manageSelectAll() {
		return manageService.selectAll();
	}

	// 一覧表示
	@RequestMapping(value = "/trainingall", method = RequestMethod.GET)
	public List<Training> TrainingSelectAll() {
		return trainingService.selectAll();
	}

	// 一覧表示
	@RequestMapping(value = "/resultall", method = RequestMethod.GET)
	public List<Result> resultSelectAll() {
		return resultService.selectAll();
	}

	// グラフ表示
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public ChartData SampleChart() {

		List<ChartBean> datasetsList = new ArrayList<ChartBean>();
		ChartBean datasets = new ChartBean();
		ChartData chartdata = new ChartData();
		int playerid[] = new int[10];
		List<Result> resultList = resultService.selectAll();
		List<Player> playerList = playerService.selectAll();
		List<Training> trainingList = trainingService.selectAll();
		List<String> labels = new ArrayList<String>();
		List<Integer> pointList = new ArrayList<Integer>();
		int coler = 255;

		for(Player player : playerList) {
			int point = 0;
			int i =0;
			for(Result result : resultList) {
				if(result.getPlayerid() == player.getPlayerid()) {
					point += result.getPoint();
					i++;
				}
			}
			pointList.add(point);
			labels.add(player.getName());
		}
		coler = coler - 25;

		datasets.setLabel("総得点");
		datasets.setBorderColor("rgba("+coler+",0,0)");
		datasets.setBackgroundColor("rgba(255 ,127 ,127)");
		datasets.setLineTension(0);
		datasets.setFill(false);

		int[] point = new int[pointList.size()];
		int j = 0;
		for(int p : pointList) {
			point[j] = p;
			j++;
		}

		datasets.setData(point);

		String[] label = new String[labels.size()];
		int i = 0;
		for(String name : labels) {
			label[i] = name;
			i++;
		}

		datasetsList.add(datasets);

		chartdata.setLabels(label);
		chartdata.setDatasets(datasetsList);

//			for(Result result : resultList) {
//
//				boolean flg = true;
//				for(int label : labels) {
//					if(result.getTrainingid() == label) {
//						flg = false;
//						break;
//
//					}
//				}
//				if(flg) {
//					labels.add(result.getTrainingid());
//				}
//			}




		return chartdata;
	}


}
