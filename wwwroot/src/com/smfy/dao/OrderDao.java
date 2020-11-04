package com.smfy.dao;

import java.util.List;

import com.smfy.entity.Order;

public interface OrderDao {
	/**
	 * ��ѯ����
	 * @param status ��ѯ���� 
	 * @paramp  ageIndex ��ǰҳ��
	 * @param   pageSize ÿҳ����
	 * @return
	 */
	List<Order> findAllOrder(String status,int pageIndex,int pageSize);
	
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
