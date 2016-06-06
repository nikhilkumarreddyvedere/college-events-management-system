/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.BranchBean;
import com.buzz.bean.NewsfeedBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.BranchFormBean;
import com.buzz.formbean.NewsFeedFormBean;
import com.buzz.serviceimpl.BranchServiceImpl;
import com.buzz.serviceimpl.NewsServiceImpl;

/**
 * MyEclipse Struts Creation date: 07-27-2013
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/addNews" name="NewsFeedFormBean"
 *                input="/NewsFeedForm.jsp" scope="request" validate="true"
 */
public class AddNewsAction extends Action {
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
		NewsFeedFormBean newsFeedFormBean = (NewsFeedFormBean) form;// TODO
		// Auto-generated
		// method
		// stub
		NewsfeedBean newsfeedBean = new NewsfeedBean(newsFeedFormBean);
		try {
			System.out.println("haiiiii");
			new NewsServiceImpl().addNews(newsfeedBean);
			request.setAttribute("message",
					"News Details Inserted SuccessFully");
			return mapping.findForward("success");
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			return mapping.findForward("fail");
		} catch (Exception e) {
			request.setAttribute("message", "News Details  Not Inserted");
			return mapping.findForward("fail");
		}

	}
}