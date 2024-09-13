package com.moon.mProject.api.vo;

import java.util.Date;

import lombok.Data;

@Data
public class LostFoundItemVO {

	private int no;
	private int lost_mng_no;
	private String lost_stts;
	private Date reg_ymd;
	private Date rcv_ymd;
	private String lgs_dtl_cn;
	private String cstd_plc;
	private String lost_rgtr_id;
	private String lost_nm;
	private String lost_knd;
	private String rcpl;
	private String inq_cnt;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getLost_mng_no() {
		return lost_mng_no;
	}
	public void setLost_mng_no(int lost_mng_no) {
		this.lost_mng_no = lost_mng_no;
	}
	public String getLost_stts() {
		return lost_stts;
	}
	public void setLost_stts(String lost_stts) {
		this.lost_stts = lost_stts;
	}
	public Date getReg_ymd() {
		return reg_ymd;
	}
	public void setReg_ymd(Date reg_ymd) {
		this.reg_ymd = reg_ymd;
	}
	public Date getRcv_ymd() {
		return rcv_ymd;
	}
	public void setRcv_ymd(Date rcv_ymd) {
		this.rcv_ymd = rcv_ymd;
	}
	public String getLgs_dtl_cn() {
		return lgs_dtl_cn;
	}
	public void setLgs_dtl_cn(String lgs_dtl_cn) {
		this.lgs_dtl_cn = lgs_dtl_cn;
	}
	public String getCstd_plc() {
		return cstd_plc;
	}
	public void setCstd_plc(String cstd_plc) {
		this.cstd_plc = cstd_plc;
	}
	public String getLost_rgtr_id() {
		return lost_rgtr_id;
	}
	public void setLost_rgtr_id(String lost_rgtr_id) {
		this.lost_rgtr_id = lost_rgtr_id;
	}
	public String getLost_nm() {
		return lost_nm;
	}
	public void setLost_nm(String lost_nm) {
		this.lost_nm = lost_nm;
	}
	public String getLost_knd() {
		return lost_knd;
	}
	public void setLost_knd(String lost_knd) {
		this.lost_knd = lost_knd;
	}
	public String getRcpl() {
		return rcpl;
	}
	public void setRcpl(String rcpl) {
		this.rcpl = rcpl;
	}
	public String getInq_cnt() {
		return inq_cnt;
	}
	public void setInq_cnt(String inq_cnt) {
		this.inq_cnt = inq_cnt;
	}
	
	@Override
	public String toString() {
		return "LostFoundItemVO [no=" + no + ", lost_mng_no=" + lost_mng_no + ", lost_stts=" + lost_stts + ", reg_ymd="
				+ reg_ymd + ", rcv_ymd=" + rcv_ymd + ", lgs_dtl_cn=" + lgs_dtl_cn + ", cstd_plc=" + cstd_plc
				+ ", lost_rgtr_id=" + lost_rgtr_id + ", lost_nm=" + lost_nm + ", lost_knd=" + lost_knd + ", rcpl="
				+ rcpl + ", inq_cnt=" + inq_cnt + "]";
	}
	
	
}
