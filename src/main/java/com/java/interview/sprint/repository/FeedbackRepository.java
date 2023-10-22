package com.java.interview.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.interview.sprint.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> 
{
	@Modifying
	@Query(value="update feedback u set u.retro_id = :retroId where u.id = :feedbackId",nativeQuery=true)	 
	int updateFeedbackBasedOnRetrospective(@Param("retroId") Long id, 
			  @Param("feedbackId") Long feedbackId);


}
