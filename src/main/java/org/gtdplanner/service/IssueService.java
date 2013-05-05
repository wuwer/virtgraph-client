package org.gtdplanner.service;

import java.util.List;

import org.gtdplanner.domain.Issue;

public interface IssueService {
	
	public void addIssue(Issue issue);
	public List<Issue> listIssues();
	public void removeIssue(Integer id);
}
