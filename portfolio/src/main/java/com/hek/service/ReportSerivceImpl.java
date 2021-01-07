package com.hek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hek.mapper.BoardAttachMapper;
import com.hek.mapper.ReportMapper;
import com.hek.vo.BoardAttachVO;
import com.hek.vo.Criteria;
import com.hek.vo.ReportVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReportSerivceImpl implements ReportService{

	@Setter(onMethod_ = @Autowired)
	private ReportMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;

	@Transactional
	@Override
	public void register(ReportVO report) {
		
		log.info("register"+ report);
		
		mapper.insertSelectKey(report);
		
		if(report.getAttachList() == null || report.getAttachList().size() <= 0){
			return;
		}
		
		report.getAttachList().forEach(attach -> {
			attach.setBno(report.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override
	public ReportVO get(int bno) {
		
		log.info("get"+ bno);
		return mapper.read(bno);
	}

	@Transactional
	@Override
	public boolean modify(ReportVO report) {
		log.info("modify"+report);
		
		attachMapper.deleteAll(report.getBno());
		
		boolean modifyResult = mapper.update(report) ==1;
		
		if(modifyResult && report.getAttachList().size() > 0) {
			report.getAttachList().forEach(attach ->{
				attach.setBno(report.getBno());
				attachMapper.insert(attach);
			});
		}
		return modifyResult;
	}

	@Transactional
	@Override
	public boolean remove(int bno) {
		log.info("remove"+ bno);
		
		attachMapper.deleteAll(bno);
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<ReportVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get totla count");
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(int bno) {
		log.info("get Attach list By bno"+bno);
		return attachMapper.findByBno(bno);
	}
	

	
}
