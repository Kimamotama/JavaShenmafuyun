package com.smfy.dao.impl;

import com.smfy.dao.SmsDao;
import com.smfy.util.SmsSet;

import java.util.ArrayList;

import com.qcloud.sms.SmsSingleSender;
import com.qcloud.sms.SmsSingleSenderResult;

public class SmsDaoImpl implements SmsDao {

	@Override
	public int sendSms(String phoneNumber) {
		// TODO Auto-generated method stub
		//SDK AppID
		int appid = SmsSet.appid;
		//App Key
		String appkey = SmsSet.appkey;
		//ģ��Id
		int tmplId = SmsSet.tmplId;
		//�������6����֤��
		int max=999999;
		int min=100000;
		int number=(int) (Math.random()*(max-min))+min;
		System.out.println("���ɵ�6λ�����֤���ǣ�"+number);			
		try {
			 //��ʼ������
	    	SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
	    	SmsSingleSenderResult singleSenderResult;
	    	 //ָ��ģ�嵥��
	    	 //�������ģ�� id Ϊ 1��ģ������Ϊ��{1}Ϊ���Ķ�̬��¼��֤�룬����{2}��������д����Ǳ��˲���������Ա����š�
	    	ArrayList<String> params = new ArrayList<>();
	    	params.add(number+"");
	    	params.add("5");
	    	singleSenderResult = singleSender.sendWithParam("86", phoneNumber, tmplId, params, "", "","");
	    	System.out.println(singleSenderResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return number;
	}

}
