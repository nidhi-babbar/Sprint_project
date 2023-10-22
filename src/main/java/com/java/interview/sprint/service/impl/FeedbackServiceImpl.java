package com.java.interview.sprint.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.interview.sprint.exception.BusinessException;
import com.java.interview.sprint.model.Feedback;
import com.java.interview.sprint.repository.FeedbackRepository;
import com.java.interview.sprint.service.FeedbackService;



@Service
class FeedbackServiceImpl implements FeedbackService {
	
	Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class); 
	
	@Autowired
  private  FeedbackRepository feedbackRepository;

	
  @Override
  public List<Feedback> getAllFeedbacks() {
	  logger.info("getAllFeedbacks");
    return feedbackRepository.findAll();
  }

 
  public Feedback createFeedback(Feedback feedback) throws BusinessException {
	  logger.info("createFeedback");
	  Feedback feedbackObj=feedbackRepository.save(feedback);
	  if(feedbackObj!=null) {
			return feedbackObj;
		}else {
			throw new BusinessException("Retrospective is  not created");
		}
 
  }
  
  

  public Feedback updateFeedback(Feedback feedback) {
	  logger.info("updateFeedback");
	  Feedback existingFeedback = feedbackRepository.findById(feedback.getId()).get();
	  existingFeedback.setName(feedback.getName());
	  existingFeedback.setBody(feedback.getBody());
	  existingFeedback.setType(feedback.getType());
    return feedbackRepository.save(feedback);
  }
  
  @Transactional
  @Override
  public Feedback updateFeedbackBasedOnRetrospective(Long id,Feedback feedback) {
	  logger.info("updateFeedbackBasedOnRetro");
	  Feedback feedbackUpdated=updateFeedback(feedback);
	  feedbackRepository.updateFeedbackBasedOnRetrospective(id, feedbackUpdated.getId());
	  return feedbackUpdated;
  }
  
  @Transactional
  @Override
  public Feedback saveFeedbackBasedOnRetrospective(Long id,Feedback feedback) throws BusinessException {
	  logger.info("saveFeedbackBasedOnRetro");
	  Feedback feedbackUpdated=createFeedback(feedback);
	feedbackRepository.updateFeedbackBasedOnRetrospective(id, feedbackUpdated.getId());
	 return feedbackUpdated;
  }
  
 

}
