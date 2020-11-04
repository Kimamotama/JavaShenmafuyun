package com.smfy.biz;

import java.util.List;

import com.smfy.entity.Tikuan;

public interface TikuanBiz {

	/**
	 * �����������
	 * @param tj
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<Tikuan> findAllTikuan(String tj,int pageIndex,int pageSize);
	/**
	 * ��ѯ��������
	 * @param tj ����
	 * @return
	 */
	int findAllCount(String tj);
	/**
	 * ɾ������
	 * @param tikuan
	 * @return
	 */
	int delTikuan(Tikuan tikuan);
}
