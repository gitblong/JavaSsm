package cn.yxxrui.dto;

import java.util.ArrayList;
import java.util.List;

public class LandlordExcelInfo {
	private List<LandLordInfo> landlordList;

	
	public LandlordExcelInfo() {
		landlordList = new ArrayList<LandLordInfo>();
	}

	public LandlordExcelInfo(List<LandLordInfo> landlordList) {
		this.landlordList = landlordList;
	}

	public List<LandLordInfo> getLandlordList() {
		return landlordList;
	}

	public void setLandlordList(List<LandLordInfo> landlordList) {
		this.landlordList = landlordList;
	}

	@Override
	public String toString() {
		return "LandlordExcelInfo [landlordList=" + landlordList + "]";
	}
	
	
}
