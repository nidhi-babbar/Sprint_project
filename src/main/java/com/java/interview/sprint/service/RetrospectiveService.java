package com.java.interview.sprint.service;

import java.util.List;

import com.java.interview.sprint.exception.BusinessException;
import com.java.interview.sprint.model.Retrospective;

public interface RetrospectiveService {
  List<Retrospective> getAllRetrospective();
  
  List<Retrospective> getAllRetrospectiveWithPagination(Integer pageNo,Integer pageSize);

  Retrospective updateRetrospective(Retrospective retrospective);
  


  Retrospective createRetrospective(Retrospective retrospective)throws BusinessException ;
}
