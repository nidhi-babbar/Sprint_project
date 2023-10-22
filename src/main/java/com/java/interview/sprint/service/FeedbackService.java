package com.java.interview.sprint.service;

import java.util.List;

import com.java.interview.sprint.exception.BusinessException;
import com.java.interview.sprint.model.Feedback;

public interface FeedbackService {
  List<Feedback> getAllFeedbacks();
 
  Feedback updateFeedbackBasedOnRetrospective(Long id,Feedback feedback);
  Feedback saveFeedbackBasedOnRetrospective(Long id,Feedback feedback)throws BusinessException;
}
