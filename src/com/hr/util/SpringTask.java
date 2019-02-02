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
	//查询客户连接订单where 当前时间-订单时间>6个月
		System.out.println("进入到查询客户流失");
		List<CstCustomer> list=cs.findlost();
	//将查询到的客户添加到流失预警表中/或者修改客户状态（流失警告）
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
