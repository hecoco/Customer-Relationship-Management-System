package com.hr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.patterns.IVerificationRequired;

import com.hr.pojo.SalChance;
import com.hr.pojo.SalPlan;
import com.hr.pojo.SysUser;
import com.hr.service.infChanceService;
import com.hr.service.infplanService;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class Planaction extends BaseAction {
     private infplanService ips;
     public void setIps(infplanService ips) {
		this.ips = ips;
	}
     private infChanceService ic;
     public void setIc(infChanceService ic) {
		this.ic = ic;
	}
     
     
     //ʵ���
     private SalPlan sp;
     private SalChance sc = new SalChance();
     
     
     public SalChance getSc() {
		return sc;
	}
	public void setSc(SalChance sc) {
		this.sc = sc;
	}
	public SalPlan getSp() {
		return sp;
	}
	public void setSp(SalPlan sp) {
		this.sp = sp;
	}
	//��ҳ���±�
	private int start;
	   //ҳ��
    private int page;
  //ÿҳ����
	private int count;
	//���ҳ��
	private int maxPage;
	//�������
	private int maxCount;
	
     public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
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
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	//��ѯ����
     public String querylist(){
    	 maxCount =ips.findCount(sc);
    	 if (page<1) {
			page=1;
		}
    	 count =3;
    	// maxCount =ips.findCount(sc);
    	 maxPage = maxCount%count==0? maxCount/count:maxCount/count+1;
    	 if(page > maxPage){
  			page = maxPage;
  		}
     	// System.out.println("123456");
     	 //ҳ����ʾ����������
     	// length=10;
     	 //��ѯSalPlan�������
    	 //List<SalPlan> list=ips.query();
    	// System.out.println(maxCount);
    	 //System.out.println( "sdad��"+page+count);
     	List<SalPlan> list= ips.querygj(sc, page,count);
     	//System.out.println("size:"+list.size());
//     	for (SalPlan s : list) {
//			System.out.println("pid: "+s.getPlaId());
//		}
     	request.put("list1", list);
     	//request.put("count", count);
    	 
 		return "list"; 
      }
     
     
     
     
     //��ת    �жϵ�����
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
     	Integer id=sp.getPlaId();
     	//����id��ѯ
     	 SalPlan sp= ips.idquerylist(id);
     	 request.put("sp", sp);
     	List<SalPlan> list= ips.querylist();
 		request.put("list", list);
     	 if (tz==1) {
     		 return "dev_plan"; 
		}else if (tz==2)  {
//			List<SalPlan> list= ips.querylist();
//     		request.put("list", list);
     		 
			return "dev_execute";
		}
		return null; 
      }
	//�޸� ��Ҫ�Ĳ���
	private String updatetores;
	public String getUpdatetores() {
		return updatetores;
	}
	public void setUpdatetores(String updatetores) {
		this.updatetores = updatetores;
	}
	//�޸�
	public String update(){
		//System.out.println(sp.getPlaId());
		//System.out.println(tz);
		//System.out.println(updatetores);
		SalPlan spp= ips.idquerylist(sp.getPlaId());
		if (tz==1) {
			spp.setPlaTodo(updatetores);
			ips.update(spp);
		}if (tz==2) {
			spp.setPlaResult(updatetores);
			ips.update(spp);
		}if (tz==4) {
			//String st=tz+"";
			System.out.println("66");
			 SalChance sch= ic.idquerylist(spp.getSlch().getChcId());
			 sch.setChcStatus(tz+"");
			 ic.update(sch);
			
		}if (tz==3) {
			//String st=tz+"";
			System.out.println("55");
			 SalChance sch= ic.idquerylist(spp.getSlch().getChcId());
			 sch.setChcStatus(tz+"");
			 ic.update(sch);
			
		}
		return "query";
	}
	
	
	//���
	public String add(){
		//System.out.println("ss");
		//System.out.println(updatetores);
		
		ips.add(sp);
		return "query";
		
		
	}
	
	
	
	
	//�߼���ѯ
	public String  querygj() {
		 maxCount =ips.findCount(sc);
    	 if (page<1) {
			page=1;
		}
    	 count =3;
    	 //maxCount =ips.findCount(sc);
    	 maxPage = maxCount%count==0? maxCount/count:maxCount/count+1;
    	 if(page > maxPage){
  			page = maxPage;
  		}
    	 
    	 //����
    	 List<SalPlan> list=ips.querygj(sc, page, count);
    	 request.put("list1", list);
		return "list";
		
	}
      
     
}
