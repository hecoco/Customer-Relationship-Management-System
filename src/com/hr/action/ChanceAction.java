package com.hr.action;

import java.util.List;

import com.hr.pojo.SalChance;
import com.hr.pojo.SysUser;
import com.hr.service.InfUserService;
import com.hr.service.infChanceService;
import com.hr.util.ResponseUtil;

public class ChanceAction extends BaseAction {
	//ic��ֵinfChanceService
     private infChanceService ic;
     public void setIc(infChanceService ic) {
		this.ic = ic;
	}
   //us��ֵInfUserService
     private InfUserService us;
 	public void setUs(InfUserService us) {
 		this.us = us;
 	}
     
 	
    //�±� 
     private int start;
     //ҳ��
     private int page;
   //ÿҳ����
 	private int count;
	//���ҳ��
 	private int maxPage;
 	//�������
	private int maxCount;
	
    public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
     public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
	//��ҳ��ѯ
     public String querylist(){
    	 if (page<1) {
			page=1;
		}
    	 count =3;
    	 maxCount = ic.findCount(sc, name, title, Linkman);
    	 //count = 5;
    	// System.out.println(maxCount);
    	 //System.out.println(count);
    	 maxPage = maxCount%count==0? maxCount/count:maxCount/count+1;
    	 //System.out.println(maxPage);
 		if(page > maxPage){
 			page = maxPage;
 		}
    	 
    	// System.out.println("123456");
    	 //ҳ����ʾ����������
    	 //length=10;
    	 //��ѯSalChance�������
    	List<SalChance> list= ic.querygj(name, title, Linkman,page,count);
    	//�½�add.jsp��Ҫ
    	List<SysUser> users=  us.querylistUser();
    	
    	request.put("list", list);
    	session.put("user", users);
    	
		return "list"; 
     }
     
     //ʵ����
     private SalChance sc;
     public SalChance getSc() {
		return sc;
	}
	public void setSc(SalChance sc) {
		this.sc = sc;
	}
	//���
     public String add() {
    	// System.out.println(ic);
    	// sc=sc.toString();
    	 System.out.println(sc.getSu().getUsrId());
    	 if (sc.getSu().getUsrId()!=0) {
    	    	SysUser sUser= us.idquerylist(sc.getSu().getUsrId());
    	    	 sc.setSu(sUser);
    	    	 sc.setChcDueTo(sUser.getUsrName());
    	    	 
		}
    	// System.out.println(sc.toString());
    	// sc.setChcDueId(1);
    	 int i=ic.add(sc);
    	 
    	 if (i>0) {
    		 ResponseUtil.jump(response, "��ӳɹ�!", "chance!querylist");
		}else {
			 ResponseUtil.jump(response, "���ʧ��!", "chance!querylist");
		}
    	 
		return null;
		
	}
     
     
     private int tz;
     public int getTz() {
		return tz;
	}
	public void setTz(int tz) {
		this.tz = tz;
	}
	//id��ѯ
     public String idquerylist(){
    	System.out.println(tz);
    	//System.out.println(sc.getChcId());
    	//ǿת   ��ΪcommonsDao���治�ܴ���������
    	Integer id=sc.getChcId();
    	//����id��ѯ
    	 SalChance sch= ic.idquerylist(id);
    	 request.put("sch", sch);
    	 if (tz==1) {
    		 return "idlist";
		}
    	 if (tz==2) {
    		 return "dispatch";
		}
		return null; 
     }
     //ɾ��
     public String delete() {
    	 System.out.println(sc.getChcId());
    	// sc=sc.toString();
    	//ǿת   ��ΪcommonsDao���治�ܴ���������
    	 Integer id=sc.getChcId();
    	 
    	 int i=ic.delete(sc);
    	 
    	 if (i>0) {
    		 ResponseUtil.jump(response, "ɾ���ɹ�!", "chance!querylist");
		}else {
			 ResponseUtil.jump(response, "ɾ��ʧ��!", "chance!querylist");
		}
    	 
		return null;
		
	}
     //�޸�
     public String update() {
     	// System.out.println(ic);
     	// sc=sc.toString();
     	 //System.out.println(sc.getSu().getUsrId());
     	// System.out.println(sc.toString());

	    	SysUser sUser= us.idquerylist(sc.getSu().getUsrId());
	    	 
	    	sc.setSu(sUser);
	    	 sc.setChcDueTo(sUser.getUsrName());
	    	
    	      sc.setChcStatus("1");
     	 int i=ic.update(sc);
     	 
     	 if (i>0) {
     		 ResponseUtil.jump(response, "�޸ĳɹ�!", "chance!querylist");
 		}else {
 			 ResponseUtil.jump(response, "�޸�ʧ��!", "chance!querylist");
 		}
     	 
 		return null;
 		
 	}
     //ָ��
     public String updatezpr() {
     	// System.out.println(ic);
     	// sc=sc.toString();
     	 //System.out.println(sc.getSu().getUsrId());
     	// System.out.println(sc.toString());

	    	SysUser sUser= us.idquerylist(sc.getSu().getUsrId());
	    	 
	    	sc.setSu(sUser);
	    	 sc.setChcDueTo(sUser.getUsrName());
    	 SalChance scChance= ic.idquerylist(sc.getChcId());
	    	 
     	 int i=ic.update(scChance);
     	 
     	 if (i>0) {
     		 ResponseUtil.jump(response, "�޸ĳɹ�!", "chance!querylist");
 		}else {
 			 ResponseUtil.jump(response, "�޸�ʧ��!", "chance!querylist");
 		}
     	 
 		return null;
 		
 	}
  
     
     //����һ��������     ��һ��������planactionl��
     //����3�����Խ���ҳ���ϵ�ֵ
     //�ͻ�����
     private String name;
     //��Ҫ
     private String title;
     //��ϵ��
     private String Linkman;
     //�߼���ѯ
     public String querygj() {
     	// count =3;
    	 maxCount = ic.findCount(sc, name, title, Linkman);
    	 if (page<1) {
 			page=1;
 		}
    	 
    	 //count = 5;
    	// System.out.println(maxCount);
    	 //System.out.println(count);
    	 maxPage = maxCount%count==0? maxCount/count:maxCount/count+1;
    	 //System.out.println(maxPage);
 		if(page > maxPage){
 			page = maxPage;
 		}
    		
    	 List<SalChance> list= ic.querygj(name, title, Linkman,page,count);
    		request.put("list", list);
    		//request.put("count", count);
    		//request.put("name", title);
    		//request.put("name", Linkman);
		return "list";
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLinkman() {
		return Linkman;
	}
	public void setLinkman(String linkman) {
		Linkman = linkman;
	}
     
     
    
     
     
}
