package com.java.interview.sprint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.java.interview.sprint.dto.FeedbackType;

@Entity
public class Feedback implements Serializable {
  private static final long serialVersionUID = 3252591505029724236L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String body;

  @Enumerated(EnumType.STRING)
  @Column(name="type")
  private FeedbackType type;


  @ManyToOne
  @JoinColumn(name="retro_id",referencedColumnName = "retrospectiveId")
  private Retrospective retrospective;

	
public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

public String getBody() {
	return body;
}

public void setBody(String body) {
	this.body = body;
}

public FeedbackType getType() {
	return type;
}

public void setType(FeedbackType type) {
	this.type = type;
}




  
}
