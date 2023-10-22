package com.java.interview.sprint.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.interview.sprint.exception.BadRequestException;
import com.java.interview.sprint.exception.BusinessException;
import com.java.interview.sprint.model.Retrospective;
import com.java.interview.sprint.service.RetrospectiveService;

@RestController
@RequestMapping(path = "/retrospective")
public class RetrospectiveController {
	Logger logger = LoggerFactory.getLogger(RetrospectiveController.class); 
	@Autowired
	private RetrospectiveService retrospectiveService;

	public void setRetrospectiveService(RetrospectiveService retrospectiveService) {
		this.retrospectiveService = retrospectiveService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Retrospective createRetrospective(@RequestBody Retrospective retrospective) throws BusinessException, BadRequestException  {
		logger.info("createRetrospective");
		if (retrospective.getRetrospectiveId() != null) {
		      throw new BadRequestException("The ID must not be provided when creating a new Rerospective");
		    }
		return retrospectiveService.createRetrospective(retrospective);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Retrospective updateRetrospective( @RequestBody Retrospective retrospective) throws BadRequestException {
		logger.info("updateRetrospective");
		if (retrospective.getRetrospectiveId() == null) {
			 throw new BadRequestException("The ID is empty, we cannot update");
		}
		
		return retrospectiveService.updateRetrospective(retrospective);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Retrospective> getAllRetrospective() {
		logger.info("getAllRetrospective");
		return retrospectiveService.getAllRetrospective();
	}

	@GetMapping("/pagination")
	@ResponseStatus(HttpStatus.OK)
	public List<Retrospective> getAllRetrospectiveWithPagination(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "1") Integer pageSize) {
		logger.info("getAllRetrospectiveWithPagination");
		List<Retrospective> list = retrospectiveService.getAllRetrospectiveWithPagination(pageNo, pageSize);

		return list;
	}

}
