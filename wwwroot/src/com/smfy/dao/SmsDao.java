package com.smfy.dao;

public interface SmsDao {
	/**
	 * ���Ͷ���
	 * @param phoneNumber �ֻ�����
	 * @return ���ط��͵Ķ�����֤��
	 */
	int	sendSms(String phoneNumber);
}
