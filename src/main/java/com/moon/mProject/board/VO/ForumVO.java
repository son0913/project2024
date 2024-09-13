package com.moon.mProject.board.VO;


public class ForumVO {
/*
    idx	int
	title	varchar(50)
	content	varchar(1000)
	writeId	varchar(30)
	regDate	date
	modData	date
 * */
	private int idx;
	private String title;	//제목
	private String content;	//내용
	private String writer;	//작성자
	private String regDate;	//등록일
	private String modDate;	//수정일
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	
	@Override
	public String toString() {
		return "ForumVO [idx=" + idx + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate + ", modDate=" + modDate + "]";
	}
}
