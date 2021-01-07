package com.hek.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hek.vo.BoardAttachVO;
import com.hek.vo.Criteria;
import com.hek.vo.ReportVO;

public interface ReportMapper {

	public List<ReportVO> getList();
	
	public List<ReportVO> getListWithPaging(Criteria cri);
	
	public void insert(ReportVO report);
	
	public Integer insertSelectKey(ReportVO report);
	
	public ReportVO read(int bno);
	
	public int delete(int bno);
	
	public int update(ReportVO report);
	
	public int getTotalCount(Criteria cri);
	
	public void updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
	
	public List<BoardAttachVO> findByBno(int bno);
}
