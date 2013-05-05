package org.gtdplanner.controller;

import org.gtdplanner.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IssueController {
	
	@Autowired
	private IssueService issueService;
	
	@RequestMapping(value = "/issues", method = RequestMethod.GET)
	public String issues(Model model)
	{
		model.addAttribute("issues", issueService.listIssues());
		return "issues";
	}
}
