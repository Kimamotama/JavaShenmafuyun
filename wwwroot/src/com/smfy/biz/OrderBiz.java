package com.smfy.biz;

import java.util.List;

import com.smfy.entity.Order;

public interface OrderBiz {
	/**
	 * ��ѯ����
	 * @param status ��ѯ���� 
	 * @return
	 */
	List<Order> findAllOrder(String status,int pageIndex, int pageSize);
	/**
	 * ��ѯȫ����������
	 * @return
	 */
	int findAllOrderCount(String status);
	/**
	 * ɾ������
	 * @param id ����IDɾ��
	 * @return
	 */
	int deleteOrder(int id);
	

}
