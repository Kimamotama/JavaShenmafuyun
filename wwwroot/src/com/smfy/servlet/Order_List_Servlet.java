package com.smfy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.smfy.biz.impl.OrderBizImpl;
import com.smfy.entity.Order;

/**
 * Servlet implementation class Order_List_Servlet
 */
public class Order_List_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_List_Servlet() {
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
		String status=request.getParameter("status");
		//��ǰҳ��
		int pageIndex=1;//Ĭ����ʾ��һҳ
		String pageIndexString=request.getParameter("pageIndex");
		if(pageIndexString!=null&&pageIndexString.length()>0){
			pageIndex=Integer.parseInt(pageIndexString);
		}
		//ÿҳ��ʾ�ļ�¼��
		int pageSize=5;//Ĭ��ÿҳ��ʾ5��
		String pageSizeString=request.getParameter("pageSize");
		if(pageIndexString!=null&&pageIndexString.length()>0){
			pageSize=Integer.parseInt(pageSizeString);
		}
		//��ҳ��
		int allPage=0;
		//������
		int count=new OrderBizImpl().findAllOrderCount(status);
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
			//��������				
			//request.setAttribute("pageIndex", pageIndex);
			//request.setAttribute("allPage", allPage);
		}
				
		List<Order> orderList=null;//�ȳ�ʼ��
		orderList= new OrderBizImpl().findAllOrder(status,pageIndex, pageSize);

		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageIndex", pageIndex);
		map.put("allPage", allPage);
		map.put("orderList",orderList);
		//ʹ��JSON�����û�����
		String json=JSON.toJSONString(map);
		//������д��web��ҳ
		response.setCharacterEncoding("utf-8");             //��ֹajax���ص��������루�����ĵ�����£��ͱ���Ҫд��
		response.setContentType("text/html; charset=UTF-8");//��jspҳ�汾����ı���ʽһ��		
		PrintWriter out= response.getWriter();              //��ȡPrintWriter���󣬱�����webд����
		out.write(json);                                  //������д��webҳ��,����д��callBack(data)��data��	
		out.flush();                                        //�����
		out.close();                                        //�ر���
	}

}
