package com.hr.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hr.pojo.SysRole;
import com.hr.pojo.SysUser;
import com.hr.service.InfSysRoleService;
import com.hr.service.InfUserService;
import com.hr.util.PageUtil;
import com.hr.util.ResponseUtil;

public class UserAction extends BaseAction{
	private InfUserService us;
	private InfSysRoleService rs;
	public void setRs(InfSysRoleService rs) {
		this.rs = rs;
	}
	public void setUs(InfUserService us) {
		this.us = us;
	}
	
	private SysUser user;
	private int page;
	private int count;
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//登录
	public String login(){
		SysUser u = us.login(user.getUsrName(), user.getUsrPassword());
		if(u!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.getServletContext().setAttribute("u", u);
			System.out.println(u.getRole().getRights().size());
			ResponseUtil.jump(response, "登录成功!", "html/index.jsp");
		}else{
			ResponseUtil.jump(response, "用户名或密码错误", "login.html");
		}
		return null;
	}
	//查询
	public String findAll(){
		PageUtil pu= us.findFy(page, count, user);
		/*List<SysRole> role= rs.findAll();
		request.put("role", role);*/
		request.put("pu", pu);
		return "sele";
	}
	//添加
	public String add(){
		 us.add(user);
		return "yes";
	}
	//查看
	public String findck(){
		System.out.println(user.getUsrId());
		SysUser sus =us.findById(user);
		//System.out.println(sus.getUsrId());
		request.put("sus", sus);
		return "ck";
	}
	//根据id查询
	public String findid(){
		SysUser uss= us.findById(user);
		request.put("uss", uss);
		return "id";
	}
	//查询
	public String update(){
		
		us.update(user);
		return "yes";
	}
	//删除
	public String delete(){
		us.delete(user);
		return "yes";
	}
	//查询指派
	public String findzp(){
		//System.out.println("编号： "+user.getUsrId()+"  用户名： "+user.getUsrName()+"  角色："+user.getRole().getRoleName()+" 状态："+user.getUsrFlag());
		//查询单值
		SysUser yu= us.findById(user);
		request.put("yu", yu);
		//查询值给下拉列表做指派
		List<SysRole> role= rs.findAll();
		request.put("role", role);
		return "zp";
	}
	//修改指派
	public String updatezp(){
		System.out.println(roleId);
		System.out.println(user.getUsrId());
		SysUser ss= us.findById(user);
		SysRole role= rs.findId(roleId);
		ss.setRole(role);
		System.out.println(ss.getUsrName());
		System.out.println(ss.getRole().getRoleId());
		us.update(ss);
		//ss.getRole().setRoleId(roleId);
		return "yes";
	}
	private int roleId;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}
	
}
