package spring.biz.board.vo;

import java.sql.Date;

public class BoardVO {
	private int seq;
	private String title;
	private String Writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	// 기본생성자
	public BoardVO() { 
		super();
	}
	// 매개변수 생성자
	public BoardVO(String title, String writer, String content) {
		super();
		this.title = title;
		Writer = writer;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", Writer=" + Writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}
	
}
