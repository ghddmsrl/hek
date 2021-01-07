package com.hek.service;

import java.util.List;

import com.hek.vo.BoardAttachVO;
import com.hek.vo.Criteria;
import com.hek.vo.ReportVO;

public interface ReportService {

	public void register(ReportVO report);
	
	public ReportVO get(int bno);
	
	public boolean modify(ReportVO report);
	
	public boolean remove(int bno);
	
	public List<ReportVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
	public List<BoardAttachVO> getAttachList(int bno);
}
