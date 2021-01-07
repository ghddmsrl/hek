package com.hek.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ReportVO {

	private int bno;
	private String store;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
	private int replyCnt;
	
	private List<BoardAttachVO> attachList;
}
