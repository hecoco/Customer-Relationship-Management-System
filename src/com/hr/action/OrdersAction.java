package com.hr.action;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.hr.pojo.CstCustomer;
import com.hr.pojo.Orders;
import com.hr.pojo.OrdersLine;
import com.hr.service.InfOrders;

public class OrdersAction extends BaseAction{
	private InfOrders ifo;
	public void setIfo(InfOrders ifo) {
		this.ifo = ifo;
	}
	private CstCustomer cct;
	private Orders ords;
	private OrdersLine ordsline;
	
	
	//���ݿͻ�id��ѯ����
	public String findOrdersById()
	{
		System.out.println("������ݿͻ�id��ѯ����");
		CstCustomer ccto=(CstCustomer) ifo.findOrdersById(CstCustomer.class,cct.getCustNo());
		request.put("orderslist", ccto.getOrderss());
		request.put("idd", ccto.getCustNo());
		request.put("namen", ccto.getCustName());
		return SUCCESS;
	}
	//���ݶ���id��ѯ������ϸ
	public String findOrdersLine()
	{
		System.out.println("������ݶ���id��ѯ������ϸ");
		Orders or= (Orders) ifo.findOrdersById(Orders.class, ords.getOdrId());
		//���ݶ��������ѯ��Ʒ
		System.out.println("������ݶ�������id��ѯ��Ʒ");
		OrdersLine olLine= (OrdersLine) ifo.findOrdersById(OrdersLine.class, or.getOrdersLines().get(0).getOddId());
		//����Ʒ�����ݴ���jsp
		double count=0;
		for (OrdersLine line : or.getOrdersLines()) {
			count+=line.getOddCount()*line.getProducts().getProdPrice();	
		}
		request.put("count", count);
		request.put("sp", olLine.getProducts());
		//�Ѷ��������ݴ���jsp
		request.put("dd", or);
		//�Ѷ�����������ݴ���jsp
		request.put("ddxq", or.getOrdersLines());
		return "bid";
	}
	
	
	
	public CstCustomer getCct() {
		return cct;
	}
	public void setCct(CstCustomer cct) {
		this.cct = cct;
	}
	public Orders getOrds() {
		return ords;
	}
	public void setOrds(Orders ords) {
		this.ords = ords;
	}
	public OrdersLine getOrdsline() {
		return ordsline;
	}
	public void setOrdsline(OrdersLine ordsline) {
		this.ordsline = ordsline;
	}
	
}
