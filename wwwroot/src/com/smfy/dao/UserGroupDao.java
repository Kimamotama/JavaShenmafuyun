package com.smfy.dao;

import java.util.List;

import com.smfy.entity.UserGroup;

public interface UserGroupDao {
	/**
	 * ��ѯ
	 * @param UserGroup
	 * @return
	 */
	List<UserGroup>finAllGroup();
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	int deleUserGroup(int id);
	
	/**
	 * ��������
	 * @param 
	 * @return
	 */
	int addUserGroup(UserGroup userGroup);
	
	/**
	 * �޸ķ���
	 * @param 
	 * @return
	 */
	int updateUserGroup(UserGroup userGroup);

}
