package org.gtdplanner.service;

import java.util.List;

import org.gtdplanner.dao.IssueDAO;
import org.gtdplanner.domain.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*The @Service stereotype annotation used to decorate the ContactServiceImpl class is
 *  a specialized form of the @Component annotation. It is appropriate to annotate the
 *   service-layer classes with @Service to facilitate processing by tools or anticipating 
 *   any future service-specific capabilities that may be added to this annotation.
 * */

@Service
public class IssueServiceImpl implements IssueService {
	
	@Autowired
	private IssueDAO issueDAO;

	@Override
	@Transactional
	public void addIssue(Issue issue) {
		issueDAO.addIssue(issue);
	}

	@Override
	@Transactional
	public List<Issue> listIssues() {
		return issueDAO.listIssues();
	}

	@Override
	@Transactional
	public void removeIssue(Integer id) {
		issueDAO.removeIssue(id);
	}

}
