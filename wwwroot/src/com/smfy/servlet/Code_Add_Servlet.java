package com.smfy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smfy.biz.impl.CodeBizImpl;
import com.smfy.entity.Code;

/**
 * Servlet implementation class Code_Add_Servlet
 */
public class Code_Add_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code_Add_Servlet() {
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
		request.setCharacterEncoding("UTF-8");
		int codeId=Integer.parseInt(request.getParameter("codeId"));//Դ��Id
		int adminId=Integer.parseInt(request.getParameter("adminId"));//����Id 1
		String title=request.getParameter("title");//���� 2
		int typeId=Integer.parseInt(request.getParameter("typeId"));//���� 3
		float price=Float.parseFloat(request.getParameter("price"));//�۸�4
		int sort=Integer.parseInt(request.getParameter("sort"));//���� 5
		int acs=Integer.parseInt(request.getParameter("acs")); //�������� 6
		String origin=request.getParameter("origin");//��Դ 7
		String update=request.getParameter("update");//����ʱ�� 8
		//����ת��
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date newDate=null;
		try {
			newDate = sdf.parse(update);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String keywords=request.getParameter("keywords");//�ؼ��� 9
		String summary=request.getParameter("summary");//ժҪ 10
		String content=request.getParameter("content");//ժҪ 11
		String downUrl=request.getParameter("downUrl");//�������ص�ַ 12
		String extPwd=request.getParameter("extPwd");//��ȡ���� 13
		String decomPwd=request.getParameter("decomPwd");//��ѹ���� 14
		String tbPath=request.getParameter("tbPath");//����ͼ·�� 15
		String filePath=request.getParameter("filePath");//�ļ�·�� 16
		int status=Integer.parseInt(request.getParameter("status")); //״̬ 17 ����ǹ�������Ϊ1����Ա������Ϊ0
		
		Code code=new Code();		
		if(codeId!=0){//�༭
			code.setId(codeId);
		}		
		code.setAdminId(adminId);
		code.setTitle(title);
		code.setTypeId(typeId);
		code.setPrice(price);
		code.setSort(sort);
		code.setAcs(acs);
		code.setOrigin(origin);
		code.setUpdate(newDate);
		code.setKeywords(keywords);
		code.setSummary(summary);
		code.setContent(content);
		code.setDownUrl(downUrl);
		code.setExtPwd(extPwd);
		code.setDecomPwd(decomPwd);
		code.setTbPath(tbPath);
		code.setFilePath(filePath);
		code.setStatus(status);

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		int result=0;
		if(codeId!=0){//�༭
			result=new CodeBizImpl().editCode(code);
		}else{//���
			result=new CodeBizImpl().AddCode(code);
		}
		if(result>0){
			out.write("ok");
		}else{
			out.write("error");
		}		
		out.flush();
		out.close();
	}

}
