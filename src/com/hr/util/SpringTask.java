package com.hr.util;

import java.util.List;

import com.hr.pojo.CstCustomer;
import com.hr.pojo.CstLost;
import com.hr.service.InfCstlostService;

public class SpringTask {
    
	private InfCstlostService cs;
	public void setCs(InfCstlostService cs) {
		this.cs = cs;
	}
	
	public void task()
	{
	//��ѯ�ͻ����Ӷ���where ��ǰʱ��-����ʱ��>6����
		System.out.println("���뵽��ѯ�ͻ���ʧ");
		List<CstCustomer> list=cs.findlost();
	//����ѯ���Ŀͻ���ӵ���ʧԤ������/�����޸Ŀͻ�״̬����ʧ���棩
		System.out.println("1");
        cs.update(list);
        
        CstLost losts=new CstLost();
        losts.setLstCustNo(list.get(0).getCustNo());
        losts.setLstCustName(list.get(0).getCustName());
        losts.setLstCustManagerId(list.get(0).getSysusers().getUsrId());
        losts.setLstCustManagerName(list.get(0).getSysusers().getUsrName());
        losts.setLstLastOrderDate(list.get(0).getOrderss().get(0).getOdrDate());
        losts.setLstStatus(list.get(0).getCustStatus());
        cs.add(losts);
		
	}
	
}
