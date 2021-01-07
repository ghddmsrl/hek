package com.hek.service;

import java.util.List;

import com.hek.vo.Criteria;
import com.hek.vo.ReplyPageDTO;
import com.hek.vo.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO vo);
	
	public ReplyVO get(int rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(int rno);
	
	public List<ReplyVO> getList(Criteria cri, int bno);
	
	public ReplyPageDTO getListPage(Criteria cri, int bno);
}
