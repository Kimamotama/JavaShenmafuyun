package com.smfy.dao;

import java.util.List;

import com.smfy.entity.Ment;

public interface MentDao {
	/**
	 * �������
	 * @param ment ����
	 * @return
	 */
	int addMent(Ment ment);
	/**
	 * ɾ������
	 * @param ment ����
	 * @return
	 */
	int delMent(Ment ment);
	/**
	 * �ظ�����
	 * @param ment ����
	 * @return
	 */
	int reMent(Ment ment);
	/**
	 * �޸�����  stasus=1Ϊ���ͨ��
	 * @param ment ����
	 * @return
	 */
	int updateMnet(Ment ment);
	/**
	 * �����۵���
	 * @param ment ͨ�����۶����id
	 * @return
	 */
	int dpMent(Ment ment);
	/**
	 * �������������������
	 * @param tj ��ѯ����������Դ��id
	 * @return
	 */
	List<Ment> findAllMent(String tj,int pageIndex, int pageSize);
	/**
	 * ����ȫ����������
	 * @return
	 */
	int findAllMentCount(String tj);
}
