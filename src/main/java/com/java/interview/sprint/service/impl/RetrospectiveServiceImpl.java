package com.java.interview.sprint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.interview.sprint.exception.BusinessException;
import com.java.interview.sprint.model.Retrospective;
import com.java.interview.sprint.repository.RetrospectiveRepository;
import com.java.interview.sprint.service.RetrospectiveService;

@Service
public class RetrospectiveServiceImpl implements RetrospectiveService {
	Logger logger = LoggerFactory.getLogger(RetrospectiveServiceImpl.class); 

	@Autowired
	private RetrospectiveRepository retrospectiveRepository;

	@Override
	public List<Retrospective> getAllRetrospective() {
		logger.info("getAllRetrospective");
		return retrospectiveRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
	}

	@Override
	public List<Retrospective> getAllRetrospectiveWithPagination(Integer pageNo, Integer pageSize) {
		logger.info("getAllRetrospectiveWithPagination");
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<Retrospective> pagedResult = retrospectiveRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Retrospective>();
		}

	}

	@Override
	public Retrospective createRetrospective(Retrospective retrospective) throws BusinessException {
		logger.info("createRetrospective");
		Retrospective retro=retrospectiveRepository.save(retrospective);
		if(retro!=null) {
			return retro;
		}else {
			throw new BusinessException("Retrospective is  not created");
		}
		   
	}

	@Override
	public Retrospective updateRetrospective(Retrospective retrospective) {
		
		logger.info("updateRetrospective");
		return retrospectiveRepository.save(retrospective);
	}

	public void setRetrospectiveRepository(RetrospectiveRepository retrospectiveRepository) {
		this.retrospectiveRepository = retrospectiveRepository;
	}

}
