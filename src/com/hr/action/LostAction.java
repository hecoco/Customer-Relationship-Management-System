package com.hr.action;

import java.util.List;

import com.hr.pojo.CstLost;
import com.hr.service.InfCstlostService;

public class LostAction extends BaseAction{
   private InfCstlostService cs;
   public void setCs(InfCstlostService cs) {
	this.cs = cs;
}
   private CstLost losts;
   //查询流失客户的信息
   public String findAll()
   {
	   System.out.println("进入查询流失客户");
	   List<CstLost> listcstlost=cs.findAll();
	   request.put("listcstlost", listcstlost);
	   return SUCCESS;
   }
   //根据id进行查询流失客户
   public String findByid()
   {
	   System.out.println("进入id查询流失客户");
	   CstLost listbid=(CstLost) cs.findByid(CstLost.class, losts.getLstId());
	   request.put("listbid", listbid);
	   return "bid";
   }
   //修改的方法
   public String update()
   {
	       CstLost cstlost=(CstLost) cs.findByid(CstLost.class, losts.getLstId());
	       cstlost.setLstStatus("3");
	       cstlost.setLstReason(losts.getLstReason());
		   cs.update(cstlost);
	return "update";   
   }
   
   //根据id进行查询已经流失客户
   public String findByidd()
   {
	   System.out.println("进入id查询流失客户");
	   CstLost listbidd=(CstLost) cs.findByid(CstLost.class, losts.getLstId());
	   request.put("listbidd", listbidd);
	   return "bidd";
   }
   //修改的方法
   public String updatee()
   {
	       CstLost cstlost=(CstLost) cs.findByid(CstLost.class, losts.getLstId());
	       cstlost.setLstStatus("2");
	       cstlost.setLstDelay(losts.getLstDelay());
		   cs.update(cstlost);
	return "updatee";   
   }
   
public CstLost getLosts() {
	return losts;
}
public void setLosts(CstLost losts) {
	this.losts = losts;
}
   
}
