package kr.co.hyewon.bean;

public class BoardInfoBean {
	
	private int board_info_idx;
	private String board_info_name;
	
	public int getBoard_info_idx() {
		return board_info_idx;
	}
	public void setBoard_info_idx(int board_info_idx) {
		this.board_info_idx = board_info_idx;
	}
	public String getBoard_info_name() {
		return board_info_name;
	}
	public void setBoard_info_name(String board_info_name) {
		this.board_info_name = board_info_name;
	}
	
	
	// 답글기능을 위한 vo
	
	//원글 번호 
	private int originNo;
	
	//원글(답글포함)에 대한 순서
	private int groupOrd;
	
	//답글 계층 
	private int groupLayer;

	public int getOriginNo() {
		return originNo;
	}
	public void setOriginNo(int originNo) {
		this.originNo = originNo;
	}
	public int getGroupOrd() {
		return groupOrd;
	}
	public void setGroupOrd(int groupOrd) {
		this.groupOrd = groupOrd;
	}
	public int getGroupLayer() {
		return groupLayer;
	}
	public void setGroupLayer(int groupLayer) {
		this.groupLayer = groupLayer;
	}
	
	

}
