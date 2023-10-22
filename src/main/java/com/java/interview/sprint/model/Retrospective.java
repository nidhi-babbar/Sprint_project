package com.java.interview.sprint.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;




@Entity
public class Retrospective implements Serializable {
	private static final long serialVersionUID = 5560221391479816650L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long retrospectiveId;
	private String name;
	private String summary;
	private Date date;

	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "participants", joinColumns = @JoinColumn(name = "retrospective_id"))
	@Column(name = "participant", nullable = false)
	private List<String> participants = new ArrayList<String>();

	@OneToMany(mappedBy = "retrospective", cascade = CascadeType.ALL)
	private List<Feedback> feedback;

	public List<String> getParticipants() {
		return participants;
	}

	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public String getName() {
		return name;
	}

	public Long getRetrospectiveId() {
		return retrospectiveId;
	}

	public void setRetrospectiveId(Long retrospectiveId) {
		this.retrospectiveId = retrospectiveId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
