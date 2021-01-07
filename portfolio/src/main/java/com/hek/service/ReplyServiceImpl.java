package com.hek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hek.mapper.ReplyMapper;
import com.hek.mapper.ReportMapper;
import com.hek.vo.Criteria;
import com.hek.vo.ReplyPageDTO;
import com.hek.vo.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private ReportMapper reportMapper;

	@Transactional
	@Override
	public int register(ReplyVO vo) {
		
		log.info("register"+vo);
		
		reportMapper.updateReplyCnt(vo.getBno(), 1);
		
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(int rno) {
		
		log.info("get"+ rno);
		
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		
		log.info("modify"+ vo);
		
		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(int rno) {
		
		log.info("remove"+ rno);
		
		ReplyVO vo = mapper.read(rno);
		
		return 0;
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		
		log.info("get Reply List"+ bno);
		
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, int bno) {
		
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}
	
}
