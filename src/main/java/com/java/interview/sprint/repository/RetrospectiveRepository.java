package com.java.interview.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.interview.sprint.model.Retrospective;

public interface RetrospectiveRepository extends JpaRepository<Retrospective, Long> {}
