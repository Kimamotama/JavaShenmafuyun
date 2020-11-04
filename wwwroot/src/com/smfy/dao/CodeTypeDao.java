package com.smfy.dao;

import java.util.List;

import com.smfy.entity.CodeType;

public interface CodeTypeDao {
	/**
	 * ����ȫ��Դ������
	 * @return
	 */
	List<CodeType> findAllCodeType();
	/**
	 * ���Դ������
	 * @param codeType ����
	 * @return
	 */
	int addCodeType(CodeType codeType);
	/**
	 * ɾ��Դ������
	 * @param codeType ����
	 * @return
	 */
	int delCodeType(CodeType codeType);
	/**
	 * �༭Դ������
	 * @param codeType
	 * @return
	 */
	int updateCodeType(CodeType codeType);
}
