package com.java.interview.sprint.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.interview.sprint.exception.BadRequestException;
import com.java.interview.sprint.exception.BusinessException;
import com.java.interview.sprint.model.Feedback;
import com.java.interview.sprint.service.FeedbackService;

@RestController
@RequestMapping(path="/feedback")
public class FeedbackController {
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class); 
	
	
	@Autowired
	private  FeedbackService feedbackService;
	
 
	

	 
	 @PutMapping("updateFeedback/{id}")
	  @ResponseStatus(HttpStatus.OK)
	  public Feedback updateFeedbackBasedOnRetro(@PathVariable("id") Long id,@RequestBody Feedback feedback) throws BadRequestException {
		 
			if (feedback.getId()== null) {
				 throw new BadRequestException("The ID is empty, we cannot update feedback");
			    }
	    return feedbackService.updateFeedbackBasedOnRetrospective(id,feedback);
	  }
	  
	 
	 @PostMapping("createFeedback/{id}")
	  @ResponseStatus(HttpStatus.OK)
	  public Feedback saveFeedbackBasedOnRetro(@PathVariable("id") Long id,@RequestBody Feedback feedback) throws BadRequestException, BusinessException {
		 if (feedback.getId()!= null) {
			 throw new BadRequestException("The ID must not be provided when creating a new Feedback");
			
		}
	    return feedbackService.saveFeedbackBasedOnRetrospective(id,feedback);
	  }
	  
	  
	  
	  @GetMapping
	  @ResponseStatus(HttpStatus.OK)
	  public List<Feedback> getAllFeedbacks() {
	    return feedbackService.getAllFeedbacks();
	  }
	
	  
	  
	  public void setFeedbackService(FeedbackService feedbackService) {
			this.feedbackService = feedbackService;
		}

}

  