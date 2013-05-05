package org.gtdplanner.dao;

import java.util.List;

import org.gtdplanner.domain.Issue;

public interface IssueDAO {
	
	public void addIssue(Issue issue);
	public List<Issue> listIssues();
	public void removeIssue(Integer id);
	
	

}
