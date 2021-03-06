package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.EventsBean;
import com.buzz.serviceimpl.EventServiceImpl;

public class ViewEventsByDateAction extends Action {
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
		Vector<EventsBean> vEventsBeans = null;
		String target = null;
		try {
			System.out.println("dddd");
			/*vEventsBeans = new EventServiceImpl()
					.viewEventsbyDate(request
							.getParameter("eventdate"));*/
			if (!vEventsBeans.isEmpty()) {
				request.setAttribute("vEventsBeans", vEventsBeans);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (Exception e) {
			request.setAttribute("message", "No Events");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}