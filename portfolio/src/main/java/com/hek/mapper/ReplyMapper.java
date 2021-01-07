package com.hek.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hek.vo.Criteria;
import com.hek.vo.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);
	
	public ReplyVO read(int bno);
	
	public int delete(int bno);
	
	public int update(ReplyVO reply);
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") int bno);
	
	public int getCountByBno(int bno);
}
