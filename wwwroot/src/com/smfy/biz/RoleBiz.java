package com.smfy.biz;

import java.util.List;

import com.smfy.entity.Role;

public interface RoleBiz {
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
	


}
