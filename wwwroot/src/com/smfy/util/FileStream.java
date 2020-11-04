package com.smfy.util;
/**
 * �ֽ�����װ����
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStream {
	//<!----------------------------------------------------��ȡ�ļ�---------------------------------------------------->
	public static String readFile(String path){
		StringBuffer sb=new StringBuffer();
		//1.�����ļ����ֽ���
		InputStream fis=null;
		try {
			fis=new FileInputStream(path);//InputStreamΪ�����࣬����ʵ����
			byte [] bytes=new byte[1024];//����
			int data=0;			
				while ((data=fis.read(bytes))!=-1) {//(data=fis.read(bytes))!=-1��ʾ���������
					//�ַ�����ת��
					String str=new String(bytes,0,data);//�����,0,data�Ƿ�ֹ1024����0000000
					sb.append(str);
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
	        //2.�ر��ֽ���
			try {
				if (fis!=null) {
					fis.close();				
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return  sb.toString();
	}
	//<!----------------------------------------------------д���ļ�---------------------------------------------------->
	public static boolean writeFile(String path,String content,boolean flag){
		boolean result=false;
		//1.�����ļ����ֽ���
        OutputStream fos=null;
        try {
                //2.���� ���������
			fos=new FileOutputStream(path, flag);//flag��ʾ�Ƿ񸲸�,flag=true��ʾ��ĩβ��ӣ�flag=false��ʾ����
			//�ַ���String--->byte[]
			byte[] words=content.getBytes();
			//д��
			fos.write(words, 0, words.length);
			result=true;
		} catch (Exception e) {
			
		}
		finally{
			try {
				if (fos!=null) {
					fos.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//<!----------------------------------------------------�ļ��ĸ���---------------------------------------------------->
	public static boolean copyFile(String frompath,String toPath){
		boolean result=false;
		// �ļ��ĸ���:�ȶ�ȡҪ���Ƶ��ļ�����д�����ļ�
		//1.��ȡ�ļ�
		InputStream fis=null;
		//2.д���ļ�
		OutputStream fos=null;
		try {
			//3.��ȡ
			fis=new FileInputStream(frompath);
			//4.д��
			fos=new FileOutputStream(toPath);
			//5.�߶���д
			StringBuffer content=new StringBuffer();
			//������
			byte [] bytes=new byte[1024];//����
			int data=0;			
				while ((data=fis.read(bytes))!=-1) {//(data=fis.read(bytes))!=-1��ʾ���������
					//�ַ�����ת��
					String str=new String(bytes,0,data);//�����,0,data�Ƿ�ֹ1024����0000000
					content.append(str);
				}
		       //��д��
				//�ַ���String--->byte[]
				byte[] words=content.toString().getBytes();
				//д��
				fos.write(words, 0, words.length);
			result=true;	
		} catch (Exception e) {
			
		}
		
		finally{
			
			try {
				if (fis!=null) {
					fis.close();
				}
				if (fos!=null) {
					fos.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
