package com.smfy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.smfy.biz.impl.HuikuaiBizImpl;
import com.smfy.entity.Huikuan;

/**
 * Servlet implementation class Huikuan_List_Servlet
 */
public class Huikuan_List_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Huikuan_List_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ѯ����
				String tj=request.getParameter("tj");
			    //�жϽ��յ��ַ�������û�����ģ�û�оʹ�����������    
			    Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
			    Matcher m = p.matcher(tj);
			    if (!m.find()) {
			    	tj=new String(tj.getBytes("ISO-8859-1"),"utf-8");
			    }
			    
				int pageIndex=1;//Ĭ����ʾ��һҳ
				String pageIndexString=request.getParameter("pageIndex");
				if(pageIndexString!=null&&pageIndexString.length()>0){
					pageIndex=Integer.parseInt(pageIndexString);
				}
				//ÿҳ��ʾ�ļ�¼��
				int pageSize=5;//Ĭ��ÿҳ��ʾ5��
				String pageSizeString=request.getParameter("pageSize");
				if(pageSizeString!=null&&pageSizeString.length()>0){
					pageSize=Integer.parseInt(pageSizeString);
				}
				//��ҳ��
				int allPage=0;
				//������
				int count=new HuikuaiBizImpl().findAllCount(tj);
				if(count>0){
					//������ҳ��
					if(count%pageSize==0){
						allPage=count/pageSize;
					}else{
						allPage=count/pageSize+1;
					}
					//���ҳ��
					if(pageIndex<1){
						pageIndex=1;
					}else if(pageIndex>allPage){
						pageIndex=allPage;
					}
				}		
				
				List<Huikuan> hkList=null;
				hkList=new HuikuaiBizImpl().findAllHuikuan(tj, pageIndex, pageSize);
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("pageIndex", pageIndex);
				map.put("allPage", allPage);
				map.put("count", count);
				map.put("hkList",hkList);
				//ʹ��JSON�����û�����
				String json=JSON.toJSONString(map);
				response.setCharacterEncoding("utf-8");             
				response.setContentType("text/html; charset=UTF-8");		
				PrintWriter out= response.getWriter();             
				out.write(json);                                 
				out.flush();                                      
				out.close();          
	}

}
