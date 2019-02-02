package com.hr.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ServletResponseAware{
	
	public Map<String, Object> request;
	public Map<String, Object> session;
	public Map<String, Object> application;
	public HttpServletResponse response;
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
	
}
