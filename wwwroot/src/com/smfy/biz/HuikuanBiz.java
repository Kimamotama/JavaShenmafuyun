package com.smfy.biz;

import java.util.List;

import com.smfy.entity.Huikuan;

public interface HuikuanBiz {

	/**
	 * ��ѯȫ�����
	 * @param tj
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<Huikuan>findAllHuikuan(String tj,int pageIndex,int pageSize);
	/**
	 * ��ѯ��������
	 * @param tj ����
	 * @return
	 */
	int findAllCount(String tj);
	
	/**
	 * ɾ������
	 * @param huikuan
	 * @return
	 */
	int delHuikuan(Huikuan huikuan);
}
