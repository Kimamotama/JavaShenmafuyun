package com.smfy.biz;

import java.util.List;

import com.smfy.entity.Admin;

public interface AdminBiz {
	/**
	 * �����¼
	 * @param admin ����Ա����
	 * @return
	 */
	Admin adminLogin(Admin admin);
	
	/**
	 * ��ѯ���й���Ա
	 * @return
	 */
	List<Admin> findAlladmin(String tj);
	
	/**
	 * ��ӹ���Ա
	 * @param admin
	 * @return
	 */
	int addAdmin(Admin admin);
	
	/**
	 * ɾ������Ա
	* @param admin
	 * @return
	 */
	int delAdmin(Admin admin);
	
	/**
	 * �޸Ĺ���Ա
	 * @param admin
	 * @return
	 */
	int UpdateAdmin(Admin admin);
	/**
	 * �޸Ĺ���Ա״̬�����ߣ����ߣ����ã�ͣ�ã�
	 * @param admin
	 * @return
	 */
	int updateAdminStatus(Admin admin);
}
