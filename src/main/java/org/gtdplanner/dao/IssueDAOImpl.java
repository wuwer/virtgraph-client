package org.gtdplanner.dao;

import java.util.List;

import org.gtdplanner.domain.Issue;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 *The @Repository annotation is yet another stereotype that was introduced in Spring 2.0. 
 *This annotation is used to indicate that a class functions as a repository and needs to have 
 *exception translation applied transparently on it. The benefit of exception translation is that 
 *the service layer only has to deal with exceptions from Spring’s DataAccessException hierarchy,
 *even when using plain JPA in the DAO classes. 
 * */

@Repository
public class IssueDAOImpl implements IssueDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addIssue(Issue issue) {
		sessionFactory.getCurrentSession().save(issue);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Issue> listIssues() {
		return sessionFactory.getCurrentSession().createQuery("from Issue").list();
	}

	@Override
	public void removeIssue(Integer id) {
		Issue issue = (Issue) sessionFactory.getCurrentSession().load(Issue.class, id);
		if(issue != null)
		{
			sessionFactory.getCurrentSession().delete(issue);
		}
	}

}
