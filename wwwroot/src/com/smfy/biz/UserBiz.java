package com.smfy.biz;

import java.util.List;

import com.smfy.entity.User;

public interface UserBiz {
	/**
	 * ��Ա��¼
	 * @param user ��Ա����
	 * @return
	 */
	User userLogin(User user); 
	/**
	 * ʹ���ֻ���̬��¼
	 * @param phone �ֻ�����
	 * @return
	 */
	User phoneLogin(String phone);
	/**
	 * ����û����Ƿ����
	 * @param name �û���
	 * @return
	 */
	User checkUserName(String name);
	/**
	 * �޸�״̬�����ߣ����ߣ����ã�ͣ�ã�
	 * @param user
	 * @return
	 */
	int updateUserStatus(User user);
	/**
	 * ��ѯ�û�
	 * @param tj ����
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<User> findAllUser(String tj,int pageIndex,int pageSize);
	/**
	 * ��ѯ�û�����
	 * @param tj ����
	 * @return
	 */
	int findAllUserCount(String tj);
	/**
	 * ɾ����Ա
	 * @param id����ID
	 * @return
	 */
	int deleteUser(int id);		
	/**
	 * ��Աע��
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * �޸Ļ�Ա
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * ��ѯ��Ա
	 * @param tj ����
	 * @return
	 */
	User findUser(String tj);
	/**
	 * �����п�
	 * @param user
	 * @return
	 */
	int bindBank(User user);
	/**
	 * �޸��û�����
	 * @param user
	 * @return
	 */
	int updatePwd(User user);
	/**
	 * �޸Ļ�Աͷ��
	 * @param user
	 * @return
	 */
	int updateHeadPic(User user);
}
