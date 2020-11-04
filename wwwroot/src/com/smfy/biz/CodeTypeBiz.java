package com.smfy.biz;

import java.util.List;

import com.smfy.entity.CodeType;

public interface CodeTypeBiz {
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
