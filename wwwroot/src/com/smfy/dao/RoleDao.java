package com.smfy.dao;

import java.util.List;

import com.smfy.entity.Role;

public interface RoleDao {
	/**
	 * ��ѯ
	 * @param role
	 * @return
	 */
	List<Role>findAllRole();
	
	/**
	 * ɾ��
	 * @param 
	 * @return
	 */
	int deleRole(int id);
	
	/**
	 * ��ѯ���ж�������
	 * @param 
	 * @return
	 */
	/*List<Role>findAllRoless();*/

	
	

}
