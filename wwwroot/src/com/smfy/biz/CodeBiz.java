package com.smfy.biz;

import java.util.List;

import com.smfy.entity.Code;

public interface CodeBiz {
	/**
	 * ���Դ��
	 * @param code Դ�����
	 * @return
	 */
	int AddCode(Code code);
	/**
	 * �޸�Դ��
	 * @param code Դ�����
	 * @return
	 */
	int editCode(Code code);
	/**
	 * �޸�Դ��״̬
	 * @param code Դ�����
	 * @return
	 */
	int updateCodeStatus(Code code);
	/**
	 * ɾ��Դ��
	 * @param code Դ�����
	 * @return
	 */
	int delCode(Code code);
	/**
	 * ����Դ���б�
	 * @param tj ��ѯ����
	 * @param pageIndex �ڼ�ҳ
	 * @param pageSize ÿҳ��ʾ����������
	 * @return
	 */
	List<Code> findAllCode(String tj,int pageIndex,int pageSize);
	/**
	 * ����ȫ��Դ������
	 * @return
	 */
	int findAllCodeCount(String tj);
	/**
	 * �������ҵ���Դ��
	 * @param tj ��ѯ������������ID������ؼ���
	 * @return
	 */
	Code findCodeInfo(String tj);
}
