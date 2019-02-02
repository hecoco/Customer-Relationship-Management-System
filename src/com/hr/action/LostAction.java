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
   //��ѯ��ʧ�ͻ�����Ϣ
   public String findAll()
   {
	   System.out.println("�����ѯ��ʧ�ͻ�");
	   List<CstLost> listcstlost=cs.findAll();
	   request.put("listcstlost", listcstlost);
	   return SUCCESS;
   }
   //����id���в�ѯ��ʧ�ͻ�
   public String findByid()
   {
	   System.out.println("����id��ѯ��ʧ�ͻ�");
	   CstLost listbid=(CstLost) cs.findByid(CstLost.class, losts.getLstId());
	   request.put("listbid", listbid);
	   return "bid";
   }
   //�޸ĵķ���
   public String update()
   {
	       CstLost cstlost=(CstLost) cs.findByid(CstLost.class, losts.getLstId());
	       cstlost.setLstStatus("3");
	       cstlost.setLstReason(losts.getLstReason());
		   cs.update(cstlost);
	return "update";   
   }
   
   //����id���в�ѯ�Ѿ���ʧ�ͻ�
   public String findByidd()
   {
	   System.out.println("����id��ѯ��ʧ�ͻ�");
	   CstLost listbidd=(CstLost) cs.findByid(CstLost.class, losts.getLstId());
	   request.put("listbidd", listbidd);
	   return "bidd";
   }
   //�޸ĵķ���
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
