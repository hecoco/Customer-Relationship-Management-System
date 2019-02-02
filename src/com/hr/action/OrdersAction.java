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
	
	
	//根据客户id查询订单
	public String findOrdersById()
	{
		System.out.println("进入根据客户id查询订单");
		CstCustomer ccto=(CstCustomer) ifo.findOrdersById(CstCustomer.class,cct.getCustNo());
		request.put("orderslist", ccto.getOrderss());
		request.put("idd", ccto.getCustNo());
		request.put("namen", ccto.getCustName());
		return SUCCESS;
	}
	//根据订单id查询订单明细
	public String findOrdersLine()
	{
		System.out.println("进入根据订单id查询订单明细");
		Orders or= (Orders) ifo.findOrdersById(Orders.class, ords.getOdrId());
		//根据订单详情查询商品
		System.out.println("进入根据订单详情id查询商品");
		OrdersLine olLine= (OrdersLine) ifo.findOrdersById(OrdersLine.class, or.getOrdersLines().get(0).getOddId());
		//把商品表数据传到jsp
		double count=0;
		for (OrdersLine line : or.getOrdersLines()) {
			count+=line.getOddCount()*line.getProducts().getProdPrice();	
		}
		request.put("count", count);
		request.put("sp", olLine.getProducts());
		//把订单表数据传到jsp
		request.put("dd", or);
		//把订单详情表数据传到jsp
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
