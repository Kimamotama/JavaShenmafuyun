package com.smfy.util;
/**
* 
* �ַ�����װ����
*
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileBuffer {
	//<!-----------------------bufferedRead ��ȡ�ı��ļ���һ��һ�еĶ�ȡ�����죡----------------------->
		public static String brFile(String path){
			StringBuffer sb=new StringBuffer();
			        //�ȴ���һ��reader����
			Reader reder=null;
			BufferedReader br=null;
			try {
				reder=new FileReader(path);
				br=new BufferedReader(reder);
				//��ʼ��ȡ
				String line="";
				while ((line=br.readLine())!=null) {
					sb.append(line);			
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				try {
					//�ȿ����
					if (br!=null) {
						br.close();
					}
					if (reder!=null) {
						reder.close();
					}
					
				} catch (IOException e) {			
					e.printStackTrace();
				}
			}
			return  sb.toString();
		}
		//<!-----------------------bufferedRead д���ı��ļ���һ��һ�е�д�룬���죡----------------------->
		public static boolean bwFile(String path,String content,boolean flag){
			boolean result=false;
			    //�ȴ���һ��writer����
			Writer writer=null;
			BufferedWriter bw=null;
			try {
				writer=new FileWriter(path,flag);//flag��ʾ�Ƿ񸲸�,flag=true��ʾ��ĩβ��ӣ�flag=false��ʾ����
				bw=new BufferedWriter(writer);
				//��ʼд��
				bw.write(content);
				//д��������ݣ�Ҫˢ�»�����
				bw.flush();
				result=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				try {
					//�ȿ����
					if (bw!=null) {
						bw.close();
					}
					if (writer!=null) {
						writer.close();
					}
					
				} catch (IOException e) {			
					e.printStackTrace();
				}
			}
			return result;
		}
		//<!------------------------------------buffered�����ı��ļ��ĸ��ƣ�------------------------------------>
		public static boolean bcFile(String frompath,String toPath){
			boolean result=false;
			// �ļ��ĸ���:�ȶ�ȡҪ���Ƶ��ļ�����д�����ļ�
			//1.��ȡ�ļ�
			Reader reder=null;
			BufferedReader br=null;
			//2.д���ļ�
			Writer writer=null;
			BufferedWriter bw=null;			
			try {
				//3.��ȡ
				reder=new FileReader(frompath);
				br=new BufferedReader(reder);
				//4.д��
				writer=new FileWriter(toPath);
				bw=new BufferedWriter(writer);
				//5.�߶���д
				//������
				StringBuffer content=new StringBuffer();
				String line="";
				while ((line=br.readLine())!=null) {
					content.append(line);
				}
				//��д��
				bw.write(content.toString());
				//д��������ݣ�Ҫˢ�»�����
				bw.flush();
				result=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		finally{
			
				try {
					//�ȿ����
					if (br!=null) {
						br.close();
					}
					if (reder!=null) {
						reder.close();
					}
					
					if (bw!=null) {
						bw.close();
					}
					if (writer!=null) {
						writer.close();
					}
					
				} catch (IOException e) {			
					e.printStackTrace();
				}
			}
			return result;
		}
	}