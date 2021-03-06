package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.TopicfileBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.StudyDetailsServiceImpl;
import com.buzz.serviceimpl.TopicServiceImpl;

public class TopicFileById extends Action {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TopicfileBean topicFileBean = null;
		String target = null;
		try {
			topicFileBean = new TopicServiceImpl().viewTopicFilebyId(Integer
					.parseInt(request.getParameter("topicfileid")));
			if (!topicFileBean.equals(null)) {
				request.setAttribute("topicFileBean", topicFileBean);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {
			// message = new ActionMessage(e.getMessage());
			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			// message = new ActionMessage("Branch Details  Not Inserted");
			request.setAttribute("message", "No Topic File Data");
			target = "failure";
		}
		return mapping.findForward(target);
	}
}